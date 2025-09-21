<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>함께 걸음 - 가게 디테일</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/restaurant/restaurantDetail.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/restaurant/restaurantModal.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/restaurant/restaurantDetail.js"></script>

</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />
	<!-- 메인 -->
	<main>
		<!-- 메인 바디 -->
		<div class="main_body">
			<!-- 페이지 타이틀 -->
			<h1 id="page_title">
				<c:out value="${shops.getShopsName()}" />
				<c:out value="${shops.getShopsBranchName()}" />
			</h1>
			<!-- 페이지 내용 영역 -->
			<div class="context">
				<!-- 음식점 소개 영역 -->
				<div class="detail_info_area">
					<!-- 음식점 이미지 -->
					<div class="restaurant_img_box">
						<img id="restaurant_img"
							src="${pageContext.request.contextPath}/assets/img/restaurant/re0.jpg">
					</div>
					<!-- 음식점 소개 영역 -->
					<div class="restaurant_info">
						<!-- 음식점 정보 -->
						<div class="restaurant_information">
							<div class="restaurant_name">
								<h1 id="short_name">
									<c:out value="${shops.getShopsName()}" />
								</h1>
								<h1 id="short_branch">
									<c:out value="${shops.getShopsBranchName()}" />
								</h1>
							</div>
							<p id="short_category">
								상권업종중분류 :
								<c:out value="${shops.getShopsBizMidCategory()}" />
							</p>
							<p id="short_address">
								도로명 주소 :
								<c:out value="${shops.getShopsRoadAddress()}" />
							</p>
							<p id="short_call">
								전화번호:
								<c:out value="${shops.getShopsPhone()}" />
							</p>
							<p id="short_hours">
								영업 시간:
								<c:out value="${shops.getShopsWorkingHours()}" />
							</p>
							<p id="short_takeout">
								테이크아웃:
								<c:choose>
									<c:when test="${shops.getShopsTakeout() == 'N' }">X</c:when>
									<c:when test="${shops.getShopsTakeout() == 'Y' }">O</c:when>
									<c:otherwise>null</c:otherwise>
								</c:choose>
							</p>
						</div>
						<!-- 음식점 설명 -->
						<div class="restaurant_introduction">
							<p id="introduction">
								<c:out value="${shops.getShopsIntroText()}" />
							</p>
						</div>
					</div>
				</div>
				<!-- 지도 영역 -->
				<div class="detail_map_area">
					<!-- 지도 이미지 -->
					<div class="map_img_box" id="map"></div>
					<div id="short_info">
						<div>
							<p id="short_firstfloor">
								일층:
								<c:out value="${shops.getShopsFloor1f()}" />
							</p>
							<p id="short_ramp">
								경사로:
								<c:out value="${shops.getShopsRamp()}" />
							</p>
							<p id="short_entrance_curb">
								입구턱:
								<c:out value="${shops.getShopsEntranceStep()}" />
							</p>
							<p id="short_entrance_step">
								입구문턱:
								<c:out value="${shops.getShopsEntranceThreshold()}" />
							</p>
							<p id="short_restroom_curb">
								화장실턱:
								<c:out value="${shops.getShopsToiletStep()}" />
							</p>
						</div>
						<div>
							<p id="short_restroom_step">
								화장실문턱:
								<c:out value="${shops.getShopsToiletThreshold()}" />
							</p>
							<p id="short_restroom">
								장애인화장실:
								<c:out value="${shops.getShopsDisabledToilet()}" />
							</p>
							<p id="short_elevator">
								엘리베이터:
								<c:out value="${shops.getShopsElevator()}" />
							</p>
							<p id="short_parking">
								주차장:
								<c:out value="${shops.getShopsParking()}" />
							</p>
							<p id="short_disabled_parking">
								장애인주차장:
								<c:out value="${shops.getShopsDisabledParking()}" />
							</p>
							<div id="star_img_box">
								<img draggable="false" id="star_img" class="noStar"
									src="${pageContext.request.contextPath}/assets/img/restaurant/star.png"
									data-shops-number="${shops.shopsNumber}" /> <span>찜하기</span>
								<%-- <c:choose>
									<c:when test="${isJim == 0 }">
										<img draggable="false" id="star_img" class="noStar"
											src="${pageContext.request.contextPath}/assets/img/restaurant/star.png"
											data-shops-number="${shops.shopsNumber}" />
										<span>찜하기</span>
									</c:when>
									<c:otherwise>
										<img draggable="false" id="star_img" class="yesStar"
											src="${pageContext.request.contextPath}/assets/img/restaurant/star.png"
											data-shops-number="${shops.shopsNumber}" />
										<span>찜하기</span>
									</c:otherwise>
								</c:choose> --%>

							</div>
							<a href="/shops/shopsListOk.sh">
								<div id="list_button">목록</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- 푸터 -->
	<jsp:include page="/footer.jsp" />
	<!-- 로그인 요청 모달 -->
	<div id="restaurantModalLogin"></div>
	<script>
		window.shopsNumber = "${shops.shopsNumber}";

		window.usersNumber ="${sessionScope.usersNumber}";;
		
		console.log(window.shopsNumber);
		console.log(window.usersNumber);
	</script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f1ed8d49c70a5d2d213e83f145527e1"></script>

	<script type="text/javascript">
	const latitude = <c:out value="${shops.getShopsLatitude()}" /> 
	const longitude = <c:out value="${shops.getShopsLongitude()}" />
	
	console.log("lat = "  + latitude);
	console.log("long = "  + longitude);
	
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng( latitude, longitude ), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		 const markerPosition = new kakao.maps.LatLng(latitude, longitude);
		  const marker = new kakao.maps.Marker({
		    position: markerPosition
		  });

		  marker.setMap(map);
	</script>
</body>
</html>
