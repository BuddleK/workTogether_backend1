<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>약관</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/sign/basic.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/sign/terms.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/sign/terms.js"></script>
</head>

<body>
	<jsp:include page="/header.jsp" />
	<main>
		<section class="terms">
			<form action="" method="">
				<div class="terms_title">
					<p>약관</p>
				</div>
				<div class="terms_all">
					<div class="terms_checkbox">
						<input type="checkbox" id="all"> <label for="all">
							<div></div>
							<p class="all_p">전체 동의하기</p>
						</label>
					</div>
					<p>
						실명 인증된 아이디로 가입, 위치기반 서비스 이용약관(선택) 동의를<br> 포함합니다.
					</p>
				</div>
				<div class="term">
					<div class="terms_checkbox">
						<input type="checkbox" id="check1" class="check"> <label
							for="check1">
							<div></div>
							<p>
								<span>[필수]</span> 이용약관
							</p>
						</label>
					</div>
					<p>
						여러분을 환영합니다.<br> 함께걸음 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한
						함께걸음 서비스의 이용과 관련하여 ...
					</p>
				</div>
				</div>
				<div class="term">
					<div class="terms_checkbox">
						<input type="checkbox" id="check2" class="check"> <label
							for="check2">
							<div></div>
							<p>
								<span>[필수]</span> 개인정보 수집 및 이용
							</p>
						</label>
					</div>
					<p>개인정보보호법에 따라 함께걸음에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및
						이용목적, 개인정보의 보유 및 이용기간, 등의 거부권 및 동의 거부 시 불이익에 관한...</p>
				</div>
				<div class="term">
					<div class="terms_checkbox">
						<input type="checkbox" id="check3" class="check"> <label
							for="check3">
							<div></div>
							<p>
								<span>[필수]</span> 실명 인증된 아이디로 가입
							</p>
						</label>
					</div>
					<p>실명 인증된 아이디로 가입하시면 본인인증이 필요한 서비스를 가입 후 바로 이용하실 수 있어요.</p>
				</div>
				<div class="next_btn">
					<a href="${pageContext.request.contextPath}/users/joinNormal.us">
						<button type="button" id="normal">일반회원가입</button>
					</a> 
					<a href="${pageContext.request.contextPath}/users/joinCare.us">
						<button type="button" id="care">돌봄회원가입</button>
					</a>
				</div>
			</form>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />

</body>

</html>