<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

      <div class="title">프로필 수정</div>
<!-- 마이페이지 사진 수정 -->

      <div class="main_container">
        <ul class="profile_section">
          <img src="${pageContext.request.contextPath}/assets/img/myPageCare/peple.jpg" alt="사람사진">
          <input type="file">
        </ul>
<!-- 가능 요일 선택 칸 -->
        <form action="" method="get">
          <div class="caremodify">

            <div class="name_date">
              <div>요일</div>
              <div class="possible_date">
                <button>월</button>
                <button>화</button>
                <button>수</button>
                <button>목</button>
                <button>금</button>
                <button>토</button>
                <button>일</button>
                <button id="check">확인</button>
              </div>
            </div>
<!-- 이력 페이지 수정 칸 -->
            <div class="recode">
              <div>이력</div>
              <div class="reode_detail">
                <ul>
                  <li>
                    <label class="license" for="license"> 자격증 1 </label>
                    <input type="file" id="license" placeholder="자격증 1">
                  </li>
                  <li>
                    <label class="license" for="manuscript"> 계좌 사본 </label>
                    <input type="file" id="manuscript" placeholder="계좌 사본">
                  </li>
                  <li>
                    <label class="license" for="experience"> 주요 이력 </label>
                    <input type="text" id="experience" placeholder="이력">
                    <button class="confrim">확인</button>
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
                    <li><input type="text" placeholder="우편번호 입력"></li>
                    <li>
                      <input type="text" placeholder="주소 입력">
                      <button>우편번호 찾기</button>
                    </li>
                    <li>
                      <input type="text" placeholder="상세 주소" id="detail">
                      <button>확인</button>
                    </li>
                  </ul>
                </nav>
              </div>
            </div>

<!-- 소개글 수정 칸 -->
            <div class="introduce">
              <div>소개글</div>
              <div class="introduce_detail">
                <input type="text" placeholder="소개글을 입력하세요">
                <button>확인</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </main>
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
  <jsp:include page="/footer.jsp" />


</body>

</html>