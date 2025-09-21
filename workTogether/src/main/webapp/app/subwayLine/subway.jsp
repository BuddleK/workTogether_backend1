<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지하철</title>
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

        <!-- 현재 선택된 라인(요청 속성 또는 파라미터, 없으면 0=전체) -->
        <c:set var="curLine"
            value="${not empty lineNumber ? lineNumber : (not empty param.lineNumber ? param.lineNumber : '0')}" />

        <!-- 라인 버튼 -->
        <div class="subway">
            <div class="subway_subwayLine">
                <c:forEach var="line" items="${lines}">
                    <button
                        data-line-number="${line.lineNumber}"
                        data-line-name="${line.lineName}"
                        class="<c:if test='${curLine == \"0\" and line.lineNumber == 0}'>selected-btn</c:if>">
                        ${line.lineName}
                    </button>
                </c:forEach>
            </div>
        </div>

        <div class="map-and-list">
            <!-- 노선 이미지: 선택된 라인 값에 맞춰 파일명 매핑 -->
            <div class="map_section">
                <c:choose>
                    <c:when test="${curLine == '0'}">
                        <c:set var="imgName" value="allline.png" />
                        <c:set var="altText" value="전체 노선도" />
                    </c:when>
                    <c:when test="${curLine == '2'}">
                        <c:set var="imgName" value="line2.png" />
                        <c:set var="altText" value="2호선 노선도" />
                    </c:when>
                    <c:when test="${curLine == '3'}">
                        <c:set var="imgName" value="line3.png" />
                        <c:set var="altText" value="3호선 노선도" />
                    </c:when>
                    <c:when test="${curLine == '4'}">
                        <c:set var="imgName" value="line4.png" />
                        <c:set var="altText" value="4호선 노선도" />
                    </c:when>
                    <c:when test="${curLine == '7'}">
                        <c:set var="imgName" value="line7.png" />
                        <c:set var="altText" value="7호선 노선도" />
                    </c:when>
                    <c:when test="${curLine == '9'}">
                        <c:set var="imgName" value="line9.png" />
                        <c:set var="altText" value="9호선 노선도" />
                    </c:when>
                    <c:when test="${curLine == '100'}"><!-- 신분당선 -->
                        <c:set var="imgName" value="dxline.png" />
                        <c:set var="altText" value="신분당선 노선도" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="imgName" value="allline.png" />
                        <c:set var="altText" value="전체 노선도" />
                    </c:otherwise>
                </c:choose>

                <c:url var="imgSrc" value="/assets/img/subwayLine/${imgName}" />
                <img src="${imgSrc}" alt="${altText}"
                     onerror="this.src='${pageContext.request.contextPath}/assets/img/subwayLine/allline.png'">
            </div>

            <!-- 역 목록 -->
            <div class="station_list" id="station_list">
                <h3 id="station_list_title">
                    <c:choose>
                        <c:when test="${curLine == '0'}">전체 역 목록</c:when>
                        <c:when test="${curLine == '100'}">신분당선 역 목록</c:when>                        
                        <c:otherwise>${curLine}호선 역 목록</c:otherwise>
                    </c:choose>
                </h3>

                <div class="station_list_inner">
                    <c:choose>
                        <c:when test="${not empty stations}">
                            <c:forEach var="station" items="${stations}">
                                <div class="station_name" data-line="${station.lineNumber}">
                                    <a href="${pageContext.request.contextPath}/subway/subwayDetail.sw?stationId=${station.stationsId}">
                                        ${station.stationsName}
                                    </a>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="station_empty">표시할 역 정보가 없습니다.</div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
	</main>
	<jsp:include page="/footer.jsp" />
</body>

</html>