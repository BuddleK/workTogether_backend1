<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Matching</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalMatching.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalMatching.js"></script>
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
      <div class="title">매칭 기록</div>
      <form action="" method="get">
        <!-- 월 표시 -->
        <nav class="month">
          <ul>
            <li><a href="">1월</a></li>
            <li><a href="">2월</a></li>
            <li><a href="">3월</a></li>
            <li><a href="">4월</a></li>
            <li><a href="">5월</a></li>
            <li><a href="">6월</a></li>
            <li><a href="">7월</a></li>
            <li><a href="">8월</a></li> 
            <li><a href="">9월</a></li>
            <li><a href="">10월</a></li>
            <li><a href="">11월</a></li>
            <li><a href="">12월</a></li>
          </ul>
        </nav>
        <!-- 매칭 기록 표시 섹션 -->
        <nav class="matching">
          <ul>
            <li>
              <div>2일 김괭이 돌봄회원 | 이용 시간 : 09 : 00 ~ 18 : 00
              포인트 사용 : 10,000</div>
              <div class="matchingbutton">
                <button type="button" id="complete">이용완료</button>
                <button type="button" id="cancel">취소</button>
              </div>
            </li>
          </ul>
        </nav>
        <!-- 매칭 기록 표시 섹션 -->
        <nav class="matching">
          <ul>
            <li>
              <div>2일 김괭이 돌봄회원 | 이용 시간 : 09 : 00 ~ 18 : 00
                포인트 사용 : 10,000</div>
              <div class="matchingbutton">
                <button type="button" id="complete">이용완료</button>
                <button type="button" id="cancel">취소</button>
              </div>
            </li>
          </ul>
        </nav>
        <!-- 매칭 기록 표시 섹션 -->
        <nav class="matching">
          <ul>
            <li>
              <div>2일 김괭이 돌봄회원 | 이용 시간 : 09 : 00 ~ 18 : 00
                포인트 사용 : 10,000</div>
              <div class="matchingbutton">
                <button type="button" id="complete">이용완료</button>
                <button type="button" id="cancel">취소</button>
              </div>
            </li>
          </ul>
        </nav>
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
      </form>
    </div>
    
  </main>
  <div class="completemodal">
    <div class="modal-content">
      <p>이용이 완료 되었습니다.</p>
      <button type="button" onclick="completeModalClose()" id="completeBtn">확인</button>
    </div>
  </div>
  <div class="cancelmodal">
    <div class="modal-content">
      <p>이용이 취소 되었습니다.</p>
      <button type="button" onclick="cancelModalClose()" id="cancelBtn">확인</button>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>

</html>