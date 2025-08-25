<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postDetailNotlogin.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
   <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script> 
  <script defer src="${pageContext.request.contextPath}/assets/js/post/postDetailNotlogin.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <div class="context">
      <div class="post_area">
        <div class="post_title">
          <c:out value="${post.getPostsTitle()}"/>
        </div>
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
            <c:out value="${post.getPostsContent()}"/>
        </div>
      </div>
      <div class="button_area">
      	<button class="button_list"><a href="${pageContext.request.contextPath}/post/postMain.po">목록으로</button>
		<!-- 신고 버튼 -->
		<div class="del"><button class="button_del">신고</button></div>
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
  <!-- 신고 확인 모달 -->
  <!-- <div class="checkmodal" id="editModal">
    <div class="modal_box">
      <p>이 게시글을  신고하시겠습니까?</p>
      <div class="exit-value">
              <select class="exit-select">
                <option disabled selected>신고 사유를 입력하여 주십시오.</option>
                <option>부적절한 글이 포함되어 있습니다.</option>
                <option>부적절한 행동이 포함되어 있습니다.</option>
                <option>광고성 단어가 포함되어 있습니다</option>
              </select>
            </div>
      <div class="modal_buttons">
        <button id="check">확인</button>
        <button id="cancle">취소</button>
      </div>
    </div>
  </div> -->
  <!-- 자신이 이미 신고한 게시글일때 모달 -->
  <!-- <div class="notmodal" id="editModal">
    <div class="modal_box">
      <p>이미 신고한 게시글입니다</p>
      <div class="modal_buttons">
        <button id="notcheck">확인</button>
      </div>
    </div>
  </div> -->
  <!-- <div class="reportmodal">
    <div class="modal_box">
      <p>신고되었습니다</p>
      <div class="modal_buttons">
        <button id="reportcheck">확인</button>
      </div>
    </div>
  </div> -->
  <jsp:include page="/footer.jsp" />
  <script>
    /* let usersNumber = "${sessionScope.memberNumber}"; */
   let usersNumber = 3; 
  </script>
</body>
</html>