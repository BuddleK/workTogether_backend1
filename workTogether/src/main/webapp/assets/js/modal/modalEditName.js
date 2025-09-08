window.addEventListener('DOMContentLoaded', () => {
	// html 문서에 모달 불러오기
	fetch(contextPath + '/app/modal/modalEditName.jsp')
		.then(response => response.text())
		.then(data => {
			document.getElementById('modalEditName').innerHTML = data;
		});
});

//모달 요소 가져오기
const modalEditName = document.getElementById("modalEditName");

//input 요소 담을 변수
let input;

// 모달이 나타나는 함수(버튼에 추가하여 사용)
function modalEditNameShow() {
	event.preventDefault();
	console.log("모달버튼클릭");
	modalEditName.style.display = "flex";
	input = document.getElementById("new_name");
	input.focus();

	input.onkeyup = (e) => {
		if (e.key === "Enter") {
			modalEditNameCheck();
		}
	};
}

//모달 끄기 함수(모달 내부 x이미지에 추가되어 있음)
function modalEditNameNone() {
	if (input) {
		input.onkeyup = null; // 이벤트 제거
	}
	modalEditName.style.display = "none";
}

function modalEditNameCheck() {
	const value = document.getElementById("new_name").value.trim();
	if (!value) {
		alert("이름을 입력하세요.");
		return;
	}

	// hidden input에 값 채우기
	document.getElementById("hiddenNewName").value = value;

	// form submit
	document.getElementById("editNameForm").submit();
}



function modalEditNameCancel() {
	modalEditNameNone();
}
modalEditNameNone();
