<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원 상세페이지(일반)</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/noticeDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/noticeDetail.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
  </head>
  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <section class="notice_detail">
        <div class="notice_info">
          <div class="info_title">
            <span class="title">안녕하세요</span>
          </div>
          <div class="member_info">
            <div class="member_name_title">작성자명</div>
            <div class="member_name">아무개</div>
            <div class="member_add_title">등록날짜</div>
            <div class="member_add_date">2025 - 08 - 04</div>
          </div>
          <div class="cnt">
            <div class="cnt_title">조회수</div>
            <div class="cnt_content">4</div>
          </div>
        </div>
        <div class="notice_content">
          <textarea name="content" id="content">
            이 좁은 세상에 나를 남겨두고
            홀로 떠나기가 얼마나 힘이 들었니
            못다 한 사랑은 잠시 가슴에 묻어둬
            머지않아 우린 다시 만날 테니까
            내일이 오면 그 고운 눈빛도
            추억으로 남을 테지만
            아무 걱정마, 이별없는 다음 세상에
            네가 먼저 가서 기다리면 되니까
            하늘 끝에서 흘린 눈물이
            비 되어 내리면
            나를 부르는 너의 목소리
            찾아 헤메이다
            나도 너를 따라서 세상 떠나는 날
            그때 한걸음에 내게 달려와
            내 품에 안겨줘
            커튼 사이로 별빛이 내려와
            뒤척이다 잠에서 깨면
            너의 얼굴이 어렴풋이 보이는 듯해
            사무치는 그리움에 목이 메어와
            하늘 끝에서 흘린 눈물이
            비 되어 내리면
            나를 부르는 너의 목소리
            찾아 헤메이다
            나도 너를 따라서 세상 떠나는 날
            그때 한걸음에 내게 달려와
            내 품에 안겨줘
            내가 그리워 힘이 들어도
            조금만 기다려
            나의 미소와 나의 숨결과
            지난 추억까지
            고이 가슴 한 켠에 묻어 두었다가
            그때 다시 만날 그날이 오면
            지워줄게</textarea
          >
        </div>
        <div class="notice_btn">
          <button class="list" onclick="cancle()" type="button">목록</button>
          <button class="update" onclick="modalUpdateShow()" type="button">
            수정
          </button>
        </div>
      </section>
    </main>
    <jsp:include page="/footer.jsp" />
    <div id="modalUpdate"></div>
  </body>
</html>
