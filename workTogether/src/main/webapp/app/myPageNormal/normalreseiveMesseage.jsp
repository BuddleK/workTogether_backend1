<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Messeage</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalreseiveMesseage.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalreseiveMesseage.js"></script>
</head>

<body>
  <div id="header"></div>
  <main>
    <!-- ë©ë´ ì¬ì´ëë° ì¹ì -->
    <nav class="main_sidebar">
      <ul>
        <li><img src="./../../assets/img/myPageNormal/normalMember.jpg" alt="#"></li>
        <li><a href="./normalPwCheck.html">ê°ì¸ì ë³´ ìì </a></li>
        <li><a href="./normalMark.html">ì°í ëª©ë¡</a></li>
        <li><a href="./normalheart.html">íí¸ ëª©ë¡</a></li>
        <li><a href="./normalMatching.html">ë§¤ì¹­ ê¸°ë¡</a></li>
        <li><a href="./normalsendMesseage.html">ìª½ì§í¨</a></li>
        <li><a href="./normalPost.html">ê²ìê¸ ê´ë¦¬</a></li>
        <li><a href="./normalPoint.html">í¬ì¸í¸ ì¶©ì </a></li>
        <li><a href="./normalReference.html">1 ë 1 ë¬¸ì</a></li>
        <li><a href="./normalQuit.html">íì íí´</a></li>
      </ul>
    </nav>
    <form action="" method="get">
      <div class="div_mark">
        <!-- ë©ë´ ì ëª© -->
        <div class="title">ìª½ì§í¨</div>
        <!-- ë°ì ìª½ì§, ë³´ë¸ ìª½ì§ë¡ ì´ë -->
        <nav class="div_choose">
          <ul> 
            <li class="send"><a href="./normalsendMesseage.html">ë°ì ìª½ì§</a></li>
            <li>|</li>
            <li class="reseive"><a href="./normalreseiveMesseage.html">ë³´ë¸ ìª½ì§</a></li>
          </ul>
        </nav>
        <nav class="mark_nav">
          <!-- ë³´ë¸ ìª½ì§ ì»¬ë¼ -->
          <ul>
            <li><input onclick="toggleMarksAll()" id="checkbox_col" name="mark_check_col" type="checkbox"></li>
            <li class="name_col">
              <div>ë³´ë¸ ì¬ë</div>
            </li>
            <li class="location_col">
              <div>ì ëª©</div>
            </li>
            <li class="phone_col">
              <div>ë ì§</div>
            </li>
            <li class="read_col">
              <div>ì½ì ìí</div>
            </li>
          </ul>
        </nav>
        <!-- ë³´ë¸ ìª½ì§ ëª©ë¡ ë¦¬ì¤í¸ -->
        <ul class="mark_list">
        </ul>
        <!-- íì´ì§ë¤ì´ì -->
        <nav class="page">
          <ul>
            <li><a href="">&lt;</a></li>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
            <li><a href="">4</a></li>
            <li><a href="">&gt;</a></li>
          </ul>
        </nav>
        <!-- ë³´ë¸ ìª½ì§ ì­ì  ë²í¼ -->
        <div class="div_delete">
          <button type="button" onclick="delMarks()" id="delete">ì­ì </button>
        </div>
      </div>
    </form>

  </main>
  <!-- ë³´ë¸ ìª½ì§ íì¸ ëª¨ë¬ -->
  <div class="modal">
    <div class="modal-content">
      <button id="sendxbutton">X</button>
      <p>ë³´ë¸ ìª½ì§ ì½ê¸°</p>
      <div class="sendmember">
        <div>ë°ë ì¬ë : íê¸¸ë | honggildong123</div>
      </div>
      <div class="content">
        <div>ìª½ì§ ë´ì©</div>
      </div>
      <button type="button" id="deleteBtn">ì­ì </button>
    </div>
  </div>

  <div id="footer"></div>
</body>

</html>