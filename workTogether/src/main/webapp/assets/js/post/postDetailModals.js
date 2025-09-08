
	
/*	const check = document.getElementById("check");
	const notcheck = document.getElementById("notcheck");
	const cancle = document.getElementById("cancle");
	
	const notmodal = document.querySelector('.notmodal');
	const reportmodal = document.querySelector('.reportmodal');
	const reportcheck = document.getElementById('reportcheck');
	
	const delButton = docuemnt.querySelector('post_del_button');
	const delModal = document.getElementById('del_modal');
	
	del.addEventListener('click', function () {
	  checkmodal.style.display = 'block';
	});
	notcheck.addEventListener('click', function () {
	  notmodal.style.display = 'none';
	});
	check.addEventListener('click', function () {
	  reportmodal.style.display = 'block';
	  checkmodal.style.display = 'none';
	});
	reportcheck.addEventListener('click', function () {
	  reportmodal.style.display = 'none';
	});
	
	cancle.addEventListener('click', function () {
	  checkmodal.style.display = 'none';
	});
	check.addEventListener('click', function () {
	  checkmodal.style.display = 'none';
	});
	
	
	function postDel(){
		var checked = confirm("confirm 테스트 확인");
		if(checked){
			consol.log("")
			true;
		}else{
			//여기 주소고
		}
	}*/

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
	
	
	var usersNumber = document.getElementById("usersNumber").value;
	    console.log(usersNumber);
	
	del.addEventListener("click", () => {
		editModal.style.display = "flex";
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
	      checkmodal.style.display = "none";
	      if (data.result === "reported") {
	        reportmodal.style.display = "flex";
	      } else if (data.result === "already") {
	        notmodal.style.display = "flex";
	      }
	    });
	  });

	notcheck.addEventListener("click", () => {
		notmodal.style.display = "none";
	});
	
	notcancle.addEventListener("click", () =>{
		notmodal.style.display = "none";
	});
	
	reportcheck.addEventListener('click', () => {
		reportmodal.style.display = "none";
	});
		
})






	