
const del = document.querySelector('.button_del');
const check = document.getElementById("check");
const notcheck = document.getElementById("notcheck");
const cancle = document.getElementById("cancle");
const checkmodal = document.querySelector('.checkmodal');
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
}
	