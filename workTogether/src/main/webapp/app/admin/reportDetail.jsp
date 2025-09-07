<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
  window.contextPath = "${pageContext.request.contextPath}";
</script>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원 상세페이지(일반)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/reportDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <!-- <script
      defer
      src="${pageContext.request.contextPath}/assets/js/modal/modalDeleteReportedPost.js"
    ></script> -->
    <script
      defer
      src="${pageContext.request.contextPath}/assets/js/modal/modalDeletePostReason.js"
    ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
  </head>
  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <section class="notice_detail">
        <div class="notice_info">
          <div class="info_title">
            <span class="title"><c:out value="${report.getPostsTitle()}"/></span>
          </div>
          <div class="member_info">
            <div class="member_name_title">작성자명</div>
            <div class="member_name"><c:out value="${report.getUsersName()}"/></div>
            <div class="member_add_title">등록날짜</div>
            <div class="member_add_date"><c:out value="${report.getPostsCreatedDate()}"/></div>
          </div>
          <div class="cnt">
            <div class="cnt_title">조회수</div>
            <div class="cnt_content"><c:out value="${report.getPostsViewCount()}"/></div>
          </div>
        </div>
        <div class="notice_content">
          <textarea name="content" id="content" readonly><c:out value="${report.getPostsContent()}"/></textarea>
          <div class="reply">
            <div class="reply_cnt">댓글 (1)</div>
            <div class="line"></div>
            <div class="reply_content">너는 잘 모르는구나?</div>
            <div class="reply_content">너는 잘 모르는구나?</div>
          </div>
        </div>
        <div class="notice_btn">
          <button class="list" onclick="location.href='${pageContext.request.contextPath}/admin/adminReportList.ad'" type="button">목록</button>
          <button
            class="delete"
            onclick="modalDeletePostReasonShow()"
            type="button">
            삭제
          </button>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
    <div id="modalDeletePostReason"></div>
  </body>
</html>
