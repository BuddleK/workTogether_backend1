<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>뉴스 수정</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/newsBoardAdd.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />

  <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
</head>
<body>
  <jsp:include page="/header_admin.jsp" />

  <main>

    <!-- 수정 폼 -->
    <form action="${pageContext.request.contextPath}/admin/news/newsUpdateOk.ad" method="post">
      <!-- 필수 히든값들 -->
      <input type="hidden" name="newsNumber" value="${news.newsNumber}" />
      <input type="hidden" name="page" value="${param.page}" />

      <section class="add_section">
        <div class="add_data">
          <div class="title">뉴스제목</div>
          <!-- 제목 입력 -->
          <input type="text" name="title" class="title_content"
                 value="${news.newsTitle}" placeholder="뉴스 제목을 입력하세요" required />

          <div class="name">작성자명</div>
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
          <div class="board_option"></div>
          <!-- 내용 입력 -->
          <textarea name="content" id="news" placeholder="내용을 입력하세요." required>${news.newsContent}</textarea>
        </div>

        <div class="add_link">
          <div class="add_link_title">뉴스링크</div>
          <!-- 링크 입력 -->
          <input type="text" name="link" class="link_input"
                 value="${news.newsLinkUrl}" placeholder="http://example.com" />
        </div>

        <div class="add_btn">
          <a class="cancle" href="${pageContext.request.contextPath}/admin/news/newsListOk.ad">취소</a>
          <button class="add" type="submit">수정 완료</button>
        </div>
      </section>
    </form>
  </main>

  <jsp:include page="/footer.jsp" />
</body>
</html>