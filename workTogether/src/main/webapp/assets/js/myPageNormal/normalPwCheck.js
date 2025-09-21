document.addEventListener("DOMContentLoaded", function () {
    const sidebarLinks = document.querySelectorAll(".main_sidebar ul li a"); 

    sidebarLinks.forEach(link => {
		console.log('click함')
      link.addEventListener("click", function (e) {
          e.preventDefault();
          alert("비밀번호 인증이 필요합니다.");
      });
    });
  });