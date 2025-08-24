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
  <jsp:include page="/header.jsp" />
  <main>
    <div class="context">
      <div class="post_area">
        <div class="post_title">
          수정 대상
        </div>
        <div class="post_info">
          <div class="post_columns">
            등록자명
          </div>
          <div class="post_col">
            작성한 사람
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
          <textarea id="input_text">눈누 난나</textarea>
        </div>
      </div>
      <div class="button">
        <button class="list"><a href="${pageContext.request.contextPath}/app/post/postMain.jsp">목록</a></button>
        <button class="button_write">수정 완료</button>
      </div>
    </div>
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
  <jsp:include page="/footer.jsp" />
</body>
</html>