<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_PostDetailPage</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/carePostDP.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/carePostDP.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
<!-- 페이지 세부 정보 -->


    <section class="post_dp">
      <!-- 게시판 디테일 페이지 -->
      <div class="title">
        <h2>안녕하세요</h2>
      </div>
      <div class="post_info">
        <span>등록자명 : 아무개</span>
        <span>등록일 : 2025-08-04</span><br>
        <span>조회수 : 4</span>
      </div>
      <!-- 게시글 내용 -->
      <div class="post_content">
        안녕하세요
      </div>
      <div class="buttons">
        <a class="btn_list" href="${pageContext.request.contextPath}/carePost.jsp">목록</a>
        <a class="btn_delete" href="#deleteModal">삭제</a>
        <a class="btn_retry" href="${pageContext.request.contextPath}/carePostRe.html" id="editLink">수정</a>
      </div>
<!-- 게시글 댓글 내용 -->
      <section class="reply">
        <h4>댓글 [1]</h4>
        <hr>
        <div class="comment">
          <div class="author">아무개</div>
          <div class="cmt_content">반갑다내이름은박찬호고나는LA다저스에있을때부..</div>
          <div class="date">2025-08-02</div>
        </div>
<!-- 게시글 댓글 작성 칸 -->
        <div class="comments">
          <form action="" method="get">
            댓글작성 <br>
            <hr>
            <input type="text" placeholder="댓글을 작성하세요">
            <button>작성</button>
          </form>
        </div>
      </section>
    </section>
  </main>
  <!-- 삭제 버튼 클릭시 출력 모달 -->
  <div class="modal" id="deleteModal">
    <div class="modal_box">
      <p>정말로 게시글을 삭제하시겠습니까?</p>
      <form method="post" action="" class="modal_buttons">
      <a href="${pageContext.request.contextPath}/carePost.html"><button type="submit" id="confirmDelete">확인</button></a>
      <a href="${pageContext.request.contextPath}/carePost.html"><button type="submit" id="cansleDelete">취소</button></a>
    </form>
    </div>
  </div>

  <jsp:include page="/footer.jsp" />

</body>

</html>