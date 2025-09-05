<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>RB</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>

  <!-- CSS 파일 동적 로드 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/subwayLine/${station.cssFile}">
</head>

<body>
  <jsp:include page="/header.jsp" />

  <main>
    <div class="station_info">
      <!-- 역 이미지 -->
      <div class="station_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/${station.stationImg}"
             alt="<c:out value='${station.stationsName}'/>">
      </div>

      <!-- 역 이름 -->
      <div class="station_exit">
        <div><c:out value="${station.stationsName}" /></div>
      </div>

      <!-- 노선 번호 이미지 -->
      <div class="line_number">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/${station.lineImg}"
             alt="<c:out value='${station.lineNumber}'/>">
      </div>
    </div>

    <!-- 지도 API -->
    <div class="map_api">

    </div>
  </main>

  <jsp:include page="/footer.jsp" />
</body>
</html>
