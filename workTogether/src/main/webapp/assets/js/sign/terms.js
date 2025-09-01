NodeList.prototype.map = Array.prototype.map;
NodeList.prototype.filter = Array.prototype.filter;

const all = document.querySelector("#all");
const terms = document.querySelectorAll(".check");
const link = "./../../app/sign/signNormal.html";

// console.log(all);
// console.log(terms);

all.addEventListener("click", () => {
  terms.forEach((term) => {
    term.checked = all.checked;
  });
});

terms.forEach((term) => {
  term.addEventListener("click", () => {
    all.checked =
      terms.map((term) => term.checked).filter((checked) => checked).length ===
      terms.length;
  });
  console.log(terms.length);
});

function hrefLink() {
  location.href = link;
}

function goNextNormal() {
  // all.checked =
  //   terms.map((term) => term.checked).filter((checked) => checked).length ===
  //   terms.length;
  if (all.checked) {
    alert("전체 동의 완료!!");
    alert("일반 회원가입페이지로 이동합니다.");
    location.href="./../../app/sign/signNormal.jsp"
  } else {
    alert("전체 동의를 하셔야만 합니다.");
  }
}

function goNextCare() {
  // all.checked =
  //   terms.map((term) => term.checked).filter((checked) => checked).length ===
  //   terms.length;
  if (all.checked) {
    alert("전체 동의 완료!!");
    alert("돌봄 회원가입페이지로 이동합니다.");
    location.href="./../../app/sign/signCare.jsp"
  } else {
    alert("전체 동의를 하셔야만 합니다.");
  }
}
