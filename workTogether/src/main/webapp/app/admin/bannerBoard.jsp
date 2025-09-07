<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>배너 뉴스 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/bannerBoard.css" />
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
					<h1>배너 뉴스 관리 (최대 6개)</h1>
				</div>

				<div class="table">
					<!-- 헤더 -->
					<div class="board_column">
						<div class="board_head board_number">번호</div>
						<div class="board_head board_title">제목</div>
						<div class="board_head board_date">작성일</div>
						<div class="board_head board_action">관리</div>
					</div>

					<!-- 내용 -->
					<div class="table_content">
						<c:choose>
							<c:when test="${empty banners}">
								<div class="empty">등록된 배너 뉴스가 없습니다.</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="b" items="${banners}">
									<c:if test="${not empty b.bannerTitle}">
										<ul class="table_body" id="banner-row-${b.bannerNewsNumber}">
											<!-- 번호 -->
											<li class="body_number"><c:out
													value="${b.bannerNewsNumber}" /></li>

											<!-- 제목(수정 페이지로 이동) -->
											<li class="body_content"><a
												href="${pageContext.request.contextPath}/admin/adminNewsBannerUpdate.ad?bannerNewsNumber=${b.bannerNewsNumber}">
													<c:out value="${b.bannerTitle}" />
											</a></li>

											<!-- 작성일 -->
											<li class="body_date"><c:out
													value="${b.bannerCreatedDate}" /></li>

											<!-- 관리 -->
											<li class="body_delete"><a class="edit_btn"
												href="${pageContext.request.contextPath}/admin/adminNewsBannerUpdate.ad?bannerNewsNumber=${b.bannerNewsNumber}">수정</a>
												<form method="post"
													action="${pageContext.request.contextPath}/admin/adminNewsBannerDeleteOk.ad"
													style="display: inline;"
													onsubmit="return confirm('정말 삭제하시겠어요?');">
													<input type="hidden" name="bannerNewsNumber"
														value="${b.bannerNewsNumber}" />
													<button type="submit" class="delete_btn">삭제</button>
												</form></li>
										</ul>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- 등록 버튼 -->
					<div class="add">
						<a
							href="${pageContext.request.contextPath}/admin/adminNewsBannerUpdate.ad"
							class="add_btn">등록</a>
					</div>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
	<div id="modalDeleteNews"></div>

	<script>
		let adminNumber = "${sessionScope.adminNumber}";
	</script>
</body>
</html>
