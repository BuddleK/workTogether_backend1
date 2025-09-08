<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Post_Write</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postWrite.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/post/postWrite.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <form id="write_form" class="context" action="${pageContext.request.contextPath}/post/postWriteOk.po">
      <!-- <form class="post_area"> -->
      <div class="post_title">
        <input id="input_title" name="postTitle" placeholder="제목을 입력하세요">
      </div>
      <div id="context_box">
        <textarea id="input_text" name="postContext" placeholder="내용을 입력하세요"></textarea>
      </div>
      <div class="button_area">
        <button type="button" class="list"><a href="${pageContext.request.contextPath}/post/postMain.po">목록</a></button>
        <button type="button" id="write_button" class="button_write">작성</button>
      </div>
    </form>
  </main>
  <div id="ask_write_modal" class="writecheckmodal">
    <div class="modal_box">
      <p>작성하시겠습니까?</p>
      <div class="modal_buttons">
        <button type="button" id="writecheck">확인</button>
        <button type="button" id="writecancel">취소</button>
      </div>
    </div>
  </div>
  <div id="write_ok_modal" class="writemodal">
    <div class="modal_box">
      <p>작성되었습니다</p>
      <div class="modal_buttons">
        <button type="button" id="writeok">확인</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
      <script>
    	let memberNumber = "${sessionScope.memberNumber}"; 
    </script>
</body>
</html>