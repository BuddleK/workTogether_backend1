<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Reference_Up</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalReferenceUp.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalReferenceUp.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 문의 작성 디테일 페이지 -->
    <section class="reference_dp">
      <div class="title">
        <h2>[문의] 다크모드 요청</h2>
      </div>
      <div class="reference_info">
        <span>등록자명 : 아무개</span>
        <span>등록일 : 2025-08-04</span><br>
      </div>
      <div class="tools">
      </div>
      <div class="reference_content">
        <textarea></textarea>
      </div>
      <div class="buttons">
        <a href="${pageContext.request.contextPath}/normalReference.jsp"><button class="btn_list">목록</button></a>
        <a href="${pageContext.request.contextPath}/normalReference.jsp"><button class="btn_cancle">취소</button></a>
        <button class="btn_compelete">등록</button>
      </div>
    </section>
  </main>
  <!-- 문의사항 등록 확인 모달 -->
  <div class="modal" id="editModal">
    <div class="modal_box">
      <p>문의가 등록 되었습니다.</p>
      <div class="modal_buttons">
        <a href="${pageContext.request.contextPath}/normalReference.jsp"><button id="check">확인</button></a>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>
</html>