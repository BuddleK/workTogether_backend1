<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>care_Messeagereturn</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careMessageReturn.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careMessageReturn.js"></script>
</head>

<body>
  <jsp:include page="/header.jsp" />
  <main>
          <!-- 마이페이지 사이드 바 목록과 이동 경로 -->

    <nav class="sidebar">
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

    <div class="div_mark">
          <!-- 마이페이지 제목 -->

      <div class="title">쪽지함</div>
      <!-- 받은 쪽지와 보낸 쪽지로 이동 할 수 있는 칸 -->
      <nav class="div_choose">
        <ul>
          <li class="send"><a href="${pageContext.request.contextPath}/myPageCare/careMesseage.cp">받은 쪽지</a></li>
          <li>|</li>
          <li class="reseive"><a href="${pageContext.request.contextPath}/myPageCare/careSendMesseage.cp"><strong>보낸 쪽지</strong></a></li>
        </ul>
      </nav>
      <!-- 페이지 분류 창 -->
      <nav class="mark_nav">
        <ul>
          <li><input type="checkbox"></li>
          <li class="name">
            <div>받은 사람</div>
          </li>
          <li class="messeagetitle">
            <div>제목</div>
          </li>
          <li class="day">
            <div>날짜</div>
          </li>
          <li class="read">
            <div>읽음 상태</div>
          </li>
        </ul>
      </nav>
      
      
      
      <c:choose>
      	<c:when test="${not empty rMessageList}">
      		<c:forEach var="rMessage" items="${rMessageList}">
      
			<!-- 쪽지 게시글 상세 페이지  -->
		      <nav class="mark_list" data-messageNumber="${rMessage.getMessageNumber()}" >
		        <ul>
		          <li><input type="checkbox"></li>
		          <li class="name"><a href="">
		              <div><c:out value="${rMessage.getUsersName()}" /></div>
		            </a></li>
		          <li class="messeagetitle"><a href="">
		              <div><c:out value="${rMessage.getMessageContents()}" /></div>
		            </a></li>
		          <li class="day"><a href="">
		              <div><c:out value="${rMessage.getMessageDate()}" /></div>
		            </a></li>
		          <li class="read"><a href="">
		              <div><c:out value="${rMessage.getIsRead()}" /></div>
		            </a></li>
		        </ul>
		      </nav>
      		
      		</c:forEach>
      		
      	</c:when>
      	<c:otherwise>
      	</c:otherwise>
      </c:choose>
      
<!-- 페이지 네이션 -->
      <nav class="page">
           <ul>
            <c:if test="${prev}">
          		<li><a href="${pageContext.request.contextPath}/myPageCare/careSendMesseage.cp?page=${startPage - 1}" class="prev">&lt;</a></li>
          	</c:if>
          	<c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
          	<c:forEach var="i" begin="${realStartPage}" end="${endPage}">
          		<c:choose>
          			<c:when test="${!(i == page) }">
          				<li><a href="${pageContext.request.contextPath}/myPageCare/careSendMesseage.cp?page=${i}">
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
          		<li><a href="${pageContext.request.contextPath}/myPageCare/careSendMesseage.cp?page=${endPage + 1}" class="next">&gt;</a>
          	</c:if>
          </ul>

      </nav>
      <!-- 삭제 버튼 -->
      <div class="div_delete">
        <button class="btn_list_delete">삭제</button>
      </div>
    </div>


  </main>
  <!-- 삭제버튼 클릭 시 출력되는 모달 -->
  <div class="modal_bg" id="deleteMsgModal">
    <div class="modal_box confirm_modal">
      <p class="confirm_text">정말로 쪽지를 삭제하시겠습니까?</p>
      <div class="confirm_buttons">
        <button class="btn_confirm" onclick="confirmDelete()">확인</button>
        <button class="btn_cancel" onclick="closeDeleteModal()">취소</button>
      </div>
    </div>
  </div>
<!-- 삭제 확인 모달에서 확인 버튼 클릭시 나오는 모달 -->
  <div class="modal_bg" id="sendSuccessModal">
    <div class="modal_box modal_send">
      <p class="send_message">쪽지가 삭제되었습니다.</p>
      <div class="modal_button">
        <button class="btn_confirm" onclick="closeSendModal()">확인</button>
      </div>
    </div>
  </div>
  <!-- 리스트 클릭 시 보낸 쪽지 내용 출력 모달 -->
  <div id="msgModal" class="modal_bg">
    <div class="modal_box">
      <div class="modal_read">
        <span class="modal_title">보낸 쪽지 내용</span>
        <span class="modal_close">&times;</span>
      </div>
      <div class="modal_info">
        <div class="receiver_info">
          <span>받는 사람 : </span><span class="receiver_name">장성규</span> | <span class="receiver_id">JangJang</span>
        </div>
        <div class="message_content">
          오늘 이렇게 연락을 드린 건 다름이 아니고...
        </div>
      </div>
      <!-- 삭제 버튼 클릭시 삭제 -->
      <div class="modal_button">
        <button class="btn_delete">삭제</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>

</html>