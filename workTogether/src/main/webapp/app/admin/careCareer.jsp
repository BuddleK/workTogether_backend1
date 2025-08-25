<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄 회원 이력 수정 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/careCareer.css" />
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
					<h1>돌봄 회원 이력 수정 관리</h1>
				</div>
				<form
					action="${pageContext.request.contextPath}/admin/careCareer/list.ad"
					method="get">
					<div class="searchbox">
						<select name="column" id="" class="search_column">
							<option value="number">수정 신청 번호</option>
							<option value="name">신청자 명</option>
							<option value="id">신청자 아이디</option>
							<option value="date">신청 날짜</option>
							<option value="condition">상태</option>
						</select> <input type="text" name="keyword" value="${param.keyword}" />
						<button type="submit">검색</button>
					</div>
				</form>

				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">수정 신청 번호</div>
						<div class="board_head board_name">신청자 명</div>
						<div class="board_head board_id">신청자 아이디</div>
						<div class="board_head board_date">신청 날짜</div>
						<div class="board_head board_condition">상태</div>
					</div>

					<div class="table_content">
						<c:choose>
							<c:when test="${empty list}">
								<div class="empty">조회된 이력 수정 신청이 없습니다.</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="row" items="${list}">
									<ul class="table_body">
										<li class="body_number"><a
											href="${pageContext.request.contextPath}/app/admin/careCareerDetailUpdate.jsp?number=${row.number}">${row.number}</a>
										</li>
										<li class="body_name"><a
											href="${pageContext.request.contextPath}/app/admin/careCareerDetailUpdate.jsp?number=${row.number}">${row.name}</a>
										</li>
										<li class="body_id"><a
											href="${pageContext.request.contextPath}/app/admin/careCareerDetailUpdate.jsp?number=${row.number}">${row.userId}</a>
										</li>
										<li class="body_date"><a
											href="${pageContext.request.contextPath}/app/admin/careCareerDetailUpdate.jsp?number=${row.number}">${row.date}</a>
										</li>
										<li class="body_condition"><a
											href="${pageContext.request.contextPath}/app/admin/careCareerDetailUpdate.jsp?number=${row.number}">${row.status}</a>
										</li>
									</ul>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>
