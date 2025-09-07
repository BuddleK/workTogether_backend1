<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>프로필 수정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careProfile.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careProfile.js"></script>
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
      <div class="title">프로필 수정</div>
      
      <div class="main_container">
      	<form class="main_form" action="${pageContext.request.contextPath}/myPageCare/careProfileUpdate.cp" method="post" enctype="multipart/form-data">

      		<!-- 마이페이지 사진 수정 -->
        	<div class="profile_section">
          		<img id="profilePreview"
  					src="${pageContext.request.contextPath}${profile.getProfilesFilesPath()}${profile.getProfilesFilesName()}${profile.getProfilesFilesType()}" 
  					onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/assets/img/myPageCare/default.png';" 
  					alt="프로필 이미지">
          		<input id="profileUpload" type="file" name="proPic">
        	</div>
		

          <div class="caremodify">
			<!-- 가능 요일 선택 칸 -->
            <div class="name_date">
              <div>요일</div>
              <div class="possible_date">
              	<input type="checkbox" id="mon" name="dayMonday"   value="Y" ${profile.dayMonday  eq 'Y' ? 'checked' : ''}>
    			<label for="mon" class="day-btn">월</label>

				<input type="checkbox" id="tue" name="dayTuesday"  value="Y" ${profile.dayTuesday eq 'Y' ? 'checked' : ''}>
				<label for="tue" class="day-btn">화</label>

				<input type="checkbox" id="wed" name="dayWednesday" value="Y" ${profile.dayWednesday eq 'Y' ? 'checked' : ''}>
				<label for="wed" class="day-btn">수</label>

				<input type="checkbox" id="thu" name="dayThursday" value="Y" ${profile.dayThursday eq 'Y' ? 'checked' : ''}>
				<label for="thu" class="day-btn">목</label>

				<input type="checkbox" id="fri" name="dayFriday"   value="Y" ${profile.dayFriday  eq 'Y' ? 'checked' : ''}>
				<label for="fri" class="day-btn">금</label>

				<input type="checkbox" id="sat" name="daySaturday" value="Y" ${profile.daySaturday eq 'Y' ? 'checked' : ''}>
				<label for="sat" class="day-btn">토</label>

				<input type="checkbox" id="sun" name="daySunday"   value="Y" ${profile.daySunday  eq 'Y' ? 'checked' : ''}>
				<label for="sun" class="day-btn">일</label>
              </div>
            </div>
			<!-- 이력 페이지 수정 칸 -->
            <div class="recode">
              <div>이력</div>
              <div class="reode_detail">
                <ul>
                  <li>
                    <label class="license" for="license"><c:out value="${profile.getLicenseFilesName()}"/></label>
                    <input type="file" id="license" placeholder="자격증 1">
                  </li>
                  <li>
                    <label class="license" for="manuscript"><c:out value="${profile.getAccountFilesName()}"/></label>
                    <input type="file" id="account" placeholder="계좌 사본">
                	<button type="button" id="request">수정 요청</button>
                  </li>
                </ul>
              </div>
            </div>
			<!-- 지역 수정 칸 -->
            <div class="place">
              <div>지역</div>
              <div class="palce_detail">
                <nav>
                  <ul>
                    <li><input name="usersPostsalCode" id="usersPostsalCode" type="text" placeholder="우편번호 입력" value="${profile.getUsersPostsalCode()}"></li>
                    <li>
                      <input name="usersAddressLine1" id="usersAddressLine1" type="text" placeholder="주소 입력" value="${profile.getUsersAddressLine1()}">
                      <button type="button" onclick="openPostcode()" id="find_post">우편번호 찾기</button>
                    </li>
                    <li>
                      <input name="usersAddressLine2" id="usersAddressLine2" type="text" placeholder="상세 주소"value="${profile.getUsersAddressLine2()}">
                    </li>
                  </ul>
                </nav>
              </div>
            </div>
			<!-- 소개글 수정 칸 -->
            <div class="introduce">
              <div>소개글</div>
              <div class="introduce_detail">
                <input name="careIntroText" type="text" placeholder="소개글을 입력하세요" value="${profile.getCareIntroText()}">
              </div>
            </div>
            
          </div>
          <button type="submit" id="check">확인</button>
        </form>
      </div>
    </div>
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<!-- 파일 첨부 버튼 클릭 시 파일 업로드 모달 출력-->
  <div id="uploadSuccessModal" class="modal">
    <div class="modal-content">
      <p>파일이 업로드 되었습니다.</p>
      <button id="uploadConfirmBtn" onclick="closeuploadSuccessModal()">확인</button>
    </div>
  </div>
<!-- 확인 버튼 클릭시 정보가 저장되었습니다 모달 -->
  <div id="saveSuccessModal" class="modal">
    <div class="modal-content">
      <p>정보가 저장되었습니다.</p>
      <button id="saveConfirmBtn">확인</button>
    </div>
  </div> 
<!-- 이력 수정 완료 버튼 클릭시 수정 신청 완료 모달 출력 -->
  <div id="proposeSuccessModal" class="modal">
    <div class="modal-content">
      <p>이력 수정 신청이 완료되었습니다.</p>
      <button id="saveConfirmBtn">확인</button>
    </div>
  </div>
  <!-- 우편번호 찾기 모달 -->
  <div id="findModal" class="modal">
    <div class="modal-content">
      <p>우편번호 찾기 api</p>
      <button id="saveConfirmBtn">확인</button>
    </div>
  </div>
  
  </main>
  <jsp:include page="/footer.jsp" />
</body>
    
    <!-- 수정 서블릿을 타고 왔다면.. -->
<c:if test="${updatedComplete}">
    <script>alert("수정이 완료되었습니다");</script>
</c:if>

</html>