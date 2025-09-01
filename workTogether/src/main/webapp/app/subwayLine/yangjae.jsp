<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RB</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/subwayLine/yangjae.css">
</head>

<body>
  <jsp:include page="/header.jsp" />

  <main>

    <div class="station_info">
      <!-- 해당 지하철 역 사진 -->

      <div class="station_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/yangjae.png" alt="">
      </div>

      <div class="station_exit">
        <!-- 역 정보 -->
        <div> 양재역 </div>
      </div>

      <div class="line_number">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/Line_3.png" alt="">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/dx_Line.png" alt="">
      </div>
    </div>

    <!-- 지도 api -->
    <div class="map_api">
      <div>
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/KakaoTalk_20250806_170707522_07.png" alt="">
      </div>
      <a href="${pageContext.request.contextPath}/subway.jsp"><button>목록</button></a>

    </div>


  </main>
  <jsp:include page="/footer.jsp" />
</body>

</html>