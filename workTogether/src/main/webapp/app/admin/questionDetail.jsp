<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>1:1문의 사항</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/questionDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/modal/modalQuestionAnswered.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<section class="notice_detail">
			<div class="notice_info">
				<div class="info_title">
					<span class="title"><c:out
							value="${question.referenceTitle}" /></span>
				</div>
				<div class="member_info">
					<div class="member_name_title">작성자명</div>
					<div class="member_name">
						<c:out value="${question.usersName}" />
					</div>
					<div class="member_add_title">등록날짜</div>
					<div class="member_add_date">
						${question.referenceCreatedDate}
					</div>
				</div>
				<div class="qna">
					<div class="qna_title">문의사항 내용</div>
					<div class="qna_content">
						<c:out value="${question.referenceContent}" />
					</div>
				</div>
			</div>
			<form action="${pageContext.request.contextPath}/admin/adminReferenceDetailOk.ad" method="post">
			  <input type="hidden" name="referenceNumber" value="${reference.referenceNumber}" />
			  <textarea name="replyContent" id="reply" placeholder="답변을 달아주세요"></textarea>
			
			  <div class="notice_btn">
			    <!-- 목록 이동 -->
			    <button class="list" type="button"
			      onclick="location.href='${pageContext.request.contextPath}/admin/adminReferenceList.ad'">목록</button>
			    <!-- 답변 달기 (submit) -->
			    <button class="delete" type="submit">답변 달기</button>
			  </div>
			</form>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />
	<div id="modalQuestionAnswered"></div>
</body>
</html>
