<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>전체목록 페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/news/newsList.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/news/newsList.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 전체 뉴스 페이지 컨테이너 -->
    <div class="search_result_container">
      <!-- 전체 뉴스 탑메뉴(소메뉴) -->
      <div class="search_result_topmenu">
        <!-- 전체 뉴스 페이지 제목 -->
        <div class="title">전체목록</div>
        <!-- 검색 창 바 -->
        <div class="searchbar">
          <!-- 검색 결과 보내주기 위한 폼 -->
          <form action="get">
            <!-- 검색 입력 창 -->
            <input type="text" class="underbar">
          </form>
          <!-- 검색 버튼 -->
          <button class="search_btn">
            <!-- 검색 버튼 이미지 -->
            <img class="searchIcon" src="${pageContext.request.contextPath}/assets/img/news/searchIcon.png" alt="검색아이콘">
          </button>
        </div>
      </div>
      <!-- 전체 뉴스 카드 리스트 -->
      <div class="search_result_card">
      	<c:choose>
      		<c:when test="${not empty newsList}">
      			<ul>
      				<c:forEach var="news" items="${newsList}">
      					<li>
      						<!-- 뉴스 링크 이동 카드 리스트 -->
      						<div class="card"><a href="${news.newsLinkUrl}" target="_blank">
      							<p class="cardtitle">
      								<c:out value="${news.newsTitle}"/>
      							</p>
      							<p class="cardlink">
      								<c:out value="${news.newsLinkUrl}"/>
      							</p>
      						</a></div>
      					</li>
      				</c:forEach>
        		</ul>
      		</c:when>
      		<c:otherwise>
   				<div>
   					<div colspan="5" align="center">등록된 뉴스가 없습니다.</div>
   				</div>
   			</c:otherwise>
      	</c:choose>
        
        <!-- 페이지 네이션 -->
        <div class="pagination">
			<ul class="paging">
				<c:if test="${prev}">
					<li><a
						href="${pageContext.request.contextPath}/news/newsAllList.ne?page=${startPage - 1}"
						class="prev">&lt;</a></li>
				</c:if>
				<c:set var="realStartPage"
					value="${startPage < 0 ? 0 : startPage}" />
				<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
					<c:choose>
						<c:when test="${!(i == page) }">
							<li><a
								href="${pageContext.request.contextPath}/news/newsAllList.ne?page=${i}">
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
						href="${pageContext.request.contextPath}/news/newsAllList.ne?page=${endPage + 1}"
						class="next">&gt;</a>
				</c:if>
			</ul>
        </div>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
</body>
</html>