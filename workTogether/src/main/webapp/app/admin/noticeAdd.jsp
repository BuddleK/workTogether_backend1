<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원 상세페이지(일반)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/noticeAdd.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/noticeAdd.js"></script>
  </head>
  <body>
   	<jsp:include page="/header_admin.jsp" />
    <main>
      <div id="sidebar"></div>
      <section class="detail_page">
        <div class="detail_box">
          <form action="${pageContext.request.contextPath}/admin/adminNoticeInsertOk.ad" method="post" class="detail_form">
            <div class="detail_title">
              <input type="text" 
                     name="noticeTitle" 
                     class="detail_title_text" 
                     placeholder="제목" 
                     value="${param.noticeTitle}" 
                     />
            </div>
            <div class="detail_content">
              <div class="detail_content_input">
                <textarea name="noticeContent" id="detail">${param.noticeContent}</textarea>
              </div>
            </div>
            <div class="btn_area">
              <button class="cancle_btn" formaction="${pageContext.request.contextPath}/admin/adminNotice.ad">취소</button>
              <button class="add_btn" formaction="${pageContext.request.contextPath}/admin/adminNoticeInsertOk.ad">추가</button>
            </div>
          </form>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
  </body>
</html>
