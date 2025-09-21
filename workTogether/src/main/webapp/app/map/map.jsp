<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>함께 걸음</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/map/map.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/map/map.js"></script>
</head>
<%
    // WEB-INF/.env 경로 얻기
    String envPath = application.getRealPath("/WEB-INF/.env");

    java.util.Properties env = new java.util.Properties();
    if (envPath != null) {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(envPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int eq = line.indexOf('=');
                if (eq > 0) {
                    String k = line.substring(0, eq).trim();
                    String v = line.substring(eq + 1).trim();
                    env.setProperty(k, v);
                }
            }
        } catch (Exception e) {
            // 필요하면 로그
        }
    }
    String kakaoKey = env.getProperty("KAKAO_MAP_API_KEY");

%>
<body>
  <jsp:include page="/header.jsp" />
 <main>
    <!-- 지도 페이지 컨테이너 -->
    <div class="map_container">
      <!-- 지도 api 칸 -->
      <div class="map_api">
        <div id="map" style="width:800px;height:500px;"></div>
        
<%--         <c:choose>
			<c:when test="${not empty markerList}">
				<c:forEach var="post" items="${markerList}">
				
					<script>
						console.log('우히');
					</script>
				</c:forEach>
			</c:when>
			<c:otherwise>
   				<div>
   					<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
   				</div>
			</c:otherwise>
		</c:choose>
         --%>
        
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f1ed8d49c70a5d2d213e83f145527e1"></script>
        <script type="text/javascript" >
        
        
       	var positions = [
 			<c:forEach var="marker" items="${markerList}">
				{
					content: '<div>${marker.shopsName}</div>',
	                latlng: new kakao.maps.LatLng(
	                        parseFloat("${marker.shopsLatitude}"),  // 위도를 실수로 변환
	                        parseFloat("${marker.shopsLongitude}")  // 경도를 실수로 변환
	                    ),
 	                rnum: "${marker.rnum}",
	                shopsNumber: "${marker.shopsNumber}",
	                shopsName: "${marker.shopsName}",
	                shopsLatitude: "${marker.shopsLatitude}",
	                shopsLongitude: "${marker.shopsLongitude}",
	                shopsRoadAddress: "${marker.shopsRoadAddress}",  // 도로명 주소 추가
	                shopsWorkingHours: "${marker.shopsWorkingHours}",  // 영업시간 추가
	                shopsPhone: "${marker.shopsPhone}",  // 전화번호 추가
	                shopsTakeout: "${marker.shopsTakeout}",  // 테이크아웃 여부 추가
	                shopsIntroText: "${marker.shopsIntroText}"  // 가게 소개 추가
				}
            	<c:if test="${!empty markerList[markerList.size() - 1]}">, </c:if> <!-- 마지막 항목 뒤에 콤마 제거 -->
			</c:forEach> 
        	];

            // markerList의 각 항목 출력 (예시)
            /* markerList.forEach(function(shop) {
                console.log("content: " + shop.content);
                console.log("latlng: " + shop.latlng);
            }); */
            // markerList 콘솔에 출력
            //console.log(markerList); 

        
      		var container = document.getElementById('map');
      		var options = {
         		center: new kakao.maps.LatLng(37.491199, 127.008918),
         		level: 6
      		};
      		// 지도 생성
      		var map = new kakao.maps.Map(container, options);
      
			// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
