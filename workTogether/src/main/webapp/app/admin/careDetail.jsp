<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원 상세페이지(일반)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/careDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalEditName.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalDeleteMember.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalPointRefundLog.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
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
          <form action="" method="" class="detail_form">
            <div class="detail_content">
              <div class="detail_content_name">
                <div class="table_head_name">성명</div>
                <div class="table_name_detail">
                  <span id="name">슬립핑</span>
                  <button onclick="modalEditNameShow()" type="button">
                    수정
                  </button>
                </div>
                <div class="table_member_type">
                  <div class="table_member_type_title">
                    <p>회원 구분</p>
                  </div>
                  <label for="normal" class="type_label">
                    <input
                      type="radio"
                      name="member_type"
                      id="normal"
                      checked
                    />
                    <p>일반</p>
                  </label>
                  <label for="care" class="type_label">
                    <input type="radio" name="member_type" id="care" />
                    <p>돌봄</p>
                  </label>
                </div>
                <div class="table_join_date">
                  <div class="table_join_title">가입날짜</div>
                  <div class="table_join_detail">2025-08-02</div>
                </div>
              </div>
              <div class="detail_content_address">
                <div class="table_head table_head_address">주소</div>
                <div class="table_address_detail">
                  <input type="text" readonly />
                  <input type="text" readonly />
                </div>
              </div>
              <div class="detail_content_phone">
                <div class="table_head table_head_phone">전화번호</div>
                <div class="table_detail table_phone_detail">
                  <input type="text" readonly />
                </div>
              </div>
              <div class="detail_content_email">
                <div class="table_head table_head_email">이메일</div>
                <div class="table_detail table_email_detail">
                  <input type="text" readonly />
                </div>
              </div>
              <div class="detail_content_id">
                <div class="table_head table_head_id">아이디</div>
                <div class="table_detail table_id_detail">
                  <input type="text" readonly />
                </div>
              </div>
              <div class="detail_content_pw">
                <div class="table_head table_head_pw">비밀번호</div>
                <div class="table_detail table_pw_detail">
                  <input type="text" readonly />
                </div>
              </div>
              <div class="detail_content_point">
                <div class="table_head table_head_point">포인트 잔액</div>
                <div class="table_point_detail">
                  <input type="text" readonly />
                  <button onclick="modalPointRefundLogShow()" type="button">
                    환급내역 조회
                  </button>
                </div>
              </div>
              <div class="detail_content_account">
                <div class="table_head_account">계좌 수정</div>
                <div class="table_detail table_pw_detail">
                  <input type="text" placeholder="카카오뱅크 3333-05-8985942" />
                  <button class="update_btn" type="button">수정</button>
                </div>
              </div>
            </div>
            <div class="delete">
              <button
                type="button"
                class="delete_btn"
                onclick="modalDeleteMemberShow()"
              >
                삭제
              </button>
            </div>
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
