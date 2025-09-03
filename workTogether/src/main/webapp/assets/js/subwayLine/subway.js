document.addEventListener("DOMContentLoaded", () => {
  const buttons = document.querySelectorAll(".subway_subwayLine button");
  const mapSection = document.querySelector(".map_section");
  const stationList = document.querySelector("#station_list");

  buttons.forEach(btn => {
    btn.addEventListener("click", () => {
      const lineNumber = btn.getAttribute("data-line-number"); 
      const url = `/subway/subwayLine.sw?lineNumber=${lineNumber}`;

      // 서버에서 새 JSP 받아오기
      fetch(url)
        .then(res => res.text())
        .then(html => {
          const parser = new DOMParser();
          const newDoc = parser.parseFromString(html, "text/html");

          // --- 노선도 영역 갱신 ---
          const newMapSection = newDoc.querySelector(".map_section");
          if (newMapSection) {
            mapSection.innerHTML = newMapSection.innerHTML;
          }

          // --- 역 목록 영역 갱신 ---
          const newStationList = newDoc.querySelector("#station_list");
          if (newStationList) {
            stationList.innerHTML = newStationList.innerHTML;
          }

          // --- 노선도 이미지 토글 ---
          const lineImgs = mapSection.querySelectorAll("[class^='subway_line']");
          lineImgs.forEach(div => (div.style.display = "none"));

          const selectedImg = mapSection.querySelector(
            ".subway_line" + lineNumber + "_img"
          );
          if (selectedImg) {
            selectedImg.style.display = "block";
          } else {
            console.warn(`선택한 노선(${lineNumber})의 이미지가 없습니다.`);
          }
        })
        .catch(err => console.error("노선도/역 목록 로드 실패:", err));
    });
  });
});
