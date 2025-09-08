
	
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
	const checkmodal = document.querySelector('.checkmodal');
	const check = document.getElementById("check");
	const cancle = document.getElementById("cancle");
	const reportmodal = document.querySelector('.reportmodal');
	const reportcheck = document.getElementById('reportcheck');
	const notmodal = document.querySelector('.notmodal');
	const notcheck = document.getElementById("notcheck");
	const notcancle = document.getElementById("notcancle");
	
	
	
	var usersNumber = document.getElementById("usersNumber").value;
	    console.log(usersNumber);
		const reportUrl = "${pageContext.request.contextPath}/post/postReport.po?postsNumber=${post.getPostsNumber()}&postsUsersNumber=${post.getUsersNumber()}";
	
	del.addEventListener("click", () => {
		checkmodal.style.display = "flex";
	});
	
	cancle.addEventListener("click", () => {
		checkmodal.style.display = "none";
	});
	
	check.addEventListener("click", () => {
		if(usersNumber < 0){
			checkmodal.style.display = "none";
			notmodal.style.display = "flex";
		}else{
			window.location.href = reportUrl;
			checkmodal.style.display = "none";
			reportmodal.style.display = "flex";
		}
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






	