<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄 회원 신청 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/careRequest.css" />
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
					<h1>돌봄 회원 신청 관리</h1>
				</div>

				<!-- 테이블 헤더 -->
				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">회원번호</div>
						<div class="board_head board_title">아이디</div>
						<div class="board_head board_title">이름</div>
						<div class="board_head board_date">신청일</div>
						<div class="board_head board_title">상태</div>
					</div>

					<!-- 목록 -->
					<div class="table_content">
						<c:choose>
							<c:when test="${empty list}">
								<div class="empty"
									style="height: 120px; display: flex; align-items: center; justify-content: center;">
									대기 중인 신청이 없습니다.</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="row" items="${list}">
									<ul class="table_body">
										<li class="body_number"><c:out value="${row.usersNumber}" />
										</li>
										<li class="body_content"><c:out value="${row.usersId}" />
										</li>
										<li class="body_content"><c:out value="${row.usersName}" />
										</li>
										<li class="body_date"><c:out
												value="${row.usersCreatedDate}" /></li>
										<li class="body_content"><c:choose>
												<c:when test="${row.careAccept eq 'W'}">대기중</c:when>
												<c:when test="${row.careAccept eq 'Y'}">승인</c:when>
												<c:otherwise>반려</c:otherwise>
											</c:choose></li>
									</ul>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- 페이징 -->
					<c:if test="${not empty list}">
						<div class="paging_box">
							<ul class="paging">
								<c:if test="${prev}">
									<li class="prev"><a
										href="${pageContext.request.contextPath}/admin/care/list.ad?page=${startPage - 1}">&lt;</a>
									</li>
								</c:if>

								<c:forEach begin="${startPage}" end="${endPage}" var="p">
									<li class="page_number ${p == page ? 'active' : ''}"><a
										href="${pageContext.request.contextPath}/admin/care/list.ad?page=${p}">${p}</a>
									</li>
								</c:forEach>

								<c:if test="${next}">
									<li class="next"><a
										href="${pageContext.request.contextPath}/admin/care/list.ad?page=${endPage + 1}">&gt;</a>
									</li>
								</c:if>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>