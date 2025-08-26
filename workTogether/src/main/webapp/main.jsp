<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% session.setAttribute("usersNumber", 2); %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>함께 걸음</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/main.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/main/includeMain.js"></script>

</head>
<body>
  <!-- 헤더 -->
  <jsp:include page="/header.jsp" />
  <!-- 메인 -->
  <main>
    <!-- 메인 바디 -->
    <div class="main_body">
      <!-- 뉴스 배너 영역 -->
      <div class="news_banner">
        <!-- 여기부터 슬라이드 박스 -->
        <ul class="slide-box">
          <!-- 첫 번째 슬라이드 -->
          <c:forEach var="banner" items="${mainBanner}">
	          <li>
	            <div class="slide-img">
	              <img class="banner_img" draggable="false" src="${banner.getBannerImageFilesNumber()}">
	              <a draggable="false" href="${banner.getBannerLinkUrl()}">
	                <h3><c:out value="${banner.getBannerTitle()}"></c:out></h3>
	                <p><c:out value="${banner.getBannerContent()}"></c:out></p>
	              </a>
	            </div>
	          </li>
	      </c:forEach>
        </ul>
      </div>
       <!-- 추천 활동 및 추천 게시물 영역 -->
      <div class="recommend">
        <!-- 추천활동 박스 -->
        <div class="recommend_activity">
          <!-- 추천활동 타이틀 -->
          <div class="recommend_title">오늘의 추천활동</div>
          <!-- 추천활동 목록 -->
          <ul class="recommend_activiies">
            <li><a href="https://www.sac.or.kr/site/main/home">예술의 전당</a></li>
            <li><a href="https://www.gugak.go.kr/site/main/index001">국립국악원</a></li>
          </ul>
        </div>
        <!-- 게시물 추천 박스 -->
        <div class="recommend_board">
          <!-- 추천 박스 타이틀 -->
          <div class="recommend_title">게시판</div>
          <!-- 추천 게시물 목록 -->
          <ul class="board_list">
          	<c:forEach var="post" items="${mainPost}">
	            <!-- 추천 게시물 1 -->
	            <li>
	              <!-- 게시물 정보 -->
	              <a href="${pageContext.request.contextPath}/post/postReadOk.po?postsNumber=${post.getPostsNumber()}">
	                <span class="board_list_number"><c:out value="${post.getPostsNumber()}"></c:out></span>
	                <span class="board_list_title"><c:out value="${post.getPostsTitle()}"></c:out></span>
	                <span class="board_list_author"><c:out value="${post.getUsersName()}"></c:out></span>
	                <span class="board_list_date"><c:out value="${post.getPostsCreatedDate()}"></c:out></span>
	              </a>
	            </li>
            </c:forEach>
          </ul>
        </div>
      </div>
      <!-- 지도, 인기 돌봄회원 영역 시작 -->
      <div class="explore">
        <!-- 지도 박스 -->
        <div class="explore_map">
          <!-- 지도 이미지 -->
          <img src="${pageContext.request.contextPath}/assets/img/main/map.PNG" class="map_img">
        </div>
        <!-- 인기 돌봄회원 박스 -->
        <div class="explore_care">
          <!-- 인기 돌봄회원 목록 -->
          <ul class="profile_list">
            <!-- 인기 돌봄회원 1 -->
            <c:forEach var="heart" items="${mainHeart}">
	            <li class="profile">
	              <a href ="${pageContext.request.contextPath}/careList/careListDetailOk.cl?usersNumber=${heart.getUsersNumber}" class="care_profile">
	                <!-- 사진이랑 소개 -->
	                <div class="profile_info">
	                  <div class="profile_pic_box">
	                    <img class="profile_pic" src="${heart.getProfilesFilesPath()}">
	                  </div>
	                  <span class="profile_text">
	                    <div class="profile_name"><c:out value="${heart.getUsersName()}"></c:out></div>
	                    <div class="profile_introduction"><c:out value="${heart.getCareIntroText()}"></c:out></div>
	                  </span>
	                </div>
	                <!-- 요일 -->
	                <div>
	                  <ul class="day_box">
	                    <li class="day"><c:out value="${heart.getDayMonday()}"></c:out></li>
	                  </ul>
	                </div>
	              </a>
	            </li>
            </c:forEach>
            <!-- 인기 돌봄회원 2 -->
            <li class="profile">
              <a href ="${pageContext.request.contextPath}/app/careMember/careMemberDetail.jsp" class="care_profile">
                <!-- 사진이랑 소개 -->
                <div class="profile_info">
                  <div class="profile_pic_box">
                    <img class="profile_pic" src="${pageContext.request.contextPath}/assets/img/main/profilePicCare.png">
                  </div>
                  <span class="profile_text">
                    <div class="profile_name">김괭이dddd</div>
                    <div class="profile_introduction">안녕하세요~!</div>
                  </span>
                </div>
                <!-- 요일 -->
                <div>
                  <ul class="day_box">
                    <li class="day">화</li>
                    <li class="day">화</li>
                    <li class="day">화</li>
                    <li class="day">화</li>
                  </ul>
                </div>
              </a>
            </li>
            <!-- 인기 돌봄회원 3 -->
            <li class="profile">
              <a href ="${pageContext.request.contextPath}/app/careMember/careMemberDetail.jsp" class="care_profile">
                <!-- 사진이랑 소개 -->
                <div class="profile_info">
                  <div class="profile_pic_box">
                    <img class="profile_pic" src="${pageContext.request.contextPath}/assets/img/main/profilePicCare.png">
                  </div>
                  <span class="profile_text">
                    <div class="profile_name">김괭이dddd</div>
                    <div class="profile_introduction">안녕하세요~!</div>
                  </span>
                </div>
                <!-- 요일 -->
                <div>
                  <ul class="day_box">
                    <li class="day">화</li>
                    <li class="day">화</li>
                    <li class="day">화</li>
                    <li class="day">화</li>
                  </ul>
                </div>
              </a>
            </li>
            <!-- 인기 돌봄회원 4 -->
            <li class="profile">
              <a href ="${pageContext.request.contextPath}/app/careMember/careMemberDetail.jsp" class="care_profile">
                <!-- 사진이랑 소개 -->
                <div class="profile_info">
                  <div class="profile_pic_box">
                    <img class="profile_pic" src="${pageContext.request.contextPath}/assets/img/main/profilePicCare.png">
                  </div>
                  <span class="profile_text">
                    <div class="profile_name">김괭이dddd</div>
                    <div class="profile_introduction">안녕하세요~!</div>
                  </span>
                </div>
                <!-- 요일 -->
                <div>
                  <ul class="day_box">
                    <li class="day">화</li>
                    <li class="day">화</li>
                    <li class="day">화</li>
                    <li class="day">화</li>
                  </ul>
                </div>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </main>
  <!-- 푸터 -->
  <jsp:include page="/footer.jsp" />
</body>

<script>
	let usersNumber = <%= session.getAttribute("usersNumber") != null ? session.getAttribute("usersNumber") : "null" %>;
	console.log(usersNumber);
</script>

</html> 