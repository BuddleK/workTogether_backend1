<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Quit</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalQuit.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalQuit.js"></script>
</head>
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
    <div class="div_mark">
      <!-- 메뉴 제목 -->
      <div class="title">회원 탈퇴</div>
      <!-- 주의사항 표시 -->
      <div class="arlim">
        <nav>
          <ul>
            <li>🛈 더 이상의 이용을 원하지 않는 불필요한 사이트의 대한 회원 탈퇴 처리</li>
            <li class="li_color">· 본 서비스는 본인인증 내역을 기반으로 제공되는 서비스로, 회원 탈퇴시 60일간 회원가입이 불가하며 그에 따른 불이익은 책임 지지 않습니다. </li>
            <li class="li_color">· 회원 탈퇴시 보유한 포인트는 전부 소멸 됩니다.</li>
          </ul>
        </nav>
      </div>
      <form action="" method="get">
        <!-- 회원 탈퇴 박스 -->
        <div class="exit-box">
          <div class="exit-row">
            <div class="exit-label">탈퇴 날짜</div>
            <div class="exit-value">2025 - 08 - 03</div>
          </div>
          <div class="exit-row">
            <div class="exit-label">탈퇴 사유</div>
            <div class="exit-value">
              <select class="exit-select">
                <option disabled selected>탈퇴 사유를 입력하여 주십시오.</option>
                <option>서비스 이용 불편</option>
                <option>개인정보 우려</option>
                <option>재가입 예정 없음</option>
                <option>기타</option>
              </select>
            </div>
          </div>
        </div>
        <!-- 탈퇴하기 버튼 -->
        <button type="button" onclick="openQuitModal()" id="next">다음</button>
      </form>
    </div>
  </main>
  <!-- 확인 모달창 -->
  <div class="checkmodal" id="checkModal">
    <div class="modal_box">
      <p>정말로 회원 탈퇴를 진행하시겠습니까?</p>
      <p>※미사용 포인트는 소멸됩니다</p>
      <div class="modal_buttons">
        <button type="button" onclick="showDoneModal()" id="checkBtn">확인</button>
        <button type="button" onclick="cancelQuit()" id="cancelBtn">취소</button>
      </div>
    </div>
  </div>
  <!-- 완료 모달창 -->
  <div class="modal" id="doneModal">
    <div class="modal_box">
      <p>성공적으로 회원을 탈퇴 하셨습니다.</p>
      <div class="modal_buttons">
        <a href="${pageContext.request.contextPath}/main.jsp"><button type="button" id="doneOkBtn">확인</button></a>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>

</html>