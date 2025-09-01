<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 모달 컨테이너 -->
<div id="modal">
	<form action="${pageContext.request.contextPath}/careList/careSendMsgOk.cl" method="post">
		<!-- 모달 창 -->
		<div class="modal_window">
			<!-- 모달 바디 -->
			<div class="modal_body_confirm">
				<!-- 모달 닫기 버튼 -->
				<div class="modal_x_box">
					<img onclick="turnOffModal()" class="modal_x"
						src="${pageContext.request.contextPath}/assets/img/main/xIcon.png">
				</div>
				<!-- 모달 내용 -->
				<p id="modal_text">
					<!-- 돌봄회원 가입 반려 -->
					쪽지보내기
				</p>
				<!-- 보내는 사람 정보 -->
				<div class="letter_info">
				<input type="hidden" name="careNumber" value="${care.getUsersNumber() }">
					<span>받는 사람 : </span> <span id="writer_name"><c:out
							value="${care.getUsersName() }"></c:out></span><span> | </span>
					<span id="writer_id" > <c:out value="${care.getUsersId() }"></c:out>
					</span>
				</div>
				<!-- 내용 입력 창 -->
				<textarea name="message" id="letter_text"></textarea>
				<!-- 모달 버튼 박스 -->
				<div class="modal_button_box">
					<!-- 확인 버튼 -->
					<button type="submit" class="modal_check_button">
						확인</button>
					<!-- 취소 버튼 -->
				</div>
			</div>
		</div>
	</form>
</div>
