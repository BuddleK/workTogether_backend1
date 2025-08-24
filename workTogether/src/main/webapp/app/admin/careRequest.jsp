<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>돌봄 회원 신청 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/careRequest.css" />
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
          <h1>돌봄 회원 신청 관리</h1>
        </div>

        <!-- 검색(추후 연결) -->
        <form action=""${pageContext.request.contextPath}/admin/careCareer/list.ad" method="get">
          <div class="searchbox">
            <select name="column" class="search_column">
              <option value="number">돌봄 회원 신청 번호</option>
              <option value="name">신청자 명</option>
              <option value="id">신청자 아이디</option>
              <option value="date">신청 날짜</option>
              <option value="condition">상태</option>
            </select>
            <input type="text" name="keyword" value="${param.keyword}" />
            <button type="submit">검색</button>
          </div>
        </form>

        <div class="table">
          <div class="board_column">
            <div class="board_head board_number">돌봄 회원 신청 번호</div>
            <div class="board_head board_name">신청자 명</div>
            <div class="board_head board_id">신청자 아이디</div>
            <div class="board_head board_date">신청 날짜</div>
            <div class="board_head board_condition">상태</div>
          </div>

          <c:choose>
            <c:when test="${empty list}">
              <div class="empty">대기 중인 신청이 없습니다.</div>
            </c:when>
            <c:otherwise>
              <c:forEach var="row" items="${list}">
                <ul class="table_body">
                  <li class="body_number">
                    <a href="/App/admin/care/detail.ad?usersNumber=${row.usersNumber}&page=${page}">
                      ${row.usersNumber}
                    </a>
                  </li>
                  <li class="body_name">
                    <a href="/App/admin/care/detail.ad?usersNumber=${row.usersNumber}&page=${page}">
                      ${row.usersName}
                    </a>
                  </li>
                  <li class="body_id">
                    <a href="/App/admin/care/detail.ad?usersNumber=${row.usersNumber}&page=${page}">
                      ${row.usersId}
                    </a>
                  </li>
                  <li class="body_date">
                    <a href="/App/admin/care/detail.ad?usersNumber=${row.usersNumber}&page=${page}">
                      ${row.usersCreatedDate}
                    </a>
                  </li>
                  <li class="body_condition">
                    <a href="/App/admin/care/detail.ad?usersNumber=${row.usersNumber}&page=${page}">
                      <span class="status-badge">대기</span>
                    </a>
                  </li>
                </ul>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </div>

        <!-- 페이지네이션: AdminCareListController에서 넣어준 값 사용 -->
        <c:if test="${not empty list}">
          <div class="pagination">
            <c:if test="${prev}">
              <a href="/App/admin/care/list.ad?page=${startPage - 1}">&laquo; Prev</a>
            </c:if>

            <c:forEach begin="${startPage}" end="${endPage}" var="p">
              <c:choose>
                <c:when test="${p == page}">
                  <span class="active">${p}</span>
                </c:when>
                <c:otherwise>
                  <a href="/App/admin/care/list.ad?page=${p}">${p}</a>
                </c:otherwise>
              </c:choose>
            </c:forEach>

            <c:if test="${next}">
              <a href="/App/admin/care/list.ad?page=${endPage + 1}">Next &raquo;</a>
            </c:if>
          </div>
        </c:if>
      </div>
    </section>
  </main>

  <jsp:include page="/footer.jsp" />
</body>
</html>