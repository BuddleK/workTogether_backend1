<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>point return</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/carePointreturn.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/carePointreturn.js"></script>
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

    <section class="return_section">
          <!-- 마이페이지 제목 -->

      <h2>포인트 환급</h2>
      <!-- 알림 정보 -->

      <div class="info_box">
        <ul>
          <li>포인트 환급 신청이 가능합니다.</li>
          <li>환급은 10원 단위로 가능합니다.</li>
          <li>수수료는 10% 입니다.</li>
        </ul>
      </div>
      <!-- 페이지 세부 정보 -->

      <div class="point_table_wrap">
        <div class="point_table">
          <div class="point_fixed"><label>보유 포인트</label></div>
          <div class="point_row"><span>38,960 P</span></div>
        </div>
<!-- 신청 포인트 환급하기 위한 칸 -->
        <div class="point_table">
          <div class="point_fixed"><label for="input_point">신청 포인트</label></div>
          <div class="point_row">
            <input type="text" id="input_point"placeholder="환급할 포인트를 입력하세요">
            <span>(최대 10만 포인트)</span>
          </div>
        </div>
<!-- 예상 전환 포인트 칸 -->
        <div class="point_table">
          <div class="point_fixed"><label>예상 전환 포인트</label></div>
          <div class="point_row"><span>34,200 P</span></div>
        </div>
<!-- 어느 계좌로 입금 되는지 보여주는 칸 -->
        <div class="point_table">
          <div class="point_fixed"><label>입금 대상 계좌</label></div>
          <div class="point_row"><span>[기업은행] 506502-04-342422</span></div>
        </div>

      </div>
<!-- 환급 신청 버튼 -->
      <div class="return_button">
        <button class="btn_return" id="btn_return">환급 신청</button>
<!-- 환급 신청 완료 모달 -->
        <div class="modal" id="refundModal">
          <div class="modal_box">
            <p>환급 신청이 완료되었습니다.</p>
            <div class="modal_buttons">
              <button id="refundConfirm">확인</button>
            </div>
          </div>
        </div>
<!-- 환급 지급 내역 버튼 -->
        <button class="btn_return_list">
          <a href="${pageContext.request.contextPath}/carePointList.jsp">환급/지급 내역</a>
        </button>
      </div>
    </section>
  </main>

  <jsp:include page="/footer.jsp" />
</body>

</html>