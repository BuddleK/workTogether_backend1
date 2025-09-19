<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="site_header_login">
  <div>
    <!-- 헤더 왼쪽 메뉴 -->
    <span>
      <!-- 로고 -->
      <a href="#">
        <img src="${pageContext.request.contextPath}/assets/img/main/logoP.png" />
      </a>
      <!-- 관리자 표시(그냥 텍스트) -->
      <div class="admin_text">· 관리자</div>
    </span>
    <!-- 헤더 오른쪽 메뉴 -->
    <span>
    	<c:choose>
    		<c:when test="${empty sessionScope.adminNumber}">
      		<!-- 로그인 메뉴 -->
      		<a href="${pageContext.request.contextPath}/app/admin/adminLogin.jsp" class="logout"> 로그인 </a>
      	</c:when>
      	<c:otherwise>
      		<!-- 로그아웃 메뉴 -->
      		<a href="${pageContext.request.contextPath}/app/admin/adminLogin.jsp" class="logout"> 로그아웃 </a>
      	</c:otherwise>
      </c:choose>
    </span>
  </div>
</header>
