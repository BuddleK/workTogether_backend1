<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>1:1문의 사항</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/questionDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
    <script
      defer
      src="${pageContext.request.contextPath}/assets/js/modal/modalQuestionAnswered.js"
    ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
  </head>
  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <section class="notice_detail">
        <div class="notice_info">
          <div class="info_title">
            <span class="title">안녕하세요</span>
          </div>
          <div class="member_info">
            <div class="member_name_title">작성자명</div>
            <div class="member_name">아무개</div>
            <div class="member_add_title">등록날짜</div>
            <div class="member_add_date">2025 - 08 - 04</div>
          </div>
          <div class="qna">
            <div class="qna_title">문의사항 내용</div>
            <div class="qna_content">눈이 너무아퍼요</div>
          </div>
        </div>
        <div class="notice_content">
          <textarea name="content" id="content" readonly>
            다크모드 만들어주세요
          </textarea>
          <div class="reply_box">
            <textarea name="content" id="reply" placeholder="답변을 달아주세요">
            </textarea>
          </div>
        </div>
        <div class="notice_btn">
          <button class="list" onclick="cancle()" type="button">목록</button>
          <button
            class="delete"
            onclick="modalQuestionAnsweredShow()"
            type="button"
          >
            답변 달기
          </button>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
    <div id="modalQuestionAnswered"></div>
  </body>
</html>
