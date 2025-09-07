<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <% session.setAttribute("usersNumber", 2); %>  --%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_Modify</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careProfile.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careModify.js"></script>
</head>
</head>

<body>
  <jsp:include page="/header.jsp" />
    <!-- 우편번호 팝업 -->
  <script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
	function openPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						document.getElementById("usersPostsalCode").value = data.zonecode
								|| "";
						document.getElementById("usersAddressLine1").value = data.roadAddress
								|| data.jibunAddress || "";
						document.getElementById("usersAddressLine2").focus();
					}
				}).open();
	}
</script>
  <main>
    <!-- 마이페이지 사이드 바 목록과 이동 경로 -->
    <nav class="sidebar">
      <ul>
        <li>
        	<a href="${pageContext.request.contextPath}/myPageCare/careProfile.cp">
          		<img 
  				src="${pageContext.request.contextPath}${profilePic.getProfilesFilesPath()}${profilePic.getProfilesFilesName()}${profilePic.getProfilesFilesType()}" 
  				onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/assets/img/myPageCare/default.png';" 
  				alt="프로필 이미지">
        	</a>
        </li>
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
    	<div class="title">개인정보 수정</div>
    	
    <div class="main_container">
      <!-- 알림 정보 -->
      <div class="modNotice">
        <div class="mod_script">
        	<p>저희 함께걸음은 회원님의 개인 정보를 신중히 취급하며, 회원님의 동의 없이 기재하신 회원정보를 공개하지 않습니다.</p>
        	<p>회원님의 개인 정보를 안전하게 보호하기 위해 최선을 다하고 있습니다.</p>
        	<p>회원님의 정보를 특정할 수 있는 것은 입력을 지양해 주시길 바랍니다.</p>
        </div>
      </div>
      <!-- 페이지 세부 정보 수정-->

      <form action="${pageContext.request.contextPath}/myPageCare/careModify.cp" method="post"
      data-context-path="${pageContext.request.contextPath}" novalidate>
        <!-- 수정하는 것의 제목 -->
        <div>회원 정보</div>
        <div class="caremodify">
        	<div class="mod">
        		<div>성명</div>
        		<div><c:out value="${careModify.getUsersName()}" /></div>
        	</div>
        	<div class="mod">
        		<div>주소</div>
        		<div>
                  <ul>
                    <li><input name="usersPostsalCode" id="usersPostsalCode" type="text" placeholder="우편번호 입력" value="${careModify.getUsersPostsalCode()}"></li>
                    <li>
                      <input name="usersAddressLine1" id="usersAddressLine1" type="text" placeholder="주소 입력" value="${careModify.getUsersAddressLine1()}">
                      <button type="button" onclick="openPostcode()" id="find_post">우편번호 찾기</button>
                    </li>
                    <li>
                      <input name="usersAddressLine2" id="usersAddressLine2" type="text" placeholder="상세 주소"value="${careModify.getUsersAddressLine2()}">
                    </li>
                  </ul>
        		</div>
        	</div>
        	<div class="mod">
        		<div>전화번호</div>
        		<div>
        			<input name="usersPhone" id="usersPhone" type="text" placeholder="- 기호 없이 11자리 입력" value="${careModify.getUsersPhone()}">
        		</div>
        	</div>
        	<div class="mod">
        		<div>아이디</div>
        		<div>
        			<c:out value="${careModify.getUsersId()}"/>
        		</div>
        	</div>
        	<div class="mod">
        		<div>이메일</div>
        		<div>
        			<input name="usersEmail" id="usersEmail" type="text" placeholder="이메일 입력" value="${careModify.getUsersEmail()}">
        			<p class="err_message" id="email_error">형식에 맞게 입력해 주세요.</p>
        		</div>
        	</div>
        	<div class="mod">
        		<div>비밀번호 수정</div>
        		<div>
                  <ul>
                    <li>
                      <input type="password" placeholder="비밀번호 8자리 입력(숫자와 영어 특수기호 포함)" id="rePw">
                      <p class="err_message" id="password_error">형식에 맞게 입력해 주세요.</p>
                    </li>
                    <li>
                      <input type="password" placeholder="비밀번호 재입력" id="reCheckPw">
                      <p class="err_message" id="re_password_error">비밀번호가 일치하지 않습니다.</p>
                    </li>
                  </ul>
        		</div>
        	</div>
        </div>
          <button type="button" id="check">확인</button>
  			<!-- 모든 확인 버튼 클릭시 정보 저장 모달 출력 -->
 			 <div id="saveSuccessModal" class="modal">
    			<div class="modal-content">
      				<p>정보가 저장되었습니다.</p>
      				<button id="saveConfirmBtn">확인</button>
    			</div>
  			</div>
  			 <div id="notCorecetModal" class="modal">
    			<div class="modal-content">
      				<p>비밀번호가 맞지 않습니다.</p>
      				<button id="CorrectBtn">확인</button>
    			</div>
  			</div>
      </form>
    </div><!-- main_container 끝 -->
    </div>
  </main>

  <jsp:include page="/footer.jsp" />
</body>
<script>
/*     	let usersNumber = "${sessionScope.usersNumber}"; */
</script>
</html>