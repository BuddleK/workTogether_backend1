<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄 이력 신청관리</title>

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
</head>
<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<div id="sidebar"></div>

		<section class="care_box">
			<div class="box_title">
				<h1>돌봄 이력 신청관리</h1>
			</div>

			<!-- 컨트롤러에서 준 값 -->
			<input type="hidden" id="usersNumber" value="${usersNumber}" /> <input
				type="hidden" id="approveAction" value="${approveAction}" /> <input
				type="hidden" id="rejectAction" value="${rejectAction}" />

			<!-- 테이블 영역: form 제거 -> div로 -->
			<div class="table_form">
				<div class="table">
					<div class="thead">
						<div class="thead_content thead_name">성명</div>
						<div class="thead_content thead_phone">전화번호</div>
						<div class="thead_content thead_email">이메일</div>
						<div class="thead_content thead_detach">자격증</div>
						<div class="thead_content thead_account">통장사본</div>
					</div>

					<div class="tbody">
						<div class="tbody_content tbody_name">
							<c:out value="${user.usersName}" />
						</div>
						<div class="tbody_content tbody_phone">
							<c:out value="${user.usersPhone}" />
						</div>
						<div class="tbody_content tbody_email">
							<c:out value="${user.usersEmail}" />
						</div>

						<!-- 자격증 -->
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
								<c:otherwise>없음</c:otherwise>
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

					<!-- 버튼 -->
					<div class="btn_area" style="position: relative; z-index: 1000;">
						<button id="btnReject" class="cancle" type="button">반려 처리</button>
						<button id="btnApprove" class="submit" type="button">승인
							완료</button>
					</div>
				</div>
			</div>

			<!-- 실제 전송용 폼 (숨김) -->
			<form id="careActionForm" method="post">
				<input type="hidden" name="usersNumber" value="${usersNumber}">
				<input type="hidden" name="rejectComment" id="rejectComment">
			</form>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />

	<script>
    function val(id){ const el=document.getElementById(id); return el?el.value:""; }

    function approveUser(){
      const approveUrl = val("approveAction");
      if(!approveUrl){ alert("승인 URL이 없습니다."); return; }
      if(!confirm("해당 신청을 승인하시겠습니까?")) return;

      const form = document.getElementById("careActionForm");
      form.action = approveUrl;
      form.submit();
      // 서버 리다이렉트 전 표시만 필요하면 아래 주석 해제
      // alert("승인 처리를 진행합니다.");
    }

    function rejectUser(){
      const rejectUrl = val("rejectAction");
      if(!rejectUrl){ alert("반려 URL이 없습니다."); return; }

      const reason = (prompt("반려 사유를 입력하세요") || "").trim();
      if(!reason){ alert("반려 사유가 필요합니다."); return; }

      if(!confirm("해당 신청을 반려 처리하시겠습니까?")) return;

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
