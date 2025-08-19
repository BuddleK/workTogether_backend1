<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Post_Modify</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postModify.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/post/postModify.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
    <!-- 게시물 수정  디테일 페이지-->
    <form action="">
      <nav class="post_title">
        <ul>
          <li class="post_name"> 안녕하세요</li>
          <li>
            <ul class="post_info">
              <li>
                <div>등록자명</div>
              </li>
              <li class="post_member">
                <div>홍길동</div>
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
      <div class="api">글쓰기 api?</div>
      <div class="input">
        <textarea></textarea>
        <input type="text">
      </div>
      <div class="button">
        <button class="list"><a href="${pageContext.request.contextPath}/app/post/postMain.jsp">목록</a></button>
        <button class="button_write">수정하기</button>
      </div>
    </form>
  </main>
  <!-- 수정 확인 모달 -->
  <div class="notmodal" id="editModal">
    <div class="modal_box">
      <p>수정하시겠습니까?</p>
      <div class="modal_buttons">
        <a href="${pageContext.request.contextPath}/app/post/postDetaillogin.jsp"><button id="check">확인</button></a>
        <button id="cancle">취소</button>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>
</html>