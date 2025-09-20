<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>뉴스 상세</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/newsBoardDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
</head>
<body>
	<jsp:include page="/header_admin.jsp" />

	<main>
		<c:url var="backUrl" value="/admin/news/newsListOk.ad">
			<c:if test="${not empty param.page}">
				<c:param name="page" value="${param.page}" />
			</c:if>
		</c:url>

		<form
			action="${pageContext.request.contextPath}/admin/news/newsUpdateOk.ad"
			method="post">
			<input type="hidden" name="newsNumber" value="${news.newsNumber}" />
			<input type="hidden" name="page" value="${param.page}" />

			<section class="add_section">
				<div class="add_data">
					<div class="title">뉴스 제목</div>
					<input type="text" name="newsTitle" class="title_content"
						value="${news.newsTitle}" required />

					<div class="name">작성자명</div>
					<div class="name_content">
						<c:choose>
							<c:when test="${not empty sessionScope.adminName}">
								<c:out value="${sessionScope.adminName}" />
							</c:when>
							<c:otherwise>
							관리자<c:out value="${news.adminNumber}" />
							</c:otherwise>
						</c:choose>
					</div>

					<div class="date">작성 날짜</div>
					<div class="date_content">${news.newsCreatedDate}</div>
				</div>

				<div class="add_link">
					<div class="add_link_title">뉴스 링크</div>
					<input type="text" class="link_input" name="newsLinkUrl"
						value="${news.newsLinkUrl}" />
					<div>
						<c:if test="${not empty news.newsLinkUrl}">
							<a href="${news.newsLinkUrl}" target="_blank" rel="noopener">링크
								열기</a>
						</c:if>
					</div>
				</div>

				<div class="add_btn">
					<a class="cancel" href="${backUrl}">목록</a>
					<button class="add" type="submit">수정</button>
				</div>
			</section>
		</form>
	</main>

	<jsp:include page="/footer.jsp" />
	<script>
  document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form[action$="/admin/news/newsUpdateOk.ad"]');
    const btn  = form?.querySelector('button.add[type="submit"]');

    btn?.addEventListener('click', function (e) {
      e.preventDefault(); // 기본 제출 막기 (여기서 disabled 해도 안전)

      // HTML5 required 등 유효성 검사 먼저
      if (form && !form.reportValidity()) return;

      alert('수정이 완료되었습니다.');
      btn.disabled = true; // 중복 클릭 방지

      // 네이티브 제출 트리거 (검증/submit 이벤트를 정상 경로로)
      if (typeof form.requestSubmit === 'function') {
        form.requestSubmit(btn);
      } else {
        form.submit(); // 구형 브라우저 대응(검증은 위에서 이미 확인)
      }
    });
  });
</script>
</body>
</html>
