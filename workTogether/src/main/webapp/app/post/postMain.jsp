<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Post</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postMain.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/post/postMain.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 공지사항, 일반 게시글 목록 섹션 -->
    <form action="" method="get">
      <nav class="post_top">
        <ul>
          <li class="number"><div>번호</div></li>
          <li class="posttitle"><div>제목</div></li>
          <li class="name"><div>작성자</div></li>
          <li class="view"><div>조회수</div></li>
          <li class="postday"><div>작성일</div></li>
        </ul>
      </nav>
      <!-- 공지사항 섹션 -->
      <nav class="post_notify">
        <ul>
          <li class="number">
            <div>공지</div>
          </li>
          <li class="posttitle">
            <div><a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">사이트 이용시 주의사항</a></div>
          </li>
          <li class="name">
            <div>관리자</div>
          </li>
          <li class="view">
            <div>5</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_notify">
        <ul>
          <li class="number">
            <div>공지</div>
          </li>
          <li class="posttitle">
            <div><a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">사이트 이용시 주의사항</a></div>
          </li>
          <li class="name">
            <div>관리자</div>
          </li>
          <li class="view">
            <div>5</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_notify">
        <ul>
          <li class="number">
            <div>공지</div>
          </li>
          <li class="posttitle">
            <div><a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">사이트 이용시 주의사항</a></div>
          </li>
          <li class="name">
            <div>관리자</div>
          </li>
          <li class="view">
            <div>5</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="notify_open">
        <ul>
          <li>숨은 공지 펼치기(2개) v</li>
        </ul>
      </nav>
      <!-- 일반 게시글 섹션 -->
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>10</div>
          </li>
          <li class="posttitle">
            <div><a href="${pageContext.request.contextPath}/app/post/postDetaillogin.jsp">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>9</div>
          </li>
          <li class="posttitle">
            <div><a href="${pageContext.request.contextPath}/app/post/postDetailNotlogin.jsp">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul >
          <li class="number">
            <div>8</div>
          </li>
          <li class="posttitle">
            <div onclick="postTitle()" class="postTitle">안녕하세요</div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>7</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>6</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>5</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>4</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>3</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>2</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <nav class="post_member">
        <ul>
          <li class="number">
            <div>1</div>
          </li>
          <li class="posttitle">
            <div><a href="">안녕하세요</a></div>
          </li>
          <li class="name">
            <div>홍길동</div>
          </li>
          <li class="view">
            <div>3</div>
          </li>
          <li class="postday">
            <div>2025-08-09</div>
          </li>
        </ul>
      </nav>
      <!-- 검색 섹션 -->
      <nav class="search">
        <ul>
          <li><div>제목/내용 v</div></li>
          <li><input type="text"></li>
          <li><a href=""><img src="${pageContext.request.contextPath}/assets/img/post/search.png" alt=""></a></li>
          <button type="button" onclick="postWrite()" class="postWrite"><a href="${pageContext.request.contextPath}/app/post/postWrite.jsp">글쓰기</a></button>
        </ul>
      </nav>
      <!-- 페이지네이션 -->
      <nav class="page">
        <ul>
          <a href="">
            <li>&lt;</li>
          </a>
          <a href="">
            <li>1</li>
          </a>
          <a href="">
            <li>2</li>
          </a>
          <a href="">
            <li>3</li>
          </a>
          <a href="">
            <li>4</li>
          </a>
          <a href="">
            <li>&gt;</li>
          </a>
        </ul>
      </nav>
    </form>
    <!-- 비로그인 회원이 글쓰기 버튼 클릭시 모달 -->
    <div class="modal">
      <div class="modal-content">
        <button id="sendxbutton"><a href="${pageContext.request.contextPath}/app/login/login.jsp">X</a></button>
        <p>로그인이 필요합니다</p>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>