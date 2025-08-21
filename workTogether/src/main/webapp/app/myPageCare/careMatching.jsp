<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>매칭기록</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careMatching.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careMatching.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <header>

  </header>
  <main>
          <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="sidebar">
      <ul>
        <li><a href="${pageContext.request.contextPath}/careProfile.jsp"><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></a></li>
        <li><a href="${pageContext.request.contextPath}/careModify.jsp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/careMark.jsp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/careMatching.jsp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/careMessage.jsp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/carePost.jsp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/carePointreturn.jsp">포인트 환급</a></li>
        <li><a href="${pageContext.request.contextPath}/careReference.jsp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/careExit.jsp">회원 탈퇴</a></li>
      </ul>
    </nav>

    <div class="div_mark">
          <!-- 마이페이지 제목 -->

      <div class="title"> 매칭 기록 </div>
      <!-- 페이지 월 분류 제목 -->

      <div class="matching_month">
        <ul class="months">
          <li class="month">1월</li>
          <li class="month">2월</li>
          <li class="month">3월</li>
          <li class="month">4월</li>
          <li class="month">5월</li>
          <li class="month">6월</li>
          <li class="month">7월</li>
          <li class="month">8월</li>
          <li class="month">9월</li>
          <li class="month">10월</li>
          <li class="month">11월</li>
          <li class="month">12월</li>
        </ul>
        <!-- 매칭 페이지 원래 넣었던 값 (js 넣어서 이건 안나와요) -->
        <ul class="matching_list">
          <li class="matching">
            <div class="matching_day">
              2일
            </div>
            <div class="matching_member">
              김괭이
            </div>
            <div class="matching_time">
              이용 시간: 09:00 ~ 18:00
            </div>
            <div class="matching_point">
              포인트 사용: 10,000
            </div>
            <div class="check">
              완료 / 취소 / 진행중
            </div>
          </li>
        </ul>
      </div>
      <!-- 페이지네이션 -->
      <nav class="page">
        <ul>
          <li><a href="">&lt;</a></li>
          <li><a href="">1</a></li>
          <li><a href="">2</a></li>
          <li><a href="">3</a></li>
          <li><a href="">4</a></li>
          <li><a href="">&gt;</a></li>
        </ul>

      </nav>
      <!-- 추가 버튼 클릭시 하단에 있는 모달창 출력 -->
      <div class="div_add">
        <button>추가</button>
      </div>
    </div>
  </main>
  <footer>

  </footer>
<!-- 추가 버튼을 클릭 시 아래의 모달 생성 -->
  <div class="modal" id="matching_add">
    <div class="modal_container">
      <h2> 매칭 추가 </h2>
      <form action="" method="get">
        <label for=""> 대상자: <input type="text" ></label><br>
        <label for=""> 날짜: <input type="date"></label><br>
        <label for=""> 시간: <input type="text"></label><br>
        <label for=""> 지급 P: <input type="text"></label><br>
        <div class="modal_button">
          <button type="submit" id="success_modal">등록</button>
          <button id="cansel_modal">취소</button>
        </div>
      </form>
    </div>
  </div>
  <!-- 매칭 추가 등록 버튼 클릭 시 나오는 모달 -->
  <div class="modal" id="complete_modal">
    <div class="modal_container">
      <p>매칭 정보가 등록되었습니다</p>
      <button id="success_button">확인</button>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />

</body>

</html>