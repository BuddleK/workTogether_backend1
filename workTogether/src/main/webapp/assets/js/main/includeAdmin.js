window.addEventListener("DOMContentLoaded", () => {
  // 헤더 불러오기
  fetch("./../../header_admin.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("header").innerHTML = data;
    });

  // 푸터 불러오기
  fetch("./../../footer.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("footer").innerHTML = data;
    });
});
