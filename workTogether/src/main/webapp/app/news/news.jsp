<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뉴스페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/news/news.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/news/news.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 뉴스 페이지 컨테이너 -->
    <div class="news_container">
      <!-- 뉴스 탑메뉴(소메뉴) -->
      <div class="news_topmenu">
        <!-- 전체 보기 페이지 이동 버튼 -->
        <div class="all_news"><a href="${pageContext.request.contextPath}/app/news/newsList.jsp">&plus;전체보기</a></div>
        <!-- 뉴스 페이지 제목 -->
        <div class="title">NEWS</div>
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
      <!-- 슬라이드 베너 랩 -->
      <div class="slides_wrap">
        <!-- 베너 div -->
        <div class="slides">
          <div class="cardlist">
            <!-- 뉴스 링크이동 카드 -->
            <div class="card"><a draggable="false" href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <h1>서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</h1><br>
                이흥재 기자 : 서울 서초구가 경계선지능인을 위한 전국 최초의 맞춤형 평생학습지원 공간인 ‘서초 낮은울타리 평생학습센터’를 지난 25일 개소하고 본격적인 운영에 들어갔다. ....
              </a></div>
          </div>
          <div class="cardlist">
            <!-- 뉴스 링크이동 카드 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <h1>서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</h1><br>
                이흥재 기자 : 서울 서초구가 경계선지능인을 위한 전국 최초의 맞춤형 평생학습지원 공간인 ‘서초 낮은울타리 평생학습센터’를 지난 25일 개소하고 본격적인 운영에 들어갔다. ....
              </a></div>
          </div>
          <div class="cardlist">
            <!-- 뉴스 링크이동 카드 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <h1>서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</h1><br>
                이흥재 기자 : 서울 서초구가 경계선지능인을 위한 전국 최초의 맞춤형 평생학습지원 공간인 ‘서초 낮은울타리 평생학습센터’를 지난 25일 개소하고 본격적인 운영에 들어갔다. ....
              </a></div>
          </div>
          <div class="cardlist">
            <!-- 뉴스 링크이동 카드 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <h1>서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</h1><br>
                이흥재 기자 : 서울 서초구가 경계선지능인을 위한 전국 최초의 맞춤형 평생학습지원 공간인 ‘서초 낮은울타리 평생학습센터’를 지난 25일 개소하고 본격적인 운영에 들어갔다. ....
              </a></div>
          </div>
          <div class="cardlist">
            <!-- 뉴스 링크이동 카드 -->
            <div class="card"><a href="https://www.barrierfreenews.com/news/articleView.html?idxno=38466">
                <h1>서초구, ‘경계선지능인’ 위한 맞춤형 학습공간 개소</h1><br>
                이흥재 기자 : 서울 서초구가 경계선지능인을 위한 전국 최초의 맞춤형 평생학습지원 공간인 ‘서초 낮은울타리 평생학습센터’를 지난 25일 개소하고 본격적인 운영에 들어갔다. ....
              </a></div>
          </div>
        </div>
      </div>
    </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>