<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>돌봄 회원 환급 관리</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/refund.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
</head>

<body>
	<jsp:include page="/header_admin.jsp" />
	<main>
		<div id="sidebar"></div>
		<section class="userManager">
			<div class="searchcontent">
				<div class="title">
					<h1>돌봄 회원 환급 관리</h1>
				</div>

				<div class="table">
					<div class="board_column">
						<div class="board_head board_number">환급 신청 번호</div>
						<div class="board_head board_name">신청자 명</div>
						<div class="board_head board_id">신청자 아이디</div>
						<div class="board_head board_date">신청 날짜</div>
						<div class="board_head board_refund_date">환급 날짜</div>
						<div class="board_head board_type">환급 여부</div>
					</div>

					<div class="table_content">
						<c:choose>
							<c:when test="${empty list}">
								<ul class="table_body">
									<li class="body_name" style="width: 100%; text-align: center;">환급
										요청한 회원이 없습니다.</li>
								</ul>
							</c:when>

							<c:otherwise>
								<c:forEach var="row" items="${list}">
									<ul class="table_body">
										<li class="body_number"><a
											href="${pageContext.request.contextPath}/admin/pointReturnDetailOk.ad?pointReturnId=${row.pointReturnId}">
												<c:out value="${row.pointReturnId}" />
										</a></li>
										<li class="body_name"><a
											href="${pageContext.request.contextPath}/admin/pointReturnDetailOk.ad?pointReturnId=${row.pointReturnId}">
												<c:out value="${row.usersName}" />
										</a></li>
										<li class="body_id"><a
											href="${pageContext.request.contextPath}/admin/pointReturnDetailOk.ad?pointReturnId=${row.pointReturnId}">
												<c:out value="${row.usersId}" />
										</a></li>
										<li class="body_date"><a
											href="${pageContext.request.contextPath}/admin/pointReturnDetailOk.ad?pointReturnId=${row.pointReturnId}">
												<c:out value="${row.requestedAt}" />
										</a></li>
										<li class="body_refund_date"><a
											href="${pageContext.request.contextPath}/admin/pointReturnDetailOk.ad?pointReturnId=${row.pointReturnId}">
												<c:choose>
													<c:when test="${row.status == 'A'}">
														<c:out value="${row.refundedAt}" />
													</c:when>
													<c:otherwise>-</c:otherwise>
												</c:choose>
										</a></li>
										<li class="body_type"><a
											href="${pageContext.request.contextPath}/admin/pointReturnDetailOk.ad?pointReturnId=${row.pointReturnId}">
												<c:choose>
													<c:when test="${row.status == 'A'}">Y</c:when>
													<c:otherwise>N</c:otherwise>
												</c:choose>
										</a></li>
									</ul>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					
					<!-- 페이징 -->
					<c:if test="${not empty list}">
						<div class="paging_box">
							<ul class="paging">
								<c:if test="${prev}">
									<li class="prev"><a
										href="${pageContext.request.contextPath}/admin/pointReturnListOk.ad?page=${startPage - 1}">&lt;</a>
									</li>
								</c:if>

								<c:forEach begin="${startPage}" end="${endPage}" var="p">
									<li class="page_number ${p == page ? 'active' : ''}"><a
										href="${pageContext.request.contextPath}/admin/pointReturnListOk.ad?page=${p}">${p}</a>
									</li>
								</c:forEach>

								<c:if test="${next}">
									<li class="next"><a
										href="${pageContext.request.contextPath}/admin/pointReturnListOk.ad?page=${endPage + 1}">&gt;</a>
									</li>
								</c:if>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>
