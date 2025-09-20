<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Care_PwCheck</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageCare/carePwCheck.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/myPageCare/carePwCheck.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<main>
		<!-- 마이페이지 사이드 바 목록과 이동 경로 -->

		<nav class="main_sidebar">
			<ul>
        <li>
        	<a href="${pageContext.request.contextPath}/myPageCare/careProfile.cp">
          		<img 
  				src="${pageContext.request.contextPath}${profilePic.getProfilesFilesPath()}${profilePic.getProfilesFilesName()}${profilePic.getProfilesFilesType()}" 
  				onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/assets/img/myPageCare/default.png';" 
  				alt="프로필 이미지">
        	</a>
        </li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/careModify.cp">개인정보
						수정</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/careMark.cp">찜한
						목록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/careMatching.cp">매칭
						기록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/careMesseage.cp">쪽지함</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/carePost.cp">게시글
						관리</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/carePointreturn.cp">포인트
						환급</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/careReference.cp">1
						대 1 문의</a></li>
				<li><a
					href="${pageContext.request.contextPath}/myPageCare/careExit.cp">회원
						탈퇴</a></li>
			</ul>
		</nav>
		<!-- 페이지 세부 정보 -->

		<div class="pw_check">
			<form
				action="/myPageCare/carePwCheckOk.cp"
				method="post">
				비밀번호<input name="usersPassword" type="password" placeholder="비밀번호 8자리 입력">
				<button type="submit">비밀번호 확인</button>
			<c:if test="${not empty pwCheck and not pwCheck}">
				<div>일치하지 않는 비밀번호 입니다</div>
			</c:if>
			</form>
		</div>
	</main>
	<jsp:include page="/footer.jsp" />

</body>

</html>