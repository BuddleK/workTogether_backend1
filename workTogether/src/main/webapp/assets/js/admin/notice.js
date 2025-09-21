function confirmDelete(noticeNumber) {
    if (confirm("정말 삭제하시겠습니까?")) {
        // 확인 클릭 시 해당 form submit
        document.getElementById("deleteForm" + noticeNumber).submit();
    }
}