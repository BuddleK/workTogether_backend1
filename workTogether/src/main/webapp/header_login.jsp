<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="site_header_login">
  <!-- 헤더 윗 줄 -->
  <div id="header_upper">
    <!-- 헤더 윗 줄 왼쪽 -->
    <span>
      <!-- 로고 -->
      <a href="${pageContext.request.contextPath}/main.jsp">
        <img src="${pageContext.request.contextPath}/assets/img/main/logoP.png">
      </a>
    </span>
    <!-- 헤더 윗 줄 오른쪽 -->
    <span>
      <!-- 마이페이지 메뉴-->
      <a href="${pageContext.request.contextPath}/myPageNormal/normalPwCheck.jsp">
        마이페이지
      </a>
      <!-- 로그아웃 메뉴 -->
      <a href="${pageContext.request.contextPath}/main.jsp">
        로그아웃
      </a>
    </span>
  </div>
  <!-- 네비게이션 -->
  <nav>
    <!-- 네비게이션 메뉴 리스트 -->
    <ul>
      <!-- 지도메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/map/map.jsp">
            · 지도
          </a>
        </div>
      </li>
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/subwayLine/subway.jsp">
            · 지하철 노선도
          </a>
        </div>
      </li>
      <!-- 가게 리스트 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/restaurant/restaurant.jsp">
            · 가게 리스트
          </a>
        </div>
      </li>
      <!-- 뉴스 게시판 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/news/news.jsp">
            · 뉴스 게시판
          </a>
        </div>
      </li>
      <!-- 일반 게시판 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/post/postMain.jsp">
            · 일반 게시판
          </a>
        </div>
      </li>
      <!-- 돌봄 회원 리스트 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/careMember/careMember.jsp">
            · 돌봄 회원 리스트
          </a>
        </div>
      </li>
    </ul>
  </nav>
</header> 