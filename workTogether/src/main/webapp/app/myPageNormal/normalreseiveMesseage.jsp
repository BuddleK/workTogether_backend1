<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Messeage</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalreseiveMesseage.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalreseiveMesseage.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 메뉴 사이드바 섹션 -->
    <nav class="main_sidebar">
      <ul>
        <li><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></li>
        <li><a href="${pageContext.request.contextPath}/normalPwCheck.jsp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/normalMark.jsp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalheart.jsp">하트 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalMatching.jsp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalsendMesseage.jsp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/normalPost.jsp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/normalPoint.jsp">포인트 충전</a></li>
        <li><a href="${pageContext.request.contextPath}/normalReference.jsp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/normalQuit.jsp">회원 탈퇴</a></li>
      </ul>
    </nav>
    <form action="" method="get">
      <div class="div_mark">
        <!-- 메뉴 제목 -->
        <div class="title">쪽지함</div>
        <!-- 받은 쪽지, 보낸 쪽지로 이동 -->
        <nav class="div_choose">
          <ul> 
            <li class="send"><a href="${pageContext.request.contextPath}/normalsendMesseage.jsp">받은 쪽지</a></li>
            <li>|</li>
            <li class="reseive"><a href="${pageContext.request.contextPath}/normalreseiveMesseage.jsp">보낸 쪽지</a></li>
          </ul>
        </nav>
        <nav class="mark_nav">
          <!-- 보낸 쪽지 컬럼 -->
          <ul>
            <li><input onclick="toggleMarksAll()" id="checkbox_col" name="mark_check_col" type="checkbox"></li>
            <li class="name_col">
              <div>보낸 사람</div>
            </li>
            <li class="location_col">
              <div>제목</div>
            </li>
            <li class="phone_col">
              <div>날짜</div>
            </li>
            <li class="read_col">
              <div>읽음 상태</div>
            </li>
          </ul>
        </nav>
        <!-- 보낸 쪽지 목록 리스트 -->
        <ul class="mark_list">
        </ul>
        <!-- 페이지네이션 -->
        <nav class="page">
          <ul>
            <li><a href="">&lt;</a></li>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
            <li><a href="">4</a></li>
            <li><a href="">&gt;</a></li>
          </ul>
        </nav>
        <!-- 보낸 쪽지 삭제 버튼 -->
        <div class="div_delete">
          <button type="button" onclick="delMarks()" id="delete">삭제</button>
        </div>
      </div>
    </form>

  </main>
  <!-- 보낸 쪽지 확인 모달 -->
  <div class="modal">
    <div class="modal-content">
      <button id="sendxbutton">X</button>
      <p>보낸 쪽지 읽기</p>
      <div class="sendmember">
        <div>받는 사람 : 홍길동 | honggildong123</div>
      </div>
      <div class="content">
        <div>쪽지 내용</div>
      </div>
      <button type="button" id="deleteBtn">삭제</button>
    </div>
  </div>

  <jsp:include page="/footer.jsp" />
</body>

</html>