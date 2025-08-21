<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>돌봄 회원 환급 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/refund.css" />
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
            <h1>돌봄 회원 환급 관리</h1>
          </div>
          <form action="" method="">
            <div class="searchbox">
              <select name="column" id="" class="search_column">
                <option value="number">환급 신청 번호</option>
                <option value="name">신청자 명</option>
                <option value="id">신청자 아이디</option>
                <option value="date">신청 날짜</option>
                <option value="type">환급 여부</option>
              </select>
              <input type="text" />
              <button>검색</button>
            </div>
          </form>
          <div class="table">
            <div class="board_column">
              <div class="board_head board_number">환급 신청 번호</div>
              <div class="board_head board_name">신청자 명</div>
              <div class="board_head board_id">신청자 아이디</div>
              <div class="board_head board_date">신청 날짜</div>
              <div class="board_head board_refund_date">환급 날짜</div>
              <div class="board_head board_type">환급 여부</div>
            </div>
            <div class="table_content">
              <ul class="table_body">
                <li class="body_number"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">1</a></li>
                <li class="body_name"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">가나다</a></li>
                <li class="body_id"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">abc123</a></li>
                <li class="body_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_refund_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_type"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">Y</a></li>
              </ul>
              <ul class="table_body">
                <li class="body_number"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2</a></li>
                <li class="body_name"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">가나다</a></li>
                <li class="body_id"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">abc123</a></li>
                <li class="body_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_refund_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_type"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">Y</a></li>
              </ul>
              <ul class="table_body">
                <li class="body_number"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">3</a></li>
                <li class="body_name"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">가나다</a></li>
                <li class="body_id"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">abc123</a></li>
                <li class="body_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_refund_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">NaN</a></li>
                <li class="body_type"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">N</a></li>
              </ul>
              <ul class="table_body">
                <li class="body_number"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">4</a></li>
                <li class="body_name"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">가나다</a></li>
                <li class="body_id"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">abc123</a></li>
                <li class="body_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_refund_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">NaN</a></li>
                <li class="body_type"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">N</a></li>
              </ul>
              <ul class="table_body">
                <li class="body_number"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">5</a></li>
                <li class="body_name"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">가나다</a></li>
                <li class="body_id"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">abc123</a></li>
                <li class="body_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_refund_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_type"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">Y</a></li>
              </ul>
              <ul class="table_body">
                <li class="body_number"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">6</a></li>
                <li class="body_name"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">가나다</a></li>
                <li class="body_id"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">abc123</a></li>
                <li class="body_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">2025-08-09</a></li>
                <li class="body_refund_date"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">NaN</a></li>
                <li class="body_type"><a href="${pageContext.request.contextPath}/app/admin/refundDetail.jsp">N</a></li>
              </ul>
          </div>
        </div>
      </section>
    </main>

    <jsp:include page="/footer.jsp" />
  </body>
</html>
