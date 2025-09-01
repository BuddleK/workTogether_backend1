document.addEventListener('DOMContentLoaded', function () {
  const buttons = document.querySelectorAll('.subway_subwayLine button');
  const stations = document.querySelectorAll('#station_list .station_name');
  const listTitle = document.getElementById('station_list_title');
  const listInner = document.querySelector('.station_list_inner')
  
  // 모든 역 데이터를 메모리에 저장
  let stationData = [];
  stations.forEach(station => {
    stationData.push({
      name: station.textContent.trim(),
      line: parseInt(station.dataset.line),
      element: station
    });
  });

  // 버튼 클릭 이벤트
  buttons.forEach(button => {
    button.addEventListener('click', function () {
      const clickedId = button.id;

      // 버튼 스타일 초기화
      buttons.forEach(btn => btn.classList.remove('selected-btn'));
      button.classList.add('selected-btn');

      // 모든 역 숨기기
      stations.forEach(station => station.style.display = "none");

      if (clickedId === "all") {
        listTitle.textContent = "전체 역 목록";

        // 이름별 최소 호선만 표시
        let minLineMap = {};
        stationData.forEach(st => {
          if (!(st.name in minLineMap) || st.line < minLineMap[st.name].line) {
            minLineMap[st.name] = st;
          }
        });

        Object.values(minLineMap).forEach(st => {
          st.element.style.display = "block";
        });

        return;
      }

      // 특정 호선 클릭
      const lineNumber = parseInt(clickedId.replace("line", ""));
      listTitle.textContent = button.textContent + " 역 목록";

      // 선택한 노선 역 모두 표시
      stationData.forEach(st => {
        if (st.line === lineNumber) {
          st.element.style.display = "block";
        }
      });
    });
  });

  // 기본: 전체 버튼 클릭
  document.getElementById("all").click();
});
