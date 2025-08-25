document.addEventListener("DOMContentLoaded",() => {
	const careNumber = window.careNumber;
	const normalNumber =  window.normalNumber;
	const commentListEl = document.querySelector(".comment_list")
	
	console.log(careNumber + '유저넘버')
	console.log(normalNumber + 'gkkgk')
	
	async function loadComments() {
	    if (!careNumber) return;
		
	    try {
			const res = await fetch(`/comment/commentListOk.co?careNumber=${encodeURIComponent(careNumber)}`, {
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

	     comments.forEach((reply) => {
	        const isMyComment = String(reply.normalNumber) === String(normalNumber);
	        const li = document.createElement("li");

	        li.innerHTML = `
	          <div class="comment-info">
	            <span class="writer">${reply.memberId ?? ""}</span>
	            <span class="date">${(reply.replyUpdateDate || reply.replyDate) ?? ""}</span>
	          </div>
	          <div class="comment-content-wrap">
	            <div class="comment-content">${reply.replyContent ?? ""}</div>
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
	  
	  loadComments();
});