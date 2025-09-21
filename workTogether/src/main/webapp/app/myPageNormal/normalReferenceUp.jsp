<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <form action="/myPageNormal/normalReferenceInsertOk.mn" method="post">
      <div class="title">
        <textarea name="title" class="input_title"></textarea>
      </div>
      <div class="reference_info">
        <span class="name">등록자명 : ${userName }</span>
        <span>등록일 : ${today }</span><br>
      </div>
      
      <div class="reference_content">
        <textarea name="content"></textarea>
      </div>
      <div class="buttons">
        <a href="${pageContext.request.contextPath}/normalReference.jsp"><button class="btn_list">목록</button></a>
        <button type="button" class="btn_compelete">등록</button>
      </div>
      <div class="modal" id="editModal">
    <div class="modal_box">
      <p>문의가 등록 되었습니다.</p>
      <div class="modal_buttons">
        <button id="check" type="submit">확인</button>
      </div>
    </div>
  </div>
    </form>
    </section>
  </main>
  <!-- 문의사항 등록 확인 모달 -->
  
  <jsp:include page="/footer.jsp" />
</body>
</html>