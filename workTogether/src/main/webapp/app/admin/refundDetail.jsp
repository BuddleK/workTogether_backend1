<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄회원 환급 관리</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/refundDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>

</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<div id="sidebar"></div>
		<section class="care_box">
			<div class="box_title">
				<h1>돌봄회원 환급 관리</h1>
			</div>

			<form
				action="${pageContext.request.contextPath}/admin/pointReturnApproveOk.ad"
				method="post" class="table_form">

				<!-- hidden 값 -->
				<input type="hidden" name="pointReturnNumber"
					value="${item.pointReturnId}" /> <input type="hidden"
					name="usersNumber" value="${item.usersNumber}" />
				<!-- 목록 위치/필터 유지 -->
				<input type="hidden" name="page" value="${param.page}" /> <input
					type="hidden" name="status" value="${param.status}" />

				<div class="table">
					<div class="thead">
						<div class="thead_content thead_name">성명</div>
						<div class="thead_content thead_bank">은행</div>
						<div class="thead_content thead_account">계좌번호</div>
						<div class="thead_content thead_point">환급 신청 포인트</div>
						<div class="thead_content thead_left_point">잔여 포인트</div>
					</div>
					<div class="tbody">
						<div class="tbody_content tbody_name">
							<c:out value="${item.usersName}" default="-" />
						</div>
						<div class="tbody_content tbody_bank">
							<c:out value="${item.bankName}" default="-" />
						</div>
						<div class="tbody_content tbody_account">
							<c:out value="${item.accountNumber}" default="-" />
						</div>
						<div class="tbody_content tbody_point">
							<fmt:formatNumber value="${item.pointsAmount}" pattern="#,##0" />
							P
						</div>
						<div class="tbody_content tbody_left_point">
							<fmt:formatNumber value="${item.remainPoint}" pattern="#,##0" />
							P
						</div>
					</div>
					<c:if test="${item.status eq 'Y'}">
						<div class="tbody">
							<div class="tbody_content" style="grid-column: 1/-1;">
								환급일시 :
								<c:out value="${item.refundedAt}" default="-" />
							</div>
						</div>
					</c:if>
				</div>

				<div class="btn_area">
					<a class="cancle"
						href="${pageContext.request.contextPath}/admin/pointReturnListOk.ad?page=${param.page}&status=${param.status}">
						취소</a>
					<button class="submit" type="submit">환급 완료</button>
				</div>
			</form>
		</section>
	</main>
	<jsp:include page="/footer.jsp" />
</body>
</html>
