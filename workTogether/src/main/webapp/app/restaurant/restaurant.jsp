<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>함께 걸음 - 음식점 리스트</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/restaurant/restaurant.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/restaurant/restaurantModal.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/restaurant/restaurant.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/restaurant/restaurantModalLogin.js"></script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/header.jsp" />
	<!-- 메인 -->
	<main>
		<!-- 메인 바디 -->
		<div class="main_body">
			<!-- 페이지 타이틀 -->
			<p class="page_title">가게 리스트</p>
			<!-- 페이지 내용 -->
			<div class="context">
				<!-- 지역 선택 영역 -->
				<div class="region_select">
					<!-- 지역 목록 -->
					<ul class="region_list">
						<!-- 지역 -->
						<li onclick="reClicked(0)" class="region_button">
							<div class="region_mark"></div> 방배동
						</li>
						<!-- 지역 -->
						<li onclick="reClicked(1)" class="region_button">
							<div class="region_mark"></div> 반포동
						</li>
						<!-- 지역 -->
						<li onclick="reClicked(2)" class="region_button">
							<div class="region_mark"></div> 서초동
						</li>
						<!-- 지역 -->
						<li onclick="reClicked(3)" class="region_button">
							<div class="region_mark"></div> 양재동
						</li>
						<!-- 지역 -->
						<li onclick="reClicked(4)" class="region_button">
							<div class="region_mark"></div> 내곡동
						</li>
						<!-- 지역 -->
						<li onclick="reClicked(5)" class="region_button">
							<div class="region_mark"></div> 잠원동
						</li>
					</ul>
					<!-- 동 선택 영역 -->
					<div class="region_small">
						<!-- 동 리스트 -->
						<ul id="region_small_list"></ul>
					</div>
				</div>
				<!-- 음식점 선택 영역 -->
				<div class="restaurant_select">
					<!-- 음식점 카드 표출 영역 -->
					<div class="restaurant_board">
						<!-- 음식점 카드 영역 윗줄(2개) -->
						<div class="restaurant_row">
							<c:choose>
								<c:when test="${not empty shopsList}">
									<c:forEach var="shop" items="${shopsList}">
										<div class="restaurant_card">
											<a class="go_detail"
												href="${pageContext.request.contextPath}/shops/shopsListOk.sh?shopsNumber=${shop.shopsNumber}">
												<!-- href="./../restaurant/restaurantDetail.jsp?restaurant=0&leNum=1&adNum=2"> -->
												<div class="restaurant_name">
													<c:out value="${shop.getShopsName()}" />
													<!-- 좌표 확인용 -->
													<c:out value="${shop.getShopsBranchName()}" />
												</div>
											</a>
											<div class="restaurant_introduce">
												<div class="restaurant_info">
													<div>
														<c:out value="${shop.getShopsAdminDong()}" />
													</div>
													<div>
														<c:out value="${shop.getShopsIntroText()}" />
													</div>
													<div>
														영업 시간 :
														<c:out value="${shop.getShopsWorkingHours()}" />
													</div>
												</div>
												<div class="restaurant_mark">
													<div onclick="togleStar(0)" class="star_img_box">
														<img class="star_img"
															src="./../../assets/img/restaurant/star.png"
															data-favorite="<c:out value='${shop.getIsFavorite()}'/>">
													</div>
													<div>찜하기</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div>
										<div align="center">등록된 가게가 없습니다.</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- 음식점 카드 영역 아랫줄(2개) -->
						<!-- <div class="restaurant_row"></div> -->
					</div>
					<!-- 페이지네이션 -->
					<div class="restaurant_pagenation">
						<ul class="paging">
							<c:if test="${prev}">
								<li><a
									href="${pageContext.request.contextPath}/shops/shopsListOk.sh?page=${startPage - 1}"
									class="prev">&lt;</a></li>
							</c:if>
							<c:set var="realStartPage"
								value="${startPage < 0 ? 0 : startPage}" />
							<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
								<c:choose>
									<c:when test="${!(i == page) }">
										<li><a
											href="${pageContext.request.contextPath}/shops/shopsListOk.sh?page=${i}">
												<c:out value="${i}" />
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#" class="active"> <c:out value="${i}" />
										</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${next}">
								<li><a
									href="${pageContext.request.contextPath}/shops/shopsListOk.sh?page=${endPage + 1}"
									class="next">&gt;</a>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- 푸터 -->
	<jsp:include page="/footer.jsp" />
	<!-- 로그인 요청 모달 -->
	<div id="restaurantModalLogin"></div>
</body>
<script>
	let userNumber = "${sessionScope.memberNumber}";
</script>
</html>
