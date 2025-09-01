<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Point</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalPoint.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalPoint.js"></script>
</head>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 메뉴 사이드바 섹션 -->
    <nav class="main_sidebar">
      <ul>
        <li><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></li>
        <li><a href="${pageContext.request.contextPath}/normalPwCheck.jsp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/normalMark.jsp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalheart.jsp">하트 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalMatching.jsp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalsendMesseage.jsp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/normalPost.jsp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/normalPoint.jsp">포인트 충전</a></li> 
        <li><a href="${pageContext.request.contextPath}/normalReference.jsp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/normalQuit.jsp">회원 탈퇴</a></li>
      </ul>
    </nav>
    <div class="div_mark">
      <!-- 메뉴 제목 -->
      <div class="title">개인정보 수정</div>  
      <!-- 주의사항  표시-->
      <div class="arlim">
        <nav>
          <ul>
            <li>🛈저희 함께걸음은 회원님의 개인 정보를 신중히 취급하며, 회원님의 동의 없이 기재하신 회원정보를 공개하지 않습니다.</li>
            <li>회원님의 개인 정보를 안전하게 보호하기 위해 최선을 다하고 있습니다. </li>
            <li>회원님의 정보를 특정할 수 있는 것은 입력을 지양해 주시길 바랍니다.</li>
          </ul>
        </nav>
      </div>
      <form action="" method="get"> 
        <!-- 포인트  충전, 충전 내역 섹션 -->
        <div class="point_have">
          <div class="point_have_title">포인트 잔액</div>
          <div class="point_point">10000 포인트</div>
          <div class="button">
            <button type="button" id="chargeBtn">포인트 충전</button>
            <button type="button" id="chargehis">충전 내역</button>
          </div>
        </div>
        <!-- 포인트 사용 내역 섹션 -->
        <div class="point_use">
          <div class="point_use_title">포인트 사용 내역</div>
          <nav class="month">
            <ul>
              <li>&lt;</li>
              <li>8월</li>
              <li>&gt;</li>
            </ul>
          </nav>
          <div class="point_total_use">
            <div class="point_month">8월 총 사용 포인트 : 10,000p</div>
            <nav class="point_day">
              <ul>
                <li>몇일 : 돌봄회원 이름</li>
                <li>몇일 : 돌봄회원 이름</li>
                <li>몇일 : 돌봄회원 이름</li>
                <li>몇일 : 돌봄회원 이름</li>
              </ul>
            </nav>
          </div>
        </div>
      </form>
    </div>
    <!-- 포인트 충전 모달 -->
    <div class="modal">
      <div class="modal-content">
        <p>포인트 충전</p>
        <div class="payapi">
          <div>결제 api</div>
        </div>
        <div class="charge">
          <div><input type="text"></div>
        </div>
        <nav>
          <ul class="charge_point">
            <li>
              <ul>
                <li><div>충전 전 포인트</div></li>
                <li><div>충전되어있는 포인트</div></li>
              </ul>
            </li>
            <li>
              <ul>
                <li><div>충전 할 포인트</div></li>
                <li><div>충전 할 포인트</div></li>
              </ul>
            </li>
            <li>
              <ul>
                <li><div>충전 후 포인트</div></li>
                <li><div>충전 전 포인트+충전 할 포인트</div></li>
              </ul>
            </li>
          </ul>
        </nav>
        <button type="button" id="deleteBtn">취소</button>
        <button type="button" onclick="openpointcharge()" id="completeBtn">완료</button>
      </div>
    </div>
    <!-- 포인트 충전 내역 모달 -->
    <div class="modal_history">
      <div class="modal-content">
        <p>포인트 충전 내역</p>
        <div class="charge_history">
          <div>
            <nav class="charge_month">
              <ul>
                <li><button type="button">&lt;</button></li>
                <li><div>8월</div></li>
                <li><button type="button">&gt;</button></li>
              </ul>
            </nav>
          </div>
          <div>
            <nav class="charge_day">
              <ul>
                <li>2일 : 100,000</li>
                <li>2일 : 100,000</li>
                <li>2일 : 100,000</li>
                <li>2일 : 100,000</li>
              </ul>
            </nav>
          </div>
        </div>
        <button type="button" id="deletebutton">취소</button>
        <button type="button" onclick="openpointhis()" id="completeBtn">완료</button>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>

</html>