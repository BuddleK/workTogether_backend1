<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Quit</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalQuit.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalQuit.js"></script>
</head>
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
    <div class="div_mark">
      <!-- ë©ë´ ì ëª© -->
      <div class="title">íì íí´</div>
      <!-- ì£¼ìì¬í­ íì -->
      <div class="arlim">
        <nav>
          <ul>
            <li>ð ë ì´ìì ì´ì©ì ìíì§ ìë ë¶íìí ì¬ì´í¸ì ëí íì íí´ ì²ë¦¬</li>
            <li class="li_color">Â· ë³¸ ìë¹ì¤ë ë³¸ì¸ì¸ì¦ ë´ì­ì ê¸°ë°ì¼ë¡ ì ê³µëë ìë¹ì¤ë¡, íì íí´ì 60ì¼ê° íìê°ìì´ ë¶ê°íë©° ê·¸ì ë°ë¥¸ ë¶ì´ìµì ì±ì ì§ì§ ììµëë¤. </li>
            <li class="li_color">Â· íì íí´ì ë³´ì í í¬ì¸í¸ë ì ë¶ ìë©¸ ë©ëë¤.</li>
          </ul>
        </nav>
      </div>
      <form action="" method="get">
        <!-- íì íí´ ë°ì¤ -->
        <div class="exit-box">
          <div class="exit-row">
            <div class="exit-label">íí´ ë ì§</div>
            <div class="exit-value">2025 - 08 - 03</div>
          </div>
          <div class="exit-row">
            <div class="exit-label">íí´ ì¬ì </div>
            <div class="exit-value">
              <select class="exit-select">
                <option disabled selected>íí´ ì¬ì ë¥¼ ìë ¥íì¬ ì£¼ì­ìì¤.</option>
                <option>ìë¹ì¤ ì´ì© ë¶í¸</option>
                <option>ê°ì¸ì ë³´ ì°ë ¤</option>
                <option>ì¬ê°ì ìì  ìì</option>
                <option>ê¸°í</option>
              </select>
            </div>
          </div>
        </div>
        <!-- íí´íê¸° ë²í¼ -->
        <button type="button" onclick="openQuitModal()" id="next">ë¤ì</button>
      </form>
    </div>
  </main>
  <!-- íì¸ ëª¨ë¬ì°½ -->
  <div class="checkmodal" id="checkModal">
    <div class="modal_box">
      <p>ì ë§ë¡ íì íí´ë¥¼ ì§ííìê² ìµëê¹?</p>
      <p>â»ë¯¸ì¬ì© í¬ì¸í¸ë ìë©¸ë©ëë¤</p>
      <div class="modal_buttons">
        <button type="button" onclick="showDoneModal()" id="checkBtn">íì¸</button>
        <button type="button" onclick="cancelQuit()" id="cancelBtn">ì·¨ì</button>
      </div>
    </div>
  </div>
  <!-- ìë£ ëª¨ë¬ì°½ -->
  <div class="modal" id="doneModal">
    <div class="modal_box">
      <p>ì±ê³µì ì¼ë¡ íìì íí´ íì¨ìµëë¤.</p>
      <div class="modal_buttons">
        <a href="./../../main.html"><button type="button" id="doneOkBtn">íì¸</button></a>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>

</html>