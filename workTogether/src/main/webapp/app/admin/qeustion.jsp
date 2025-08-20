<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>1:1 문의 사항 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/question.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
  </head>

  <body>
    <div id="header"></div>
    <main>
      <div id="sidebar"></div>
      <section class="userManager">
        <div class="searchcontent">
          <div class="title">
            <h1>1:1 문의 사항 관리</h1>
          </div>
          <form action="" method="">
            <div class="searchbox">
              <select name="column" id="" class="search_column">
                <option value="number">문의 번호</option>
                <option value="title">문의 제목</option>
                <option value="name">작성자</option>
                <option value="id">회원 아이디</option>
                <option value="date">신청 날짜</option>
                <option value="type">답변 여부</option>
              </select>
              <input type="text" />
              <button>검색</button>
            </div>
          </form>
          <div class="table">
            <div class="board_column">
              <div class="board_head board_number">문의 번호</div>
              <div class="board_head board_title">문의 제목</div>
              <div class="board_head board_name">작성자</div>
              <div class="board_head board_id">회원 아이디</div>
              <div class="board_head board_date">신청 날짜</div>
              <div class="board_head board_type">답변 여부</div>
            </div>
            <div class="table_content">
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">1</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >오늘 날씨가 좋네요</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">김옥순</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">abc123</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">Y</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >정마담한테는 밑에서 한장</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">고니</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">gstop</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">N</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">3</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >거 죽기 딱 좋은 날씨네</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">준구</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">helpplz</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">N</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">4</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >묻고 떠블로 가</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">곽철용</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">irondragon</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">N</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">5</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >모히또 가서 몰디브 한잔</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">이병헌</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">twohands</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">Y</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">6</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >어찌 내가 왕이 될 상인가</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">광해</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">slave02</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">Y</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">7</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >어이가 없네</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">유아인</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">understandguy</a
                  >
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">N</a>
                </li>
              </ul>
              <ul class="table_body">
                <li class="body_number">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">8</a>
                </li>
                <li class="body_title">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp"
                    >납득이 안가잔아 납득이</a
                  >
                </li>
                <li class="body_name">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">납득이</a>
                </li>
                <li class="body_id">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">bibibigo</a>
                </li>
                <li class="body_date">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">2025-08-09</a>
                </li>
                <li class="body_type">
                  <a href="${pageContext.request.contextPath}/app/admin/questionDetail.jsp">Y</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="paging_box">
            <ul class="paging">
              <li class="prev">
                <a href="">&lt;</a>
              </li>
              <li class="page_number">
                <a href="">1</a>
              </li>
              <li class="page_number">
                <a href="">2</a>
              </li>
              <li class="page_number">
                <a href="">3</a>
              </li>
              <li class="page_number">
                <a href="">4</a>
              </li>
              <li class="page_number">...</li>
              <li class="next">
                <a href="">&gt;</a>
              </li>
            </ul>
          </div>
        </div>
      </section>
    </main>

    <div id="footer"></div>
  </body>
</html>
