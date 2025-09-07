<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal_Modify</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalModify.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalmodify.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function openPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						document.getElementById("usersPostsalCode").value = data.zonecode
								|| "";
						document.getElementById("usersAddressLine1").value = data.roadAddress
								|| data.jibunAddress || "";
						document.getElementById("usersAddressLine2").focus();
					}
				}).open();
	}
</script>
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
				<li><a
					href="/myPageNormal/normalModify.mn">개인정보
						수정</a></li>
				<li><a href="/myPageNormal/normalfavoriteList.mn">찜한
						목록</a></li>
				<li><a
					href="/myPageNormal/normalHeartList.mn">하트 목록</a></li>
				<li><a
					href="/myPageNormal/normalMatching.mn">매칭
						기록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalsendMesseage.jsp">쪽지함</a></li>
				<li><a href="/myPageNormal/normalPostsList.mn">게시글
						관리</a></li>
				<li><a
					href="${pageContext.request.contextPath}/normalPoint.jsp">포인트
						충전</a></li>
				<li><a
					href="/myPageNormal/normalReferenceInsert.mn">1
						대 1 문의</a></li>
				<li><a href="/myPageNormal/normalExit.mn">회원
						탈퇴</a></li>
			</ul>
		</nav>
		<div class="div_mark">
			<!-- 메뉴 제목 -->
			<div class="title">개인정보 수정</div>
			<!-- 주의사항 표시 -->
			<div class="arlim">
				<nav>
					<ul>
						<li>🛈 저희 함께걸음은 회원님의 개인 정보를 신중히 취급하며, 회원님의 동의 없이 기재하신 회원정보를
							공개하지 않습니다.</li>
						<li>회원님의 개인 정보를 안전하게 보호하기 위해 최선을 다하고 있습니다.</li>
						<li>회원님의 정보를 특정할 수 있는 것은 입력을 지양해 주시길 바랍니다.</li>
					</ul>
				</nav>
			</div>
			<!-- 회원 정보 섹션 -->
			<form action="/myPageNormal/normalModifyOk.mn" method="post">
				<div>
					<div>회원 정보</div>
				</div>
				<nav class="normalmodify">
					<ul>
						<li class="member">
							<ul>
								<li class="info">성명</li>
								<li class="myinfo"><c:out value="${normal.getUsersName() }"></c:out>
								</li>
							</ul>
						</li>
						<li class="member">
							<ul>
								<li class="info">상태</li>
								<li class="myinfo"><c:out
										value="${normal.getNormalUsersLevel() }"></c:out>레벨</li>
							</ul>
						</li>
						<li class="member">
							<ul>
								<li class="info">주소</li>
								<li class="myinfo">
									<ul>
										<li><input type="text" id="usersPostsalCode"
											name="usersPostsalCode"
											value="${normal.getUsersPostsalCode() }"></li>
										<li><input type="text" id="usersAddressLine1"
											name="usersAddressLine1"
											value="${normal.getUsersAddressLine1() }">
											<button type="button" id="mailbutton"
												onclick="openPostcode()">우편번호 찾기</button></li>
										<li><input type="text" id="usersAddressLine2"
											name="usersAddressLine2"
											value="${normal.getUsersAddressLine2() }"></li>
									</ul>
								</li>
							</ul>
						</li>
						<li class="member">
							<ul>
								<li class="info">전화번호</li>
								<li class="myinfo"><input type="text" name="usersPhone"
									value="${normal.getUsersPhone() }"></li>
							</ul>
						</li>
						<li class="member">
							<ul>
								<li class="info">아이디</li>
								<li class="myinfo">${normal.getUsersId() }</li>
							</ul>
						</li>
						<li class="member">
							<ul>
								<li class="info">이메일</li>
								<li class="myinfo"><input type="text" name="usersEmail"
									value="${normal.getUsersEmail() }"></li>
							</ul>
						</li>
						<li class="member">
							<ul>
								<li class="info">비밀번호</li>
								<li class="myinfo">
									<ul>
										<li><input id="pwInput" type="password"
											name="usersPassword" placeholder="비밀번호 입력"></li>
										<li><input id="newPwInput" type="password"
											placeholder="새 비밀번호 입력"> <!-- <button type="button" id="pwbutton">확인</button></li> -->
										<li><div class="pwCheck">비밀번호가 일치하지않습니다</div></li>
									</ul>
							</ul>
						</li>
					</ul>
				</nav>
				<button>수정완료</button>
				<c:if test="${err eq 'email_dup'}">
					<script>
						alert("이미 등록된 이메일입니다. 다른 이메일을 입력해 주세요.");
					</script>
				</c:if>
				<c:if test="${success eq 'success' }">
					<script>
						alert("수정 완료 되었습니다.")
					</script>
				</c:if>
			</form>
		</div>
	</main>
	<!-- 정보 수정 확인 모달들 -->

	<div class="modal_pw">
		<div class="modal-content">
			<p>비밀번호 수정이 완료 되었습니다.</p>
			<button type="button" onclick="openpwModalClose()"
				id="saveConfirmBtn">확인</button>
		</div>
	</div>

	<jsp:include page="/footer.jsp" />
</body>
</html>