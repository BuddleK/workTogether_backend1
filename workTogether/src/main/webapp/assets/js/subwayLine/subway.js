// /assets/js/subwayLine/subway.js
document.addEventListener("DOMContentLoaded", () => {
  const buttons = document.querySelectorAll(".subway_subwayLine button");

  // 현재 라인 파라미터
  const params = new URLSearchParams(location.search);
  const currentLine = params.get("lineNumber") || "0";

  // 버튼 active 표시
  buttons.forEach(b => {
    if (b.dataset.lineNumber === currentLine ||
        (!params.has("lineNumber") && (b.dataset.lineNumber === "0" ||
         b.dataset.lineName === "전체" || b.textContent.trim() === "전체"))) {
      b.classList.add("selected-btn");
    }
  });

  // 클릭 시 단순 이동 (AJAX X → 깜빡임 없음)
  buttons.forEach(btn => {
    btn.addEventListener("click", () => {
      const num = btn.dataset.lineNumber || "0";
      if (num === currentLine) return; // 동일 라인이면 아무 것도 안 함
      window.location.href = `${window.location.origin}${window.location.pathname}?lineNumber=${num}`;
      // 예: /subway/subwayList.sw?lineNumber=2
    });
  });
});
