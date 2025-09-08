<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal_Mark</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalMark.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalMark.js"></script>
</head>

<body>
	<jsp:include page="/header.jsp" />
	<main>
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
					href="${pageContext.request.contextPath}/myPageNormal/normalMsgList.mn">쪽지함</a></li>
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
		<form action="/myPageNormal/normalfavoriteListDeleteOk.mn" method="get">
			<div class="div_mark">
				<div class="title">찜한 목록</div>
				<nav class="mark_nav">
					<ul>
						<li><input onclick="checkedAll()" id="checkbox_col"
							name="mark_check_col" type="checkbox"></li>
						<li class="name_col">
							<div>이름</div>
						</li>
						<li class="location_col">
							<div>위치</div>
						</li>
						<li class="phone_col">
							<div>전화번호</div>
						</li>
					</ul>
				</nav>
				<ul class="mark_list">
					<c:forEach var="fshop" items="${favoriteList}"  varStatus="status">
						<li id="li_${status.index+1}" value="${fshop.favoritesNumber}"><input class="checkbox_li" name="mark_check"
							type="checkbox"  value="${fshop.favoritesNumber}" >
							<div class="name">
								<div>${fshop.shopsName}</div>
							</div> <a class="location"
							href="${pageContext.request.contextPath}/shops/shopsDetailOk.sh?shopsNumber=${fshop.shopsNumber}">
								<div>${fshop.shopsRoadAddress}</div>
						</a>
							<div class="phone">
								<div>${fshop.shopsPhone }</div>
							</div></li>
					</c:forEach>
				</ul>
				<div class="restaurant_pagenation">
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
				<div class="div_delete">
					<button type="button" id="btnDelete">찜 삭제</button>
				</div>
			</div>
		</form>

	</main>
	<!-- 삭제 버튼 클릭시 확인 모달 -->
	<div class="modal" id="deleteModal">
		<div class="modal_box">
			<p>찜한 가게를 삭제하시겠습니까?</p>
			<div class="modal_buttons">
				<button type="button" id="confirmDelete">확인</button>
				<button type="button" id="cancelDelete">취소</button>
			</div>
		</div>
	</div>
	<!-- 찜 삭제확인 모달 확인 버튼 클릭시 모달 -->
	<div class="modal" id="chek_deleteModal">
		<div class="modal_box">
			<p>찜이 삭제 되었습니다.</p>
			<div class="modal_buttons">
				<button type="button" id="check_confirmDelete">확인</button>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp" />
</body>

</html>