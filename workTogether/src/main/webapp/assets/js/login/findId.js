// 랜덤 6자리 인증번호 + 타이머 + 폼제출
const CODE_KEY = 'verifyCode';
let _timerId = null;

function generateCode() {
  return String(Math.floor(Math.random() * 1_000_000)).padStart(6, '0'); // 000000~999999
}

function startTimer(sec = 60) {
  clearInterval(_timerId);
  const timerEl = document.querySelector('.timer');
  const endAt = Date.now() + sec * 1000;

  _timerId = setInterval(() => {
    const left = Math.max(0, Math.ceil((endAt - Date.now()) / 1000));
    if (timerEl) timerEl.textContent = String(left);
    if (left === 0) {
      clearInterval(_timerId);
      sessionStorage.removeItem(CODE_KEY); // 만료 시 코드 폐기
      if (timerEl) timerEl.textContent = '만료';
    }
  }, 1000);
}

function sendMsg(e) {
  if (e) e.preventDefault();

  const code = generateCode();
  sessionStorage.setItem(CODE_KEY, code);
  alert(`인증번호 "${code}" 를 입력하세요`);

  const alertBox = document.querySelector('.alert');
  const phoneBox = document.querySelector('.box_phone');
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

function checkMsg(e) {
  if (e) e.preventDefault();
  const typed = (document.getElementById('author_number')?.value || '').trim();
  const saved = sessionStorage.getItem(CODE_KEY);

  const ok = /^\d{6}$/.test(typed) && saved && typed === saved;

  document.querySelector('.error_box_msg')?.style.setProperty('display', 'block');
  document.querySelector('.okay_msg')?.style.setProperty('display', ok ? 'block' : 'none');
  document.querySelector('.error_msg')?.style.setProperty('display', ok ? 'none' : 'block');

  return ok;
}

function nextPg(e) {
  if (e) e.preventDefault();

  const nameOk  = !!document.getElementById('name_input')?.value.trim();
  const phoneOk = !!document.getElementById('phone_input')?.value.trim();

  if (!nameOk || !phoneOk) {
    alert('이름과 휴대전화를 입력해주세요.');
    return;
  }
  if (!checkMsg()) {
    alert('인증번호가 올바르지 않습니다.');
    return;
  }

  document.querySelector('form')?.submit(); // /users/findIdOk.us로 제출
}

// JSP onclick 대응
window.sendMsg = sendMsg;
window.checkMsg = checkMsg;
window.nextPg  = nextPg;
