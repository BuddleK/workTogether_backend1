<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postDetaillogin.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/post/postDetaillogin.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <div class="context">
      <div class="post_area">
        <div class="post_title">
          제목
        </div>
        <div class="post_info">
          <div class="post_columns">
            등록자명
          </div>
          <div class="post_col">
            홍길동
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
          내용~
        </div>
      </div>
      <div class="button_area">
      	<a href="${pageContext.request.contextPath}/app/post/postMain.jsp"><button type="button" class="button_list">목록</button></a>
      	<button type="button" class="button_delete">삭제</button>
       	<a href="${pageContext.request.contextPath}/app/post/postModify.jsp"><button type="button" class="button_enroll">수정</button></a>
      </div>
      <div class="reply_area">
        <div class="reply_count">
          댓글 [2]
        </div>
        <ul class="reply_list">
          <li class="reply">
            <span class="reply_author">홍길동</span>
            <span class="reply_context">형을 형이라 부르지 못하고</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
          <li class="reply">
            <span class="reply_author">클로렐라</span>
            <span class="reply_context">정말 초록초록 해요</span>
          </li>
        </ul>
      </div>
      <div>
        <div class="reply_write_box">댓글 작성</div>
        <div class="reply_console">
          <input id="reply_input" placeholder="댓글 작성 중">
          <span type="button" id="reply_button">
            <p>작성</p>
          </span>
        </div>
      </div>
    </div>
  </main>
  <!-- 게시글 삭제 확인 모달 -->
  <div class="checkmodal" id="editModal">
    <div class="modal_box">
      <p>이 게시글을 삭제하시겠습니까?</p>
      <div class="modal_buttons">
        <a href="${pageContext.request.contextPath}/app/post/postMain.jsp"><button id="check">확인</button></a>
        <button id="cancle">취소</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>
</html>