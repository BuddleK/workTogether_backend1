<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.setAttribute("usersNumber", 1); %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원탛퇴</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careExit.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careExit.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="sidebar">
      <ul>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careProfile.cp"><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careModify.cp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMark.cp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMatching.cp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMesseage.cp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/carePost.cp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/carePointreturn.cp">포인트 환급</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careReference.cp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careExit.cp">회원 탈퇴</a></li>
      </ul>
    </nav>
    <!-- 마이페이지 제목 -->
    <section class="exit-section">
      <h2>회원 탈퇴</h2>
      <!-- 알림 정보 -->
      <div class="exit-guide">
        <ul>
          <li>🛈 더 이상의 이용을 원하지 않는 불필요한 사이트의 대한 회원 탈퇴 처리</li>
          <li class="red">· 본 서비스는 본인인증 내역을 기반으로 제공되는 서비스로, 회원 탈퇴 시 60일간 회원가입이 불가하며 그에 따른 불이익은 책임 지지 않습니다.</li>
          <li class="red">· 회원 탈퇴시 포인트가 남아있다면 소멸됩니다.</li>
        </ul>
      </div>
<!-- 페이지 세부 정보 -->
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
<!-- 탈퇴 사유의 유무 존재 확인-->
      <div class="exit-button-area">
        <button class="exit-button" type="button">다음</button>
        <p id="reasonError" class="error-text">탈퇴사유를 꼭 입력해주세요</p>
      </div>

<!-- 모달창 1번째로 뜨는 것 -->
      <div class="modal" id="modalConfirm" aria-hidden="true">
        <div class="modal-content">
          <p>정말로 회원 탈퇴를 진행하시겠습니까?<br><span class="red">※ 탈퇴는 되돌릴 수 없습니다.</span></p>
          <div class="modal-buttons">
            <button class="btn" onclick="closeModal('modalConfirm')">취소</button>
            <button class="btn blue" onclick="checkWithdrawal()">확인</button>
          </div>
        </div>

      </div>
<!-- 회원 탈퇴 불가 이유 모달 -->
      <div class="modal" id="modalFail" aria-hidden="true">
        <div class="modal-content">
          <p>예약된 거동 불편자가 있어 회원 탈퇴가 불가합니다.</p>
          <div class="modal-buttons">
            <button class="btn" onclick="closeModal('modalFail')">취소</button>
            <button class="btn blue" onclick="closeModal('modalFail')">확인</button>
          </div>
        </div>
      </div>
<!-- 회원 탈퇴 성공 모달 -->
      <div class="modal" id="modalSuccess" aria-hidden="true">
        <div class="modal-content">
          <p>성공적으로 회원을 탈퇴 하셨습니다.</p>
          <div class="modal-buttons">
            <a href="${pageContext.request.contextPath}/main.html"><button class="btn blue" onclick="closeModal('modalSuccess')">확인</button></a>
          </div>
        </div>
      </div>
    </section>
  </main>

  <jsp:include page="/footer.jsp" />

</body>

</html>