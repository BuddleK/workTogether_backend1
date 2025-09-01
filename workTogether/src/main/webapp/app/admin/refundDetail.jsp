<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>돌봄회원 환급 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/refundDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalRefundFinished.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
  </head>
  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <div id="sidebar"></div>
      <section class="care_box">
        <div class="box_title">
          <h1>돌봄회원 환급 관리</h1>
        </div>
        <form action="" method="" class="table_form">
          <div class="table">
            <div class="thead">
              <div class="thead_content thead_name">성명</div>
              <div class="thead_content thead_bank">은행</div>
              <div class="thead_content thead_account">계좌번호</div>
              <div class="thead_content thead_point">환급 신청 포인트</div>
              <div class="thead_content thead_left_point">잔여 포인트</div>
            </div>
            <div class="tbody">
              <div class="tbody_content tbody_name">홍길동</div>
              <div class="tbody_content tbody_bank">카카오뱅크</div>
              <div class="tbody_content tbody_account">3333-05-8985754</div>
              <div class="tbody_content tbody_point">5000P</div>
              <div class="tbody_content tbody_left_point">2750P</div>
            </div>
          </div>
          <div class="btn_area">
            <button class="cancle" onclick="cancle()" type="button">
              취소
            </button>
            <button
              class="submit"
              onclick="modalRefundFinishedShow()"
              type="button"
            >
              환급 완료
            </button>
          </div>
        </form>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
    <div id="modalRefundFinished"></div>
  </body>
</html>
