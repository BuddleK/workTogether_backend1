<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원 상세페이지(돌봄)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/careDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />

    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
    <script>
    	const contextPath = "${pageContext.request.contextPath}";
    </script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalEditName.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalDeleteMember.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalPointRefundLog.js"></script>
  </head>
  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <div id="sidebar"></div>
      <section class="detail_page">
        <div class="detail_box">
          <div class="detail_title">
            <h1>회원 정보</h1>
          </div>
          <form action="${pageContext.request.contextPath}/admin/adminUserNameUpdateOk.ad" method="post" class="detail_form">
            <div class="detail_content">
              <!-- 성명 -->
              <div class="detail_content_name">
                <div class="table_head_name">성명</div>
                <div class="table_name_detail">
                  <span id="name">${admin.usersName}</span>
                  <button onclick="modalEditNameShow()" type="button" style="cursor: pointer;">수정</button>
                </div>
                <!-- 회원 구분 -->
                <div class="table_member_type">
                  <div class="table_member_type_title"><p>회원 구분</p></div>
				    <!-- 일반 회원 -->
				    <label for="normal" class="type_label">
				        <input type="radio" name="member_type" id="normal" value="일반"
				               ${admin.usersType == 'N' ? 'checked="checked"' : ''} disabled/>
				        <p>일반</p>
				    </label>
				
				    <!-- 돌봄 회원 -->
				    <label for="care" class="type_label">
				        <input type="radio" name="member_type" id="care" value="돌봄"
				               ${admin.usersType == 'C' ? 'checked="checked"' : ''} disabled/>
				        <p>돌봄</p>
				    </label>
                </div>
                <!-- 가입 날짜 -->
                <div class="table_join_date">
                  <div class="table_join_title">가입날짜</div>
                  <div class="table_join_detail">${admin.usersCreatedDate}</div>
                </div>
              </div>
              <!-- 주소 -->
              <div class="detail_content_address">
                <div class="table_head table_head_address">주소</div>
                <div class="table_address_detail">
                  <input type="text" value="${admin.usersAddressLine1}" readonly />
                  <input type="text" value="${admin.usersAddressLine2}" readonly />
                </div>
              </div>
              <!-- 전화번호 -->
              <div class="detail_content_phone">
                <div class="table_head table_head_phone">전화번호</div>
                <div class="table_detail table_phone_detail">
                  <input type="text" value="${admin.usersPhone}" readonly />
                </div>
              </div>
              <!-- 이메일 -->
              <div class="detail_content_email">
                <div class="table_head table_head_email">이메일</div>
                <div class="table_detail table_email_detail">
                  <input type="text" value="${admin.usersEmail}" readonly />
                </div>
              </div>
              <!-- 아이디 -->
              <div class="detail_content_id">
                <div class="table_head table_head_id">아이디</div>
                <div class="table_detail table_id_detail">
                  <input type="text" value="${admin.usersId}" readonly />
                </div>
              </div>
              <!-- 비밀번호 -->
              <div class="detail_content_pw">
                <div class="table_head table_head_pw">비밀번호</div>
                <div class="table_detail table_pw_detail">
                  <input type="text" value="${admin.usersPassword}" readonly />
                </div>
              </div>
              <!-- 포인트 -->
              <div class="detail_content_point">
                <div class="table_head table_head_point">포인트 잔액</div>
                <div class="table_point_detail">
                  <input type="text" value="${admin.usersPoint}" readonly />
                  <button onclick="modalPointRefundLogShow()" type="button">환급내역 조회</button>
                </div>
              </div>
              <!-- 계좌 -->
              <div class="detail_content_account">
				  <div class="table_head_account">계좌 수정</div>
				  <div class="table_detail table_pw_detail">
				    <input type="text" id="passbookInput" placeholder="${admin.usersPassbook}" />
				    <button class="update_btn" type="button" onclick="updatePassbook()" style="cursor: pointer;">수정</button>
				  </div>
			  </div>

            </div>
            <!-- 회원 삭제 -->
            <div class="delete">
              <button type="button" class="delete_btn" onclick="modalDeleteMemberShow()" style="cursor: pointer;">삭제</button>
            </div>
            
          </form>
          <!-- 이름 수정 전송용 hidden form -->
			<form id="editNameForm" action="${pageContext.request.contextPath}/admin/adminUserNameUpdateOk.ad" method="post">
			    <input type="hidden" name="usersNumber" value="${admin.usersNumber}" />
			
			    <!-- 모달에서 입력받은 이름 값 담는 hidden input -->
			    <input type="hidden" name="usersName" id="hiddenNewName" />
			</form>
			
			<form id="editPassbookForm" action="${pageContext.request.contextPath}/admin/adminUserPassbookUpdateOk.ad" method="post">
			  <input type="hidden" name="usersNumber" value="${admin.usersNumber}" />
			  <input type="hidden" name="usersPassbook" id="hiddenNewPassbook" />
			</form>
			
			<form id="deleteMemberForm" action="${pageContext.request.contextPath}/admin/adminUserDeleteOk.ad"
			      method="post">
			  <input type="hidden" name="usersNumber" value="${admin.usersNumber}" />
			</form>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
    <div id="modalEditName"></div>
    <div id="modalDeleteMember"></div>
    <div id="modalPointRefundLog"></div>
  </body>
</html>
