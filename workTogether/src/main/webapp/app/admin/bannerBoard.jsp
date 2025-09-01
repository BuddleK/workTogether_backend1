<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>배너 게시글 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerAdmin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/bannerBoard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/sidebar.css" />
    <script defer src="${pageContext.request.contextPath}/assets/js/main/includeAdmin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/admin/admin.js"></script>
    <script defer src="${pageContext.request.contextPath}/assets/js/modal/modalDeleteNews.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modalAdmin.css" />
  </head>

  <body>
    <jsp:include page="/header_admin.jsp" />
    <main>
      <div id="sidebar"></div>
      <section class="userManager">
        <div class="searchcontent">
          <div class="title">
            <h1>배너 게시글 관리</h1>
          </div>
          <form action="" method="">
            <div class="searchbox">
              <select name="column" id="" class="search_column">
                <option value="number">번호</option>
                <option value="title">제목</option>
                <option value="date">작성일</option>
              </select>
              <input type="text" />
              <button>검색</button>
            </div>
          </form>
          <div class="table">
            <div class="board_column">
              <div class="board_head board_number">번호</div>
              <div class="board_head board_title">제목</div>
              <div class="board_head board_date">작성일</div>
            </div>
            <div class="table_content">
              <div class="table">
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href=".${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
                <ul class="table_body">
                  <li class="body_number">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">1</a>
                  </li>
                  <li class="body_content">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">뉴스 제목</a>
                  </li>
                  <li class="body_date">
                    <a href="${pageContext.request.contextPath}/app/admin/bannerDetail.jsp">2025-08-09</a>
                  </li>
                  <li class="body_delete">
                    <button class="delete_btn" onclick="modalDeleteNewsShow()">
                      삭제
                    </button>
                  </li>
                </ul>
              </div>
            </div>
            <div class="paging_box">
              <ul class="paging">
                <li class="prev">
                  <a href="#">&lt;</a>
                </li>
                <li class="page_number">
                  <a href="#">1</a>
                </li>
                <li class="page_number">
                  <a href="#">2</a>
                </li>
                <li class="page_number">
                  <a href="#">3</a>
                </li>
                <li class="page_number">
                  <a href="#">4</a>
                </li>
                <li class="page_number">...</li>
                <li class="next">
                  <a href="#">&gt;</a>
                </li>
              </ul>
              <div class="add">
                <a href="${pageContext.request.contextPath}/app/admin/bannerUpdate.jsp" class="add_btn"
                  >등록</a
                >
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>

    <jsp:include page="/footer.jsp" />
    <div id="modalDeleteNews"></div>
  </body>
</html>
