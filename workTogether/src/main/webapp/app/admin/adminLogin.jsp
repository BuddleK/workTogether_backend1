<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>관리자 로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminLogin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
	<script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminlogin.js"></script>
  </head>

  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <section class="login">
        <form action="${pageContext.request.contextPath}/admin/loginOk.ad" method="post">
          <div class="box">
            <div class="box_title">
              <p>관리자 로그인</p>
            </div>
            <div class="id_box">
              <input type="text" placeholder="USER ID" id="id" name="adminId"/>
            </div>
            <div class="pw_box">
              <input type="password" placeholder="PASSWORD" id="pw" name="adminPassword"/>
            </div>
            <div class="bt_box">
              <button type="submit">로그인</button>
            </div>
          </div>
        </form>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
  </body>
</html>
