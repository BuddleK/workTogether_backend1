<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Care_PostDetailPage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageCare/careReferenceCheck.css">
</head>

<body>
	<jsp:include page="/header.jsp" />
	<main>
		<!-- 작성한 문의사항 디테일 페이지 -->


		<c:forEach var="list" items="${detailList}" varStatus="status">
			<section class="careReferenceCheck">
				<div class="title">
					<h2>
						<c:out value="${list.referenceTitle }"></c:out>
					</h2>
				</div>
				<div class="careReferenceCheck_info">
					<span>등록자명 : <c:out value="${list.usersName }"></c:out> </span> <span>등록일 : <c:out value="${list.referenceCreatedDate }"></c:out> </span><br>
				</div>
				<div class="careReferenceCheck_content">
					<c:out value="${list.referenceContent }"></c:out>
				</div>
				<!-- 관리자가 달아준 문의 답변 -->
				<c:forEach var="listReply" items="${detailReply}" varStatus="status">
				
				<section class="reply">
					<div class="comment">
						<div class="author"> <c:out value="${listReply.adminName }"></c:out> </div>
						<div class="cmt_content"> <c:out value="${listReply.replyContent }"></c:out> </div>
						<div class="date"><c:out value="${listReply.replyCreatedDate }"></c:out></div>
					</div>
				</section>
				</c:forEach>
				<!-- 문의 목록으로 가는 버튼 -->
				<div class="buttons">
					<a href="/myPageNormal/normalReferenceList.mn"><button
							class="btn_list">목록</button>
				</div>
				</a>
			</section>
		</c:forEach>

	</main>
	<jsp:include page="/footer.jsp" />

</body>

</html>