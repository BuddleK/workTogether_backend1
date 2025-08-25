document.addEventListener("DOMContentLoaded", () => {
	const careNumber = window.careNumber;
	const normalNumber = window.normalNumber;
	const commentListEl = document.querySelector(".comment_list")
	
	const commentBtn = document.querySelector("#comment_button");
	
	commentBtn?.addEventListener("click", async () => {
		const contentEl = document.querySelector("#comment_text");
		const content = contentEl?.value.trim();
		if (!content) return alert("후기를 입력해주세요.");
		   if (!careNumber || !normalNumber) return alert("care || userNumber의 값이 없습니다.");
		   
		   try {
		         const response = await fetch("/comment/commentWriteOk.co", {
		           method: "POST",
		           headers: {
		             "Content-Type": "application/json; charset=utf-8",
		             "X-Requested-With": "XMLHttpRequest",
		           },
		           body: JSON.stringify({ careNumber, normalNumber, commentsContent: content }),
		         });

		         const result = await safeJson(response);
		         if (result?.status === "success") {
		           alert("댓글이 작성되었습니다.");
		           if (contentEl) contentEl.value = "";
		           await loadComments();
		         } else {
		           alert("댓글 작성에 실패했습니다.");
		         }
		       } catch (error) {
		         console.error("댓글 작성 실패:", error);
		         alert("댓글 작성 중 오류가 발생했습니다.");
		       }
	});

	console.log(careNumber + '유저넘버')
	console.log(normalNumber + 'gkkgk')

	async function loadComments() {
		if (!careNumber) return;

		try {
			const res = await fetch(`/comment/commentListOk.co?careNumber=${encodeURIComponent(careNumber)}`,
				{
					headers: { "Accept": "application/json", "X-Requested-With": "XMLHttpRequest" },
				});
			if (!res.ok) throw new Error("후기 목록을 불러오는 데 실패했습니다.1");
			const comments = await safeJson(res);
			renderComments(Array.isArray(comments) ? comments : []);
		} catch (error) {
			console.error("후기 목록 불러오기 실패:", error);
			alert("후기 목록을 불러오는데 실패했습니다.");
		}
	};

	function renderComments(comments) {
		if (!commentListEl) return;

		commentListEl.innerHTML = "";

		if (!comments.length) {
			commentListEl.innerHTML = "<li>댓글이 없습니다.</li>";
			return;
		}

		const frag = document.createDocumentFragment();

		comments.forEach((comment) => {
			const isMyComment = String(comment.normalNumber) === String(normalNumber);
			const li = document.createElement("li");

			li.innerHTML = `
			<div class="comment_div">
				<div class="comment_number">${comment.normalNumber}</div>
				<div class="comment_author">${comment.usersName}</div>
				<div class="comment_context">${comment.commentsContent}</div>
				<div class="comment_date">${comment.commentUpdatedDate}</div>
			</div>
	        `;
			frag.appendChild(li);
		});

		commentListEl.appendChild(frag);
	}

	async function safeJson(res) {
		const text = await res.text();
		try { return text ? JSON.parse(text) : null; } catch { return null; }
	}

	loadComments();
});