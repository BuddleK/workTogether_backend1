<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>RB</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>


<!-- CSS 파일 동적 로드 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/subwayLine/${station.cssFile}">
</head>

<body>
	<jsp:include page="/header.jsp" />

	<main>
		<div class="station_info">
			<!-- 역 이미지 -->
			<%-- <div class="station_img">
        <img src="${stationImgUrl}"
             alt="${station.stationsName}"
             onerror="this.src='${pageContext.request.contextPath}/assets/img/subwayLine/placeholder.png'">
      </div> --%>

			<!-- 역 이름 -->
			<div class="station_exit">
				<div>${station.stationsName}</div>
			</div>

			<!-- 노선 번호 이미지 -->
			<div class="line_number">
				<img src="${lineImgUrl}" alt="${station.lineNumber}"
					onerror="this.src='${pageContext.request.contextPath}/assets/img/subwayLine/placeholder.png'">
			</div>
		</div>


		<!-- 지도 API -->
		<div class="map_api">
			<c:choose>
				<c:when test="${not empty lat and not empty lng}">
					<div id="map" style="width: 100%; height: 400px;" data-lat="${lat}"
						data-lng="${lng}" data-name="${station.stationsName}"></div>

					<script>
						(function initKakaoMap() {
							// 1) SDK 객체 유효성 검사
							function ready(fn) {
								if (window.kakao && kakao.maps
										&& kakao.maps.load) {
									fn();
									return;
								}
								// SDK가 아직 로드되지 않은 경우: 로드 완료 이벤트 대기
								var check = setInterval(function() {
									if (window.kakao && kakao.maps
											&& kakao.maps.load) {
										clearInterval(check);
										fn();
									}
								}, 50);
							}

							ready(function() {
								kakao.maps
										.load(function() {
											var mapEl = document
													.getElementById('map');
											if (!mapEl) {
												return;
											}

											var lat = parseFloat(mapEl.dataset.lat);
											var lng = parseFloat(mapEl.dataset.lng);
											var name = mapEl.dataset.name
													|| '역';

											if (isNaN(lat) || isNaN(lng)) {
												mapEl.innerHTML = '<div style="padding:16px;text-align:center;color:#666;">좌표가 없습니다.</div>';
												return;
											}

											var center = new kakao.maps.LatLng(
													lat, lng);
											var map = new kakao.maps.Map(mapEl,
													{
														center : center,
														level : 3
													});

											// 마커/인포윈도우를 쓰고 싶으면 아래 주석 해제
											/*
											var marker = new kakao.maps.Marker({ position: center });
											marker.setMap(map);
											var info = new kakao.maps.InfoWindow({
											  content: '<div style="padding:5px;font-size:13px;">' + name + '역</div>'
											});
											info.open(map, marker);
											 */
										});
							});
						})();
					</script>
				</c:when>
				<c:otherwise>
					<div style="padding: 16px; text-align: center; color: #666;">좌표
						정보가 없어 지도를 표시할 수 없습니다.</div>
				</c:otherwise>
			</c:choose>

		</div>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>
