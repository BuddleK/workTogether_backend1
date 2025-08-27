<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="site_header">
  <div id="header_upper">
    <span>
      <!-- 로고 -->
      <a href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath}/assets/img/main/logoP.png">
      </a>
    </span>
    <span>
    	<c:choose>
    		<c:when test="${empty sessionScope.usersNumber}">
		     	<!-- 로그인 메뉴 -->
		      	<a href="${pageContext.request.contextPath}/users/nomalLogin.us">일반 로그인</a>
		      	<a href="${pageContext.request.contextPath}/users/CareLogin.us">돌봄 로그인</a>
		      	<%-- <a href="${pageContext.request.contextPath}/login/login.us">로그인</a> --%>
		      	<!-- 회원가입 메뉴 -->
		      	<a href="${pageContext.request.contextPath}/app/sign/terms.jsp">회원가입</a>
		      	<%-- <a href="${pageContext.request.contextPath}/users/joinNormalOk.us">돌봄 회원가입</a> --%>				
    		</c:when>
    		<c:otherwise>
	    		<c:choose>
    				<c:when test="${sessionScope.usersType == 'C'}">
	    				<!--  돌봄 마이페이지 메뉴 -->
			      		<a href="${pageContext.request.contextPath}/app/myPageCare/carePwcheck.jsp">마이페이지</a>
			      		<%-- <a href="${pageContext.request.contextPath}/myPageCare/carePwcheck.??">마이페이지</a> --%>
			    	</c:when>
			    	<c:otherwise>
			    		<!--  일반 마이페이지 메뉴 -->
			      		<a href="${pageContext.request.contextPath}/app/myPageNormal/normalModify.jsp">마이페이지</a>
			      		<%-- <a href="${pageContext.request.contextPath}/myPageNormal/normalModify.??">마이페이지</a> --%>
			    	</c:otherwise>
    			</c:choose>
	    		<!-- 로그아웃 메뉴 -->
				<a href="${pageContext.request.contextPath}/users/logoutOk.us">로그아웃</a>
				<%-- <a href="${pageContext.request.contextPath}/logoutOk.us">로그아웃</a> --%>
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
          <a href="${pageContext.request.contextPath}/map/mapMain.ma">
            · 지도
          </a>
        </div>
      </li>
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/subway/subwayList.sw">
            · 지하철 노선도
          </a>
        </div>
      </li>
      <!-- 가게 리스트 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/shops/shopsListOk.sh">
            · 가게 리스트
          </a>
        </div>
      </li>
      <!-- 뉴스 게시판 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/app/news/news.jsp">
          <%-- <a href="${pageContext.request.contextPath}/news/newsMain.news"> --%>
            · 뉴스 게시판
          </a>
        </div>
      </li>
      <!-- 일반 게시판 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/post/postMain.po">
            · 일반 게시판
          </a>
        </div>
      </li>
      <!-- 돌본 회원 리스트 메뉴 -->
      <li>
        <div>
          <a href="${pageContext.request.contextPath}/careList/careListOk.cl">
            · 돌봄 회원 리스트
          </a>
        </div>
      </li>
    </ul>
  </nav>
  <script>

		
		console.log(window.usersType);
		console.log(window.usersNumber);
	</script>
</header> 
