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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careReferenceDP.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careReferenceDP.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="main_sidebar">
      <ul>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careProfile.jsp"><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careModify.jsp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careMark.jsp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careMatching.jsp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careMessage.jsp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/carePost.jsp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/carePointreturn.jsp">포인트 환급</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careReference.jsp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/app/myPageCare/careExit.jsp">회원 탈퇴</a></li>
      </ul>
    </nav>

    <!-- 페이지 세부 정보 -->
    <section class="reference_dp">
      <div class="title">
        <input type="text">

      </div>
<!-- 페이지 세부 정보 안내 -->
      <div class="reference_info">
        <span>등록자명 : 아무개</span>
        <span>등록일 : 2025-08-04</span><br>
      </div>
      <div class="tools">

        <textarea name="" id=""></textarea>

      </div>
      <!-- 문의 사항 입력 칸 -->
      <div class="re_post_content">
        <textarea id="contentInput" placeholder="내용을 입력하세요"></textarea>
      </div>
      <!-- 문의사항 버튼 -->
      <div class="buttons">
        <a class="btn_list" href="${pageContext.request.contextPath}/careReference.jsp">목록</a>
        <a class="btn_cancle" href="${pageContext.request.contextPath}/careReference.jsp">취소</a>
        <button type="button" class="btn_compelete" id="saveBtn">등록</button>
      </div>
    </section>
  </main>
  <footer>

  </footer>
  <!-- 등록 버튼 클릭 시 출력 모달 -->
  <div class="modal" id="editModal" ;>
    <div class="modal_box">
      <p>문의가 등록 되었습니다.</p>
      <div class="modal_buttons">
        <a href="${pageContext.request.contextPath}/myPageCare/careReference.jsp"><button id="check"> 확인</button></a>
      </div>
    </div>
  </div>

  <jsp:include page="/footer.jsp" />


</body>

</html>