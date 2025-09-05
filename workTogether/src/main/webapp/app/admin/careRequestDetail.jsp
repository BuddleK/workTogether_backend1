<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄회원 신청관리</title>

<!-- 공통 CSS/JS -->
<link rel="stylesheet" href="/App/assets/css/headerAdmin.css" />
<link rel="stylesheet" href="/App/assets/css/footer.css" />
<link rel="stylesheet" href="/App/assets/css/admin/basic.css" />
<link rel="stylesheet" href="/App/assets/css/admin/careRequestDetail.css" />
<link rel="stylesheet" href="/App/assets/css/admin/sidebar.css" />
<link rel="stylesheet" href="/App/assets/css/modalAdmin.css" />

<script defer src="/App/assets/js/main/includeAdmin.js"></script>
<script defer src="/App/assets/js/modal/modalCareAllowRejectFinished.js"></script>
</head>

<body>
	<jsp:include page="/header_admin.jsp" />

	<main>
		<div id="sidebar"></div>

		<section class="care_box">
			<div class="box_title">
				<h1>돌봄 회원 신청관리</h1>
			</div>

			<form method="post" class="table_form">
				<div class="table">
					<!-- 헤더 -->
					<div class="thead">
						<div class="thead_content thead_name">성명</div>
						<div class="thead_content thead_phone">전화번호</div>
						<div class="thead_content thead_email">이메일</div>
						<div class="thead_content thead_detach">자격증 파일</div>
						<div class="thead_content thead_account">통장사본</div>
					</div>

					<!-- 내용 -->
					<div class="tbody">
						<div class="tbody_content tbody_name">${signup.usersName}</div>
						
						<div class="tbody_content tbody_phone">${signup.usersPhone}</div>
						<div class="tbody_content tbody_email">${signup.usersEmail}</div>

						<!-- 자격증 파일 -->
						<div class="tbody_content tbody_detach">
							<c:choose>
								<c:when test="${not empty licenseFile}"> ${licenseFile.fileName}
								<a
										href="/App/admin/care/fileDownload.ad?fileNumber=${licenseFile.fileNumber}&type=license">
										<button class="download" type="button">다운로드</button>
									</a>
								</c:when>
								<c:otherwise> - </c:otherwise>
							</c:choose>
						</div>

						<!-- 통장사본 -->
						<div class="tbody_content tbody_account">
							<c:choose>
								<c:when test="${not empty accountFile}"> ${accountFile.fileName}
								<a
										href="/App/admin/care/fileDownload.ad?fileNumber=${accountFile.fileNumber}&type=account">
										<button class="download" type="button">다운로드</button>
									</a>
								</c:when>
								<c:otherwise> - </c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<!-- 버튼 영역 -->
				<div class="btn_area">
					<button class="cancle" type="button"
						onclick="modalCareAllowRejectShow()">반려 처리</button>
					<button class="submit" type="button"
						onclick="modalCareAllowFinishedShow()">승인 완료</button>
				</div>
			</form>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />

	<!-- 모달 -->
	<div id="modalCareAllowReject"></div>
	<div id="modalCareAllowFinished"></div>
</body>
</html>