<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>공지사항 상세페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/noticeDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/noticeDetail.js"></script>
</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<section class="notice_detail">
			<div class="notice_info">
			<form action="${pageContext.request.contextPath}/admin/adminNotice.ad" method="post" class="detail_form" enctype="multipart/form-data">
				<div class="info_title">
					<span class="title"><c:out value="${notice.noticeTitle}"/></span>
				</div>
				<div class="member_info">
					<div class="member_name_title">작성자명</div>
					<div class="member_name">${notice.adminName}</div>
					<div class="member_add_title">등록날짜</div>
					<div class="member_add_date">${notice.noticeCreatedDate}</div>
				</div>
				<div class="cnt">
					<div class="cnt_title">조회수</div>
					<div class="cnt_content">${notice.noticeViewCount}</div>
				</div>
				<div class="notice_content">
					<textarea name="content" id="content">${notice.noticeContent}</textarea>
				</div>
				<div class="notice_btn">
					<button class="list" formaction="${pageContext.request.contextPath}/admin/adminNotice.ad">목록</button>
					<button class="update" formaction="${pageContext.request.contextPath}/admin/adminNoticeUpdate.ad?adminNumber=${notice.adminNumber}">수정</button>
				</div>
			</form>
			</div>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />
	<div id="modalUpdate"></div>
</body>
</html>
