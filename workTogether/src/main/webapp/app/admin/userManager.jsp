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
				<form action="" method="">
					<div class="searchbox">
						<select name="column" id="" class="search_column">
							<option value="number">회원 번호</option>
							<option value="name">회원 이름</option>
							<option value="id">회원 아이디</option>
							<option value="email">회원 이메일</option>
							<option value="phone">회원 전화번호</option>
							<option value="type">회원 분류</option>
						</select> <input type="text" />
						<button>검색</button>
					</div>
				</form>
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
							<ul class="table_body">
								<%-- <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">1</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/careDetail.jsp">2</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/careDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/careDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/careDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/careDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/careDetail.jsp">돌봄</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">3</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">4</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">5</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">6</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">7</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">8</a>
                  </li>
                  <li class="body_name">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">거북이</a>
                  </li>
                  <li class="body_id">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">tutleman08</a>
                  </li>

                  <li class="body_email">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >bingo@naver.com</a
                    >
                  </li>
                  <li class="body_phone">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp"
                      >010-1234-5678</a
                    >
                  </li>
                  <li class="body_type">
                    <a href="${pageContext.request.contextPath}/app/admin/userDetail.jsp">일반</a>
                  </li> --%>
								<c:choose>
									<c:when test="${not empty boardList}">
										<c:forEach var="users" items="${userList}">
											<div class="users-row">
												<div class="users-item body_number">
													<c:out value="${users.getUserNumber()}" />
												</div>
												<div class="users-item body_name">
													<a
														href="${pageContext.request.contextPath}/admin/userManagerListOk?usersNumber=${users.usersNumber}">
														<c:out value="${users.getUserName()}" />
													</a>
												</div>
												<div class="users-item body_id">
													<a
														href="${pageContext.request.contextPath}/admin/userManagerListOk?usersNumber=${users.usersNumber}">
														<c:out value="${users.getUserId()}" />
													</a>
												</div>
												<div class="users-item body_email">
													<a
														href="${pageContext.request.contextPath}/admin/userManagerListOk?usersNumber=${users.usersNumber}">
														<c:out value="${users.getUserEmail()}" />
													</a>
												</div>
												<div class="users-item body_phone">
													<a
														href="${pageContext.request.contextPath}/admin/userManagerListOk?usersNumber=${users.usersNumber}">
														<c:out value="${users.getUserPhone()}" />
													</a>
												</div>
												<div class="users-item body_type">
													<a
														href="${pageContext.request.contextPath}/admin/userManagerListOk?usersNumber=${users.usersNumber}">
														<c:choose>
															<c:when test="${ users.userType == 'C'}">
																<c:out value="돌봄" />
															</c:when>
															<c:when test="${ users.userType == 'N'}">
																<c:out value="일반" />
															</c:when>
															<c:otherwise>
																<c:out value="알수없음" />
															</c:otherwise>
														</c:choose>
													</a>
												</div>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<dev>
										<div colspan="6" align="center">등록된 유저가 없습니다.</div>
										</dev>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
					<div class="paging_box">
						<ul class="paging">
							<!-- <li class="prev"><a href="">&lt;</a></li>
							<li class="page_number"><a href="">1</a></li>
							<li class="page_number"><a href="">2</a></li>
							<li class="page_number"><a href="">3</a></li>
							<li class="page_number"><a href="">4</a></li>
							<li class="page_number">...</li>
							<li class="next"><a href="">&gt;</a></li> -->

							<c:if test="${prev}">
								<li><a href="${pageContext.request.contextPath}/admin/userManagerListOk.ad?page=${startPage - 1}"
									class="prev">&lt;</a></li>
							</c:if>
							<c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
							<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
								<c:choose>
									<c:when test="${!(i == page) }">
										<li><a href="${pageContext.request.contextPath}/admin/userManagerListOk.ad?page=${i}">
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
								<li><a href="${pageContext.request.contextPath}/admin/userManagerListOk.ad?page=${endPage + 1}"
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
