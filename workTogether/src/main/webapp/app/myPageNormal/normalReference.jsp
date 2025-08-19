<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Reference</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalReference.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
</head>
<body>
  <div id="header"></div>
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
        <div class="title">1 대 1 문의</div>
        <nav class="div_choose">
          <ul>
            <li>1 대 1 문의 목록</li>
          </ul>
        </nav>
        <!-- 문의 목록 컬럼 -->
        <nav class="mark_nav">
          <ul>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="referencetitle">
              <div>제목</div>
            </li>
            <li class="day">
              <div>신청 날짜</div>
            </li>
            <li class="check">
              <div>확인 여부</div>
            </li>
          </ul>
        </nav>
        <!-- 문의 목록 리스트 -->
        <nav class="mark_list">
          <ul>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="referencetitle">
              <a href="${pageContext.request.contextPath}/normalReferenceDetail.jsp"><div>제목</div></a>
            </li>
            <li class="day">
              <div>신청 날짜</div>
            </li>
            <li class="check">
              <div>확인 여부</div>
            </li>
          </ul>
        </nav>
        <nav class="mark_list">
          <ul>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="referencetitle">
              <a href="${pageContext.request.contextPath}/normalReferenceDetail.jsp"><div>제목</div></a>
            </li>
            <li class="day">
              <div>신청 날짜</div>
            </li>
            <li class="check">
              <div>확인 여부</div>
            </li>
          </ul>
        </nav>
        <nav class="mark_list">
          <ul>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="referencetitle">
              <a href="${pageContext.request.contextPath}/normalReferenceDetail.jsp"><div>제목</div></a>
            </li>
            <li class="day">
              <div>신청 날짜</div>
            </li>
            <li class="check">
              <div>확인 여부</div>
            </li>
          </ul>
        </nav>
        <nav class="mark_list">
          <ul>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="referencetitle">
              <a href="${pageContext.request.contextPath}/normalReferenceDetail.jsp"><div>제목</div></a>
            </li>
            <li class="day">
              <div>신청 날짜</div>
            </li>
            <li class="check">
              <div>확인 여부</div>
            </li>
          </ul>
        </nav>
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
        <!-- 문의 등록하기 버튼 -->
        <div class="div_delete">
          <button><a href="${pageContext.request.contextPath}/normalReferenceUp.jsp">등록</a></button>
        </div>
      </div>
    </form>
  
  </main>
  <div id="footer"></div>
</body>
</html>