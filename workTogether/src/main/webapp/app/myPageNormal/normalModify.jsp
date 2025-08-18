<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Modify</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalModify.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalmodify.js"></script>
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
      <div class="title">ê°ì¸ì ë³´ ìì </div>
      <!-- ì£¼ìì¬í­ íì -->
      <div class="arlim">
        <nav>
          <ul>
            <li>ð ì í¬ í¨ê»ê±¸ìì íìëì ê°ì¸ ì ë³´ë¥¼ ì ì¤í ì·¨ê¸íë©°, íìëì ëì ìì´ ê¸°ì¬íì  íìì ë³´ë¥¼ ê³µê°íì§ ììµëë¤.</li>
            <li>íìëì ê°ì¸ ì ë³´ë¥¼ ìì íê² ë³´í¸íê¸° ìí´ ìµì ì ë¤íê³  ììµëë¤. </li>
            <li>íìëì ì ë³´ë¥¼ í¹ì í  ì ìë ê²ì ìë ¥ì ì§ìí´ ì£¼ìê¸¸ ë°ëëë¤.</li>
          </ul>
        </nav>
      </div>
      <!-- íì ì ë³´ ì¹ì -->
      <form action="" method="get">
        <div>
          <div>íì ì ë³´</div>
        </div>
        <nav class="normalmodify">
          <ul>
            <li class="member">
              <ul>
                <li class="info">ì±ëª</li>
                <li class="myinfo">ì´ë¦</li>
              </ul>
            </li>
            <li class="member">
              <ul>
                <li class="info">ìí</li>
                <li class="myinfo">ë ë²¨</li>
              </ul>
            </li>
            <li class="member">
              <ul>
                <li class="info">ì£¼ì</li>
                <li class="myinfo">
                  <ul>
                    <li><input type="text" placeholder="ì°í¸ë²í¸"></li>
                    <li><input type="text" placeholder="ì£¼ì"><button  type="button" id="mailbutton">ì°í¸ë²í¸ ì°¾ê¸°</button></li>
                    <li><input type="text" placeholder="ìì¸ì£¼ì"><button  type="button" id="addressbutton">íì¸</button></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li class="member">
              <ul>
                <li class="info">ì íë²í¸</li>
                <li class="myinfo"><input type="text" placeholder="010-1234-5678"><button type="button" id="phonebutton">ìì </button></li>
              </ul>
            </li>
            <li class="member">
              <ul>
                <li class="info">ìì´ë</li>
                <li class="myinfo">ìì´ë</li>
              </ul>
            </li>
            <li class="member">
              <ul>
                <li class="info">ì´ë©ì¼</li>
                <li class="myinfo"><input type="text" placeholder="ì´ë©ì¼"><button type="button" id="emailbutton">ìì </button></li>
              </ul>
            </li>
            <li class="member">
              <ul>
                <li class="info">ë¹ë°ë²í¸</li>
                <li class="myinfo">
                  <ul>
                    <li><input id="pwInput" type="password" placeholder="ë¹ë°ë²í¸ ìë ¥"></li>
                    <li><input id="newPwIntput" type="password" placeholder="ì ë¹ë°ë²í¸ ìë ¥"><button type="button" id="pwbutton">íì¸</button></li>
                    <li><div class="pwCheck" >ë¹ë°ë²í¸ê° ì¼ì¹íì§ììµëë¤</div></li>
                  </ul>
              </ul>
            </li>
          </ul>
        </nav>
      </form>
    </div>
  </main>
  <!-- ì ë³´ ìì  íì¸ ëª¨ë¬ë¤ -->
  <div class="modal_address">
    <div class="modal-content">
      <p>ì£¼ì ìì ì´ ìë£ ëììµëë¤.</p>
      <button type="button" onclick="openaddressModalClose()" id="saveConfirmBtn">íì¸</button>
    </div>
  </div>
  <div class="modal_email">
    <div class="modal-content">
      <p>ì´ë©ì¼ ìì ì´ ìë£ ëììµëë¤.</p>
      <button type="button" onclick="openemailModalClose()" id="saveConfirmBtn">íì¸</button>
    </div>
  </div>
  <div class="modal_pw">
    <div class="modal-content">
      <p>ë¹ë°ë²í¸ ìì ì´ ìë£ ëììµëë¤.</p>
      <button type="button" onclick="openpwModalClose()" id="saveConfirmBtn">íì¸</button>
    </div>
  </div> 
  <div class="modal_phone">
    <div class="modal-content">
      <p>ì íë²í¸ ìì ì´ ìë£ ëììµëë¤.</p>
      <button type="button" onclick="openphoneModalClose()" id="saveConfirmBtn">íì¸</button>
    </div>
  </div> 
  <div class="modal_mail">
    <div class="modal-content">
      <p>ì°í¸ë²í¸ ì°¾ê¸° api?</p>
      <button type="button" onclick="openmailModalClose()" id="saveConfirmBtn">íì¸</button>
    </div>
  </div>
  <div id="footer"></div>
</body>
</html>