<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_PwCheck</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalPwCheck.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalPwCheck.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 메뉴 사이드바 섹션 -->
    <nav class="main_sidebar">
	<ul>
		<li><img
			src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg"
			alt="#"></li>
		<li><a href="/myPageNormal/normalModify.mn">개인정보 수정</a></li>
		<li><a href="/myPageNormal/normalfavoriteList.mn">찜한 목록</a></li>
		<li><a href="/myPageNormal/normalHeartListTotal.mn">하트 목록</a></li>
		<li><a href="/myPageNormal/normalMatching.mn">매칭 기록</a></li>
		<li><a href="/myPageNormal/normalMsgList.mn">쪽지함</a></li>
		<li><a href="/myPageNormal/normalPostsListOk.mn">게시글 관리</a></li>
		<li><a href="/myPageNormal/normalPoint.mn">포인트 충전</a></li>
		<li><a href="/myPageNormal/normalReferenceList.mn">1 대 1 문의</a></li>
		<li><a href="/myPageNormal/normalExit.mn">회원 탈퇴</a></li>
	</ul>
</nav>
    <!-- 비밀번호 확인 섹션 -->
    <div class="pw_check">
      <form action="/myPageNormal/checkPwOk.mn" method="get"> 
      비밀번호 
      <input id="pw_input" name="usersPassword" type="password" placeholder="비밀번호 8자리 입력" />
      <c:if test="${not empty errorMsg}">
          <div id="pwaccord">${errorMsg}</div>
      </c:if>
      <button type="submit" class="checkBtn">비밀번호 확인</button>
    </div>
  </form>
  </main>
  <jsp:include page="/footer.jsp" />
</body>

</html>