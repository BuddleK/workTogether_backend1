<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>포인트 지급/환급 내역</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/carePointList.css" />
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

    <section class="point-history">
      <div class="history-box">
        <!-- 마이페이지 제목 -->
        <!-- 페이지 세부 정보 -->

        <div class="history-section">
          <h3>환급 내역</h3>

          <div class="month-control">
            <button>&lt;</button>
            <span>8월</span>
            <button>&gt;</button>
          </div>
          <div class="table-box">
            <div class="table-header">
              <span>순번</span>
              <span>환급 포인트</span>
              <span>날짜</span>
            </div>
            <div class="table-row">
              <span>1</span>
              <span>38,000P</span>
              <span>2025-08-02</span>
            </div>
          </div>
          <div class="pagination">
            &lt; <span class="active">1</span> 2 3 4 ... &gt;
          </div>
        </div>
        <!-- 마이페이지 제목 -->
        <!-- 페이지 세부 정보 -->
        <div class="history-section" id="takepoint">
          <h3>받은 포인트 내역</h3>
          <div class="month-control">
            <button>&lt;</button>
            <span>8월</span>
            <button>&gt;</button>
          </div>
          <div class="table-box">
            <div class="table-header">
              <span>순번</span>
              <span>지급자</span>
              <span>지급 포인트</span>
              <span>날짜</span>
            </div>
            <div class="table-row">
              <span>1</span>
              <span>아무개</span>
              <span>5,000P</span>
              <span>2025-08-02</span>
            </div>
          </div>
          <!-- 페이지 네이션 -->
          <div class="pagination">
            &lt; <span class="active">1</span> 2 3 4 ... &gt;
          </div>
        </div>
      </div>
    </section>
  </main>

  <jsp:include page="/footer.jsp" />

</body>

</html>