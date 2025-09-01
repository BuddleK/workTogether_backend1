<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% session.setAttribute("usersNumber", 2); %> 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_Modify</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careModify.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careModify.js"></script>
</head>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="main_sidebar">
      <ul>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careProfile.cp"><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careModify.cp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMark.cp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMatching.cp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMesseage.cp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/carePost.cp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/carePointreturn.cp">포인트 환급</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careReference.cp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careExit.cp">회원 탈퇴</a></li>
      </ul>
    </nav>

    <div class="div_mark">
      <!-- 마이페이지 제목 -->

      <div class="title">개인정보 수정</div>
      <div class="arlim">
        <div>

        </div>
        <!-- 알림 정보 -->

        <nav>
          <ul>
            <li>저희 함께걸음은 회원님의 개인 정보를 신중히 취급하며, 회원님의 동의 없이 기재하신 회원정보를 공개하지 않습니다.</li>
            <li>회원님의 개인 정보를 안전하게 보호하기 위해 최선을 다하고 있습니다. </li>
            <li>회원님의 정보를 특정할 수 있는 것은 입력을 지양해 주시길 바랍니다.</li>
          </ul>
        </nav>
      </div>
      <!-- 페이지 세부 정보 수정-->

      <form action="${pageContext.request.contextPath }/myPageCare/careModify.cp" method="post"
      data-context-path="${pageContext.request.contextPath}" novalidate>
        <!-- 수정하는 것의 제목 -->
        <div>
          <div>회원 정보</div>
        </div>
        <nav class="caremodify">
          <ul>
            <li class="member">
              <!-- 저장되어 있는 이름과 성명 -->
              <ul>
                <li class="info">성명</li>
                <li class="myinfo"><c:out value="${careModify.getUsersName()}" /></li>
              </ul>
            </li>
            <li class="member">
              <!-- 주소를 수정하기 위한 칸 -->
              <ul>
                <li class="info">주소</li>
                <li class="myinfo">
                  <ul>
                    <li><div><c:out value="${careModify.getUsersPostCode()}" /></div></li>
                    <li><div><c:out value="${careModify.getUsersAddrLine1()}" /></div><button>우편번호 찾기</button></li>
                    <li><div><c:out value="${careModify.getUsersAddrLine1()}" /></div><button type="button" id="searchPostcodeBtn">확인</button></li>
                  </ul>
                </li>
              </ul>
            </li>
            <!-- 전화번호를 수정 할 수 있는 칸 -->
            <li class="member">
              <ul>
                <li class="info">전화번호</li>
                <li class="myinfo"><div><c:out value="${careModify.getUsersPhone()}" /></div><button>수정</button></li>
              </ul>
            </li>
            <!-- 아이디를 보여주는 칸 -->
            <li class="member">
              <ul>
                <li class="info">아이디</li>
                <li class="myinfo"><div><c:out value="${careModify.getUsersId()}" /></div></li>
              </ul>
            </li>
            <!-- 이메일 수정 할 수 있는 칸 -->
            <div class="email">
              <div>이메일</div>
              <div class="email_detail">
                <div><c:out value="${careModify.getUsersEmail()}" /></div>
                <button onclick="validateEmail()">수정</button>
                <div id="result"></div>
              </div>
            </div>
            <!-- 비밀번호를 수정 하기 위한 칸 -->
            <li class="member">
              <ul>
                <li class="info">비밀번호 재설정</li>
                <li class="myinfo">
                  <ul class="pw_reset">
                    <li>
                      <input type="password" placeholder="비밀번호 8자리 입력(숫자와 영어 특수기호 포함)" id="rePw">
                    </li>
                    <li>
                      <!-- 형식 오류 메시지 (초기 숨김) -->
                      <div class="box_error_pw" id="msg_box" style="display:none" aria-live="polite">
                        <p class="error_pw_msg">형식에 맞게 입력해주세요.</p>
                      </div>
                    </li>
                    <li>
                      <input type="password" placeholder="비밀번호 재입력" id="reCheckPw">
                      <button type="button">확인</button>
                    </li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
      </form>
    </div>
  </main>
  <!-- 모든 확인 버튼 클릭시 정보 저장 모달 출력 -->
  <div id="saveSuccessModal" class="modal">
    <div class="modal-content">
      <p>정보가 저장되었습니다.</p>
      <button id="saveConfirmBtn">확인</button>
    </div>
  </div>
  <div id="findModal" class="modal">
    <div class="modal-content">
      <p>우편번호 찾기 api</p>
      <button id="saveConfirmBtn">확인</button>
    </div>
  </div>
  <div id="notCorecetModal" class="modal">
    <div class="modal-content">
      <p>비밀번호가 맞지 않습니다.</p>
      <button id="CorrectBtn">확인</button>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>
<script>
    	let usersNumber = "${sessionScope.usersNumber}";
</script>
</html>