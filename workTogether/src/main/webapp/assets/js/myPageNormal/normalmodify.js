const openmail = document.querySelector(".modal_mail");
const openaddress = document.querySelector(".modal_address");
const openphone = document.querySelector(".modal_phone");
const openemail = document.querySelector(".modal_email");
const openpw = document.querySelector(".modal_pw");

const addressmodal = document.getElementById("addressbutton");
const mailmodal = document.getElementById("mailbutton");
const phonemodal = document.getElementById("phonebutton");
const emailmodal = document.getElementById("emailbutton");
const pwmodal = document.getElementById("pwbutton");

const modalclose = document.getElementById("saveConfirmBtn");

const pwCheck = document.querySelector(".pwCheck");
const pwInput = document.getElementById("pwInput");
const newPwInput = document.getElementById("newPwInput");

let isOk = false;
let isValid = false;

function isValidPassword(password) {
	const regex = /^(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$/;
	return regex.test(password);
}

newPwInput.addEventListener("input", () => {
	const val = newPwInput.value;
	console.log(val);
	if (pwInput.value === val) {
		pwCheck.style.display = "none";
		isOk = true;
	} else {
		pwCheck.style.display = "block";
		isOk = false;
	}

	if (isValidPassword(pwInput.value)) {
		isValid = true;
	} else {
		isValid = false;
	}

	const submitBtn = document.getElementById("submit");
	submitBtn.addEventListener("click", function(event) {
		if (!isValid || !isOk) {
			event.preventDefault();
			alert("비밀번호 조건을 확인해주세요.");
		}
	});
});


//전화번호 인증

const sendCode = document.getElementById('sendCode');
const checkCode = document.getElementById('checkCode');

sendCode.addEventListener('click', () => {
	const phone = document.getElementById('userPhone');
	fetch(`/users/JoinSMSController.us?memberPhoneNumber=${encodeURIComponent(phone)}`, {
		method: "GET",
		headers: {
			"Accept": "text/plain",
			"X-Requested-With": "XMLHttpRequest"
		}
	}).then(res => {
		if (!res.ok) throw new Error("발송 실패: " + res.status);
		return res.text();
	}).then(msg => {
		alert(msg);               // 발송 메시지
		sendCode.disabled = true;  // 재발송 방지
		checkCode.readOnly = false;
		checkCode.value = "";      // 새 코드 입력 위해 비워두기
		checkCode.dataset.verified = "false";
	}).catch(err => {

		alert("SMS 발송 중 오류가 발생했습니다.\n" + err);
		sendCode.disabled = false; // 다시 시도 가능
	});
});


checkCode.addEventListener("click", function() {
	if (isExpired()) {
		alert("인증번호가 만료되었습니다. 다시 발급받아 주세요.");
		checkCode.value = "";
		sendCode.disabled = false;
		return;
	}

	const codeChecker = checkCode.value.trim();
	if (!codeChecker) {
		alert("인증번호를 입력하세요");
		return;
	}

	fetch(`/users/VerifyCodeController.us?verificationCode=${encodeURIComponent(codeChecker)}`, {
		headers: { "Accept": "text/plain", "X-Requested-With": "XMLHttpRequest" }
	}).then(res => {
		if (!res.ok) throw new Error("발송 실패: " + res.status);
		return res.text(); // text 형식으로 받음
	})
		.then(msg => {
			if (msg.includes("성공")) {
				alert("인증 성공");
				checkCode.readOnly = true;
				phoneInput.readOnly = true;
				checkCode.dataset.verified = "true";
				stopTimer();
			} else {
				alert("인증 실패");
			}
		})
		.catch(() => {
			alert("서버오류");
		});
});





