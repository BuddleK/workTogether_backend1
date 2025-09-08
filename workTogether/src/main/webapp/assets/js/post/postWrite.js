//폼
const writeForm = document.getElementById('write_form');
// 작성 버튼
const writeButton = document.getElementById('write_button');
// 작성하시겠습니까? 모달
const askWriteModal = document.getElementById('ask_write_modal');
// 모달-확인 버튼
const writeCheckButton = document.getElementById('writecheck');
// 모달-취소 버튼
const writeCancelButton = document.getElementById('writecancel');
// 작성되었습니다 모달
const writeOkModal = document.getElementById('write_ok_modal');
// 모달-작성 확인 버튼(진짜 완료해서 서블릿으로 가는 버튼)
const writeOkButton = document.getElementById('writeok');

writeButton.addEventListener('click', () =>{
	console.log("글쓰기 버튼 클릭");
	askWriteModal.style.display="block";
});
writeCancelButton.addEventListener('click', () =>{
	console.log("모달 - 글쓰기 취소 버튼 클릭");
	askWriteModal.style.display="none";
});
writeCheckButton.addEventListener('click', () =>{
	console.log("모달 - 글쓰기 확인 버튼 클릭");
	askWriteModal.style.display="none";
	writeOkModal.style.display="block";
});
writeOkButton.addEventListener('click', () =>{
	console.log("모달 - 글쓰기 완료");
	writeForm.submit();
});
