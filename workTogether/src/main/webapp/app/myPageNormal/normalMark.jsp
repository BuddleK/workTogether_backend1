<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Mark</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalMark.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/NormalMark.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
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
        <div class="title">찜한 목록</div>
        <nav class="mark_nav">
          <ul>
            <li><input onclick="toggleMarksAll()" id="checkbox_col" name="mark_check_col" type="checkbox"></li>
            <li class="name_col">
              <div>이름</div>
            </li>
            <li class="location_col">
              <div>위치</div>
            </li>
            <li class="phone_col">
              <div>전화번호</div>
            </li>
          </ul>
        </nav>
        <ul class="mark_list">
        </ul>
        <div>
          <ul class="page">
            <li><a href="">&lt;</a></li>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
            <li><a href="">4</a></li>
            <li><a href="">&gt;</a></li>
          </ul>
        </div>
        <div class="div_delete">
          <button type="button" id="btnDelete">찜 삭제</button>
        </div>
      </div>
    </form>

  </main>
  <!-- 삭제 버튼 클릭시 확인 모달 -->
  <div class="modal" id="deleteModal">
    <div class="modal_box">
      <p>찜한 가게를 삭제하시겠습니까?</p>
      <div class="modal_buttons">
        <button type="button" id="confirmDelete">확인</button>
        <button type="button" id="cancelDelete">취소</button>
      </div>
    </div>
  </div>
  <!-- 찜 삭제확인 모달 확인 버튼 클릭시 모달 -->
  <div class="modal" id="chek_deleteModal">
    <div class="modal_box">
      <p>찜이 삭제 되었습니다.</p>
      <div class="modal_buttons">
        <button type="button" id="check_confirmDelete">확인</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>

</html>