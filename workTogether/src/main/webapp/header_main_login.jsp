<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="site_header">
  <!-- 헤더 윗 줄 -->
  <div>
    <!-- 헤더 윗 줄 왼쪽 메뉴 -->
    <span>
      <!-- 로고 -->
      <a href="./main.html">
        <img src="./assets/img/main/logoP.png">
      </a>
    </span>
    <!-- 헤더 윗 줄 오른쪽 메뉴 -->
    <span>
      <!-- 마이페이지 메뉴 -->
      <a href="./app/myPageCare/carePwCheck.jsp">
        마이페이지
      </a>
      <!-- 로그아웃 메뉴 -->
      <a href="./main.jsp">
        로그아웃
      </a>
    </span>
  </div>
  <!-- 네비게이션 -->
  <nav>
    <!-- 네비게이션 메뉴 목록 -->
    <ul>
      <!-- 지도 메뉴 -->
      <li>
        <div>
          <a href="./app/map/map.jsp">
            · 지도
          </a>
        </div>
      </li>
      <!-- 지하철 노선도 메뉴 -->
      <li>
        <div>
          <a href="./app/subwayLine/subway.jsp">
            · 지하철 노선도
          </a>
        </div>
      </li>
      <!-- 가게 리스트 메뉴 -->
      <li>
        <div>
          <a href="./app/restaurant/restaurant.jsp">
            · 가게 리스트
          </a>
        </div>
      </li>
      <!-- 뉴스 게시판 메뉴 -->
      <li>
        <div>
          <a href="./app/news/news.jsp">
            · 뉴스 게시판
          </a>
        </div>
      </li>
      <!-- 일반 게시판 메뉴 -->
      <li>
        <div>
          <a href="./app/post/postMain.jsp">
            · 일반 게시판
          </a>
        </div>
      </li>
      <!-- 돌봄 회원 리스트 메뉴 -->
      <li>
        <div>
          <a href="./app/careMember/careMember.jsp">
            · 돌봄 회원 리스트
          </a>
        </div>
      </li>
    </ul>
  </nav>
</header> 
