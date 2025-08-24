<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postArlim.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/post/postDetaillogin.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <!-- 공지사항 디테일 페이지 -->
  <main>
    <div class="context">
      <div class="post_area">
        <div class="post_title">
          공지
        </div>
        <div class="post_info">
          <div class="post_columns">
            등록자명
          </div>
          <div class="post_col">
            관리자
          </div>
          <div class="post_columns">
            등록일
          </div>
          <div class="post_col">
            2025-08-09
          </div>
          <div class="post_columns">
            수정일
          </div>
          <div class="post_col">
            2025-08-10
          </div>
          <div class="post_columns">
            조회수
          </div>
          <div class="post_col">
            4
          </div>
        </div>
        <div id="context_box">
          공지사항. 다음주 목요일부터 사이트 점검을 실시합니다
        </div>
      </div>
      <div class="button_area">
      <button class="button_list"><a href="${pageContext.request.contextPath}/app/post/postMain.jsp">목록</a></button>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>