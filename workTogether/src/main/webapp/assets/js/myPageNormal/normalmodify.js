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

/*pwmodal.addEventListener("click", function (e) {
  e.preventDefault();
  openpw.style.display = "block";
});

function openpwModalClose() {
  openpw.style.display = "none";
}*/

newPwInput.addEventListener("input", () => {
  const val = newPwInput.value;
  console.log(val);
  console.log(pwInput.val);
  if (pwInput.value === val) {
    pwCheck.style.display = "none";
  } else {
    pwCheck.style.display = "block";
  }
});
