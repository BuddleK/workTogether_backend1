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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/subwayLine/subway.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/subwayLine/subway.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />

  <main>
    <h1>지하철 노선도</h1>
    <div class="subway">
      <div class="subway_subwayLine">
        <button id="all"> 전체 </button>
        <button id="line2"> 2호선 </button>
        <button id="line3"> 3호선 </button>
        <button id="line4"> 4호선 </button>
        <button id="line7"> 7호선 </button>
        <button id="line9"> 9호선 </button>
        <button id="dxline"> 신분당선 </button>
      </div>
    </div>
    <!-- 서초 전체 지하철 노선도 -->
    <div class="map_section">
      <div class="subway_allline_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/allline.png" alt="전체호선사진">
      </div>
      <!-- 서초 2호선 지하철 노선도 -->
      <div class="subway_line2_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/line2.png" alt="2호선사진">
      </div>
      <!-- 서초 3호선 지하철 노선도 -->
      <div class="subway_line3_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/line3.png" alt="3호선사진">
      </div>
      <!-- 서초 4호선 지하철 노선도 -->
      <div class="subway_line4_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/line4.png" alt="4호선사진">
      </div>
      <!-- 서초 7호선 지하철 노선도 -->
      <div class="subway_line7_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/line7.png" alt="7호선사진">
      </div>
      <!-- 서초 9호선 지하철 노선도 -->
      <div class="subway_line9_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/line9.png" alt="9호선사진">
      </div>
      <!-- 서초 신분당선 지하철 노선도 -->
      <div class="subway_dxline_img">
        <img src="${pageContext.request.contextPath}/assets/img/subwayLine/dxline.png" alt="신분당선사진">
      </div>

      <!-- 전체 역 목록 -->
      <div class="station_list" id="allline_station">
        <h3>전체 역 목록</h3>
        <ul>
          <!-- 서초 지나가는 역 이름, 정보 칸 -->
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/dongjack.jsp">동작</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gubanpo.jsp">구반포</a></li>
          <li class="station-name"><a href="${pageContext.request.contextPath}/subwayLine/shinbanpo.jsp">신반포</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gosukterminner.jsp">고속터미널</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sapeung.jsp">사평</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sinnonehyun.jsp">신논현</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/chungshindae.jsp">총신대입구</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nebang.jsp">내방</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/banpo.jsp">반포</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nonehyune.jsp">논현</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sadang.jsp">사당</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/bangbae.jsp">방배</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/seacho.jsp">서초</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gyudae.jsp">교대</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gangnam.jsp">강남</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/shinsa.jsp">신사</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/yangjae.jsp">양재</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/yangjeaforest.jsp">양재시민의숲</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/chunggyae.jsp">청계산입구</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/jameone.jsp">잠원</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nambuterminer.jsp">남부터미널</a></li>
        </ul>
      </div>

      <div class="station_list" id="line2_stations">
        <!-- 서초 2호선 이름, 정보 칸 -->

        <h3>2호선 역 목록</h3>
        <ul>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sadang.jsp">사당</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/bangbae.jsp">방배</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/seacho.jsp">서초</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gyudae.jsp">교대</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gangnam.jsp">강남</a></li>
        </ul>
      </div>

      <div class="station_list" id="line3_stations">
        <!-- 서초 3호선 이름, 정보 칸 -->
        <h3>3호선 역 목록</h3>
        <ul>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/shinsa.jsp">신사</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/jameone.jsp">잠원</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gosukterminner.jsp">고속터미널</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gyudae.jsp">교대</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nambuterminer.jsp">남부터미널</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/dongjack.jsp">양재</a></li>
        </ul>
      </div>

      <div class="station_list" id="line4_stations">
        <!-- 서초 4호선 이름, 정보 칸 -->
        <h3>4호선 역 목록</h3>
        <ul>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/dongjack.jsp">동작</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/chungshindae.jsp">총신대입구</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sadang.jsp">사당</a></li>
        </ul>
      </div>

      <div class="station_list" id="line7_stations">
        <!-- 서초 7호선 이름, 정보 칸 -->
        <h3>7호선 역 목록</h3>
        <ul>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/chungshindae.jsp">총신대입구</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nebang.jsp">내방</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gosukterminner.jsp">고속터미널</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/banpo.jsp">반포</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nonehyune.jsp">논현</a></li>
        </ul>
      </div>

      <div class="station_list" id="line9_stations">
        <!-- 서초 9호선 이름, 정보 칸 -->
        <h3>9호선 역 목록</h3>
        <ul>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/dongjack.jsp">동작</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gubanpo.jsp">구반포</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/shinbanpo.jsp">신반포</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gosukterminner.jsp">고속터미널</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sapeung.jsp">사평</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/dongjack.jsp">신논현</a></li>
        </ul>
      </div>

      <div class="station_list" id="dxline_stations">
        <!-- 서초 신분당선 이름, 정보 칸 -->
        <h3>신분당선 역 목록</h3>
        <ul>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/shinsa.jsp">신사</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/nonehyune.jsp">논현</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/sinnonehyun.jsp">신논현</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/gangnam.jsp">강남</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/yangjae.jsp">양재</a></li>
          <li class="station_name"><a href="${pageContext.request.contextPath}/subwayLine/yangjeaforest.jsp">양재시민의숲</a></li>
          <li class="station_item"><a href="${pageContext.request.contextPath}/subwayLine/chunggyae.jsp">청계산입구</a></li>
        </ul>
      </div>
    </div>

  </main>
  <jsp:include page="/footer.jsp" />
</body>

</html>