// signNormalCare.js (수정본)
// - 아이디 중복검사: /users/checkIdOk.us (POST, {usersId})
// - 인증번호: 무작위 6자리 + sessionStorage 저장 + 60초 타이머
// - 비밀번호: 8자 이상 + 영문/숫자/특수 포함
// - 모든 값 OK 시 form.submit()

const CTX = '/' + location.pathname.split('/')[1];
const CODE_KEY = 'verifyCode';

const idInput     = document.getElementById('get_id_input');
const checkIdBox  = document.querySelector('.id_err_box');
const correctId   = document.querySelector('.ok_id_msg');
const errorID     = document.querySelector('.err_id_msg');

const pwInput     = document.getElementById('pw_input');
const msgPwRule   = document.getElementById('msg_box'); // 형식 오류 박스

const pwCheck     = document.getElementById('pw_check_input');
const msgPwMatch  = document.getElementById('msg_box2');
const cp          = document.querySelector('.correct_pw');
const ep          = document.querySelector('.error_pw_check_msg');

const email       = document.getElementById('email');
const emailBoxErr = document.getElementById('msg_box_email');
const errEmail    = document.querySelector('.error_email_msg');
const okEmail     = document.querySelector('.correct_email');

const nameInput   = document.getElementById('name');
const phoneInput  = document.getElementById('phone');
const authorNum   = document.getElementById('author_number');
const address     = document.querySelector('.address');
const detailAddr  = document.querySelector('.detail_address');

const alertBox    = document.querySelector('.alert');
const phoneBox    = document.querySelector('.sign_phone');
const timerEl     = document.querySelector('.timer');

let isIdOk = false;
let isPwRuleOk = false;
let isPwMatchOk = false;
let isEmailOk = false;
let isCodeOk = false;
let _timerId = null;

// ---------- 아이디 중복검사 ----------
async function checkId(e) {
  e?.preventDefault();
  const usersId = (idInput?.value || '').trim();
  if (!usersId) return;

  try {
    const res = await fetch(`${CTX}/users/checkIdOk.us`, {
      method: 'POST',
      headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
      body: new URLSearchParams({ usersId })
    });
    const data = await res.json(); // {available: true|false}
    // available:true  → 사용 가능 → OK
    isIdOk = !!(data && data.available === true);

    if (checkIdBox) checkIdBox.style.display = 'block';
    if (correctId)  correctId.style.display  = isIdOk ? 'block' : 'none';
    if (errorID)    errorID.style.display    = isIdOk ? 'none'  : 'block';
  } catch (err) {
    console.error('checkId error', err);
    if (checkIdBox) checkIdBox.style.display = 'block';
    if (correctId)  correctId.style.display  = 'none';
    if (errorID)    errorID.style.display    = 'block';
    isIdOk = false;
  }
}
window.checkId = checkId;

// ---------- 비밀번호 규칙 ----------
const PW_PATTERN = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*?_]).{8,}$/;

pwInput?.addEventListener('input', () => {
  const ok = PW_PATTERN.test(pwInput.value || '');
  if (msgPwRule) msgPwRule.style.display = ok ? 'none' : 'block';
  isPwRuleOk = ok;
  if (pwCheck.value) validatePwMatch();
});

// ---------- 비밀번호 일치 ----------
function validatePwMatch() {
  const same = (pwInput.value || '') === (pwCheck.value || '') && (pwInput.value || '').length > 0;
  if (msgPwMatch) msgPwMatch.style.display = 'block';
  if (cp) cp.style.display = same ? 'block' : 'none';
  if (ep) ep.style.display = same ? 'none'  : 'block';
  isPwMatchOk = same;
}
pwCheck?.addEventListener('input', validatePwMatch);

// ---------- 이메일 ----------
email?.addEventListener('input', () => {
  const ok = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.value || '');
  if (emailBoxErr) emailBoxErr.style.display = 'block';
  if (errEmail)    errEmail.style.display    = ok ? 'none' : 'block';
  if (okEmail)     okEmail.style.display     = ok ? 'block' : 'none';
  isEmailOk = ok;
});

// ---------- 인증번호 ----------
function generateCode() {
  return String(Math.floor(Math.random() * 1_000_000)).padStart(6, '0'); // 000000~999999
}

function startTimer(sec = 60) {
  clearInterval(_timerId);
  const endAt = Date.now() + sec * 1000;
  _timerId = setInterval(() => {
    const left = Math.max(0, Math.ceil((endAt - Date.now()) / 1000));
    if (timerEl) timerEl.innerHTML = `<p>${left}</p>`;
    if (left === 0) {
      clearInterval(_timerId);
      sessionStorage.removeItem(CODE_KEY);
      if (timerEl) timerEl.innerHTML = `<p>만료</p>`;
      isCodeOk = false;
    }
  }, 1000);
}

function sendMsg(e) {
  e?.preventDefault();
  const code = generateCode();
  sessionStorage.setItem(CODE_KEY, code);
  alert(`인증번호 "${code}" 를 입력하세요`);

  if (alertBox && phoneBox) {
    phoneBox.style.width = '120%';
    alertBox.textContent = '인증번호가 발송되었습니다.';
    alertBox.style.display = 'block';
    setTimeout(() => {
      alertBox.style.display = 'none';
      phoneBox.style.width = '100%';
    }, 6000);
  }
  startTimer(60);
}
window.sendMsg = sendMsg;

function checkMsg(e) {
  e?.preventDefault();
  const typed = (authorNum?.value || '').trim();
  const saved = sessionStorage.getItem(CODE_KEY);
  isCodeOk = /^\d{6}$/.test(typed) && saved && typed === saved;

  const errorBoxMsg = document.querySelector('.error_box_msg');
  const okMsg       = document.querySelector('.okay_msg');
  const errorMsg    = document.querySelector('.error_msg');

  if (errorBoxMsg) errorBoxMsg.style.display = 'block';
  if (okMsg)       okMsg.style.display       = isCodeOk ? 'block' : 'none';
  if (errorMsg)    errorMsg.style.display    = isCodeOk ? 'none'  : 'block';

  return isCodeOk;
}
window.checkMsg = checkMsg;

// ---------- 섹션 토글(필요 시) ----------
function checkNormal() {
  document.querySelector('.section_care')?.style.setProperty('display', 'none');
  document.querySelector('.section_normal')?.style.setProperty('display', 'block');
}
function checkCare() {
  document.querySelector('.section_care')?.style.setProperty('display', 'block');
  document.querySelector('.section_normal')?.style.setProperty('display', 'none');
}
window.checkNormal = checkNormal;
window.checkCare   = checkCare;

// ---------- 최종 제출 ----------
function nextPg(e) {
  e?.preventDefault();

  const requiredFilled = [
    idInput, pwInput, pwCheck, email, nameInput, phoneInput, authorNum, address, detailAddr
  ].every(el => el && (el.value || '').trim().length > 0);

  // 인증번호 일치 재검사
  if (!checkMsg()) {
    alert('인증번호가 올바르지 않습니다.');
    return;
  }

  if (!(isIdOk && isPwRuleOk && isPwMatchOk && isEmailOk && requiredFilled)) {
    alert('입력값을 확인해주세요.');
    return;
  }

  // ✅ 폼 제출 (JSP form action을 /users/joinNormalOk.us 또는 /users/joinCareOk.us 로 설정)
  document.querySelector('form')?.submit();
}
window.nextPg = nextPg;
