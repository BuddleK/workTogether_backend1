<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Messeage</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageNormal/normalsendMesseage.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageNormal/normalsendMesseage.js"></script>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <main>
    <!-- 메뉴 사이드바 섹션 -->
    <nav class="main_sidebar">
      <ul>
        <li><img src="${pageContext.request.contextPath}/assets/img/myPageNormal/normalMember.jpg" alt="#"></li>
        <li><a href="${pageContext.request.contextPath}/normalPwCheck.jsp">개인정보 수정</a></li>
        <li><a href="${pageContext.request.contextPath}/normalMark.jsp">찜한 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalheart.jsp">하트 목록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalMatching.jsp">매칭 기록</a></li>
        <li><a href="${pageContext.request.contextPath}/normalsendMesseage.jsp">쪽지함</a></li>
        <li><a href="${pageContext.request.contextPath}/normalPost.jsp">게시글 관리</a></li>
        <li><a href="${pageContext.request.contextPath}/normalPoint.jsp">포인트 충전</a></li>
        <li><a href="${pageContext.request.contextPath}/normalReference.jsp">1 대 1 문의</a></li>
        <li><a href="${pageContext.request.contextPath}/normalQuit.jsp">회원 탈퇴</a></li>
      </ul>
    </nav>
    <form action="" method="get">
      <div class="div_mark">
        <!-- 메뉴 제목 -->
        <div class="title">쪽지함</div>
        <!-- 받은 쪽지, 보낸 쪽지 이동 -->
        <nav class="div_choose">
          <ul>
            <li class="send"><a href="${pageContext.request.contextPath}/normalsendMesseage.jsp">받은 쪽지</a></li>
            <li>|</li>
            <li class="reseive"><a href="${pageContext.request.contextPath}/normalreseiveMesseage.jsp">보낸 쪽지</a></li>
          </ul>
        </nav>
        <!-- 받은 쪽지 컬럼 -->
        <nav class="mark_nav">
          <ul>
            <li><input onclick="toggleMarksAll()" id="checkbox_col" name="mark_check_col" type="checkbox"></li>
            <li class="name_col">
              <div>보낸 사람</div>
            </li>
            <li class="location_col">
              <div>제목</div>
            </li>
            <li class="phone_col">
              <div>날짜</div>
            </li>
            <li class="read_col">
              <div>읽음 상태</div>
            </li>
          </ul>
        </nav>
        <!-- 받은 쪽지 목록 리스트 -->
        <ul class="mark_list">
        </ul>
        <!-- 페이지네이션 -->
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
        <!-- 받은 쪽지 삭제 버튼 -->
        <div class="div_delete">
          <button type="button" onclick="delMarks()" id="delete">삭제</button>
        </div>
      </div>
    </form>
  
  </main>
<!-- 쪽지 row 클릭시 나오는 모달창 -->
  <div class="modal_bg" id="msgModal">
    <div class="modal_box">
      <div class="modal_read">
        <span class="modal_title">받은 쪽지 읽기</span>
        <span class="modal_close" onclick="closeMsgModal()">&times;</span>
      </div>
      <div class="modal_info">
        <div class="sender_info">
          <span>보낸 사람 : </span>티라노사우루스 | <span class="sender_id">Trano</span>
        </div>
        <div class="message_content">
          나는나는 육식 공룡 풀떼기는 안먹지
        </div>
      </div>
      <!-- 해당 모달에 있는 모달창 -->
      <div class="modal_button">
        <button class="btn_reply">답장</button>
        <button class="btn_delete">삭제</button>
      </div>
    </div>
  </div>
  <!-- 답장 버튼 클릭 시 모달 출력 -->
  <div class="modal_bg" id="sendMsgModal">
    <div class="modal_box">
      <div class="modal_read">
        <span class="modal_title">쪽지 보내기</span>
        <span class="modal_close" onclick="closeSendMsgModal()">&times;</span>
      </div>
      <div class="modal_info">
        <div class="sender_info">
          <span>받는 사람 : </span>스태고사우루스 | <span class="sender_id">stago</span>
        </div>
        <textarea id="message_textarea" placeholder="내용을 입력하세요"></textarea>
      </div>
      <div class="modal_button">
        <button class="btn_send">보내기</button>
        <button class="btn_cancel">취소</button>
      </div>
    </div>
  </div>
  <!-- 보내기 버튼 클릭 시 모달 출력 -->
  <div class="modal_bg" id="sendSuccessModal">
    <div class="modal_box modal_send">
      <p class="send_message">쪽지를 보냈습니다.</p>
      <div class="modal_button">
        <button class="btn_confirm" onclick="closeSendModal()">확인</button>
      </div>
    </div>
  </div>
  <!-- 삭제 버튼 클릭 시 모달 출력 -->
  <div class="modal_bg" id="deleteMsgModal">
    <div class="modal_box confirm_modal">
      <p class="confirm_text">정말로 쪽지를 삭제하시겠습니까?</p>
      <div class="confirm_buttons">
        <button class="btn_confirm" onclick="confirmDelete()">확인</button>
        <button class="btn_cancel" onclick="closeDeleteModal()">취소</button>
      </div>
    </div>
  </div>
  <!-- 삭제 모달에서 확인 클릭시 모달 출력 -->
  <div class="modal_bg" id="sendSuccessModal">
    <div class="modal_box modal_send">
      <p class="send_message">쪽지가 삭제되었습니다.</p>
      <div class="modal_button">
        <button class="btn_confirm" onclick="closeSendModal()">확인</button>
      </div>
    </div>
  </div>
  <!-- 보낸 쪽지 페이지에서 사용하는 모달 -->
  <div class="modal_bg" id="sentMsgReadModal">
    <div class="modal_box read_modal">
      <div class="modal_header">
        <span class="modal_title">보낸 쪽지 읽기</span>
        <span class="modal_close" onclick="closeSentMsgModal()">&times;</span>
      </div>
    </div>
  </div>


  <jsp:include page="/footer.jsp" />
</body>
</html>