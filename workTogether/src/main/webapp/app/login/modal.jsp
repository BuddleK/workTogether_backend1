<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>로그인 실패</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login/modal.css" />
  </head>
  <body>
    <main>
      <section class="box">
        <div class="blur"></div>
        <div class="modal">
          <div class="cancle"><p>X</p></div>
          <div class="p_box">
            <p class="title">로그인 실패</p>
            <p class="warning">아이디 혹은 비밀번호를 확인해주세요</p>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
