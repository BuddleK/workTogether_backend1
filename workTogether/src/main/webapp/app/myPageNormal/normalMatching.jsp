<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Matching</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalMatching.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalMatching.js"></script>
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
      <div class="title">ë§¤ì¹­ ê¸°ë¡</div>
      <form action="" method="get">
        <!-- ì íì -->
        <nav class="month">
          <ul>
            <li><a href="">1ì</a></li>
            <li><a href="">2ì</a></li>
            <li><a href="">3ì</a></li>
            <li><a href="">4ì</a></li>
            <li><a href="">5ì</a></li>
            <li><a href="">6ì</a></li>
            <li><a href="">7ì</a></li>
            <li><a href="">8ì</a></li> 
            <li><a href="">9ì</a></li>
            <li><a href="">10ì</a></li>
            <li><a href="">11ì</a></li>
            <li><a href="">12ì</a></li>
          </ul>
        </nav>
        <!-- ë§¤ì¹­ ê¸°ë¡ íì ì¹ì -->
        <nav class="matching">
          <ul>
            <li>
              <div>2ì¼ ê¹ê´­ì´ ëë´íì | ì´ì© ìê° : 09 : 00 ~ 18 : 00
              í¬ì¸í¸ ì¬ì© : 10,000</div>
              <div class="matchingbutton">
                <button type="button" id="complete">ì´ì©ìë£</button>
                <button type="button" id="cancel">ì·¨ì</button>
              </div>
            </li>
          </ul>
        </nav>
        <!-- ë§¤ì¹­ ê¸°ë¡ íì ì¹ì -->
        <nav class="matching">
          <ul>
            <li>
              <div>2ì¼ ê¹ê´­ì´ ëë´íì | ì´ì© ìê° : 09 : 00 ~ 18 : 00
                í¬ì¸í¸ ì¬ì© : 10,000</div>
              <div class="matchingbutton">
                <button type="button" id="complete">ì´ì©ìë£</button>
                <button type="button" id="cancel">ì·¨ì</button>
              </div>
            </li>
          </ul>
        </nav>
        <!-- ë§¤ì¹­ ê¸°ë¡ íì ì¹ì -->
        <nav class="matching">
          <ul>
            <li>
              <div>2ì¼ ê¹ê´­ì´ ëë´íì | ì´ì© ìê° : 09 : 00 ~ 18 : 00
                í¬ì¸í¸ ì¬ì© : 10,000</div>
              <div class="matchingbutton">
                <button type="button" id="complete">ì´ì©ìë£</button>
                <button type="button" id="cancel">ì·¨ì</button>
              </div>
            </li>
          </ul>
        </nav>
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
      </form>
    </div>
    
  </main>
  <div class="completemodal">
    <div class="modal-content">
      <p>ì´ì©ì´ ìë£ ëììµëë¤.</p>
      <button type="button" onclick="completeModalClose()" id="completeBtn">íì¸</button>
    </div>
  </div>
  <div class="cancelmodal">
    <div class="modal-content">
      <p>ì´ì©ì´ ì·¨ì ëììµëë¤.</p>
      <button type="button" onclick="cancelModalClose()" id="cancelBtn">íì¸</button>
    </div>
  </div>
  <div id="footer"></div>
</body>

</html>