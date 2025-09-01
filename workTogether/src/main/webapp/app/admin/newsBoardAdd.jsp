<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>뉴스 추가</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/newsBoardAdd.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />

<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/modal/modalAddNewsFinished.js"></script>
</head>
<body>
	<jsp:include page="/header_admin.jsp" />

	<main>
		<section class="add_section">
			<!-- 뉴스 등록 폼 -->
			<form id="write-form"
				action="${pageContext.request.contextPath}/admin/news/newsWriteOk.ad"
				method="post" enctype="multipart/form-data">
				<div class="add_data">
					<div class="title">뉴스 제목</div>
					<input type="text" name="newsTitle" class="title_content" <%-- name="title" -> name="newsTitle" --%>
						placeholder="뉴스 제목을 입력하세요" required />

					<div class="name">작성자명</div>
					<input type="text" name="writer" class="name_content"
						value="${empty sessionScope.adminName ? '관리자' : sessionScope.adminName}"
						readonly />

					<div class="date">작성 날짜</div>
					<input type="text" name="date" class="date_content"
						value='<fmt:formatDate value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd" />' <%-- 오류 해결 (fmt:formatDate 사용) --%>
						readonly />
					
					<%-- AdminNewsWriteOkController에서 사용되는 adminNumber를 위한 hidden 필드 추가 --%>
					<input type="hidden" name="adminNumber" value="${sessionScope.adminNumber}" />
				</div>


				<div class="add_content">
					<div class="board_option"></div>
					<textarea name="newsContent" id="news" placeholder="요약할 뉴스를 작성해주세요" <%-- name="content" -> name="newsContent" --%>
						required></textarea>
				</div>

				<div class="add_link">
					<div class="add_link_title">뉴스 링크</div>
					<input type="text" name="newsLinkUrl" class="link_input" <%-- name="link" -> name="newsLinkUrl" --%>
						placeholder="http://example.com" />
				</div>

				<!-- 첨부 파일(선택) -->
				<div class="add_file">
					<div class="add_file_title">첨부 파일</div>
					<input type="file" name="newsImage" /> <%-- name="file" -> name="newsImage" (컨트롤러와 일관성 위해) --%>
				</div>

				<div class="add_btn">
					<button class="cancle" type="button" onclick="history.back();">취소</button>
					<button class="add" type="submit">추가 완료</button>
				</div>
			</form>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
	<div id="modalAddNewsFinished"></div>
	<script
		src="${pageContext.request.contextPath}/assets/js/admin/newsBoard.js"></script>
</body>
</html>