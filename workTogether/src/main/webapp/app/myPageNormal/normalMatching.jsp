<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal_Matching</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalMatching.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalMatching.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<main>
		<!-- 메뉴 사이드바 섹션 -->
		<nav class="main_sidebar">
			<ul>
				<li><img src="./../../assets/img/myPageNormal/normalMember.jpg"
					alt="#" /></li>
				<li><a href="./normalPwCheck.html">개인정보 수정</a></li>
				<li><a href="./normalMark.html">찜한 목록</a></li>
				<li><a href="./normalheart.html">하트 목록</a></li>
				<li><a href="./normalMatching.html">매칭 기록</a></li>
				<li><a href="./normalsendMesseage.html">쪽지함</a></li>
				<li><a href="./normalPost.html">게시글 관리</a></li>
				<li><a href="./normalPoint.html">포인트 충전</a></li>
				<li><a href="./normalReference.html">1 대 1 문의</a></li>
				<li><a href="./normalQuit.html">회원 탈퇴</a></li>
			</ul>
		</nav>
		<div class="div_mark">
			<!-- 메뉴 제목 -->
			<div class="title">매칭 기록</div>
			<%-- <c:choose> --%>
			<div class="box">
				<!-- 월 표시 -->
				<nav class="month">
					<ul>
						<li data-month="01" onclick="loadChooseMatch()" class="month">01월</li>
						<li data-month="02" onclick="loadChooseMatch()" class="month">02월</li>
						<li data-month="03" onclick="loadChooseMatch()" class="month">03월</li>
						<li data-month="04" onclick="loadChooseMatch()" class="month">04월</li>
						<li data-month="05" onclick="loadChooseMatch()" class="month">05월</li>
						<li data-month="06" onclick="loadChooseMatch()" class="month">06월</li>
						<li data-month="07" onclick="loadChooseMatch()" class="month">07월</li>
						<li data-month="08" onclick="loadChooseMatch()" class="month">08월</li>
						<li data-month="09" onclick="loadChooseMatch()" class="month">09월</li>
						<li data-month="10" onclick="loadChooseMatch()" class="month">10월</li>
						<li data-month="11" onclick="loadChooseMatch()" class="month">11월</li>
						<li data-month="12" onclick="loadChooseMatch()" class="month">12월</li>
					</ul>
				</nav>
				<!-- 매칭 기록 표시 섹션 -->
				<%-- <c:forEach var="matching" items="${matchingDTO }"> --%>
				<nav class="matching">
					<!-- <form action="" method="get"> -->
					<ul id="matching_table">
						<li>
							<%-- <div>${matching.matchDate }일"${matching.careName }"돌봄회원|
										이용 시간 : ${matching.matchMatchTime } 포인트 사용 :
										${match.matchPoints }</div>
									<div class="matchingbutton">
										<button type="button" id="complete">이용완료</button>
										<button type="button" id="cancel">취소</button>
									</div> --%>
						</li>
					</ul>
					<!-- </form> -->
				</nav>
				<%-- 	</c:forEach> --%>

				<!-- 페이지네이션 -->
				<nav class="page">
					<ul>
						<li><a href="">&lt;</a></li>
						<li><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href="">4</a></li>
						<li><a href="">&gt;</a></li>
					</ul>
				</nav>
				<%-- </c:choose> --%>
			</div>
		</div>
	</main>
	<div class="completemodal">
		<div class="modal-content">
			<p>이용이 완료 되었습니다.</p>
			<button type="button" onclick="completeModalClose()" id="completeBtn">확인</button>
		</div>
	</div>
	<div class="cancelmodal">
		<div class="modal-content">
			<p>이용이 취소 되었습니다.</p>
			<button type="button" onclick="cancelModalClose()" id="cancelBtn">확인</button>
		</div>
	</div>
	<jsp:include page="/footer.jsp" />
</body>

</html>