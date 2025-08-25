<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄회원 이력 수정 신청관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/careCareerDetailUpdate.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/modal/modalCareModifyFinished.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<div id="sidebar"></div>
		<section class="care_box">
			<div class="box_title">
				<h1>돌봄 회원  신청관리</h1>
			</div>

			<!-- 필요하면 usersNumber 전달용 히든값 -->
			<input type="hidden" id="usersNumber" value="${param.usersNumber}" />

			<form action="" method="" class="table_form">
				<div class="table">
					<div class="thead">
						<div class="thead_content thead_name">성명</div>
						<div class="thead_content thead_birth">생년월일</div>
						<div class="thead_content thead_phone">전화번호</div>
						<div class="thead_content thead_email">이메일</div>
						<div class="thead_content thead_detach">첨부파일1</div>
						<div class="thead_content thead_account">통장사본</div>
					</div>

					<div class="tbody">
						<div class="tbody_content tbody_name">
							<c:out value="${user.usersName}" />
						</div>
						<div class="tbody_content tbody_birth">
							<c:out value="${user.usersBirth}" />
						</div>
						<div class="tbody_content tbody_phone">
							<c:out value="${user.usersPhone}" />
						</div>
						<div class="tbody_content tbody_email">
							<c:out value="${user.usersEmail}" />
						</div>

						<!-- 자격증(첨부파일1) -->
						<div class="tbody_content tbody_detach">
							<c:choose>
								<c:when
									test="${not empty licenseFile and not empty licenseFile.fileNumber}">
									<c:out value="${licenseFile.fileName}" />
									<c:url var="licenseDownUrl" value="/admin/file/download.ad">
										<c:param name="kind" value="license" />
										<c:param name="no" value="${licenseFile.fileNumber}" />
									</c:url>
									<button class="download" type="button"
										onclick="location.href='${licenseDownUrl}'">다운로드</button>
								</c:when>
								<c:otherwise>
                    없음
                    <button class="download" type="button" disabled>다운로드</button>
								</c:otherwise>
							</c:choose>
						</div>

						<!-- 통장사본 -->
						<div class="tbody_content tbody_account">
							<c:choose>
								<c:when
									test="${not empty accountFile and not empty accountFile.fileNumber}">
									<c:out value="${accountFile.fileName}" />
									<c:url var="accountDownUrl" value="/admin/file/download.ad">
										<c:param name="kind" value="account" />
										<c:param name="no" value="${accountFile.fileNumber}" />
									</c:url>
									<button class="download" type="button"
										onclick="location.href='${accountDownUrl}'">다운로드</button>
								</c:when>
								<c:otherwise>
                    없음
                    <button class="download" type="button" disabled>다운로드</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="btn_area">
					<button class="cancle" onclick="modalCareModifyRejectShow()"
						type="button">반려 처리</button>
					<button class="submit" onclick="modalCareModifyFinishedShow()"
						type="button">돌봄 회원 수정 신청 완료</button>
				</div>
			</form>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />

	<!-- 모달 영역 -->
	<div id="modalCareModifyFinished"></div>
	<div id="modalCareModifyReject"></div>
</body>
</html>