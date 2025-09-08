<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입(돌봄)</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/sign/basic.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/sign/signCare.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/sign/signNormalCare.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<!-- 우편번호 팝업 -->
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
		<section class="sign">
			<form action="${pageContext.request.contextPath}/users/joinCareOk.us"
				method="post" class="sign_form" enctype="multipart/form-data">
				<input type="hidden" name="usersType" value="C" />

				<div class="sign_box sign_title">
					<p>돌봄 회원가입</p>
				</div>

				<%-- 아이디 --%>
				<div class="sign_box sign_id">
					<p>아이디</p>
					<input type="text" id="get_id_input" name="usersId"
						placeholder="8자리 이상, 문자 숫자 포함" required>
					<button onclick="checkId()" type="button">중복확인</button>
				</div>
				<div class="id_err_box">
					<p class="err_id_msg">중복된 아이디 입니다.</p>
					<p class="ok_id_msg">사용가능한 아이디 입니다.</p>
				</div>

				<%-- 비밀번호 --%>
				<div class="sign_box sign_password">
					<p>비밀번호</p>
					<input type="password" name="usersPassword"
						placeholder="비밀번호 8자리 입력(숫자와 영어 특수기호 포함)" id="pw_input" required>
				</div>
				<div class="box_error_pw" id="msg_box">
					<p class="error_pw_msg">형식에 맞게 입력해주세요.</p>
				</div>

				<%-- 비밀번호 확인 --%>
				<div class="sign_box password_check">
					<p>비밀번호 확인</p>
					<input type="password" id="pw_check_input">
				</div>
				<div class="box_re_error" id="msg_box2">
					<p class="correct_pw">비밀번호가 일치합니다.</p>
					<p class="error_pw_check_msg">비밀번호가 일치하지않습니다.</p>
				</div>

				<%-- 이메일 --%>
				<div class="sign_box sign_email">
					<p>이메일</p>
					<input type="email" id="email" name="usersEmail" required>
				</div>
				<div class="box_error_email" id="msg_box_email">
					<p class="error_email_msg">이메일형식에 맞지 않습니다.</p>
					<p class="correct_email">제대로 입력되었습니다.</p>
				</div>

				<%-- 이름 --%>
				<div class="sign_box sign_name">
					<p>이름</p>
					<input type="text" id="name" name="usersName" required>
				</div>

				<%-- 휴대전화 + 인증 --%>
				<div class="sign_box sign_birth">
					<p>휴대전화</p>
					<input type="text" id="phone" name="usersPhone"
						placeholder="- 없이 숫자만 입력해주세요." required>
				</div>
				<div class="sign_box sign_author">
					<input type="text" placeholder="인증번호 6자리 입력" id="author_number">
					<div class="timer"></div>
					<button type="button" onclick="sendMsg()">인증번호 발송</button>
					<button type="button" onclick="checkMsg()">인증번호 확인</button>
				</div>
				<div class="alert">인증번호가 발송되었습니다.</div>
				<div class="error_box_msg">
					<p class="error_msg">인증번호가 올바르지 않습니다.</p>
					<p class="okay_msg">제대로 인증되었습니다.</p>
				</div>

				<%-- 주소 --%>
				<div class="sign_box sign_address">
					<p>주소</p>
					<input type="text" id="usersPostsalCode" name="usersPostsalCode"
						placeholder="우편번호" readonly required>
					<button type="button" onclick="openPostcode()">우편 주소</button>
				</div>

				<div class="sign_box address_detail">
					<p>상세 주소</p>
					<input type="text" id="usersAddressLine1" name="usersAddressLine1"
						placeholder="기본주소" readonly required> <input type="text"
						id="usersAddressLine2" name="usersAddressLine2" placeholder="상세주소"
						required>
				</div>

				<%-- 돌봄 전용: 소개글(선택) --%>
				<div class="sign_box">
					<p>소개글</p>
					<input type="text" name="careIntroText" placeholder="간단한 소개(선택)">
				</div>

				<%-- 파일(선택) - 업로드 연동 전 UI --%>
				<div class="file">
					<input type="text" class="file-text" placeholder="자격증 파일" readonly>
					<input type="file" id="file-cert" class="hidden-file"
						name="licenseFile">
					<button type="button" class="file-open" data-target="file-cert">파일첨부</button>
				</div>
				<input type="hidden" name="licenseType" id="licenseType"> <input
					type="hidden" name="licenseName" id="licenseName"> <input
					type="hidden" name="licensePath" id="licensePath"> <input
					type="hidden" name="licenseSizeBytes" id="licenseSizeBytes">

				<%-- 파일 (통장 사본) --%>
				<div class="file">
					<input type="text" class="file-text" placeholder="통장사본 파일" readonly>
					<input type="file" id="file-account" class="hidden-file"
						name="accountFile">
					<button type="button" class="file-open" data-target="file-account">파일첨부</button>
				</div>
				<input type="hidden" name="accountType" id="accountType"> <input
					type="hidden" name="accountName" id="accountName"> <input
					type="hidden" name="accountPath" id="accountPath"> <input
					type="hidden" name="accountSizeBytes" id="accountSizeBytes">

				<%-- 파일 (프로필 사진, 선택) --%>
				<div class="file">
					<input type="text" class="file-text" placeholder="프로필사진 파일"
						readonly> <input type="file" id="file-profile"
						class="hidden-file" name="profileFile">
					<button type="button" class="file-open" data-target="file-profile">파일첨부</button>
				</div>
				<input type="hidden" name="profileType" id="profileType"> <input
					type="hidden" name="profileName" id="profileName"> <input
					type="hidden" name="profilePath" id="profilePath"> <input
					type="hidden" name="profileSizeBytes" id="profileSizeBytes">

				<div class="sign_box sign_btn">
					<button type="submit">가입하기</button>
				</div>
			</form>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />
</body>
</html>
