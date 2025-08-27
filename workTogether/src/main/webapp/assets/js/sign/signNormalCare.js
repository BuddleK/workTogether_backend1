document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("joinForm") || document.querySelector("form");

  const idInput = document.getElementById("get_id_input") || document.querySelector('input[name="usersId"]');
  const idMsgBox = document.querySelector(".id_err_box");
  const idOkMsg = document.querySelector(".ok_id_msg");
  const idErrMsg = document.querySelector(".err_id_msg");

  async function doCheckId() {
    const id = (idInput?.value || "").trim();
    if (!id) {
      if (idMsgBox) idMsgBox.style.display = "block";
      if (idOkMsg) idOkMsg.style.display = "none";
      if (idErrMsg) {
        idErrMsg.style.display = "block";
        idErrMsg.textContent = "아이디를 입력해주세요.";
      }
      return;
    }

    try {
      const res = await fetch(`/users/checkIdOk.us?usersId=${encodeURIComponent(id)}`, {
        headers: { "Accept": "application/json" }
      });
      if (!res.ok) throw new Error(res.status);
      const data = await res.json(); // {available: true|false}
      if (idMsgBox) idMsgBox.style.display = "block";
      if (data.available) {
        if (idOkMsg) idOkMsg.style.display = "block";
        if (idErrMsg) idErrMsg.style.display = "none";
      } else {
        if (idOkMsg) idOkMsg.style.display = "none";
        if (idErrMsg) {
          idErrMsg.style.display = "block";
          idErrMsg.textContent = "이미 사용 중인 아이디입니다.";
        }
      }
    } catch (_) {
      if (idOkMsg) idOkMsg.style.display = "none";
      if (idErrMsg) {
        idErrMsg.style.display = "block";
        idErrMsg.textContent = "아이디 중복 검사 중 오류가 발생했습니다.";
      }
    }
  }
  idInput?.addEventListener("change", doCheckId);
  window.checkId = doCheckId;

  // ===== 비밀번호 =====
  const pwInput = document.getElementById("pw_input");
  const pwMsg = document.getElementById("msg_box");

  pwInput?.addEventListener("input", () => {
    const val = pwInput.value;
    const pattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*?_])[A-Za-z\d!@#$%^&*?_]{8,}$/;
    if (pattern.test(val)) {
      if (pwMsg) pwMsg.style.display = "none";
    } else {
      if (pwMsg) {
        pwMsg.style.display = "block";
        pwMsg.textContent = "영문, 숫자, 특수문자를 포함한 8자 이상 비밀번호를 입력하세요.";
      }
    }
  });

  // 비밀번호 검증 =====
  const pwCheckInput = document.getElementById("pw_check_input");
  const pwCheckMsgBox = document.getElementById("msg_box2");
  const pwMatch = document.querySelector(".correct_pw");
  const pwNotMatch = document.querySelector(".error_pw_check_msg");

  pwCheckInput?.addEventListener("input", () => {
    const pw = pwInput?.value.trim();
    const confirm = pwCheckInput.value.trim();

    if (pwCheckMsgBox) pwCheckMsgBox.style.display = "block";
    if (pw && pw === confirm) {
      if (pwMatch) pwMatch.style.display = "block";
      if (pwNotMatch) pwNotMatch.style.display = "none";
    } else {
      if (pwMatch) pwMatch.style.display = "none";
      if (pwNotMatch) pwNotMatch.style.display = "block";
    }
  });

  // ===== 이메일
  const emailInput = document.getElementById("email") || document.querySelector('input[name="usersEmail"]');
  const emailBox = document.getElementById("msg_box_email");
  const emailOk = document.querySelector(".correct_email");
  const emailErr = document.querySelector(".error_email_msg");

  emailInput?.addEventListener("input", () => {
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (emailBox) emailBox.style.display = "block";
    if (pattern.test(emailInput.value)) {
      if (emailOk) emailOk.style.display = "block";
      if (emailErr) emailErr.style.display = "none";
    } else {
      if (emailOk) emailOk.style.display = "none";
      if (emailErr) emailErr.style.display = "block";
    }
  });

  // ===== 휴대폰 인증
  const sendBtn = document.getElementById("sendSMSBtn") || document.querySelector('button[onclick="sendMsg()"]');
  const phoneInput = document.getElementById("phone") || document.querySelector('input[name="usersPhone"]');
  const verifyInput = document.getElementById("author_number");
  const verifyStatus = document.querySelector(".alert");
  const timerEl = document.querySelector(".timer");

  let generatedCode = "";
  let timerId = null;

  function startTimer(sec = 60) {
    if (timerId) clearInterval(timerId);
    let left = sec;
    timerId = setInterval(() => {
      if (timerEl) timerEl.innerHTML = `<p>${left}</p>`;
      if (left-- <= 0) {
        clearInterval(timerId);
        timerId = null;
        generatedCode = "";
        if (verifyStatus) {
          verifyStatus.textContent = "인증번호가 만료되었습니다. 다시 발급받아 주세요.";
          verifyStatus.style.display = "block";
          verifyStatus.style.color = "red";
        }
      }
    }, 1000);
  }

  function sendMsg(e) {
    e?.preventDefault?.();
    const phone = (phoneInput?.value || "").trim();
    if (!phone) {
      alert("휴대폰 번호를 입력해주세요.");
      return;
    }
    generatedCode = String(Math.floor(100000 + Math.random() * 900000));
    alert(`인증번호는 [${generatedCode}] 입니다.`);

    if (verifyInput) verifyInput.disabled = false;
    if (verifyStatus) {
      verifyStatus.textContent = "인증번호가 발송되었습니다.";
      verifyStatus.style.display = "block";
      verifyStatus.style.color = "";
    }
    startTimer(60);
  }
