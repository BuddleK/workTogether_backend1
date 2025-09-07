<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal_Heart</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalheart.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalheart.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<main>
		<!-- 메뉴 사이드바 섹션 -->
		<nav class="main_sidebar">
			<ul>
				<li><img
					src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg"
					alt="#"></li>
				<li><a
					href="${pageContext.request.contextPath}/normalPwCheck.jsp">개인정보
						수정</a></li>
				<li><a href="${pageContext.request.contextPath}/normalMark.jsp">찜한
						목록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalheart.jsp">하트 목록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalMatching.jsp">매칭
						기록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalsendMesseage.jsp">쪽지함</a></li>
				<li><a href="${pageContext.request.contextPath}/normalPost.jsp">게시글
						관리</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalPoint.jsp">포인트
						충전</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalReference.jsp">1
						대 1 문의</a></li>
				<li><a href="${pageContext.request.contextPath}/normalQuit.jsp">회원
						탈퇴</a></li>
			</ul>
		</nav>
		<form action="" method="get">
			<!-- 메뉴 제목 -->
			<div class="div_mark">
				<div class="title">하트 목록</div>
			</div>
			<!-- 찜한 목록 섹션 -->
			<div class="context">
				<!-- 3개씩 보여주는 목록 -->
				<div class="card_row">
					<ul id="card_list_1">
						<c:choose>
							<c:when test="${not empty heartList }">
								<c:forEach var="care" items="${heartList }">
									<li class="care_card" data-carenumber="${care.careNumber}">
										<div class="heart_img_box" >
											<img  class="heart_img"
												src="./../../assets/img/careMember/heart_icon.png">
										</div> <a href="./../careMember/careMemberDetail.html"
										class="profile">
											<div class="profile_pic_box">
												<c:choose>
													<c:when test="${not empty care.getProfilesFilesName() } ">
														<img class="profile_pic"
															src="${pageContext.request.contextPath}/${care.getProfilesFilesPath() }/${care.getProfilesFilesName()}.${care.getProfilesFilesType()}">
													</c:when>
													<c:otherwise>
														<img class="profile_pic"
															src="${pageContext.request.contextPath}/assets/img/careMember/basic.png">
													</c:otherwise>
												</c:choose>
											</div>
											<div class="profile_name">
												${care.usersName} 
											</div>
											<div class="day_row">
												<c:if test="${care.getDayMonday() eq 'Y'}">
													<div class="day">월</div>
												</c:if>
												<c:if test="${care.getDayTuesday() eq 'Y'}">
													<div class="day">화</div>
												</c:if>
												<c:if test="${care.getDayWednesday() eq 'Y'}">
													<div class="day">수</div>
												</c:if>
												<c:if test="${care.getDayThursday() eq 'Y'}">
													<div class="day">목</div>
												</c:if>
												<c:if test="${care.getDayFriday() eq 'Y'}">
													<div class="day">금</div>
												</c:if>
												<c:if test="${care.getDaySaturday() eq 'Y'}">
													<div class="day">토</div>
												</c:if>
												<c:if test="${care.getDaySunday() eq 'Y'}">
													<div class="day">일</div>
												</c:if>
											</div>
											<div class="profile_intro">
												<div class="short_intro">${care.careIntroText }</div>
												<div class="long_intro">
													<p>${care.profilesFilesName }</p>
													<p>${care.usersAddressLine1 } 거주</p>
												</div>
											</div>
									</a>
									</li>
								</c:forEach>
							</c:when>
						</c:choose>




					</ul>
				</div>
				<!-- 페이지네이션 -->
				<div id="pagenation">페이지네이션</div>
			</div>
		</form>

	</main>
	<jsp:include page="/footer.jsp" />
</body>

<script >
	window.usersNumber= "${usersNumber}"

</script>
</html>