/* 			var markerList = [
    		{
        		content: '<div>카카오</div>', 
        		latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    		},
    		{
        		content: '<div>생태연못</div>', 
        		latlng: new kakao.maps.LatLng(33.450936, 126.569477)
    		},
    		{
        		content: '<div>텃밭</div>', 
        		latlng: new kakao.maps.LatLng(33.450879, 126.569940)
    		},
    		{
        		content: '<div>근린공원</div>',
        		latlng: new kakao.maps.LatLng(33.451393, 126.570738)
    		}
		]; */
			
			console.log(positions);
			
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

		for (var i = 0; i < positions.length; i ++) {//positions.length
      	// 마커 이미지의 이미지 크기 입니다
    	var imageSize = new kakao.maps.Size(24, 35); 
    	// 마커 이미지를 생성합니다    
    	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 

    	// 마커를 생성합니다
    	var marker = new kakao.maps.Marker({
        	map: map, // 마커를 표시할 지도
        	position: positions[i].latlng, // 마커의 위치
        	image : markerImage, // 마커 이미지 
        	index : i
    	});
      	//마커 클릭 설정
      	//marker.setClickable(true);

    	// 마커에 표시할 인포윈도우를 생성합니다 
    	var infowindow = new kakao.maps.InfoWindow({
        	content: positions[i].content // 인포윈도우에 표시할 내용
    	});

    	// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    	// 이벤트 리스너로는 클로저를 만들어 등록합니다 
    	// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    	kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	    // 클릭 이벤트에서 인덱스 값을 출력하려면 아래와 같이 클로저를 사용
	    kakao.maps.event.addListener(marker, 'click', (function(index) {
	        return function() {
	            const sideBar = document.getElementById('side_bar');
	            var shopsNumber = 0;
	            /* if (sideBar.style.display == 'flex') {
	                sideBar.style.display = "none";
	            } else { */
	                sideBar.style.display = "flex";
	                console.log('클릭된 마커의 인덱스:', index); // index 값을 콘솔에 출력
	                // positions 배열에서 클릭된 마커의 실제 정보를 가져옴
	                const shop = positions[index]; // positions 배열에서 해당 인덱스에 해당하는 가게 정보 가져오기
					
	                shopsNumber = shop.shopsNumber;
	                // 사이드바의 각 요소를 실제 데이터로 업데이트
	                const shopTitle = document.getElementById('shop_title');
	                shopTitle.textContent = shop.shopsName; // 가게 이름

	                const shopRoad = document.getElementById('shop_road');
	                shopRoad.textContent = shop.shopsRoadAddress; // 도로명 주소

	                const shopHour = document.getElementById('shop_hour');
	                shopHour.textContent = shop.shopsWorkingHours; // 영업시간

	                const shopPhone = document.getElementById('shop_phone');
	                shopPhone.textContent = shop.shopsPhone; // 전화번호

	                const shopTake = document.getElementById('shop_take');
	                if(shop.shopsTakeout == 'Y'){// 테이크아웃 여부
		                shopTake.textContent = "테이크아웃 가능";
	                }else{
		                shopTake.textContent = "테이크아웃 없음";
	                }

	                const shopIntro = document.getElementById('shop_intro');
	                shopIntro.textContent = shop.shopsIntroText; // 가게 소개
	            /* } */
	            
	            //사이드바가 눌렸을 때?
	            sideBar.addEventListener('click', () =>{
	            	window.location.href = `${pageContext.request.contextPath}/shops/shopsDetailOk.sh?shopsNumber=` + shopsNumber;
	            });
	            
	        };
	    })(i)); // 클로저에서 index를 전달
	    
}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}


      // 단일 마커
      // //마커가 표시될 위치
      // var markerPosition = new kakao.maps.LatLng(37.49188057004524, 127.00763272305007);
      // // 마커 생성
      // var marker = new kakao.maps.Marker({
      //    position: markerPosition
      // });
      //마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정?
      //marker.setClickable(true);
      // 마커가 지도 위에 표시되도록 설정
      //marker.setMap(map);
      // 마커 제거
      //marker.setMap(null);

	</script>
 		<div class="site_info">지도를 클릭 시 해당 가게 설명이 나옵니다</div>
<%--  		<a href="${pageContext.request.contextPath}/post/postMain.po">일반게시판으로 이동</a></br>
 		<a href="${pageContext.request.contextPath}/map/mapMain.map">지도 페이지로 이동</a></br>
 		<a href="${pageContext.request.contextPath}/news/newsMain.news">뉴스 페이지로 이동</a></br> --%>
      </div>
      <!-- 지도 클릭 시 사이드바 -->
      <div id="side_bar" class="sidebar">
        <!-- 지역 정보 -->
        <div class="map_info">
          <!-- 정보 칸 닫기 -->
          <!-- <div class="closebtn">&times;</div> -->
          <!-- 정보 내용 컨테이너 -->
          <div class="info_content_container">
            <!-- 정보 내용 ul -->
            <ul class="info_content">
              <!-- 지역 제목 -->
              <li id="shop_title" class="info_title">오다리집 간장게장</li><br>
              <!-- 지역 주소 -->
              <li class="info_address"><img src="${pageContext.request.contextPath}/assets/img/map/mapmarker.png" alt=""><span id="shop_road">서울 강남구 논현로 94길 7 2층</span></li>
              <br>
              <!-- 오픈 시간 -->
              <li class="info_times"><img src="${pageContext.request.contextPath}/assets/img/map/clock.png" alt=""><span id="shop_hour">01:30에 라스트 오더</span><br>
<!--                 <strong>&emsp;&emsp; 매일 : 09:20 ~ 02:00<br>
                  &emsp; &emsp; 01:30 라스트 오더</strong> -->
              </li><br>
              <!-- 장소 전화번호 -->
              <li class="info_phonenum"><img src="${pageContext.request.contextPath}/assets/img/map/call.png" alt=""><span id="shop_phone">0507-1350-6769</span></li><br>
              <!-- 장소 상세(인터넷 유무, 배달 유무 등등...) -->
              <li class="info_detail"><img src="${pageContext.request.contextPath}/assets/img/map/market.png" alt=""><span id="shop_take">테이크아웃</span></li>
            </ul>
          </div>
        </div>
        <!-- 장소 상세설명 -->
        <div class="map_detail">
          <div class="detail_title">설명</div><br>
          	<span id="shop_intro">2021 GURUNAVI JAPAN 세계100대 레스토랑 오다리집 명동본점 선정 트립어드바이저 3년연속 서울 최우수식당 선정 L,XL 사이즈 1마리 생산지의...</span>
        </div>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
  <!-- 모달창 -->
  <article class="modalbox">
    <!-- 비로그인 시 체크 모달 -->
    <div class="login_check_model">
      <!-- 모달 닫기 버튼 -->
      <div class="modal_closebtn">&times;</div>
      <!-- 모달 내용 -->
      <div class="modal_text">로그인이 필요합니다.</div>
    </div>
  </article>
  <!-- 모달창 -->
  <article class="modalbox_complet">
    <!-- 비로그인 시 체크 모달 -->
    <div class="complet_modal">
      <!-- 모달 닫기 버튼 -->
      <div class="modal_closebtn_complet">&times;</div>
      <!-- 모달 내용 -->
      <div class="modal_text">찜하기 완료</div>
    </div>
  </article>
</body>
</html>