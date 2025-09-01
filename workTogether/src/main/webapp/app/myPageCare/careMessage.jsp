<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Care_Messeage</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careMessage.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careMessage.js"></script>
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
      <!-- 페이지 받은 쪽지 보낸 쪽지 클릭 가능 -->

      <nav class="div_choose">
        <ul>
          <li class="send"><a href="${pageContext.request.contextPath}/careMessage.jsp"><strong>받은 쪽지</strong></a></li>
          <li>|</li>
          <li class="reseive"><a href="${pageContext.request.contextPath}/careMessageReturn.jsp">보낸 쪽지</a></li>
        </ul>

      </nav>
      <!-- 페이지 분류 제목 -->
      <nav class="mark_nav">
        <ul>
          <li><input type="checkbox"></li>
          <li class="name">
            <div>보낸 사람</div>
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
<!-- 쪽지 게시글 상세 페이지  -->
      <nav class="mark_list">
        <ul>
          <li><input type="checkbox"></li>
          <li class="name"><a href="">
              <div>티라노사우루스</div>
            </a></li>
          <li class="messeagetitle"><a href="">
              <div>나는 티라노</div>
            </a></li>
          <li class="day"><a href="">
              <div>2025-08-10</div>
            </a></li>
          <li class="read"><a href="">
              <div>읽음</div>
            </a></li>
        </ul>
      </nav>
      <!-- 쪽지 게시글 상세 페이지  -->

      <nav class="mark_list">
        <ul>
          <li><input type="checkbox"></li>
          <li class="name"><a href="">
              <div>보낸 사람</div>
            </a></li>
          <li class="messeagetitle"><a href="">
              <div>제목</div>
            </a></li>
          <li class="day"><a href="">
              <div>날짜</div>
            </a></li>
          <li class="read"><a href="">
              <div>읽음 상태</div>
            </a></li>
        </ul>
      </nav>
      <!-- 쪽지 게시글 상세 페이지  -->

      <nav class="mark_list">
        <ul>
          <li><input type="checkbox"></li>
          <li class="name"><a href="">
              <div>보낸 사람</div>
            </a></li>
          <li class="messeagetitle"><a href="">
              <div>제목</div>
            </a></li>
          <li class="day"><a href="">
              <div>날짜</div>
            </a></li>
          <li class="read"><a href="">
              <div>읽음 상태</div>
            </a></li>
        </ul>
      </nav>
      <!-- 쪽지 게시글 상세 페이지  -->

      <nav class="mark_list">
        <ul>
          <li><input type="checkbox"></li>
          <li class="name"><a href="">
              <div>보낸 사람</div>
            </a></li>
          <li class="messeagetitle"><a href="">
              <div>제목</div>
            </a></li>
          <li class="day"><a href="">
              <div>날짜</div>
            </a></li>
          <li class="read"><a href="">
              <div>읽음 상태</div>
            </a></li>
        </ul>
      </nav>
      <!-- 페이지 네이션  -->
      <nav class="page">
        <ul>
          <li>&lt;</li>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>&gt;</li>
        </ul>

      </nav>
      <!-- 삭제 버튼 클릭 시 쪽지 삭제 -->
      <div class="div_delete">
        <button class="btn_list_delete">삭제</button>
      </div>
    </div>
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