// /assets/js/login/findPw.js
const CTX = '/' + location.pathname.split('/')[1];
const CODE_KEY = 'verifyCode';
let _timerId = null;

function generateCode() {
  return String(Math.floor(Math.random() * 1_000_000)).padStart(6, '0'); // 000000~999999
}

function startTimer(sec = 60) {
  clearInterval(_timerId);
  const timer = document.querySelector(".timer");
  const endAt = Date.now() + sec * 1000;

  _timerId = setInterval(() => {
    const left = Math.max(0, Math.ceil((endAt - Date.now()) / 1000));
    if (timer) timer.innerHTML = `<p>${left}</p>`;
    if (left === 0) {
      clearInterval(_timerId);
      sessionStorage.removeItem(CODE_KEY); 
      if (timer) timer.innerHTML = `<p>만료</p>`;
    }
  }, 1000);
}

function sendMsg(e) {
  e?.preventDefault();

  const code = generateCode();
  sessionStorage.setItem(CODE_KEY, code);
  alert(`인증번호 "${code}" 를 입력하세요`);

  const alertBox = document.querySelector(".alert");
  const phoneBox = document.querySelector(".box_phone");
  if (alertBox && phoneBox) {
    phoneBox.style.width = "120%";
    alertBox.textContent = "인증번호가 발송되었습니다.";
    alertBox.style.display = "block";
    setTimeout(() => {
      alertBox.style.display = "none";
      phoneBox.style.width = "100%";
    }, 6000);
  }

  startTimer(60);
}

function checkMsg(e) {
  e?.preventDefault();
  const input = document.getElementById("author_number");
  const errorBoxMsg = document.querySelector(".error_box_msg");
  const errorMsg = document.querySelector(".error_msg");
  const okMsg = document.querySelector(".okay_msg");

  const val = (input?.value || "").trim();
  const saved = sessionStorage.getItem(CODE_KEY);
  const ok = /^\d{6}$/.test(val) && saved && val === saved;

  if (errorBoxMsg) errorBoxMsg.style.display = "block";
  if (okMsg) okMsg.style.display = ok ? "block" : "none";
  if (errorMsg) errorMsg.style.display = ok ? "none" : "block";

  return ok;
}

async function checkId(e) {
  e?.preventDefault();
  const input = document.getElementById("get_id");
  const checkIdBox = document.querySelector(".check_id");
  const correctId = document.querySelector(".correct_id");
  const errorID = document.querySelector(".error_id");

  const usersId = (input?.value || "").trim();
  if (!usersId) return;

  try {
    const res = await fetch(`${CTX}/users/checkIdOk.us`, {
      method: 'POST',
      headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
      body: new URLSearchParams({ usersId })
    });
    const data = await res.json();

    const exists = data && data.available === false;
    if (checkIdBox) checkIdBox.style.display = "block";
    if (correctId)  correctId.style.display  = exists ? "block" : "none";
    if (errorID)    errorID.style.display    = exists ? "none" : "block";
  } catch (err) {
    console.error('checkId error', err);
    if (checkIdBox) checkIdBox.style.display = "block";
    if (correctId)  correctId.style.display  = "none";
    if (errorID)    errorID.style.display    = "block";
  }
}

function nextPg(e) {
  e?.preventDefault();

  const input2 = document.getElementById("get_id");
  const checkedRadio = document.querySelector('input[name="usersType"]:checked') 
                    || document.querySelector('input[name="type"]:checked');
  const nameInput = document.getElementById("name_input");
  const phoneInput = document.getElementById("phone_input");

  const idOk    = !!(input2 && input2.value.trim());
  const nameOk  = !!(nameInput && nameInput.value.trim());
  const phoneOk = !!(phoneInput && phoneInput.value.trim());
  const codeOk  = checkMsg();
  if (!idOk || !nameOk || !phoneOk || !checkedRadio) {
    alert("이름/아이디/휴대전화/회원유형을 입력해주세요.");
    return;
  }
  if (!codeOk) {
    alert("인증번호가 올바르지 않습니다.");
    return;
  }

  document.querySelector("form")?.submit();
}

window.sendMsg = sendMsg;
window.checkMsg = checkMsg;
window.checkId  = checkId;
window.nextPg   = nextPg;
