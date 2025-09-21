<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
          <c:out value="${notice.getNoticeTitle()}"/>
        </div>
        <div class="post_info">
          <div class="post_columns">
            등록자명
          </div>
          <div class="post_col">
            <c:out value="${notice.getAdminName()}"/>
          </div>
          <div class="post_columns">
            등록일
          </div>
          <div class="post_col">
            <c:out value="${notice.getNoticeCreatedDate()}"/>
          </div>
          <div class="post_columns">
            수정일
          </div>
          <div class="post_col">
            <c:out value="${updatedDate}"/>
          </div>
          <div class="post_columns">
            조회수
          </div>
          <div class="post_col">
            <c:out value="${notice.getNoticeViewCount()}"/>
          </div>
        </div>
        <div id="context_box">
          <c:out value="${content}"/>
        </div>
      </div>
      <div class="button_area">
      <a href="${pageContext.request.contextPath}/post/postMain.po" class="toListA"><button class="button_list">목록</button></a>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>