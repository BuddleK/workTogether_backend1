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
					<input type="text" name="title" class="title_content"
						placeholder="뉴스 제목을 입력하세요" required />

					<div class="name">작성자명</div>
					<input type="text" name="writer" class="name_content" value="홍길동"
						readonly />

					<div class="date">작성 날짜</div>
					<input type="text" name="date" class="date_content"
						value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>"
						readonly />
				</div>

				<div class="add_content">
					<div class="board_option"></div>
					<textarea name="content" id="news" placeholder="요약할 뉴스를 작성해주세요"
						required></textarea>
				</div>

				<div class="add_link">
					<div class="add_link_title">뉴스 링크</div>
					<input type="text" name="link" class="link_input"
						placeholder="http://example.com" />
				</div>

				<div class="add_btn">
					<button class="cancle" onclick="history.back();" type="button">취소</button>
					<button class="add" type="submit">추가 완료</button>
				</div>
			</form>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
	<div id="modalAddNewsFinished"></div>
	<script
		src="${pageContext.request.contextPath}/assets/js/admin/newsBoard.js">
	</script>

</body>
</html>
