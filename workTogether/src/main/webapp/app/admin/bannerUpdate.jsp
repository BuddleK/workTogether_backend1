<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>뉴스 추가</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/bannerUpdate.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/modal/modalAddNewsFinished.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/banneradd.js"></script>
</head>
<body>
	<jsp:include page="/header_admin.jsp" />

	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
	<c:set var="isEdit" value="${not empty banner}" />

	<c:choose>
		<c:when test="${isEdit}">
			<c:set var="formAction"
				value="${pageContext.request.contextPath}/admin/adminNewsBannerUpdateOk.ad" />
		</c:when>
		<c:otherwise>
			<c:set var="formAction"
				value="${pageContext.request.contextPath}/admin/adminNewsBannerInsertOk.ad" />
		</c:otherwise>
	</c:choose>

	<main>
		<section class="add_section">
			<form id="write-form" method="post" enctype="multipart/form-data"
				data-mode="${isEdit ? 'edit' : 'create'}" action="${formAction}">

				<c:if test="${isEdit}">
					<input type="hidden" name="bannerNewsNumber"
						value="${banner.bannerNewsNumber}" />
					<input type="hidden" name="bannerImageFilesNumber"
						value="${banner.bannerImageFilesNumber}" />
				</c:if>

				<div class="add_data">
					<div class="title">뉴스 제목</div>
					<input type="text" name="newsTitle" class="title_content"
						placeholder="뉴스 제목을 입력하세요"
						value="${isEdit ? banner.bannerTitle : ''}" required />

					<div class="name">작성자명</div>
					<input type="text" class="name_content"
						value="${empty sessionScope.adminName ? '관리자' : sessionScope.adminName}"
						readonly />

					<div class="date">작성 날짜</div>
					<input type="text" class="date_content" value="${today}" readonly />

					<input type="hidden" name="adminNumber"
						value="${sessionScope.adminNumber}" />
				</div>

				<div class="add_link">
					<div class="add_link_title">뉴스 링크</div>
					<input type="url" name="newsLinkUrl" class="link_input"
						placeholder="https://example.com"
						value="${isEdit ? banner.bannerLinkUrl : ''}" required />
				</div>

				<div class="add_image">
					<div class="add_image_title">배너 이미지</div>
					<c:if test="${isEdit and not empty banner.bannerFilesName}">
						<input type="hidden" name="existingImagePath"
							value="${banner.bannerFilesPath}/${banner.bannerFilesName}" />
					</c:if>
					<input id="imageFile" type="file" name="imageFile" accept="image/*" />
					<!-- 미리보기/메타/삭제 버튼 없음 -->
				</div>

				<div class="add_btn">
					<button class="cancle" type="button" onclick="history.back();">취소</button>
					<button class="add" type="submit">${isEdit ? '수정 완료' : '등록 완료'}</button>
				</div>
			</form>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
	<div id="modalAddNewsFinished"></div>
</body>
</html>
