document.addEventListener("DOMContentLoaded", () => {
	const replyConsole = document.querySelector(".reply_console");
	const replyInput = document.getElementById("reply_input");
	const replyBtn = document.getElementById("reply_button");
	const commentListEl = document.querySelector("#reply_ul");
	const submitBtn = document.querySelector("#reply_button");
	
	const postsNumber = window.postsNumber;
	const usersNumber = window.usersNumber;

	console.log("pn : ", postsNumber);
	console.log("un : ", usersNumber);
	
	submitBtn?.addEventListener("click", async() => {
		const contentEl = document.querySelector("#reply_input");
		const content = contentEl?.value.trim();
		if(!content) return alert("댓글 내용 입력해주세요");
		if(!postsNumber || !usersNumber) return alert("number들이 없습니다.");
		
		try{
			const response = await fetch("/reply/postReplyWriteOk.re", {
			       method: "POST",
			       headers: {
			         "Content-Type": "application/json; charset=utf-8",
			         "X-Requested-With": "XMLHttpRequest",
			       },
			       body: JSON.stringify({ postsNumber, usersNumber, replyContent: content }),
			     });

			     const result = await safeJson(response);
			     if (result?.status === "success") {
			       alert("댓글이 작성되었습니다.");
			       if (contentEl) contentEl.value = "";
			       await loadReplies();
			     } else {
			       alert("댓글 작성에 실패했습니다.");
			     }
		}catch(error){
			console.error("댓글 작성 실패:", error);
			      alert("댓글 작성 중 오류가 발생했습니다.");
		}
	})

	// ====== 댓글 영역 이벤트 위임 ======
	  if (commentListEl) {
	    commentListEl.addEventListener("click", async (event) => {
	      const target = event.target;

	      // 삭제
	      if (target.matches(".comment-delete")) {
	        const replyNumber = target.dataset.number;
	        if (!replyNumber) return;

	        if (confirm("댓글을 삭제하시겠습니까?")) {
	          try {
	            const response = await fetch(
	              `/reply/postReplyDeleteOk.re?replyNumber=${encodeURIComponent(replyNumber)}`,
	              { method: "GET", headers: { "X-Requested-With": "XMLHttpRequest" } }
	            );
	            const result = await safeJson(response);
	            if (result?.status === "success") {
	              alert("댓글이 삭제되었습니다.");
	              await loadReplies();
	            } else {
	              alert("댓글 삭제에 실패했습니다.");
	            }
	          } catch (error) {
	            console.error("댓글 삭제 실패:", error);
	            alert("댓글 삭제 중 오류가 발생했습니다.");
	          }
	        }
	      }

	      // 수정 준비
	      if (target.matches(".comment-modify-ready")) {
	        const li = target.closest("li");
	        if (!li) return;

	        const contentDiv = li.querySelector(".reply_context");
	        const originalContent = contentDiv?.textContent?.trim() ?? "";

	        if (contentDiv) {
	          // 취약하게 원문 그대로 (escapeHtml 제거)
	          contentDiv.outerHTML = `<textarea class="modify-content">${originalContent}</textarea>`;
	        }

	        const btnGroup = target.closest(".comment-btn-group");
	        if (btnGroup) {
	          btnGroup.innerHTML =
	            `<button type="button" class="comment-modify" data-number="${target.dataset.number || ""}">수정 완료</button>`;
	        }
	      }

	      // 수정 완료
	      if (target.matches(".comment-modify")) {
	        const replyNumber = target.dataset.number;
	        if (!replyNumber) return;

	        const li = target.closest("li");
	        const newContent = li?.querySelector(".modify-content")?.value.trim();
	        if (!newContent) return alert("댓글 내용을 입력해주세요.");

	        try {
	          const response = await fetch("/reply/postReplyUpdateOk.re", {
	            method: "POST",
	            headers: {
	              "Content-Type": "application/json; charset=utf-8",
	              "X-Requested-With": "XMLHttpRequest",
	            },
	            body: JSON.stringify({ replyNumber, replyContent: newContent }),
	          });

	          const result = await safeJson(response);
	          if (result?.status === "success") {
	            alert("댓글이 수정되었습니다.");
	            await loadReplies();
	          } else {
	            alert("댓글 수정에 실패했습니다.");
	          }
	        } catch (error) {
	          console.error("댓글 수정 실패:", error);
	          alert("댓글 수정 중 오류가 발생했습니다.");
	        }
	      }
	    });
	  }
	
	
	async function loadReplies() {
		if (!postsNumber) return;
		try {
			const res = await fetch(`/reply/postReplyListOk.re?postsNumber=${encodeURIComponent(postsNumber)}`, {
				headers: { "Accept": "application/json", "X-Requested-With": "XMLHttpRequest" },
			});
			if (!res.ok) throw new Error("댓글 목록 가져오기 실패");
			const replies = await safeJson(res);
			renderReplies(Array.isArray(replies) ? replies : []);
		} catch (error) {
			console.error("댓글 가져오기 실패: ", error);
			alert("댓글 가져오기 실패했습니다.")
		}
	}

	//랜더링
	function renderReplies(replies) {
		if (!commentListEl) return;

		commentListEl.innerHTML = "";

		if (!replies.length) {
			commentListEl.innerHTML = "<li>댓글이 없습니다.</li>";
			return;
		}
		
		const frag = document.createDocumentFragment();
		
		
		replies.forEach((reply) => {
		      const isMyComment = String(reply.usersNumber) === String(usersNumber);
		      const li = document.createElement("li");
			  li.className = "reply";
		      // 템플릿 리터럴 유지 (JSP EL 충돌 없음: 클라이언트 템플릿이라 안전)
		      li.innerHTML = `
		        <div class="comment-info">
				<span class="reply_author">${reply.usersName}</span>
				            <span class="reply_context">${reply.replyContent}</span>
		          ${isMyComment ? `
		            <div class="comment-btn-group">
		              <button type="button" class="comment-modify-ready" data-number="${reply.replyNumber}">수정</button>
		              <button type="button" class="comment-delete" data-number="${reply.replyNumber}">삭제</button>
		            </div>` : ""}
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
	
	loadReplies();
});
