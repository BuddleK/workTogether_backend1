<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_PwCheck</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/carePwCheck.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/carePwCheck.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
          <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="main_sidebar">
  <ul>
        <li><a href="${pageContext.request.contextPath}/careProfile.jsp"><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></a></li>
        <li><a href="${pageContext.request.contextPath}/careModify.jsp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/careMark.jsp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/careMatching.jsp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/careMessage.jsp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/carePost.jsp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/carePointreturn.jsp">포인트 환급</a></li>
        <li><a href="${pageContext.request.contextPath}/careReference.jsp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/careExit.jsp">회원 탈퇴</a></li>
      </ul>
  </nav>
  <!-- 페이지 세부 정보 -->

  <div class="pw_check">
    <form action="" method="get">
      비밀번호<input type="password" placeholder="비밀번호 8자리 입력">
      <button>비밀번호 확인</button>
      <div>일치하지 않는 비밀번호 입니다</div>
    </form>
  </div>
  </main>
  <div id="footer"></div>

  </body>

</html>