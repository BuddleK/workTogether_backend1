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
					href="/myPageNormal/normalModify.mn">개인정보
						수정</a></li>
				<li><a href="/myPageNormal/normalfavoriteList.mn">찜한
						목록</a></li>
				<li><a
					href="/myPageNormal/normalHeartListTotal.mn">하트 목록</a></li>
				<li><a
					href="/myPageNormal/normalMatching.mn">매칭
						기록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalsendMesseage.jsp">쪽지함</a></li>
				<li><a href="/myPageNormal/normalPostsList.mn">게시글
						관리</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalPoint.jsp">포인트
						충전</a></li>
				<li><a
					href="/myPageNormal/normalReferenceInsert.mn">1
						대 1 문의</a></li>
				<li><a href="/myPageNormal/normalExit.mn">회원
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
						
					</ul>
				</div>
				<!-- 페이지네이션 -->
				<div id="pagenation">
				<ul class="page">
						<c:if test="${prev}">
							<li><a
								href="${pageContext.request.contextPath}/myPageNormal/normalfavoriteList.mn?page=${startPage - 1}"
								class="prev">&lt;</a></li>
						</c:if>
						<c:set var="realStartPage"
							value="${startPage < 0 ? 0 : startPage}" />
						<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
							<c:choose>
								<c:when test="${!(i == page) }">
									<li><a
										href="${pageContext.request.contextPath}/myPageNormal/normalfavoriteList.mn?page=${i}">
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
								href="${pageContext.request.contextPath}/myPageNormal/normalfavoriteList.mn?page=${endPage + 1}"
								class="next">&gt;</a>
						</c:if>
					</ul>
				</div>
			</div>
		</form>

	</main>
	<jsp:include page="/footer.jsp" />
</body>

<script>
	window.usersNumber = "${usersNumber}"
</script>
</html>