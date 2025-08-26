<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Post</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/post/postMain.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
<%--   <script defer src="${pageContext.request.contextPath}/assets/js/post/postMain.js"></script> --%>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <div class="context">
      <div class="post_columns_top">
        <span class="post_num">번호</span>
        <span class="post_tit">제목</span>
        <span class="post_aut">작성자</span>
        <span class="post_dat">작성일</span>
        <span class="post_rea">조회수</span>
      </div>
      <ul class="notice_list">
        <li class="post_columns">
          <a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">
            <span class="post_num">공지</span>
            <span class="post_tit">전화번호 인증 관련 안내사항</span>
            <span class="post_aut">관리자</span>
            <span class="post_dat">2025-08-20</span>
            <span class="post_rea">404</span>
          </a>
        </li>
        <li class="post_columns">
          <a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">
            <span class="post_num">공지</span>
            <span class="post_tit">안내</span>
            <span class="post_aut">관리자</span>
            <span class="post_dat">2025-08-20</span>
            <span class="post_rea">404</span>
          </a>
        </li>
        <li class="post_columns">
          <a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">
            <span class="post_num">공지</span>
            <span class="post_tit">이벤트 안내</span>
            <span class="post_aut">관리자</span>
            <span class="post_dat">2025-08-20</span>
            <span class="post_rea">404</span>
          </a>
        </li>
        <li class="post_columns">
          <a href="${pageContext.request.contextPath}/app/post/postArlim.jsp">
            <span class="post_num">공지</span>
            <span class="post_tit">사이트 일정 안내</span>
            <span class="post_aut">관리자</span>
            <span class="post_dat">2025-08-20</span>
            <span class="post_rea">404</span>
          </a>
        </li>
      </ul>
      <ul class="post_list">
		<c:choose>
			<c:when test="${not empty postsList}">
				<c:forEach var="post" items="${postsList}">
					<li class="post_columns">
						<a href="${pageContext.request.contextPath}/post/postReadOk.po?postsNumber=${post.postsNumber}">
            				<span class="post_num"><c:out value="${post.getRnum()}"/></span>
            				<span class="post_tit"><c:out value="${post.getPostsTitle()}"/></span>
            				<span class="post_aut"><c:out value="${post.getUsersName()}"/></span>
            				<span class="post_dat"><c:out value="${post.getPostsCreatedDate()}"/></span>
            				<span class="post_rea"><c:out value="${post.getPostsViewCount()}"/></span>
						</a>
					</li>
				</c:forEach>
			</c:when>
			<c:otherwise>
   				<div>
   					<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
   				</div>
			</c:otherwise>
		</c:choose>
      </ul>
      <div class="search_box">
        <select id="search_criteria">
          <!-- 제목 검색 -->
          <option value="cri_title">
            제목
          </option>
          <!-- 내용 검색 -->
          <option value="cri_context">
            내용
          </option>
          <!-- 제목 + 내용 검색 -->
          <option value="cri_tc">
            제목 + 내용
          </option>
        </select>
        <!-- 검색 입력 창 -->
        <input type="text" id="criteria" placeholder="검색어를 입력하세요">
        <!-- 검색 버튼 -->
        <span id="search_icon_box">
          <!-- 검색 버튼 이미지 -->
          <img id="search_icon" src="${pageContext.request.contextPath}/assets/img/careMember/search_icon.png">
        </span>
        <div type="button" id="write_button">
          <a href="${pageContext.request.contextPath}/post/postWrite.po" id="write_button_text" >글쓰기</a>
        </div>
      </div>
      <div class="pagination">
        <ul>
          <!-- 페이징 처리 -->
<!--           <li><a href="#" class="prev">&lt;</a></li>
          <li><a href="#" class="active">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#" class="next">&gt;</a></li> -->
          
          <c:if test="${prev}">
          	<li><a href="${pageContext.request.contextPath}/post/postMain.po?page=${startPage - 1}" class="prev">&lt;</a></li>
          </c:if>
          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
          	<c:choose>
          		<c:when test="${!(i == page) }">
          			<li><a href="${pageContext.request.contextPath}/post/postMain.po?page=${i}">
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
          	<li><a href="${pageContext.request.contextPath}/post/postMain.po?page=${endPage + 1}" class="next">&gt;</a>
          </c:if>
        </ul>
      </div>
    </div>
  </main>
  <jsp:include page="/footer.jsp" />
    <!-- 비로그인 회원이 글쓰기 버튼 클릭시 모달 -->
    <div class="modal">
      <div class="modal-content">
        <button id="sendxbutton"><a href="${pageContext.request.contextPath}/app/login/login.jsp">X</a></button>
        <p>로그인이 필요합니다</p>
      </div>
    </div>
    <script>
    	let memberNumber = "${sessionScope.memberNumber}"; 
    	/* console.log = "${sessionScope.memberNumber}"); */
    	/* let usersNumber = 48; */
    </script>
</body>
</html>