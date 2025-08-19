<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<div class="sidebar">
  <ul>
    <div class="blank"></div>
    <li class="side_attach">
      <a href="${pageContext.request.contextPath}/app/admin/userManager.html">
        회원관리
      </a>
    </li>
    <div class="board">
      <li class="side_attach">일반 게시글 관리</li>
      <ul class="side_menu side_normal_board">
        <li class="side_attach">
          <a href="${pageContext.request.contextPath}/app/admin/notice.html">
            공지사항 관리
          </a>
        </li>
        <li class="side_attach">
          <a href="${pageContext.request.contextPath}/app/admin/report.html">
            신고글 관리
          </a>
        </li>
      </ul>
    </div>
    </a>
    <div class="board">
      <li class="side_attach">뉴스 게시글 관리</li>
      <ul class="side_menu side_news_board">
        <li class="side_attach">
          <a href="${pageContext.request.contextPath}/app/admin/newsBoard.html">
            뉴스 게시물
          </a>
        </li>
        <li class="side_attach">
          <a href="${pageContext.request.contextPath}/app/admin/bannerBoard.html">
            배너 게시물
          </a>
        </li>
      </ul>
    </div>
    <li class="side_attach">
      <a href="${pageContext.request.contextPath}/app/admin/refund.html">
        돌봄회원 환급 관리
      </a>
    </li>
    <div class="board">
      <li class="side_attach">돌봄 회원 신청</li>
      <ul class="side_menu side_news_board">
        <li class="side_attach">
          <a href="${pageContext.request.contextPath}/app/admin/careRequest.html">
            신청 관리
          </a>
        </li>
        <li class="side_attach">
          <a href="${pageContext.request.contextPath}/app/admin/careCareer.html">
            수정 관리
          </a>
        </li>
      </ul>
    </div>
    <li class="side_attach">
      <a href="qeustion.html">
        1:1 문의사항
      </a>
    </li>
  </ul>
</div>

</html>