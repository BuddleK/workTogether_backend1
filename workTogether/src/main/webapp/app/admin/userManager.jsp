<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/userManager.css" />
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
					<h1>회원관리</h1>
				</div>
				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">회원 번호</div>
						<div class="board_head board_name">회원 이름</div>
						<div class="board_head board_id">회원 아이디</div>
						<div class="board_head board_email">회원 이메일</div>
						<div class="board_head board_phone">회원 전화번호</div>
						<div class="board_head board_type">회원 분류</div>
					</div>
					<div class="table_big">
						<div class="table_md">
							<div class="table_body">
								<c:choose>
									<c:when test="${not empty userList}">
										<c:forEach var="users" items="${userList}">
											<div class="users-row"
												style="display: flex; flex-direction: row; text-align: center; border-bottom: 1px solid black">
												<div class="users-item body_number">
													<c:out value="${users.usersNumber}" />
												</div>
												<div class="users-item body_name">
													<a
														href="${pageContext.request.contextPath}/admin/adminUserDetail.ad?usersNumber=${users.usersNumber}">
														<c:out value="${users.usersName}" />
													</a>
												</div>
												<div class="users-item body_id">
													<a
														href="${pageContext.request.contextPath}/admin/adminUserDetail.ad?usersNumber=${users.usersNumber}">
														<c:out value="${users.usersId}" />
													</a>
												</div>
												<div class="users-item body_email">
													<a
														href="${pageContext.request.contextPath}/admin/adminUserDetail.ad?usersNumber=${users.usersNumber}">
														<c:out value="${users.usersEmail}" />
													</a>
												</div>
												<div class="users-item body_phone">
													<a
														href="${pageContext.request.contextPath}/admin/adminUserDetail.ad?usersNumber=${users.usersNumber}">
														<c:out value="${users.usersPhone}" />
													</a>
												</div>
												<div class="users-item body_type">
													<a
														href="${pageContext.request.contextPath}/admin/adminUserDetail.ad?usersNumber=${users.usersNumber}">
														<c:choose>
															<c:when test="${users.usersType == 'C'}">돌봄</c:when>
															<c:when test="${users.usersType == 'N'}">일반</c:when>
															<c:otherwise>알수없음</c:otherwise>
														</c:choose>
													</a>
												</div>
											</div>
										</c:forEach>

									</c:when>
									<c:otherwise>
										<div>
											<div colspan="6" align="center">등록된 유저가 없습니다.</div>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="paging_box">
						<ul class="paging" style="margin: 0px auto;">
							<c:if test="${prev}">
								<li><a
									href="${pageContext.request.contextPath}/admin/adminUserManagerList.ad?page=${startPage - 1}"
									class="prev">&lt;</a></li>
							</c:if>
							<c:set var="realStartPage"
								value="${startPage < 0 ? 0 : startPage}" />
							<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
								<c:choose>
									<c:when test="${!(i == page) }">
										<li><a
											href="${pageContext.request.contextPath}/admin/adminUserManagerList.ad?page=${i}">
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
									href="${pageContext.request.contextPath}/admin/adminUserManagerList.ad?page=${endPage + 1}"
									class="next">&gt;</a>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>
