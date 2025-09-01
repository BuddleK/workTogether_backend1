<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_reference</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careReference.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careReference.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
          <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="main_sidebar">
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

    <div class="div_mark">
          <!-- 마이페이지 제목 -->

      <div class="title">1 대 1 문의</div>
      <nav class="div_choose">
        <ul>
          <li>1 대 1 문의 목록</li>
        </ul>

      </nav>
      <!-- 페이지 분류 정보 -->

      <nav class="mark_nav">
        <ul>
            <li><input type="checkbox"></li>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="posttitle">
              <div>제목</div>
            </li>
            <li class="day">
              <div>날짜</div>
            </li>
          </ul>
      </nav>
      <!-- 페이지 상세 내용 -->
      <nav class="mark_list">
            <ul>
              <li><input type="checkbox"></li>
              <li class="name"><a href="${pageContext.request.contextPath}/myPageCare/careReferenceCheck.jsp">
                <div>아무개</div>
              </a></li>
              <li class="posttitle"><a href="${pageContext.request.contextPath}/myPageCare/careReferenceCheck.jsp">
                <div>안녕하세요</div>
              </a></li>
              <li class="day"><a href="${pageContext.request.contextPath}/myPageCare/careReferenceCheck.jsp">
                <div>2025-08-11</div>
              </a></li>
          
          </ul>
        </nav>
        <!-- 페이지 네이션 -->
      <nav class="page">
        <ul>
          <li>&lt;</li>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>...</li>
          <li>&gt;</li>
        </ul>

      </nav>
      <!-- 등록 버튼 클릭시 a태그로 이동 -->
      <div class="div_delete">
        <a href="${pageContext.request.contextPath}/careReferenceDP.jsp"><button>등록</button></a>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />

</body>

</html>