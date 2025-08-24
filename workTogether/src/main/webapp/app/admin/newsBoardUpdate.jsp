<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>뉴스 수정</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/newsBoardAdd.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
  </head>
  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <section class="add_section">
        <div class="add_data">
          <div class="title">뉴스제목</div>
          <div class="title_content">뉴스교실</div>
          <div class="name">작성자명</div>
          <div class="name_content">홍길동</div>
          <div class="date">작성 날짜</div>
          <div class="date_content">2025-08-10</div>
        </div>
        <div class="add_content">
          <div class="board_option"></div>
          <textarea name="news" id="news" placeholder="">
        날씨가 너무 덥다... 진짜.... 괜히 긴 바지 입었네</textarea>
        </div>
        <div class="add_link">
          <div class="add_link_title">뉴스링크</div>
          <input
            type="text"
            class="link_input"
            placeholder="수정 링크를 넣어주세요"
          />
        </div>
        <div class="add_btn">
          <button class="cancle" type="button">취소</button>
          <button class="add" type="submit">수정 완료</button>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
  </body>
</html>
