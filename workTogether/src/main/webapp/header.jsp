<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="site_header">
  <div id="header_upper">
    <span>
      <!-- 로고 -->
      <a href="${pageContext.request.contextPath}/main.jsp">
        <img src="${pageContext.request.contextPath}/assets/img/main/logoP.png">
      </a>
    </span>
    <span>
    	<c:choose>
    		<c:when test="${empty sessionScope.usersNumber}">
		     	<!-- 로그인 메뉴 -->
		      	<a href="${pageContext.request.contextPath}/서블릿 경로">로그인</a>
		      	<!-- 회원가입 메뉴 -->
		      	<a href="${pageContext.request.contextPath}/서블릿 경로">회원가입</a>
    		</c:when>
    		<c:otherwise>
    			<!-- 로그인 메뉴 -->
		      	<a href="${pageContext.request.contextPath}/서블릿 경로">마이페이지</a>
    			<!-- 로그아웃 메뉴 -->
				<a href="${pageContext.request.contextPath}/서블릿 경로">로그아웃</a>
			</c:otherwise>
    	</c:choose>
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
      <!-- 돌본 회원 리스트 메뉴 -->
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
