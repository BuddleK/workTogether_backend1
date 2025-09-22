document.addEventListener('DOMContentLoaded', () => {
  // ===== 요소 참조 =====
  const form        = document.querySelector('form');
  const sendBtn     = document.getElementById('sendSMSBtn') || document.querySelector('button[onclick="sendMsg()"]');
  const phoneInput  = document.getElementById('phone_input') || document.querySelector('input[name="usersPhone"]');
  const nameInput   = document.getElementById('name_input')  || document.querySelector('input[name="usersName"]');
  const typeRadioQ  = 'input[name="usersType"]:checked';

  const verifyInput = document.getElementById('author_number');
  const checkSMS    = document.getElementById('check');
  const timerEl     = document.querySelector('.timer');

  // 메시지/안내 영역 (있으면 사용)
  const msgBoxWrap  = document.querySelector('.error_box_msg');
  const okMsgEl     = document.querySelector('.okay_msg');
  const errMsgEl    = document.querySelector('.error_msg');
  const alertBox    = document.querySelector('.alert');
  const phoneBox    = document.querySelector('.box_phone');

  // 히든 authCode (없으면 생성)
  let authHidden = document.getElementById('authCodeHidden');
  if (!authHidden) {
    authHidden = document.createElement('input');
    authHidden.type = 'hidden';
    authHidden.name = 'authCode';
    authHidden.id   = 'authCodeHidden';
    form && form.appendChild(authHidden);
  }

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
        // 만료 시 인증상태 초기화
        setVerified(false);
        verifyInput && (verifyInput.value = '');
        sendBtn && (sendBtn.disabled = false);
        alert('인증번호가 만료되었습니다. 다시 발급받아 주세요.');
      }
    };

    tick();
    timerId = setInterval(tick, 1000);
  }

  function isExpired() {
    return !expiresAt || Date.now() > expiresAt;
  }

  // ===== 유틸: 메시지/상태 =====
  function showOk(ok) {
    if (msgBoxWrap) msgBoxWrap.style.display = 'block';
    if (okMsgEl) okMsgEl.style.display = ok ? 'block' : 'none';
    if (errMsgEl) errMsgEl.style.display = ok ? 'none'  : 'block';
  }

  function resetMessages() {
    if (okMsgEl)  okMsgEl.style.display = 'none';
    if (errMsgEl) errMsgEl.style.display = 'none';
    if (msgBoxWrap) msgBoxWrap.style.display = 'none';
  }

  function setVerified(ok) {
    verifyInput?.setAttribute('data-verified', ok ? 'true' : 'false');
    if (ok) {
      verifyInput && (verifyInput.readOnly = true);
      phoneInput  && (phoneInput.readOnly = true);
    } else {
      verifyInput && (verifyInput.readOnly = false);
      phoneInput  && (phoneInput.readOnly = false);
    }
    showOk(ok);
  }

  function normalizePhone(v) {
    return (v || '').replace(/[^0-9]/g, '');
  }

  // ===== 입력 변화에 따른 초기화 =====
  phoneInput?.addEventListener('input', () => {
    // 번호 바꾸면 인증 초기화 & 재전송 가능
    setVerified(false);
    sendBtn && (sendBtn.disabled = false);
    stopTimer();
  });

  verifyInput?.addEventListener('input', () => {
    // 인증번호 수정 시 인증 상태 해제
    setVerified(false);
    resetMessages();
    // 히든 authCode도 초기화
    authHidden && (authHidden.value = '');
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

    // 서버로 SMS 발송 요청
    fetch(`${CTX}/users/JoinSMSController.us?memberPhoneNumber=${encodeURIComponent(phoneNumber)}`, {
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

        alert(msg || '인증번호가 발송되었습니다.');
        verifyInput && (verifyInput.value = '');
        setVerified(false);
        resetMessages();
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

    // 서버에 코드 검증 요청 (세션에 저장된 코드와 비교)
    fetch(`${CTX}/users/VerifyCodeController.us?verificationCode=${encodeURIComponent(code)}`, {
      headers: { 'Accept': 'text/plain', 'X-Requested-With': 'XMLHttpRequest' }
    })
      .then(res => {
        if (!res.ok) throw new Error('검증 실패: ' + res.status);
        return res.text();
      })
      .then(msg => {
        if ((msg || '').includes('성공')) {
          alert('인증 성공');
          setVerified(true);
          stopTimer();
          // 서버가 세션에 verificationCode를 보관하더라도,
          // FindPwOkController에서 authCode 파라미터를 비교하는 경우를 대비해 hidden에 채워둔다.
          authHidden && (authHidden.value = code);
        } else {
          setVerified(false);
          alert('인증 실패');
        }
      })
      .catch(() => {
        alert('서버 오류가 발생했습니다.');
      });
  });

  // ===== 제출 가드 =====
  form?.addEventListener('submit', (e) => {
    const name  = (nameInput?.value || '').trim();
    const phone = (phoneInput?.value || '').trim();
    const typeChecked = !!document.querySelector(typeRadioQ);
    const verified = verifyInput && verifyInput.dataset.verified === 'true';

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
    if (!verified) {
      e.preventDefault();
      showOk(false);
      alert('휴대폰 인증을 완료해주세요.');
      verifyInput?.focus();
      return;
    }

    // 서버가 하이픈 없는 포맷을 기대하면 여기서 정규화
    if (phoneInput) phoneInput.value = normalizePhone(phone);

    // 통과 → 서버로 제출 (세션의 verificationCode와 authCode(히든) 비교 가능)
  });
});
