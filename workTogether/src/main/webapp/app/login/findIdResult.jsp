<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>아이디 찾기 결과</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/login/basic.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/login/findIdResult.css" />
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
		<section class="result">
			<div class="result_content">
				<div class="result_content_box">
					<div class="content_box_title">아이디 찾기 결과</div>

					<div class="content_box_value">
						<c:choose>
							<c:when test="${not empty usersId}">
								<p>
									사용자의 아이디는 <span class="id_value"><c:out
											value="${usersId}" /></span> 입니다.
								</p>
							</c:when>
							<c:otherwise>
								<p>조회된 아이디가 없습니다. 입력하신 정보를 다시 확인해 주세요.</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="result_content_link">
					<a href="${pageContext.request.contextPath}/users/findPw.us">비밀번호
						찾기</a>
					<a href="${pageContext.request.contextPath}/users/nomalLogin.us">로그인하기</a>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="/footer.jsp" />
</body>
</html>
