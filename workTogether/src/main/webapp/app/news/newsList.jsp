<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>전체목록 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/news/newsList.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/news/newsList.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 전체 뉴스 페이지 컨테이너 -->
    <div class="search_result_container">
      <!-- 전체 뉴스 탑메뉴(소메뉴) -->
      <div class="search_result_topmenu">
        <!-- 전체 뉴스 페이지 제목 -->
        <div class="title">전체목록</div>
        <!-- 검색 창 바 -->
        <div class="searchbar">
          <!-- 검색 결과 보내주기 위한 폼 -->
          <form action="get">
            <!-- 검색 입력 창 -->
            <input type="text" class="underbar">
          </form>
          <!-- 검색 버튼 -->
          <button class="search_btn">
            <!-- 검색 버튼 이미지 -->
            <img class="searchIcon" src="${pageContext.request.contextPath}/assets/img/news/searchIcon.png" alt="검색아이콘">
          </button>
        </div>
      </div>
      <!-- 전체 뉴스 카드 리스트 -->
      <div class="search_result_card">
        <ul>
          <li>
            <!-- 뉴스 링크 이동 카드 리스트 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <p class="cardtitle">서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</p>
                <p>https://www.barrierfreenews.com/news/....</p>
              </a></div>
          </li>
          <li>
            <!-- 뉴스 링크 이동 카드 리스트 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <p class="cardtitle">서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</p>
                <p>https://www.barrierfreenews.com/news/....</p>
              </a></div>
          </li>
          <li>
            <!-- 뉴스 링크 이동 카드 리스트 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <p class="cardtitle">서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</p>
                <p>https://www.barrierfreenews.com/news/....</p>
              </a></div>
          </li>
          <li>
            <!-- 뉴스 링크 이동 카드 리스트 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <p class="cardtitle">서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</p>
                <p>https://www.barrierfreenews.com/news/....</p>
              </a></div>
          </li>
        </ul>
        <!-- 페이지 네이션 -->
        <div class="pagination">
          &lt; <span class="active">1</span> 2 3 4 ... &gt;
        </div>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>