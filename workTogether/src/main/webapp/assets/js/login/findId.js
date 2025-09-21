document.addEventListener('DOMContentLoaded', () => {
  // ===== 요소 참조 =====
  const form        = document.querySelector('form');
  const sendBtn     = document.getElementById('sendSMSBtn') || document.querySelector('button[onclick="sendMsg()"]');
  const phoneInput  = document.getElementById('phone_input') || document.querySelector('input[name="usersPhone"]');
  const verifyInput = document.getElementById('author_number');
  const checkSMS    = document.getElementById('check');
  const timerEl     = document.querySelector('.timer');

  // (있으면) 메시지 영역
  const msgBoxWrap  = document.querySelector('.error_box_msg');
  const okMsgEl     = document.querySelector('.okay_msg');
  const errMsgEl    = document.querySelector('.error_msg');
  const alertBox    = document.querySelector('.alert');
  const phoneBox    = document.querySelector('.box_phone');

  // ===== 타이머 =====
  let timerId = null;
  let expiresAt = 0;

  function stopTimer() {
    if (timerId) clearInterval(timerId);
    timerId = null;
    expiresAt = 0;
    if (sendBtn)  sendBtn.textContent = '인증번호 발송';
    if (timerEl)  timerEl.textContent = '';
  }

  function startTimer(sec = 60) {
    stopTimer();
    expiresAt = Date.now() + sec * 1000;

    const tick = () => {
      const left = Math.max(0, Math.ceil((expiresAt - Date.now()) / 1000));
      if (sendBtn) sendBtn.textContent = left ? `인증번호 발송 (${left})` : '인증번호 발송';
      if (timerEl) timerEl.textContent = left ? String(left) : '만료';
      if (left <= 0) {
        stopTimer();
        if (verifyInput) {
          verifyInput.value = '';
          verifyInput.dataset.verified = 'false';
          verifyInput.readOnly = false;
        }
        if (sendBtn) sendBtn.disabled = false;
        alert('핸드폰 인증을 다시 받아주십시오.');
      }
    };

    tick();
    timerId = setInterval(tick, 1000);
  }

  function isExpired() {
    return !expiresAt || Date.now() > expiresAt;
  }

  // ===== 유틸: 메시지 토글 =====
  function showOk(ok) {
    if (msgBoxWrap) msgBoxWrap.style.display = 'block';
    if (okMsgEl) okMsgEl.style.display = ok ? 'block' : 'none';
    if (errMsgEl) errMsgEl.style.display = ok ? 'none'  : 'block';
  }

  function resetVerifyState() {
    verifyInput?.setAttribute('data-verified', 'false');
    verifyInput && (verifyInput.readOnly = false);
    if (okMsgEl)  okMsgEl.style.display = 'none';
    if (errMsgEl) errMsgEl.style.display = 'none';
    if (msgBoxWrap) msgBoxWrap.style.display = 'none';
  }

  // ===== 입력 변화에 따른 초기화 =====
  phoneInput?.addEventListener('input', () => {
    // 번호 바꾸면 인증 초기화 & 재전송 가능
    resetVerifyState();
    sendBtn && (sendBtn.disabled = false);
    stopTimer();
  });

  verifyInput?.addEventListener('input', () => {
    // 인증번호 수정 시 인증 상태 해제
    verifyInput.dataset.verified = 'false';
    if (okMsgEl)  okMsgEl.style.display = 'none';
    if (errMsgEl) errMsgEl.style.display = 'none';
  });

  // ===== SMS 발송 =====
  const phoneRegex = /^01[016789]-?\d{3,4}-?\d{4}$/;

  sendBtn?.addEventListener('click', () => {
    const phoneNumber = (phoneInput?.value || '').trim();
    if (!phoneInput || !phoneRegex.test(phoneNumber)) {
      alert('핸드폰 번호를 올바르게 입력해주세요.');
      phoneInput?.focus();
      return;
    }

    // 발송 중 중복 클릭 방지
    sendBtn.disabled = true;

    fetch(`/users/JoinSMSController.us?memberPhoneNumber=${encodeURIComponent(phoneNumber)}`, {
      method: 'GET',
      headers: {
        'Accept': 'text/plain',
        'X-Requested-With': 'XMLHttpRequest'
      }
    })
      .then(res => {
        if (!res.ok) throw new Error('발송 실패: ' + res.status);
        return res.text();
      })
      .then(msg => {
        // 상단 안내 UX (있으면)
        if (alertBox && phoneBox) {
          phoneBox.style.width = '120%';
          alertBox.textContent = '인증번호가 발송되었습니다.';
          alertBox.style.display = 'block';
          setTimeout(() => {
            alertBox.style.display = 'none';
            phoneBox.style.width = '100%';
          }, 4000);
        }

        alert(msg); // "인증번호가 발송되었습니다." 등
        verifyInput && (verifyInput.value = '');
        resetVerifyState();
        startTimer(60);
      })
      .catch(err => {
        alert('SMS 발송 중 오류가 발생했습니다.\n' + err);
        sendBtn.disabled = false;
        stopTimer();
      });
  });

  // ===== 인증번호 확인 =====
  checkSMS?.addEventListener('click', () => {
    if (isExpired()) {
      alert('인증번호가 만료되었습니다. 다시 발급받아 주세요.');
      verifyInput && (verifyInput.value = '');
      sendBtn && (sendBtn.disabled = false);
      return;
    }

    const code = (verifyInput?.value || '').trim();
    if (!code) {
      alert('인증번호를 입력하세요');
      verifyInput?.focus();
      return;
    }

    fetch(`/users/VerifyCodeController.us?verificationCode=${encodeURIComponent(code)}`, {
      headers: { 'Accept': 'text/plain', 'X-Requested-With': 'XMLHttpRequest' }
    })
      .then(res => {
        if (!res.ok) throw new Error('검증 실패: ' + res.status);
        return res.text();
      })
      .then(msg => {
        if (msg.includes('성공')) {
          alert('인증 성공');
          verifyInput && (verifyInput.readOnly = true);
          phoneInput  && (phoneInput.readOnly = true);
          verifyInput && (verifyInput.dataset.verified = 'true');
          showOk(true);
          stopTimer();
        } else {
          showOk(false);
          alert('인증 실패');
        }
      })
      .catch(() => {
        alert('서버오류');
      });
  });

  // ===== 제출 가드 =====
  form?.addEventListener('submit', (e) => {
    const name  = document.getElementById('name_input')?.value.trim();
    const phone = phoneInput?.value.trim();
    const typeChecked = !!document.querySelector('input[name="usersType"]:checked');

    if (!name || !phone) {
      e.preventDefault();
      alert('이름과 휴대전화를 입력해주세요.');
      return;
    }
    if (!typeChecked) {
      e.preventDefault();
      alert('회원 유형을 선택해주세요.');
      return;
    }
    if (!verifyInput || verifyInput.dataset.verified !== 'true') {
      e.preventDefault();
      showOk(false);
      alert('휴대폰 인증을 완료해주세요.');
      verifyInput?.focus();
      return;
    }
    // 통과 → 서버로 제출 (세션의 verificationCode와 authCode 비교)
  });
});
