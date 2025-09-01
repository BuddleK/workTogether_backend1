<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_Post</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/carePost.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/carePost.js"></script>
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


      <div class="div_mark">
            <!-- 마이페이지 제목 -->

        <div class="title">게시글 관리</div>
        <!-- 페이지 세부 정보 -->

        <nav class="div_choose">
          <ul>
            <li>작성한 게시글 목록</li>
          </ul>
        </nav>
        <!-- 페이지 분류 제목 -->
        <nav class="mark_nav">
          <ul>
            <li><input type="checkbox"></li>
            <li class="name">
              <div>작성자</div>
            </li>
            <li class="posttitle">
              <div>제목</div>
            </li>
            <li class="day">
              <div>날짜</div>
            </li>
          </ul>
        </nav>
        <!-- 게시글 글 목록 -->
        <nav class="mark_list">
            <ul>
              <li><input type="checkbox"></li>
              <li class="name"><a href="${pageContext.request.contextPath}/myPageCare/carePostDP.jsp">
                <div>아무개</div>
              </a></li>
              <li class="posttitle"><a href="${pageContext.request.contextPath}/myPageCare/carePostDP.jsp">
                <div>안녕하세요</div>
              </a></li>
              <li class="day"><a href="${pageContext.request.contextPath}/myPageCare/carePostDP.jsp">
                <div>2025-08-11</div>
              </a></li>
          
          </ul>
        </nav>
                <!-- 게시글 글 목록 -->

        <nav class="mark_list">
          <ul>
            <li><input type="checkbox"></li>
            <li class="name"><a href="">
                <div>작성자</div>
              </a></li>
            <li class="posttitle"><a href="">
                <div>제목</div>
              </a></li>
            <li class="day"><a href="">
                <div>날짜</div>
              </a></li>
          </ul>
        </nav>
                <!-- 게시글 글 목록 -->

        <nav class="mark_list">
          <ul>
            <li><input type="checkbox"></li>
            <li class="name"><a href="">
                <div>작성자</div>
              </a></li>
            <li class="posttitle"><a href="">
                <div>제목</div>
              </a></li>
            <li class="day"><a href="">
                <div>날짜</div>
              </a></li>
          </ul>
        </nav>
                <!-- 게시글 글 목록 -->

        <nav class="mark_list">
          <ul>
            <li><input type="checkbox"></li>
            <li class="name"><a href="">
                <div>작성자</div>
              </a></li>
            <li class="posttitle"><a href="">
                <div>제목</div>
              </a></li>
            <li class="day"><a href="">
                <div>날짜</div>
              </a></li>
          </ul>
        </nav>
<!-- 페이지네이션 -->
        <nav class="page">
          <ul>
            <a href="">
              <li>&lt;</li>
            </a>
            <a href="">
              <li>1</li>
            </a>
            <a href="">
              <li>2</li>
            </a>
            <a href="">
              <li>3</li>
            </a>
            <a href="">
              <li>4</li>
            </a>
            <a href="">
              <li>&gt;</li>
            </a>
          </ul>
        </nav>
        <!-- 버튼 삭제 버튼 -->
        <div class="div_delete">
          <button class="btn_list_delete">삭제</button>
        </div>
      </div>

  </main>
  <!-- 게시글 삭제 모달 -->
  <div class="modal" id="deleteModal">
    <div class="modal_box">
      <p>정말로 게시글을 삭제하시겠습니까?</p>
      <div class="modal_buttons">
        <button id="confirmDelete">확인</button>
        <button id="cancelDelete">취소</button>
      </div>
    </div>
  </div>
<!-- 게시글 삭제 확인 버튼 클릭시 출력 모달 -->
  <div class="modal" id="chek_deleteModal">
    <div class="modal_box">
      <p>게시글이 삭제 되었습니다.</p>
      <div class="modal_buttons">
        <button id="check_confirmDelete">확인</button>
      </div>
    </div>
  </div>
<!-- 체크 박스에 표시 없을 때 확인 -->
  <div class="modal" id="checkModal">
    <div class="modal_box">
      <p>삭제할 쪽지를 선택하세요</p>
      <div class="modal_buttons">
        <button id="confirmDelete_check">확인</button>
      </div>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />
</body>

</html>
