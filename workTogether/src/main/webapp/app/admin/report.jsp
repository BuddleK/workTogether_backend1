<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>신고글 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/report.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
  </head>

  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <div id="sidebar"></div>
      <section class="userManager">
        <div class="searchcontent">
          <div class="title">
            <h1>신고글 관리</h1>
          </div>
          <div class="table">
            <div class="board_column">
              <div class="board_head board_number">번호</div>
              <div class="board_head board_title">게시글 제목</div>
              <div class="board_head board_date">날짜</div>
              <div class="board_head board_cnt">개수</div>
            </div>
            <div class="table">
              <div class="table_content">
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp"
                      >사이트 이용시 주의 사항</a
                    >
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp"
                      >202 5-08-09</a
                    >
                  </li>
                  <li class="body_cnt">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">47</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp"
                      >사이트 이용시 주의 사항</a
                    >
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_cnt">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">47</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp"
                      >사이트 이용시 주의 사항</a
                    >
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_cnt">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">47</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp"
                      >사이트 이용시 주의 사항</a
                    >
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_cnt">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">47</a>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp"
                      >사이트 이용시 주의 사항</a
                    >
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_cnt">
                    <a href="${pageContext.request.contextPath}/app/admin/reportDetail.jsp">47</a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="paging_box">
              <ul class="paging">
                <li class="prev">
                  <a href="">&lt;</a>
                </li>
                <li class="page_number">
                  <a href="">1</a>
                </li>
                <li class="page_number">
                  <a href="">2</a>
                </li>
                <li class="page_number">
                  <a href="">3</a>
                </li>
                <li class="page_number">
                  <a href="">4</a>
                </li>
                <li class="page_number">...</li>
                <li class="next">
                  <a href="">&gt;</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </section>
    </main>

    <jsp:include page="/footer.jsp" />
  </body>
</html>
