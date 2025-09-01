<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="modal">
  <!-- 모달 바탕 -->
  <div class="modal_window">
    <!-- 모달 바디 -->
    <div class="modal_body_confirm">
      <!-- X 버튼 -->
      <div class="modal_x_box">
        <img onclick="careMemberModalLoginNone()" class="modal_x" src="${pageContext.request.contextPath}/assets/img/main/xIcon.png">
      </div>
      <!-- 모달 내용 -->
      <p id="modal_text">
        로그인이 필요합니다.
      </p>
      <!-- 버튼 영역 -->
      <div class="modal_button_box">
        <!-- 확인 버튼 -->
        <button onclick="careMemberModalLoginCheck()" class="modal_check_button">
          확인
        </button>
      </div>
    </div>
  </div>
</div> 