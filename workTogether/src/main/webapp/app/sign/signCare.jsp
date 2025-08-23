<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입(돌봄)</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/sign/basic.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/sign/signCare.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <!-- 우편번호 팝업 -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    function openPostcode(){
      new daum.Postcode({
        oncomplete: function(data){
          document.getElementById("usersPostsalCode").value = data.zonecode || "";
          document.getElementById("usersAddressLine1").value = data.roadAddress || data.jibunAddress || "";
          document.getElementById("usersAddressLine2").focus();
        }
      }).open();
    }
  </script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <section class="sign">
      <form action="${pageContext.request.contextPath}/users/joinCareOk.us" method="post" class="sign_form">
        <input type="hidden" name="usersType" value="C"/>

        <div class="sign_box sign_title"><p>돌봄 회원가입</p></div>

        <div class="sign_box sign_id">
          <p>아이디</p>
          <input type="text" name="usersId" placeholder="8자리 이상, 문자 숫자 포함" required>
          <button type="button" onclick="/* checkId AJAX */">중복확인</button>
        </div>

        <div class="sign_box sign_password">
          <p>비밀번호</p>
          <input type="password" name="usersPassword" placeholder="비밀번호 8자리 입력(숫자와 영어 특수기호 포함)" required>
        </div>

        <div class="sign_box password_check">
          <p>비밀번호 확인</p>
          <input type="password" placeholder="비밀번호 재입력">
        </div>

        <div class="sign_box sign_email">
          <p>이메일</p>
          <input type="text" name="usersEmail" required>
        </div>

        <div class="sign_box sign_name">
          <p>이름</p>
          <input type="text" name="usersName" required>
        </div>

        <div class="sign_box sign_birth">
          <p>휴대전화</p>
          <input type="text" name="usersPhone" placeholder="- 없이 숫자만 입력해주세요." required>
        </div>

        <div class="sign_box sign_phone">
          <input type="text" placeholder="인증번호 6자리 입력">
          <button type="button">인증번호 확인</button>
        </div>

        <div class="sign_box sign_address">
          <p>주소</p>
          <input type="text" id="usersPostsalCode" name="usersPostsalCode" placeholder="우편번호" readonly>
          <button type="button" onclick="openPostcode()">우편 주소</button>
        </div>

        <div class="sign_box address_detail">
          <p>상세 주소</p>
          <input type="text" id="usersAddressLine1" name="usersAddressLine1" placeholder="기본주소" readonly>
          <input type="text" id="usersAddressLine2" name="usersAddressLine2" placeholder="상세주소">
        </div>

        <!-- 돌봄 상세 -->
        <div class="sign_box">
          <p>소개글</p>
          <input type="text" name="careIntroText" placeholder="간단한 소개(선택)">
        </div>

        <div class="file">
          <input type="number" name="careCertificateFilesNum" placeholder="자격증 파일번호">
          <button type="button">파일첨부</button>
        </div>
        <div class="file">
          <input type="number" name="carePassbookFilesNum" placeholder="통장사본 파일번호">
          <button type="button">파일첨부</button>
        </div>
        <div class="file">
          <input type="number" name="careProfilesPhotoNumber" placeholder="프로필사진 파일번호">
          <button type="button">파일첨부</button>
        </div>

        <div class="sign_box sign_btn">
          <button type="submit">가입하기</button>
        </div>
      </form>
    </section>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>
