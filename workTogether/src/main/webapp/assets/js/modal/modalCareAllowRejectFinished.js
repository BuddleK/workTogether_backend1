window.addEventListener("DOMContentLoaded", () => {
  // html 문서에 모달 불러오기
  fetch("./../../app/modal/modalCareAllowReject.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("modalCareAllowReject").innerHTML = data;
    });
});

//모달 요소 가져오기
const modalCareAllowReject = document.getElementById("modalCareAllowReject");

//input 요소 담을 변수
let input;

const link = "./../../app/admin/careRequest.jsp";
function linkHref() {
  location.href = link;
}

function cancle() {
  linkHref();
}

// 모달이 나타나는 함수(버튼에 추가하여 사용)
function modalCareAllowRejectShow() {
  event.preventDefault();
  console.log("모달버튼클릭");
  modalCareAllowReject.style.display = "flex";
  input = document.getElementById("reason_reject");
  input.focus();

  input.onkeyup = (e) => {
    if (e.key === "Enter") {
      modalCareAllowRejectCheck();
    }
  };
}

//모달 끄기 함수(모달 내부 x이미지에 추가되어 있음)
function modalCareAllowRejectNone() {
  if (input) {
    input.onkeyup = null; // 이벤트 제거
  }
  modalCareAllowReject.style.display = "none";
}
function modalCareAllowRejectCheck() {
  const value = input.value.trim();
  if (!value) {
    alert("반려 사유를 입력하세요.");
    return;
  }
  console.log("전달할 값 : ", value);
  alert("입력됨 - " + value);
  modalCareAllowRejectNone();
  linkHref();
}
function modalCareAllowRejectCancel() {
  modalCareAllowRejectNone();
}
modalCareAllowRejectNone();

window.addEventListener("DOMContentLoaded", () => {
  // html 문서에 모달 불러오기
  fetch("./../../app/modal/modalCareAllowFinished.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("modalCareAllowFinished").innerHTML = data;
    });
});

//모달 요소 가져오기
const modalCareAllowFinished = document.getElementById(
  "modalCareAllowFinished"
);

function modalCareAllowFinishedShow() {
  // event.preventDefault();
  console.log("모달버튼클릭");
  modalCareAllowFinished.style.display = "flex";

  //엔터로 확인 버튼 누르기
  document.onkeydown = (event) => {
    if (event.key === "Enter") {
      modalCareAllowFinishedCheck();
    }
  };
}
//모달 끄기 함수(모달 내부 x이미지에 추가되어 있음)
function modalCareAllowFinishedNone() {
  modalCareAllowFinished.style.display = "none";
  document.onkeydown = null; // onkeydown 이벤트 제거
}
//확인 버튼
function modalCareAllowFinishedCheck() {
  linkHref();
  modalCareAllowFinishedNone();
}
//취소 버튼
function modalCareAllowFinishedCancel() {
  modalCareAllowFinishedNone();
}
modalCareAllowFinishedNone();
