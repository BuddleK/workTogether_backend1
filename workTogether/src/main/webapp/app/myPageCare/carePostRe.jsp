<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글 수정 후 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/carePostRe.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/carePostRe.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>

<!-- 페이지 세부 정보 -->

    <section class="post_edit">
      <div class="re_title">
        <h2>안녕하세요</h2>
      </div>
      <div class="re_post_info">
        <span>등록자명 : 아무개</span>
        <span>등록일 : 2025-08-04</span><br>
        <span>조회수 : 4</span>
      </div>
<!-- 게시글의 api 사용 부분 -->
      <div class="tools">
        <textarea name="" id=""></textarea>
      </div>
      <!-- 게시글 내용 입력 부분 -->
      <div class="re_post_content">
        <textarea id="contentInput" placeholder="내용을 입력하세요"></textarea>
      </div>
      <!-- 게시글 수정 완료, 취소, 목록 버튼 -->
      <div class="buttons">
        <a class="btn_list" href="${pageContext.request.contextPath}/carePost.jsp">목록</a>
        <a class="btn_cancle" href="${pageContext.request.contextPath}/carePostDP.jsp">취소</a>
        <button type="button" class="btn_compelete" id="saveBtn">수정완료</button>
      </div>
    </section>
  </main>
<!-- 수정 완료 모달 -->
  <div id="proposeSuccessModal" class="modal">
    <div class="modal-content">
      <p>수정이 완료되었습니다.</p>
      <div class="modal_buttons">
        <a href="${pageContext.request.contextPath}/myPageCare/carePost.jsp"><button id="saveConfirmBtn">확인</button>
      </div></a>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />

</body>

</html>