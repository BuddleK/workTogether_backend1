window.addEventListener("DOMContentLoaded", () => {
  fetch("../../app/admin/sidebar.jsp")
    .then((response) => response.text())
    .then((data) => {
      document.getElementById("sidebar").innerHTML = data;
    });
});
