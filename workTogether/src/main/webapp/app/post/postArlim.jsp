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
    <form action="">
      <!-- 공지사항 상세정보 -->
      <nav class="post_title">
        <ul>
          <li class="post_name">공지사항입니다</li>
          <li>
            <ul class="post_info">
              <li>
                <div>등록자명</div>
              </li>
              <li class="post_member">
                <div>관리자</div>
              </li>
              <li>
                <div>등록일</div>
              </li>
              <li class="post_day">
                <div>2025-08-09</div>
              </li>
            </ul>
          </li>
          <li>
            <ul class="post_info">
              <li>조회수</li>
              <li class="post_view">
                <div>4</div>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <nav class="post_content">
        <ul>
          <li>
            <div>안녕하세요</div>
          </li>
        </ul>
      </nav>
    </form>
    <div class="button">
      <button class="button_list"><a href="${pageContext.request.contextPath}/app/post/postMain.jsp">목록</a></button>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>