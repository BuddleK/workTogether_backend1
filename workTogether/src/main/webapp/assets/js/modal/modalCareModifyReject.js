window.addEventListener("DOMContentLoaded", () => {
  // html 문서에 모달 불러오기
  fetch("./../../app/modal/modalCareModifyReject.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("modalCareModifyReject").innerHTML = data;
    });
});

//모달 요소 가져오기
const modalCareModifyReject = document.getElementById("modalCareModifyReject");

//input 요소 담을 변수
let input;

const link = "./../../app/admin/careCareer.jsp";
function linkHref() {
  location.href = link;
}

function cancle() {
  linkHref();
}

// 모달이 나타나는 함수(버튼에 추가하여 사용)
function modalCareModifyRejectShow() {
  event.preventDefault();
  console.log("모달버튼클릭");
  modalCareModifyReject.style.display = "flex";
  input = document.getElementById("reason_reject");
  input.focus();

  input.onkeyup = (e) => {
    if (e.key === "Enter") {
      modalCareModifyRejectCheck();
    }
  };
}

//모달 끄기 함수(모달 내부 x이미지에 추가되어 있음)
function modalCareModifyRejectNone() {
  if (input) {
    input.onkeyup = null; // 이벤트 제거
  }
  modalCareModifyReject.style.display = "none";
}
function modalCareModifyRejectCheck() {
  const value = input.value.trim();
  if (!value) {
    alert("반려 사유를 입력하세요.");
    return;
  }
  console.log("전달할 값 : ", value);
  alert("입력됨 - " + value);
  modalCareModifyRejectNone();
  linkHref();
}
function modalCareModifyRejectCancel() {
  modalCareModifyRejectNone();
}
modalCareModifyRejectNone();
