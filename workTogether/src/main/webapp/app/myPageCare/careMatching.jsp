<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>매칭기록</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/include.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myPageCare/careMatching.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/myPageCare/careMatching.js"></script>
</head>

<body data-context-path="${pageContext.request.contextPath}" data-month="${month}">
  <jsp:include page="/header.jsp" />
  <header>

  </header>
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

      <div class="title"> 매칭 기록 </div>
      <!-- 페이지 월 분류 제목 -->

      <div class="matching_month">
        <ul class="months">
          <li class="month"><a data-month="1" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=1&page=1">1월</a></li>
          <li class="month"><a data-month="2" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=2&page=1">2월</a></li>
          <li class="month"><a data-month="3" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=3&page=1">3월</a></li>
          <li class="month"><a data-month="4" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=4&page=1">4월</a></li>
          <li class="month"><a data-month="5" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=5&page=1">5월</a></li>
          <li class="month"><a data-month="6" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=6&page=1">6월</a></li>
          <li class="month"><a data-month="7" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=7&page=1">7월</a></li>
          <li class="month"><a data-month="8" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=8&page=1">8월</a></li>
          <li class="month"><a data-month="9" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=9&page=1">9월</a></li>
          <li class="month"><a data-month="10" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=10&page=1">10월</a></li>
          <li class="month"><a data-month="11" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=11&page=1">11월</a></li>
          <li class="month"><a data-month="12" href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?month=12&page=1">12월</a></li>
        </ul>
        <!-- 매칭 페이지 원래 넣었던 값 (js 넣어서 이건 안나와요) -->
        <ul class="matching_list">
        	
        	<c:choose>
        		<c:when test="${not empty matchingList}">
        			<c:forEach var="match" items="${matchingList}">
        				<li class="matchingColumn">
            				<span class="matching_day">
              					<c:out value="${match.getMatchDate()}"/>
            				</span>
           					<span class="matching_member">
              					<c:out value="${match.getUsersName()}"/>
            				</span>
            				<span class="matching_time">
              					<c:out value="이용시간 : ${match.getMatchMatchTime()}"/>
            				</span>
            				<span class="matching_point">
              					포인트 사용: <c:out value="${match.getMatchPoints()}"/>
            				</span>
            				<span class="check">
            					<c:out value="${match.getMatchStatus()}"/>
            				</span>
        				</li>
        			</c:forEach>
        		</c:when>
        		<c:otherwise>
        			<li class="matchingColumnEmpty">
        				<div>매칭 기록이 없습니다</div>
        			</li>
        		</c:otherwise>
        	</c:choose>
        
<!--           <li class="matching">
            <div class="matching_day">
              2일
            </div>
            <div class="matching_member">
              김괭이
            </div>
            <div class="matching_time">
              이용 시간: 09:00 ~ 18:00
            </div>
            <div class="matching_point">
              포인트 사용: 10,000
            </div>
            <div class="check">
              완료 / 취소 / 진행중
            </div>
          </li> -->
          
          
          
          
        </ul>
      </div>
      <!-- 페이지네이션 -->
      <nav class="page">
        <ul>
          <c:if test="${prev}">
          	<li><a href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?page=${startPage - 1}" class="prev">&lt;</a></li>
          </c:if>
          <c:set var="realStartPage" value="${startPage < 0 ? 0 : startPage}" />
          <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
          	<c:choose>
          		<c:when test="${!(i == page) }">
          			<li><a href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?page=${i}">
          				<c:out value="${i}" />
          			</a></li>
          		</c:when>
          		<c:otherwise>
          			<li><a href="#" class="active">
          				<c:out value="${i}" />
          			</a></li>
          		</c:otherwise>
          	</c:choose>
          </c:forEach>
          <c:if test="${next}">
          	<li><a href="${pageContext.request.contextPath}/myPageCare/careMatching.cp?page=${endPage + 1}" class="next">&gt;</a>
          </c:if>
        </ul>

      </nav>
      <!-- 추가 버튼 클릭시 하단에 있는 모달창 출력 -->
      <div class="div_add">
        <button>추가</button>
      </div>
    </div>
  </main>
  <footer>

  </footer>
<!-- 추가 버튼을 클릭 시 아래의 모달 생성 -->
  <div class="modal" id="matching_add">
    <div class="modal_container">
      <h2> 매칭 추가 </h2>
      <form action="" method="get">
        <label for=""> 대상자: <input id="inputNormal" type="text" ></label><br>
        <label for=""> 날짜: <input id="inputDate" type="date"></label><br>
        <label for=""> 시간: <input id="inputTime" type="text"></label><br>
        <label for=""> 지급 P: <input id="inputPoint" type="text"></label><br>
        <div class="modal_button">
          <button type="submit" id="success_modal">등록</button>
          <button id="cansel_modal">취소</button>
        </div>
      </form>
    </div>
  </div>
  <!-- 매칭 추가 등록 버튼 클릭 시 나오는 모달 -->
  <div class="modal" id="complete_modal">
    <div class="modal_container">
      <p>매칭 정보가 등록되었습니다</p>
      <button id="success_button">확인</button>
    </div>
  </div>
  <jsp:include page="/footer.jsp" />

</body>

</html>