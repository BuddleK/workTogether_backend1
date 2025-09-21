<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal_Reference</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalReference.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<main>
		<!-- 메뉴 사이드바 섹션 -->
		<jsp:include page="sidebar.jsp"></jsp:include>
		<form action="" method="get">
			<div class="div_mark">
				<!-- 메뉴 제목 -->
				<div class="title">1 대 1 문의</div>
				<nav class="div_choose">
					<ul>
						<li>1 대 1 문의 목록</li>
					</ul>
				</nav>
				<!-- 문의 목록 컬럼 -->
				<nav class="mark_nav">
					<ul>
						<li class="name">
							<div>작성자</div>
						</li>
						<li class="referencetitle">
							<div>제목</div>
						</li>
						<li class="day">
							<div>신청 날짜</div>
						</li>
						<li class="check">
							<div>확인 여부</div>
						</li>
					</ul>
				</nav>
				<!-- 문의 목록 리스트 -->
						<c:forEach var="list" items="${referenceList }" varStatus="status">
				<nav class="mark_list">
					<ul>
							<li class="name">
								<div>${list.usersName }</div>
							</li>
							<li class="referencetitle"><a
								href="${pageContext.request.contextPath}/myPageNormal/normalReferenceDetail.mn?referenceNumber=${list.referenceNumber}">
									<div>${list.referenceTitle }</div>
							</a></li>
							<li class="day">
								<div>${list.referenceCreatedDate }</div>
							</li>
							<li class="check">
								<div>
									<c:choose>
										<c:when test="${list.answeredYn eq true}">
                    답변 완료
                </c:when>
										<c:otherwise>
                    답변 전
                </c:otherwise>
									</c:choose>
								</div>
							</li>
					</ul>
				</nav>
						</c:forEach>
				<!-- 페이지네이션 -->
				<nav class="page">
					<ul class="page">
						<c:if test="${prev}">
							<li><a
								href="${pageContext.request.contextPath}/myPageNormal/normalReferenceList.mn?page=${startPage - 1}"
								class="prev">&lt;</a></li>
						</c:if>
						<c:set var="realStartPage"
							value="${startPage < 1 ? 1 : startPage}" />
						<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
							<c:choose>
								<c:when test="${!(i == page) }">
									<li><a
										href="${pageContext.request.contextPath}/myPageNormal/normalReferenceList.mn?page=${i}">
											<c:out value="${i}" />
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="#" class="active"> <c:out value="${i}" />
									</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${next}">
							<li><a
								href="${pageContext.request.contextPath}/myPageNormal/normalReferenceList.mn?page=${endPage + 1}"
								class="next">&gt;</a>
						</c:if>
					</ul>
				</nav>
				<!-- 문의 등록하기 버튼 -->
				<div class="div_delete">
					<button>
						<a href="${pageContext.request.contextPath}/myPageNormal/normalReferenceInsert.mn">등록</a>
					</button>
				</div>
			</div>
		</form>

	</main>
	<jsp:include page="/footer.jsp" />
</body>
</html>