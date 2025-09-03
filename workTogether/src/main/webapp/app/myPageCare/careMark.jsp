<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Care_Mark</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careMark.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careMark.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />

  <main>
          <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="main_sidebar">
      <ul>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careProfile.cp"><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careModify.cp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMark.cp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMatching.cp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careMesseage.cp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/carePost.cp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/carePointreturn.cp">포인트 환급</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careReference.cp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/myPageCare/careExit.cp">회원 탈퇴</a></li>
      </ul>
    </nav>

    <form id="careMark-form" 
    action="${pageContext.request.contextPath}/myPageCare/careMark.cp" method="post">
          <!-- 마이페이지 제목 -->

      <div class="div_mark">
        <div class="title">찜한 목록</div>
        <!-- 페이지 분류 제목 -->
	
        <nav class="mark_nav">
          <ul>
            <li><input type="checkbox"></li>
            <li class="name">
              <div>이름</div>
            </li>
            <li class="location">
              <div>위치</div>
            </li>
            <li class="phone">
              <div>전화번호</div>
            </li>
          </ul>
        </nav>
        <!-- 페이지 상세 내역 -->
        <c:choose>
        	<c:when test="${not empty markList}">
        		<c:forEach var="mark" items="${markList}">
			        <nav class="mark_list"><a href="${pageContext.request.contextPath}/shops/shopsListOk.sh">
			            <ul>
			              <li><input type="checkbox"></li>
			              <li class="name">
			                <c:out value="${mark.getShopNumber()}" />
			              </li>
			              <li class="location">
			                <c:out value="${mark.getShopsRoadAddress()}" />
			              </li>
			              <li class="phone">
			                <c:out value="${mark.getShopsPhone()}" />
			              </li>
			            </ul>
			          </a>
			        </nav>
				</c:forEach>
        	</c:when>
        	<c:otherwise>
   				<div>
   					<div colspan="5" align="center">등록된 찜이 없습니다.</div>
   				</div>
   			</c:otherwise>
        </c:choose>
<!-- 페이지 이동 버튼 -->
        <nav class="page">
          <ul>
            <li><a href="">&lt;</a></li>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
            <li><a href="">4</a></li>
            <li><a href="">&gt;</a></li>
          </ul>
        </nav>
        <!-- 찜 삭제 버튼 -->
        <div class="div_delete">
          <button type="button" id="btnDelete">찜 삭제</button>
        </div>
      </div>
    </form>

  </main>
  <!-- 삭제 버튼 클릭시 확인 모달 -->
    <div class="modal" id="deleteModal">
    <div class="modal_box">
      <p>찜한 가게를 삭제하시겠습니까?</p>
      <div class="modal_buttons">
        <button id="confirmDelete">확인</button>
        <button id="cancelDelete">취소</button>
      </div>
    </div>
  </div>
<!-- 찜 삭제확인 모달 확인 버튼 클릭시 모달 -->
  <div class="modal" id="chek_deleteModal">
    <div class="modal_box">
      <p>찜이 삭제 되었습니다.</p>
      <div class="modal_buttons">
        <button id="check_confirmDelete">확인</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
  <script>
    	let memberNumber = "${sessionScope.memberNumber}";
    </script>
</body>

</html>