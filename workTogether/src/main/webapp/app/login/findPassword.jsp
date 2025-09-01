<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>비밀번호 찾기</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login/basic.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login/findPassword.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css"/>
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/login/findPw.js"></script>
</head>
<body>
<jsp:include page="/header.jsp"/>

<main>
  <section class="findId">
    <form action="${pageContext.request.contextPath}/users/findPwOk.us" method="post">
      <div class="box">
        <div class="box_title"><p>비밀번호 찾기</p></div>

        <div class="box_content">
          <div class="box_name">
            <p>이름</p>
            <input type="text" name="usersName" id="name_input" required/>
          </div>

          <div>
            <div class="box_id">
              <p>아이디</p>
              <input type="text" name="usersId" id="get_id" required/>
              <label for="member_normal">
                <input type="radio" id="member_normal" name="usersType" value="N"/>일반회원
              </label>
              <label for="member_care">
                <input type="radio" id="member_care" name="usersType" value="C"/>돌봄회원
              </label>
              <button type="button" class="check_id_btn" onclick="checkId()">아이디 확인</button>
            </div>
            <div class="check_id">
              <p class="correct_id">아이디가 제대로 확인되었습니다.</p>
              <p class="error_id">아이디가 존재하지 않습니다.</p>
            </div>
          </div>

          <div class="box_phone">
            <p>휴대전화</p>
            <input type="text" name="usersPhone" placeholder="-없이 숫자만 입력해주세요" id="phone_input" required/>
            <button type="button" onclick="sendMsg()">인증번호 받기</button>
            <div class="alert">인증번호가 발송되었습니다.</div>
          </div>

          <div>
            <div class="box_author">
              <input type="text" placeholder="인증번호 6자리 입력" class="input_number" id="author_number"/>
              <div class="timer"></div>
              <button type="button" onclick="checkMsg()">인증번호 확인</button>
            </div>
            <div class="error_box_msg">
              <p class="error_msg">인증번호가 올바르지 않습니다.</p>
              <p class="okay_msg">제대로 인증되었습니다.</p>
            </div>
          </div>

          <div class="box_next">
            <button class="next_btn" type="submit">다음</button>
          </div>
        </div>
      </div>
    </form>
  </section>
</main>

<jsp:include page="/footer.jsp"/>
</body>
</html>
