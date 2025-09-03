<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RB</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/subwayLine/subway.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/subwayLine/subway.js"></script>
</head>

<body>
	<jsp:include page="/header.jsp" />

	<main>
		<h1>지하철 노선도</h1>
		<!-- 지하철 노선 버튼 -->
		<div class="subway">
		    <div class="subway_subwayLine">
		        <c:forEach var="line" items="${lines}">
		            <button data-line-number="${line.lineNumber}" data-line-name="${line.lineName}">
		                ${line.lineName}
		            </button>
		        </c:forEach>
		    </div>
		</div>

		<!-- 서초 전체 지하철 노선도 -->
		<div class="map_section">
			<c:forEach var="station" items="${imgStations}">
				<c:choose>
					<c:when test="${empty station.stationsPhoto}">
						<div>사진없음 lineNumber=${station.lineNumber}</div>
						<c:set var="photo" value="${station.stationsPhoto}" />
						<c:if test="${not empty photo.stationsFilesPath and not empty photo.stationsFilesName }">
							<c:url var="imgUrl"	value="${photo.stationsFilesPath}${photo.stationsFilesName}" />
							<div class="subway_line${station.lineNumber}_img">
								<img src="${pageContext.request.contextPath}${imgUrl}" alt="지하철노선도 사진">
							</div>
						</c:if>
					</c:when>
				</c:choose>
			</c:forEach>
		</div>
		
		<!-- 역 목록 (하나의 구조만 사용) -->
		<div class="station_list" id="station_list">
		    <h3 id="station_list_title">
		        <c:choose>
		            <c:when test="${lineNumber eq '0' || empty lineNumber}">
		                전체 역 목록
		            </c:when>
		            <c:otherwise>${lineNumber}호선 역 목록</c:otherwise>
		        </c:choose>
		    </h3>
		    <div class="station_list_inner">
		        <c:forEach var="station" items="${stations}">
		            <div class="station_name" data-line="${station.lineNumber}">
		                <a href="${pageContext.request.contextPath}/subway/subwayDetail.sw?stationId=${station.stationsId}">
		                    ${station.stationsName}
		                </a>
		            </div>
		        </c:forEach>
		    </div>
		</div>


		
	</main>
	<jsp:include page="/footer.jsp" />
</body>

</html>