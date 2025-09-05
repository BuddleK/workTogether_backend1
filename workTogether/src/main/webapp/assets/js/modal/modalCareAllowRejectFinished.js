// 컨텍스트 경로
function getContextPath() {
  const link = document.querySelector('link[href$="/assets/css/headerAdmin.css"]');
  if (!link) return "";
  const href = link.getAttribute("href") || "";
  const idx = href.indexOf("/assets/");
  return idx > -1 ? href.slice(0, idx) : "";
}
const CTX = getContextPath();

// 회원번호 가져오기
const USERS_NUMBER = new URLSearchParams(location.search).get("usersNumber") || "";
const REJECT_URL = `${CTX}/admin/care/reject.ad`;
const LIST_URL = `${CTX}/admin/care/list.ad`;

// 모달 열기
function modalCareAllowRejectShow() {
  const modal = document.querySelector("#modalCareAllowReject .modal");
  if (modal) modal.style.display = "flex";
}

// 모달 닫기
function modalCareAllowRejectCancel() {
  const modal = document.querySelector("#modalCareAllowReject .modal");
  if (modal) modal.style.display = "none";
}

// 모달 확인 (반려 처리 요청)
function modalCareAllowRejectCheck() {
  const input = document.getElementById("reason_reject");
  const reason = input ? input.value.trim() : "";
  if (!reason) {
    alert("반려 사유를 입력하세요.");
    input.focus();
    return;
  }

  // 폼 제출처럼 POST 요청
  const form = document.createElement("form");
  form.method = "post";
  form.action = REJECT_URL;

  const numField = document.createElement("input");
  numField.type = "hidden";
  numField.name = "usersNumber";
  numField.value = USERS_NUMBER;
  form.appendChild(numField);

  const reasonField = document.createElement("input");
  reasonField.type = "hidden";
  reasonField.name = "rejectReason";
  reasonField.value = reason;
  form.appendChild(reasonField);

  document.body.appendChild(form);
  form.submit();
}