/*  sendBtn?.addEventListener("click", sendMsg);
*/  window.sendMsg = sendMsg;

  function checkMsg(e) {
    e?.preventDefault?.();
    const typed = (verifyInput?.value || "").trim();
    const ok = !!generatedCode && /^\d{6}$/.test(typed) && typed === generatedCode;

    if (verifyStatus) {
      verifyStatus.textContent = ok ? "인증에 성공했습니다." : "인증번호가 일치하지 않습니다.";
      verifyStatus.style.display = "block";
      verifyStatus.style.color = ok ? "green" : "red";
    }
    if (verifyInput) verifyInput.dataset.verified = ok ? "true" : "false";

    const errorBoxMsg = document.querySelector(".error_box_msg");
    const okMsg = document.querySelector(".okay_msg");
    const errorMsg = document.querySelector(".error_msg");
    if (errorBoxMsg) errorBoxMsg.style.display = "block";
    if (okMsg) okMsg.style.display = ok ? "block" : "none";
    if (errorMsg) errorMsg.style.display = ok ? "none" : "block";

    return ok;
  }
  window.checkMsg = checkMsg;

  // ===== 제출 전 검증
  form?.addEventListener("submit", function (e) {
    const nameInput = document.getElementById("name") || document.querySelector('input[name="usersName"]');
    const postCode = document.getElementById("usersPostsalCode") || document.getElementById("postcode");
    const addrMain = document.getElementById("usersAddressLine1") || document.getElementById("mainAddress");
    const addrDetail = document.getElementById("usersAddressLine2") || document.getElementById("detailAddress");

    const requiredInputs = [
      idInput, pwInput, pwCheckInput, emailInput, nameInput,
      phoneInput, verifyInput, postCode, addrMain, addrDetail
    ];
    const allFilled = requiredInputs.every(el => el && (el.value || "").trim().length > 0);

    if (!allFilled) {
      e.preventDefault();
      alert("모든 항목을 입력해주세요.");
      return;
    }
    if (verifyInput?.dataset.verified !== "true") {
      e.preventDefault();
      alert("휴대폰 인증을 완료해주세요.");
      verifyInput?.focus();
      return;
    }
  });
});
