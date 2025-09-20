// 페이지 열리면 실행
document.addEventListener('DOMContentLoaded', () => {
  // ===== 모달 참조 =====
  const saveModal = document.getElementById('saveSuccessModal');
  //const notCorrectModal = document.getElementById('notCorecetModal');

  const openSaveModal = () => saveModal?.classList.add('open');
  //const closeSaveModal = () => saveModal?.classList.remove('open');

  // 닫기 버튼
  //document.getElementById('saveConfirmBtn')?.addEventListener('click', closeSaveModal);
  //document.getElementById('CorrectBtn')?.addEventListener('click', () => notCorrectModal?.classList.remove('open'));

  //수정 폼
  const modForm = document.getElementById('mod_form');
  
  //수정 완료 모달 확인 버튼
  const confirmButton = document.getElementById('saveConfirmBtn');
  
  confirmButton.addEventListener('click', () =>{
	modForm.submit();
  });
  
  // 확인 버튼
  const checkButton = document.getElementById('check');
  checkButton.addEventListener('click', () =>{
/*	if(emailError.style.display == 'block'){
		alert("이메일 형식을 확인해 주세요");
		return;
	}*/
	if(passwordError.style.display == 'block'){
		alert("비밀번호 형식을 확인해 주세요");
		return;
	}
	if(rePasswordError.style.display == 'block'){
		alert("비밀번호가 일치하지 않습니다");
		return;
	}

	// 주소 입력 체크
	if (!inputPostal.value || !inputAddr1.value || !inputAddr2.value) {
	  alert("주소를 모두 입력해 주세요");
	  return;
	}

	// 전화번호 입력 체크 (11자리 확인)
	const phoneValue = inputPhone.value;
	if (!phoneValue) {
	  alert("전화번호를 입력해 주세요");
	  return;
	}
	if (phoneValue.length !== 11) {
	  alert("전화번호는 11자리로 입력해 주세요");
	  return;
	}
	
	// 전화번호 변경 여부
	if(originalPhoneNumber != inputPhone.value){
		// 인증이 되지 않은 경우 변경 불가
		if(verified == 0){
			alert("전화번호 변경 시 전화번호 인증이 필요합니다.")
			return;
		}
	}
	openSaveModal();
  });
  
  
  // 주소 인풋
  const inputPostal = document.getElementById('usersPostsalCode');
  const inputAddr1 = document.getElementById('usersAddressLine1');
  const inputAddr2 = document.getElementById('usersAddressLine2');
  
  // 전화번호 인풋
  const inputPhone = document.getElementById('usersPhone');
  const phoneError = document.getElementById('phone_error');
  const sendSMS = document.getElementById('sendSMS');
  const inputChkSMS = document.getElementById('inputChkSMS');
  const checkSMS = document.getElementById('checkSMS');
  
  //원래 전화번호
  const originalPhoneNumber = inputPhone.value;
  //인증 여부
  let verified = 0;
  // 인증 확인 버튼 비활성화
  checkSMS.disabled = true;
  // 인증번호 입력란 비활성화
  inputChkSMS.disabled = true;
  
  //sms 발송
  sendSMS.addEventListener("click", function(){
	if(inputPhone.value == originalPhoneNumber){
		alert("비밀번호가 변경되지 않았습니다.");
		return;
	}
	
	if (inputPhone.value == "" || phoneError.style.display == 'block') {
	    alert("핸드폰 번호를 확인해 주세요");
	    return;
	}
	alert("sms 진입1");
	fetch(`/users/JoinSMSController.us?memberPhoneNumber=${encodeURIComponent(inputPhone.value)}`, {
	    method: "GET",
	    headers: {
	        "Accept": "text/plain",
	        "X-Requested-With": "XMLHttpRequest" // 이걸 추가해야 서버를 다시로드 하지 않고 인증번호를 받을 수 있음
	    }
	})
	    .then(res => {
			alert("로그1111");
	        if (!res.ok) throw new Error("발송 실패: " + res.status);
	        return res.text(); // text 형식으로 받음
	    })
	    .then(msg => {
	        // 서버가 성공적으로 처리했을 때만 실행
			alert("로그1");
	        alert(msg);               // 발송 메시지
	        sendSMS.disabled = true;  // 재발송 방지
			checkSMS.disabled = false; //인증번호 확인 버튼 활성화
			checkSMS.style.backgroundColor = "#007bff" //인증 확인 버튼 파랗게 변경
			inputChkSMS.disabled = false; //인증번호 입력란 활성화
	    })
	    .catch(err => {
	        // 실패했을 때
			alert("로그2");
	        alert("SMS 발송 중 오류가 발생했습니다.\n" + err);
	        sendSMS.disabled = false; // 다시 시도 가능
	    });
  });
  // ===== 인증번호 확인 (서버 대신 로컬 비교) =====
  checkSMS.addEventListener("click", function() {
      const codeChecker = inputChkSMS.value.trim();
      if (!codeChecker) {
  	alert("인증번호를 입력하세요");
          return;
      }

      fetch(`/users/VerifyCodeController.us?verificationCode=${encodeURIComponent(codeChecker)}`, {
          headers: { "Accept": "text/plain", "X-Requested-With": "XMLHttpRequest"} 
          }).then(res => {
                  if (!res.ok) throw new Error("발송 실패: " + res.status);
                  return res.text(); // text 형식으로 받음
          })
          .then(msg => {
              if (msg.includes("성공")) {
                 alert("인증 성공");
  			 codeChecker.readOnly = true;       // 인증번호 입력란 잠금
  			 inputPhone.readOnly = true;        // (선택) 휴대폰 번호도 잠그려면 이 줄 추가
			 verified = 1;
              } else {
  			alert("인증 실패");
			sendSMS.disabled = false;
              }
          })
          .catch(() => {
              alert("서버오류");
          });
  });
  
  
  // ===== 전화번호 검사 (전역 함수) =====
  function phoneCheck(phone) {
    // 전화번호 형식 검사
    const re = /^01[016789]\d{8}$/;
    return re.test(phone);
  }
  
  // ===== 전화번호 입력 검사 =====
  inputPhone.addEventListener('input', () => {
    const phValue = inputPhone.value;
    if (phoneCheck(phValue)) {
      phoneError.style.display = 'none';
    } else {
      phoneError.style.display = 'block';
    }
  });

  
  
  const inputPw = document.getElementById('rePw');
  const inputCheckPw = document.getElementById('reCheckPw');
  const passwordError = document.getElementById('password_error');
  const rePasswordError = document.getElementById('re_password_error');

  // ===== 비밀번호 검사 (전역 함수) =====
  function passwordCheck(password) {
    // 비밀번호: 최소 8자, 숫자, 영문, 특수문자 포함
    const re = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
    return re.test(password);
  }

  // ===== 비밀번호 입력 검사 =====
  inputPw.addEventListener('input', () => {
    const pwValue = inputPw.value;
    if (passwordCheck(pwValue)) {
      passwordError.style.display = 'none';
    } else {
      passwordError.style.display = 'block';
    }
	  const checkPwValue = inputCheckPw.value;
	  if (checkPwValue === pwValue) {
	    rePasswordError.style.display = 'none';
	  } else {
	    rePasswordError.style.display = 'block';
	  }
  });

  // ===== 비밀번호 재입력 일치 여부 검사 =====
  inputCheckPw.addEventListener('input', () => {
    const pwValue = inputPw.value;
    const checkPwValue = inputCheckPw.value;
    if (checkPwValue === pwValue) {
      rePasswordError.style.display = 'none';
    } else {
      rePasswordError.style.display = 'block';
    }
  });
  
  



	
});



