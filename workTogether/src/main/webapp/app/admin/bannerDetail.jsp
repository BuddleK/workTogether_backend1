<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>배너 상세페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/bannerDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="./../../assets/js/main/includeAdmin.js"></script>
    <!-- <script
      defer
      src="./../../assets/js/modal/modalDeleteNewsFinished.js"
    ></script> -->
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/bannerDetail.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
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
          <div class="board_title">뉴스내용</div>
          <div name="news" id="news" placeholder="" readonly>
            배너 뉴스내용은 이러합니다.
            <div class="img"></div>
          </div>
        </div>
        <div class="add_link">
          <div class="add_link_title">뉴스링크</div>
          <input type="text" class="link_input" />
        </div>
        <div class="add_btn">
          <button class="cancle" onclick="cancle2()" type="button">취소</button>
          <button class="add" onclick="modalUpdateShow()" type="button">
            수정
          </button>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
    <div id="modalUpdate"></div>
  </body>
</html>
