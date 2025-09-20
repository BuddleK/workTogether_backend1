window.addEventListener("DOMContentLoaded", () => {
  // 1) 사이드바 로드
  fetch("../../app/admin/sidebar.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("sidebar").innerHTML = data;
    });

  // 2) 행 클릭 시 상세 페이지로 이동
  document.querySelectorAll(".table_body").forEach((row) => {
    row.addEventListener("click", () => {
      const usersNumber = row.dataset.usersNumber;
      if (usersNumber) {
        location.href = `${contextPath}/admin/care/detail.ad?usersNumber=${usersNumber}`;
      }
    });
  });
});
