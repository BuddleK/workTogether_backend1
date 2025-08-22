<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>뉴스 게시글 관리</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/newsBoard.css" />
</head>
<body>
  <jsp:include page="/header_admin.jsp" />

  <div class="container">
    <div class="write-btn-wrap">
      <a href="${pageContext.request.contextPath}/admin/news/newsWrite.ad" class="write-btn">등록</a>
    </div>

    <!-- 목록 헤더 -->
    <div class="board-list">
      <div class="board-header">
        <span class="no">번호</span>
        <span class="title">제목</span>
        <span class="date">작성일</span>
        <span class="hit">관리</span>
      </div>

      <!-- 목록 바디 -->
      <div class="board-body">
        <c:choose>
          <c:when test="${not empty newsList}">
            <c:forEach var="news" items="${newsList}">
              <div class="board-row">
                <div class="board-item no">
                  <a href="${pageContext.request.contextPath}/admin/news/newsReadOk.ad?newsNumber=${news.newsNumber}">
                    ${news.newsNumber}
                  </a>
                </div>

                <div class="board-item title">
                  <a href="${pageContext.request.contextPath}/admin/news/newsReadOk.ad?newsNumber=${news.newsNumber}">
                    <c:out value="${news.newsTitle}" />
                  </a>
                </div>

                <div class="board-item date">
                  <c:out value="${news.newsCreatedDate}" />
                </div>

                <div class="board-item hit">
                  <!-- 로그인한 관리자 본인 글만 삭제 버튼 노출 -->
                  <c:if test="${sessionScope.adminNumber == news.adminNumber}">
                    <form action="${pageContext.request.contextPath}/admin/news/newsDeleteOk.ad" method="post"
                          onsubmit="return confirm('정말 삭제하시겠습니까?');" style="display:inline;">
                      <input type="hidden" name="newsNumber" value="${news.newsNumber}">
                      <button type="submit" class="delete_btn">삭제</button>
                    </form>
                  </c:if>
                </div>
              </div>
            </c:forEach>
          </c:when>

          <c:otherwise>
            <div style="padding:24px;text-align:center;color:#777;">등록된 뉴스가 없습니다.</div>
          </c:otherwise>
        </c:choose>
      </div>
    </div>

    <!-- 페이징 -->
    <div class="pagination">
      <ul>
        <c:if test="${prev}">
          <li><a href="${pageContext.request.contextPath}/admin/news/newsListOk.ad?page=${startPage - 1}" class="prev">&lt;</a></li>
        </c:if>

        <c:set var="realStartPage" value="${startPage < 0 ?0 : startPage}" />
        <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
          <c:choose>
            <c:when test="${i == page}">
              <li><a href="${pageContext.request.contextPath}/admin/news/adminListOk.ad?page=${i}">
          				<c:out value="${i}" />
          			</a></li>
            </c:when>
            <c:otherwise>
              <li><a href="#" class="active">
          				<c:out value="${i}" />
          			</a></li>
            </c:otherwise>
          </c:choose>
        </c:forEach>

        <c:if test="${next}">
          <li><a href="${pageContext.request.contextPath}/admin/news/newsListOk.ad?page=${endPage + 1}" class="next">&gt;</a></li>
        </c:if>
      </ul>
    </div>
  </div>
</body>
</html>
