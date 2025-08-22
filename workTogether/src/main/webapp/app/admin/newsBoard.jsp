<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>뉴스 게시글 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/newsBoard.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />

<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/modal/modalDeleteNews.js"></script>
</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<!-- <div id="header"></div>-->

	<main>
		<div id="sidebar"></div>

		<section class="userManager">
			<div class="searchcontent">
				<div class="title">
					<h1>뉴스 게시글 관리</h1>
				</div>

				<!-- 검색 폼 -->
				<form
					action="${pageContext.request.contextPath}/admin/newsBoardSearch"
					method="get">
					<div class="searchbox">
						<select name="column" class="search_column">
							<option value="number">번호</option>
							<option value="title">제목</option>
							<option value="date">작성일</option>
						</select> <input type="text" name="keyword" />
						<button type="submit">검색</button>
					</div>
				</form>

				<!-- 게시글 테이블 -->
				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">번호</div>
						<div class="board_head board_title">제목</div>
						<div class="board_head board_date">작성일</div>
					</div>

					<div class="table_content">
						<div class="table">
							<c:forEach var="news" items="${newsList}">
								<ul class="table_body">
									<li class="body_number"><a
										href="${pageContext.request.contextPath}/admin/newsBoardDetail?id=${news.id}">${news.id}</a>
									</li>
									<li class="body_content"><a
										href="${pageContext.request.contextPath}/admin/newsBoardDetail?id=${news.id}">
											${news.title} </a></li>
									<li class="body_date"><a
										href="${pageContext.request.contextPath}/admin/newsBoardDetail?id=${news.id}">
											${news.date} </a></li>
									<li class="body_delete">
										<button class="delete_btn"
											onclick="modalDeleteNewsShow(${news.id})" type="button">
											삭제</button>
									</li>
								</ul>
							</c:forEach>
						</div>
					</div>

					<!-- 페이징 -->
					<div class="paging_box">
						<ul class="paging">
							<li class="prev"><a href="?page=${pagination.prevPage}">&lt;</a>
							</li>
							<c:forEach begin="1" end="${pagination.totalPages}" var="i">
								<li
									class="page_number <c:if test='${i == pagination.currentPage}'>active</c:if>">
									<a href="?page=${i}">${i}</a>
								</li>
							</c:forEach>
							<li class="next"><a href="?page=${pagination.nextPage}">&gt;</a>
							</li>
						</ul>

						<!-- 등록 버튼 -->
						<div class="add">
							<a
								href="${pageContext.request.contextPath}/app/admin/newsBoardAdd.jsp"
								class="add_btn">등록</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>

	<div id="footer"></div>
	<div id="modalDeleteNews"></div>
	<script>
    	let adminNumber = "${sessionScope.adminNumber}";
    </script>

</body>
</html>
