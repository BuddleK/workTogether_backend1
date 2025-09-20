<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>공지사항 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/notice.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/modal/modalDeleteNotice.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/notice.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
</head>

<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<div id="sidebar"></div>
		<section class="userManager">
			<div class="searchcontent">
				<div class="title">
					<h1>공지사항 관리</h1>
				</div>
				<form
					action="${pageContext.request.contextPath}/admin/adminNotice.ad"
					method="post">
					<div class="searchbox">
						<select name="column" id="" class="search_column">
							<option value="number">번호</option>
							<option value="title">제목</option>
							<option value="name">작성자</option>
							<option value="cnt">조회수</option>
							<option value="date">작성일</option>
						</select> <input type="text" />
						<button>검색</button>
					</div>
				</form>
				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">번호</div>
						<div class="board_head board_title">제목</div>
						<div class="board_head board_name">작성자</div>
						<div class="board_head board_cnt">조회수</div>
						<div class="board_head board_date">작성일</div>
					</div>
					<div class="table_big">
						<div class="table_md">
							<c:forEach var="notice" items="${noticeList}">
								<ul class="table_body">
									<li class="body_number"><a
										href="${pageContext.request.contextPath}/admin/adminNoticeDetail.ad?noticeNumber=${notice.noticeNumber}">
											${notice.noticeNumber} </a></li>
									<li class="body_content"><a
										href="${pageContext.request.contextPath}/admin/adminNoticeDetail.ad?noticeNumber=${notice.noticeNumber}">
											${notice.noticeTitle} </a></li>
									<li class="body_name"><a
										href="${pageContext.request.contextPath}/admin/adminNoticeDetail.ad?noticeNumber=${notice.noticeNumber}">
											${notice.adminNumber} <!-- 필요 시 이름으로 바꿔서 표시 가능 -->
									</a></li>
									<li class="body_cnt"><a
										href="${pageContext.request.contextPath}/admin/adminNoticeDetail.ad?noticeNumber=${notice.noticeNumber}">
											${notice.noticeViewCount} </a></li>
									<li class="body_date"><a
										href="${pageContext.request.contextPath}/admin/adminNoticeDetail.ad?noticeNumber=${notice.noticeNumber}">
											${notice.noticeCreatedDate} </a></li>
									<li class="body_delete">
										<button class="delete_btn"
											onclick="modalDeleteNoticeShow(${notice.noticeNumber})"
											type="button">삭제</button>
									</li>
								</ul>
							</c:forEach>
						</div>
					</div>

					<div class="paging_box">
						<ul class="paging" style="margin: 0px auto;">
							<c:if test="${prev}">
								<li><a
									href="${pageContext.request.contextPath}/admin/adminNotice.ad?page=${startPage - 1}"
									class="prev">&lt;</a></li>
							</c:if>
							<c:set var="realStartPage"
								value="${startPage < 0 ? 0 : startPage}" />
							<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
								<c:choose>
									<c:when test="${!(i == page) }">
										<li><a
											href="${pageContext.request.contextPath}/admin/adminNotice.ad?page=${i}">
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
									href="${pageContext.request.contextPath}/admin/adminNotice.ad?page=${endPage + 1}"
									class="next">&gt;</a>
							</c:if>
						</ul>
						<div class="add">
							<a href="${pageContext.request.contextPath}/admin/adminNoticeInsert.ad?adminNumber=${notice.adminNumber}" class="add_btn">등록</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />
	<div id="modalDeleteNotice"></div>
</body>
</html>
