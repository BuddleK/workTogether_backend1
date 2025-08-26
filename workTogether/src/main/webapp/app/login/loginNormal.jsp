<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>로그인페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login/login.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css"/>
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/login/login.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css"/>
</head>
<body>
<jsp:include page="/header.jsp"/>

<main>
  <section class="login">
    <form action="${pageContext.request.contextPath}/users/loginNormalOk.us" method="post">
      <div class="box">
        <div class="box_title"><p>Normal login</p></div>

        <div class="id_box">
          <input type="text" name="usersId" id="id_input" placeholder="USER ID" required/>
        </div>
        <div class="pw_box">
          <input type="password" name="usersPassword" id="pw_input" placeholder="PASSWORD" required/>
        </div>

        <div class="bt_box">
          <button type="submit">일반 로그인</button>
        </div>
        

        <div class="link_box">
          <a href="${pageContext.request.contextPath}/users/findId.us">아이디 찾기</a>
          <a href="${pageContext.request.contextPath}/users/findPw.us">비밀번호 찾기</a>
          <a href="${pageContext.request.contextPath}/app/sign/terms.jsp">회원가입</a>
        </div>
      </div>
    </form>
  </section>
  <% %>
  <% 
  	String flag = request.getParameter("");
  %>
</main>

<jsp:include page="/footer.jsp"/>
<div id="modalAdminLoginFailed"></div>
</body>
</html>
