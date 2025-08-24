<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>뉴스 상세페이지</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/newsBoardDetail.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
  <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
</head>
<body>
  <jsp:include page="/header_admin.jsp" />

  <main>
    <!-- 목록으로 돌아가기 URL 생성 (page 파라미터 있을 때만 추가) -->
    <c:url var="backUrl" value="/admin/news/newsListOk.ad">
      <c:if test="${not empty param.page}">
        <c:param name="page" value="${param.page}" />
      </c:if>
    </c:url>

    <form action="${pageContext.request.contextPath}/admin/news/newsUpdateOk.ad" method="post">
      <input type="hidden" name="newsNumber" value="${news.newsNumber}" />
      <input type="hidden" name="page" value="${param.page}" />

      <section class="add_section">
        <div class="add_data">
          <div class="title">뉴스제목</div>
          <input type="text" name="title" class="title_content" value="${news.newsTitle}" />

          <div class="name">작성자</div>
          <div class="name_content">
            <c:choose>
              <c:when test="${not empty news.adminName}">${news.adminName}</c:when>
              <c:otherwise>관리자 #${news.adminNumber}</c:otherwise>
            </c:choose>
          </div>

          <div class="date">작성 날짜</div>
          <div class="date_content">${news.newsCreatedDate}</div>
        </div>

        <div class="add_content">
          <div class="board_title">뉴스내용</div>
          <textarea name="content" id="news" placeholder="내용을 입력하세요.">${news.newsContent}</textarea>
        </div>

        <div class="add_link">
          <div class="add_link_title">뉴스링크</div>
          <input type="text" class="link_input" name="link" value="${news.newsLinkUrl}" />
        </div>

        <div class="add_btn">
          <a class="cancel" href="${pageContext.request.contextPath}/admin/news/newsListOk.ad">취소</a>
          <button class="add" type="submit">수정</button>
        </div>
      </section>
    </form>
  </main>

  <jsp:include page="/footer.jsp" />
</body>
</html>
