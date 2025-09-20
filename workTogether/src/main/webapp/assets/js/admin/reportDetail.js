const link = "./../../app/admin/report.html"
function linkHref() {
  location.href=link;
}

document.addEventListener("DOMContentLoaded", () => {
	const del = document.querySelector('.button_del');
		const editModal = document.getElementById("editModal");
		const editcheck = document.getElementById("editcheck");
		const editcancle = document.getElementById("editcancle");
		const reportmodal = document.querySelector('.reportmodal');
		const reportcheck = document.getElementById('reportcheck');
		const notmodal = document.querySelector('.notmodal');
		const notcheck = document.getElementById("notcheck");
		const notcancle = document.getElementById("notcancle");
		const reportReasonSelect = document.getElementById('reportReasonSelect');
		
		
		
		
		del.addEventListener("click", () => {
			const usersNumber = document.getElementById("usersNumber");
			console.log("usersNumber:", usersNumber);
			if (!usersNumber || usersNumber === 'null') {
						const contextPath = del.getAttribute("data-context-path");
						window.location.href = contextPath + "/users/nomalLogin.us";
						return;
			}else{
			    editModal.style.display = "flex";
			}
			
		});
		
		editcancle.addEventListener("click", () => {
			editModal.style.display = "none";
		});
		
		editcheck.addEventListener("click", () => {
		    const postNumber = del.getAttribute("data-post-number");
		    const postUserNumber = del.getAttribute("data-post-user-number");
		    const contextPath = del.getAttribute("data-context-path");
		    const reason = encodeURIComponent(reportReasonSelect.value);

		    if (!reason) {
		      alert("신고 사유를 선택해주세요.");
		      return;
		    }

		    fetch(`${contextPath}/post/postReport.po`, {
		      method: "POST",
		      headers: {
		        "Content-Type": "application/x-www-form-urlencoded"
		      },
		      body: `postsNumber=${postNumber}&postsUsersNumber=${postUserNumber}&reportReason=${reason}`})
		    .then(res => res.json())
		    .then(data => {
		      editModal.style.display = "none";
		      if (data.result === "reported") {
		        reportmodal.style.display = "flex";
		      } else if (data.result === "already") {
		        notmodal.style.display = "flex";
		      }
		    });
		  });

		notcheck.addEventListener("click", () => {
			const postNumber = del.getAttribute("data-post-number");
			    const contextPath = del.getAttribute("data-context-path");

			    fetch(`${contextPath}/post/postReportCancel.po`, {
			        method: "POST",
			        headers: {
			            "Content-Type": "application/x-www-form-urlencoded"
			        },
			        body: `postsNumber=${postNumber}`
			    })
			    .then(res => res.json())
			    .then(data => {
			        if(data.result === "success"){
			            notmodal.style.display = "none";
			            alert("신고가 취소되었습니다.");
			        } else {
			            alert("신고 취소에 실패했습니다.");
			        }
			    });
		});
		
		notcancle.addEventListener("click", () =>{
			notmodal.style.display = "none";
		});
		
		reportcheck.addEventListener('click', () => {
			reportmodal.style.display = "none";
		});
	
	
		
});