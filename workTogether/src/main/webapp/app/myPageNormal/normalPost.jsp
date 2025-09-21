<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal_Post</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalPost.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalPost.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />

	<main>
		<!-- 메뉴 사이드바 섹션 -->
		<jsp:include page="sidebar.jsp"></jsp:include>
		
		<form action="" method="get">
			<div class="div_mark">
				<!-- 메뉴 제목 -->
				<div class="title">게시글 관리</div>
				<nav class="div_choose">
					<ul>
						<li>작성한 게시글 목록</li>
					</ul>
				</nav>
				<!-- 게시글 목록 컬럼 -->
				<nav class="mark_nav">
					<ul>
						<li><input onclick="toggleMarksAll()" id="checkbox_col"
							name="mark_check_col" type="checkbox"></li>
						<li class="name_col">
							<div>작성자</div>
						</li>
						<li class="location_col">
							<div>제목</div>
						</li>
						<li class="phone_col">
							<div>날짜</div>
						</li>
					</ul>
				</nav>
				<!-- 게시글 리스트 목록 -->
				<ul class="mark_list" id="mark_list">

					<%-- <c:forEach var="li" items="${list }" varStatus="status">
						<li><input class="checkbox_li" name="mark_check"
							type="checkbox" value="1">
							<div class="name">
								<div>${li.usersName }</div>
							</div> <a class="location" href="${pageContext.request.contextPath}/post/postReadOk.po?postsNumber=${li.postsNumber}">
								<div>${li.postsTitle }</div>
						</a>
							<div class="phone">
								<div>${li.postsCreatedDate }</div>
							</div></li>
					</c:forEach> --%>

				</ul>
				<!-- 페이지네이션 -->
				<nav class="page">
					<ul>

					</ul>
				</nav>
				<!-- 게시글 삭제 버튼 -->
				<div class="div_delete">
					<button type="button" id="btnDelete"">삭제</button>
				</div>
			</div>
		</form>

	</main>
	<!-- 삭제 버튼 클릭시 확인 모달 -->
	<div class="modal" id="deleteModal">
		<div class="modal_box">
			<p>게시글을 삭제하시겠습니까?</p>
			<div class="modal_buttons">
				<button type="button" id="confirmDelete">확인</button>
				<button type="button" id="cancelDelete">취소</button>
			</div>
		</div>
	</div>
	<!-- 찜 삭제확인 모달 확인 버튼 클릭시 모달 -->
	<div class="modal" id="chek_deleteModal">
		<div class="modal_box">
			<p>게시글이 삭제 되었습니다.</p>
			<div class="modal_buttons">
				<button type="button" id="check_confirmDelete">확인</button>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp" />
</body>
</html>
