document.addEventListener("DOMContentLoaded", () => {
	const careNumber = window.careNumber;
	const normalNumber = window.normalNumber;
	const commentListEl = document.querySelector(".comment_list")
	
	const commentBtn = document.querySelector("#comment_button");
	
	commentBtn?.addEventListener("click", async () => {
		const contentEl = document.querySelector("comment_text");
		const content = contentEl?.value.trim();
		if (!content) return alert("댓글 내용을 입력해주세요.");
		   if (!careNumber || !normalNumber) return alert("care || user Number의 값이 없습니다.");
	})

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