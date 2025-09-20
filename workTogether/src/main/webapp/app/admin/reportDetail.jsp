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
        <div class="table">
            <div class="board_column">
              <div class="board_head board_number">회원번호</div>
              <div class="board_head board_title">회원 이름</div>
              <div class="board_head board_date">신고 사유</div>
            </div>
            <div class="table">
              <div class="table_content">
              	<c:choose>
              		<c:when test="${not empty adminReportList}">
              			<c:forEach var="report" items="${adminReportList}">
	                		<ul class="table_body">
		            			<li class="body_number"><c:out value="${report.getPostsNumber()}"/></li>
		                		<li class="body_content"><c:out value="${report.getPostsTitle()}"/></li>
		                		<li class="body_date"><c:out value="${report.getPostsCreatedDate()}"/></li>
	                		</ul>
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
        <div class="notice_btn">
          <button class="list" onclick="location.href='${pageContext.request.contextPath}/admin/adminReportList.ad'" type="button">목록</button>
          <div class="delete"><a href="${pageContext.request.contextPath}/admin/adminReportDeleteOk.ad?postsNumber=${report.getPostsNumber()}" class="button_del">삭제</a></div>
      	</div>
      </section>
    </main>
    <div class="checkmodal" id="del_modal">
      <div class="modal_box">
      	<p>이 게시글을 삭제하시겠습니까?</p>
      	<div class="modal_buttons">
        	<button id="check">확인</button>
        	<button id="cancle">취소</button>
      	</div>
      </div>
  	</div>
  	
  	<div class="reportmodal">
    	<div class="modal_box">
      		<p>삭제되었습니다</p>
      		<div class="modal_buttons">
        		<button id="reportcheck">확인</button>
      		</div>
    	</div>
  	</div>
    <jsp:include page="/footer.jsp" />
    <div id="modalDeletePostReason"></div>
  </body>
</html>
