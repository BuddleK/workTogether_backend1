<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<main>
		<div id="sidebar"></div>

		<section class="userManager">
			<div class="searchcontent">
				<div class="title">
					<h1>뉴스 게시글 관리</h1>
				</div>

				<!-- 검색 (백엔드에서 column/keyword 처리 예정) -->
				<form
					action="${pageContext.request.contextPath}/admin/news/newsListOk.ad"
					method="get">
					<div class="searchbox">
						<select name="column" class="search_column">
							<option value="number"
								${param.column == 'number' ? 'selected' : ''}>번호</option>
							<option value="title"
								${param.column == 'title' ? 'selected' : ''}>제목</option>
							<option value="date" ${param.column == 'date'  ? 'selected' : ''}>작성일</option>
						</select> <input type="text" name="keyword" value="${param.keyword}" />
						<button type="submit">검색</button>
					</div>
				</form>

				<!-- 테이블 헤더 -->
				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">번호</div>
						<div class="board_head board_title">제목</div>
						<div class="board_head board_date">작성일</div>
						<div class="board_head board_action">관리</div>
					</div>

					<!-- 목록 -->
					<div class="table_content">
						<c:choose>
							<c:when test="${empty newsList}">
								<div class="empty">등록된 뉴스가 없습니다.</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="news" items="${newsList}">
									<c:url var="readUrl" value="/admin/news/newsReadOk.ad">
										<c:param name="newsNumber" value="${news.newsNumber}" />
									</c:url>

									<ul class="table_body" id="news-row-${news.newsNumber}">
										<li class="body_number"><a href="${readUrl}"> <c:out
													value="${news.newsNumber}" />
										</a></li>
										<li class="body_content"><a href="${readUrl}"> <c:out
													value="${news.newsTitle}" />
										</a></li>
										<li class="body_date"><a href="${readUrl}"> <c:out
													value="${news.newsCreatedDate}" />
										</a></li>
										<li class="body_delete">
											<form method="post"
												action="${pageContext.request.contextPath}/admin/news/newsDeleteOk.ad"
												onsubmit="return confirm('정말 삭제하시겠어요?');">
												<input type="hidden" name="newsNumber"
													value="${news.newsNumber}" /> <input type="hidden"
													name="page" value="${page}" />
												<button type="submit" class="delete_btn">삭제</button>
											</form>
										</li>
									</ul>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- 페이징 -->
					<c:if test="${not empty newsList}">
						<div class="paging_box">
							<ul class="paging">
								<c:if test="${prev}">
									<li class="prev"><a
										href="${pageContext.request.contextPath}/admin/news/newsListOk.ad?page=${startPage - 1}">&lt;</a>
									</li>
								</c:if>

								<c:forEach begin="${startPage}" end="${endPage}" var="p">
									<li class="page_number ${p == page ? 'active' : ''}"><a
										href="${pageContext.request.contextPath}/admin/news/newsListOk.ad?page=${p}">${p}</a>
									</li>
								</c:forEach>

								<c:if test="${next}">
									<li class="next"><a
										href="${pageContext.request.contextPath}/admin/news/newsListOk.ad?page=${endPage + 1}">&gt;</a>
									</li>
								</c:if>
							</ul>

						</div>
					</c:if>
					<!-- 등록 버튼 -->
					<div class="add">
						<a
							href="${pageContext.request.contextPath}/admin/news/newsWrite.ad"
							class="add_btn">등록</a>
					</div>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />

	<div id="modalDeleteNews"></div>

	<script>
		// 세션으로 내려온 관리자 번호(필요시 사용)
		let adminNumber = "${sessionScope.adminNumber}";
	</script>
</body>
</html>
