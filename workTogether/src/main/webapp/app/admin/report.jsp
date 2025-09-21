<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                 <c:choose>
                    <c:when test="${not empty adminReportList}">
                       <c:forEach var="report" items="${adminReportList}">
                          <a href="${pageContext.request.contextPath}/admin/adminReportListOk.ad?postsNumber=${report.getPostsNumber()}">
                            <ul class="table_body">
                              <li class="body_number"><c:out value="${report.postsNumber}"/></li>
                               <li class="body_content"><c:out value="${report.postsTitle}"/></li>
                               <li class="body_date"><c:out value="${report.postsCreatedDate}"/></li>
                               <li class="body_cnt"><c:out value="${report.postsReportCount}"/></li>
                            </ul>
                        </a> 
                     </c:forEach>
                  </c:when>
                  <c:otherwise>
                     <div>
                        <div colspan="5" align="center">등록된 게시물이 없습니다.</div>
                     </div>
               </c:otherwise>
               </c:choose>   
              </div>
            </div>
            <!-- 페이지네이션 -->
            <div class="paging_box">
              <ul class="paging">
            <c:if test="${prev}">
               <li><a
                  href="${pageContext.request.contextPath}/admin/adminReportList.ad?page=${startPage - 1}"
                  class="prev">&lt;</a></li>
            </c:if>
            <c:set var="realStartPage"
               value="${startPage < 0 ? 0 : startPage}" />
            <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
               <c:choose>
                  <c:when test="${!(i == page) }">
                     <li><a
                        href="${pageContext.request.contextPath}/admin/adminReportList.ad?page=${i}">
                           <c:out value="${i}" />
                     </a></li>
                  </c:when>
                  <c:otherwise>
                     <li><a href="#" class="active"> <c:out value="${i}" />
                     </a></li>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
            <c:if test="${next}">
               <li><a
                  href="${pageContext.request.contextPath}/admin/adminReportList.ad?page=${endPage + 1}"
                  class="next">&gt;</a>
            </c:if>
         </ul>
            </div>
          </div>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
  </body>
</html>
