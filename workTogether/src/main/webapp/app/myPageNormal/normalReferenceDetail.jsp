<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_PostDetailPage</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careReferenceCheck.css">
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 작성한 문의사항 디테일 페이지 -->
    <section class="careReferenceCheck">
      <div class="title">
        <h2>안녕하세요</h2>
      </div>
      <div class="careReferenceCheck_info">
        <span>등록자명 : 아무개</span>
        <span>등록일 : 2025-08-04</span><br>
      </div>
      <div class="careReferenceCheck_content">
        눈이 너무 아픕니다. <br>
        다크모드 추가해주세요. <br>

        아무개올림
      </div>
      <!-- 관리자가 달아준 문의 답변 -->
      <section class="reply">
        <div class="comment">
          <div class="author">관리자</div>
          <div class="cmt_content">오늘 문의주신 내용에 대해서 처리한 결과는 이렇게 됬습니다. 받아들이세요.</div>
          <div class="date">2025-08-02</div>
        </div>
      </section>
      <!-- 문의 목록으로 가는 버튼 -->
      <div class="buttons">
        <a href="${pageContext.request.contextPath}/normalReference.jsp"><button class="btn_list">목록</button>
      </div></a>
    </section>
  </main>
  <jsp:include page="/footer.jsp" />

</body>

</html>