document.addEventListener("DOMContentLoaded", () => {
  const deleteBtn = document.querySelector(".delete"); // 삭제 버튼
  const delModal = document.getElementById("del_modal");   // 모달창
  const confirmBtn = document.getElementById("check");     // 모달 확인
  const cancelBtn = document.getElementById("cancle");     // 모달 취소

  // 삭제 버튼 클릭 시 모달 열기
  deleteBtn.addEventListener("click", () => {
    delModal.style.display = "flex";
  });

  // 모달 취소 버튼
  cancelBtn.addEventListener("click", () => {
    delModal.style.display = "none";
  });

  // 모달 확인 버튼 → 삭제 실행
  confirmBtn.addEventListener("click", () => {
    const postsNumber = deleteBtn.getAttribute("data-posts-number");
    const contextPath = window.contextPath;

    if (!postsNumber) {
      alert("게시글 번호가 없습니다.");
      return;
    }

    // 삭제 요청 (GET 방식 이동)
    location.href = `${contextPath}/admin/adminReportDeleteOk.ad?postsNumber=${postsNumber}`;
  });
});