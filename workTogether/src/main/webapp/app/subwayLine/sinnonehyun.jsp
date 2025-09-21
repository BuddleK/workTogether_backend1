<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RB</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/subwayLine/sinnonehyun.css">
</head>

<body>
  <jsp:include page="/header.jsp" />

  <main>

    <div class="station_info">
      <!-- 해당 지하철 역 사진 -->

      <div class="station_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/sinnonehyun.png" alt="">
      </div>

      <div class="station_exit">
        <!-- 역 정보 -->
        <div> 신논현역 </div>
      </div>

      <div class="line_number">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/Line_9.png" alt="">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/dx_Line.png" alt="">
      </div>
    </div>

    <!-- 지도 api -->
    <div class="map_api">
			<div id="map" style="width: 100%; height: 400px;" data-lat="${lat}"
				data-lng="${lng}" data-name="신논현역"></div>
      <a href="${pageContext.request.contextPath}/subway/subwayList.sw"><button>목록</button></a>

    </div>


  </main><script>
		(function initKakaoMap() {
			// 공통 header.jsp에서 SDK가 로드될 때까지 대기
			function ready(fn) {
				if (window.kakao && kakao.maps && kakao.maps.load) {
					fn();
					return;
				}
				var t = setInterval(function() {
					if (window.kakao && kakao.maps && kakao.maps.load) {
						clearInterval(t);
						fn();
					}
				}, 50);
			}

			ready(function() {
				kakao.maps
						.load(function() {
							var el = document.getElementById('map');
							if (!el)
								return;

							var lat = parseFloat(el.dataset.lat);
							var lng = parseFloat(el.dataset.lng);
							var name = el.dataset.name || '역';

							if (isNaN(lat) || isNaN(lng)) {
								el.innerHTML = '<div style="padding:16px;text-align:center;color:#666;">좌표가 없습니다.</div>';
								return;
							}

							var center = new kakao.maps.LatLng(lat, lng);
							var map = new kakao.maps.Map(el, {
								center : center,
								level : 3
							});

							// 마커(원하면 유지)
							var marker = new kakao.maps.Marker({
								position : center
							});
							marker.setMap(map);

							// 인포윈도우(선택)
							// new kakao.maps.InfoWindow({
							//   content:'<div style="padding:5px;font-size:13px;">' + name + '</div>'
							// }).open(map, marker);
						});
			});
		})();
	</script>
  <jsp:include page="/footer.jsp" />
</body>

</html>