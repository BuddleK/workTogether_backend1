<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <form id="modify_form" method="post" class="context" action="${pageContext.request.contextPath}/post/postUpdateOk.po?postNumber=${post.getPostsNumber()}">
      <div class="post_area">
        <input class="post_title" name="postTitle"
        	value="${post.getPostsTitle()}" required >
          
        <div class="post_info">
          <div class="post_columns">
            등록자명
          </div>
          <div class="post_col">
            <c:out value="${post.getUsersName()}"/>
          </div>
          <div class="post_columns">
            등록일
          </div>
          <div class="post_col">
            <c:out value="${post.getPostsCreatedDate()}"/>
          </div>
          <div class="post_columns">
            수정일
          </div>
          <div class="post_col">
            <c:out value="${post.getPostsUpdatedDate()}"/>
          </div>
          <div class="post_columns">
            조회수
          </div>
          <div class="post_col">
            <c:out value="${post.getPostsViewCount()}"/>
          </div>
        </div>
        <div id="context_box">
          <textarea id="input_text" name="postContext" required ><c:out value="${post.getPostsContent()}"/></textarea>
        </div>
      </div>
      <div class="button">
        <button type="button" class="list"><a href="${pageContext.request.contextPath}/post/postMain.po">목록</a></button>
        <button type="button" class="button_write">수정 완료</button>
      </div>
    </form>
  </main>
  <!-- 수정 확인 모달 -->
  <div class="notmodal" id="editModal">
    <div class="modal_box">
      <p>수정하시겠습니까?</p>
      <div class="modal_buttons">
        <button type="button" id="check">확인</button>
        <button id="cancle">취소</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>
</html>