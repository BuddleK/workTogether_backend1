<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄회원 신청관리</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/careRequestDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />

<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
</head>
<body>
	<jsp:include page="/header_admin.jsp" />

	<main>
		<div id="sidebar"></div>

		<section class="care_box">
			<div class="box_title">
				<h1>돌봄 회원 신청관리</h1>
			</div>

			<div class="table_form">
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
						<div class="tbody_content tbody_name">${item.usersName}</div>
						<div class="tbody_content tbody_phone">${item.usersPhone}</div>
						<div class="tbody_content tbody_email">${item.usersEmail}</div>

						<!-- 자격증 파일 -->
						<div class="tbody_content tbody_detach">
							<c:choose>
								<c:when test="${not empty licenseFileName}">
                  ${licenseFileName}
                  <a class="download" href="${licenseDownloadUrl}"
										download="${licenseFileName}">다운로드</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</div>

						<!-- 통장사본 -->
						<div class="tbody_content tbody_account">
							<c:choose>
								<c:when test="${not empty accountFileName}">
                  ${accountFileName}
                  <a class="download" href="${accountDownloadUrl}"
										download="${accountFileName}">다운로드</a>
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose>
						</div>
					</div>

					<div class="btn_area" style="position: relative; z-index: 1000;">
						<button id="btnReject" class="cancle" type="button">반려 처리</button>
						<button id="btnApprove" class="submit" type="button">승인
							완료</button>
					</div>
				</div>
			</div>

			<form id="careActionForm" method="post">
				<input type="hidden" name="usersNumber" value="${usersNumber}">
				<input type="hidden" name="rejectComment" id="rejectComment">
			</form>

			<input type="hidden" id="approveAction" value="${approveAction}">
			<input type="hidden" id="rejectAction" value="${rejectAction}">
			<input type="hidden" id="usersNumber" value="${usersNumber}">
		</section>
	</main>

	<jsp:include page="/footer.jsp" />

	<div id="modalCareAllowReject"></div>

	<script>
    function val(id){ const el=document.getElementById(id); return el?el.value:""; }

    function approveUser(){
      const form = document.getElementById("careActionForm");
      const approveUrl = val("approveAction");
      if(!approveUrl){ alert("승인 URL이 없습니다."); return; }
      form.action = approveUrl;
      form.submit();
    }

    function rejectUser(){
      const rejectUrl = val("rejectAction");
      if(!rejectUrl){ alert("반려 URL이 없습니다."); return; }
      const reason = (prompt("반려 사유를 입력하세요") || "").trim();
      if(!reason){ alert("반려 사유가 필요합니다."); return; }
      document.getElementById("rejectComment").value = reason;

      const form = document.getElementById("careActionForm");
      form.action = rejectUrl;
      form.submit();
    }

    document.getElementById("btnApprove")?.addEventListener("click", approveUser);
    document.getElementById("btnReject") ?.addEventListener("click", rejectUser);
  </script>
</body>
</html>
