<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>1:1 문의 사항 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/question.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
</head>

<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<div id="sidebar"></div>
		<section class="userManager">
			<div class="searchcontent">
				<div class="title">
					<h1>1:1 문의 사항 관리</h1>
				</div>
				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">문의 번호</div>
						<div class="board_head board_title">문의 제목</div>
						<div class="board_head board_name">작성자</div>
						<div class="board_head board_id">회원 아이디</div>
						<div class="board_head board_date">신청 날짜</div>
						<div class="board_head board_type">답변 여부</div>
					</div>
					<div class="table_content">
						<c:forEach var="q" items="${questions}">
							<ul class="table_body">
								<li class="body_number"><a href="${pageContext.request.contextPath}/admin/adminReferenceDetail.ad?referenceNumber=${q.referenceNumber}">
										${q.referenceNumber} </a></li>
								<li class="body_title"><a href="${pageContext.request.contextPath}/admin/adminReferenceDetail.ad?referenceNumber=${q.referenceNumber}">
										${q.referenceTitle} </a></li>
								<li class="body_name">${q.usersName}</li>
								<li class="body_id">${q.usersId}</li>
								<li class="body_date">${q.referenceCreatedDate}</li>
								<li class="body_type">
								<c:choose>
									<c:when test="${q.answeredYn}">Y</c:when>
									<c:otherwise>N</c:otherwise>
								</c:choose></li>
							</ul>
						</c:forEach>
					</div>
				</div>
				<div class="paging_box">
					<ul class="paging" style="margin: 0px auto;">
						<c:if test="${prev}">
							<li><a
								href="${pageContext.request.contextPath}/admin/adminReferenceDetail.ad?page=${startPage - 1}"
								class="prev">&lt;</a></li>
						</c:if>
						<c:set var="realStartPage"
							value="${startPage < 0 ? 0 : startPage}" />
						<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
							<c:choose>
								<c:when test="${!(i == page) }">
									<li><a
										href="${pageContext.request.contextPath}/admin/adminReferenceDetail.ad?page=${i}">
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
								href="${pageContext.request.contextPath}/admin/adminReferenceDetail.ad?page=${endPage + 1}"
								class="next">&gt;</a>
						</c:if>
					</ul>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>
