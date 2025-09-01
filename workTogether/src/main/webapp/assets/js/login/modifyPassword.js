// 비밀번호 수정: 형식검사 + 일치검사 후 폼 제출
(function () {
  const form = document.querySelector('form');
  const pw1  = document.getElementById('pw_input');
  const pw2  = document.getElementById('pw_check_input');
  const box1 = document.getElementById('msg_box');    // 형식 오류 박스
  const box2 = document.getElementById('msg_box2');   // 일치/불일치 박스
  const ok   = document.querySelector('.correct_pw');
  const err  = document.querySelector('.error_pw_check_msg');

  // 8자 이상 + 영문 + 숫자 + 특수문자 포함
  const PATTERN = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*?_]).{8,}$/;

  function validateRule() {
    const valid = PATTERN.test(pw1.value);
    if (box1) box1.style.display = valid ? 'none' : 'block';
    return valid;
  }

  function validateMatch() {
    const same = pw1.value.length > 0 && pw1.value === pw2.value;
    if (box2)  box2.style.display = 'block';
    if (ok)    ok.style.display   = same ? 'block' : 'none';
    if (err)   err.style.display  = same ? 'none'  : 'block';
    return same;
  }

  pw1?.addEventListener('input', () => {
    validateRule();
    if (pw2.value) validateMatch();
  });

  pw2?.addEventListener('input', validateMatch);

  // JSP 버튼에서 onclick="nextPg()" 로 호출
  window.nextPg = function () {
    const ruleOk = validateRule();
    const sameOk = validateMatch();
    if (!ruleOk || !sameOk) {
      alert('비밀번호를 형식에 맞게 동일하게 입력해주세요.');
      return;
    }
    // form action은 /users/updatePwOk.us 로 설정되어 있어야 함
    form?.submit();
  };
})();
