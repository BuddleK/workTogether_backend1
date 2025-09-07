<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>배너 상세페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/bannerDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/bannerDetail.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<section class="add_section">
			<div class="add_data">
				<div class="title">뉴스제목</div>
				<div class="title_content">
					<c:out value="${banner.bannerTitle}" />
				</div>
				<div class="name">작성자명</div>
				<div class="name_content">
					<c:out
						value="${empty sessionScope.adminName ? '관리자' : sessionScope.adminName}" />
				</div>
				<div class="date">작성 날짜</div>
				<div class="date_content">
					<c:out value="${banner.bannerCreatedDate}" />
				</div>
			</div>

			<div class="add_content">
				<div class="board_title">뉴스내용</div>
				<div name="news" id="news" placeholder="" readonly>
					<!-- 배너는 본문 없음 → 이미지 표시 -->
					<c:choose>
						<c:when test="${not empty banner.bannerFilesName}">
							<img
								src="${pageContext.request.contextPath}${banner.bannerFilesPath}/${banner.bannerFilesName}"
								alt="배너 이미지"
								style="max-width: 480px; max-height: 270px; border: 1px solid #e5e5e5;" />
						</c:when>
						<c:otherwise>
							<div class="img">등록된 이미지가 없습니다.</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="add_link">
				<div class="add_link_title">뉴스링크</div>
				<input type="text" class="link_input"
					value="${banner.bannerLinkUrl}" readonly />
			</div>

			<div class="add_btn">
				<button class="cancle" onclick="history.back()" type="button">취소</button>
				<a class="add"
					href="${pageContext.request.contextPath}/admin/adminNewsBannerUpdate.ad?bannerNewsNumber=${banner.bannerNewsNumber}">수정</a>
			</div>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />
	<div id="modalUpdate"></div>
</body>
</html>
