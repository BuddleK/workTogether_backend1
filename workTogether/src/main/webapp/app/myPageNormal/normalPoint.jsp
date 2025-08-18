<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Point</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalPoint.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalPoint.js"></script>
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
      <!-- ì£¼ìì¬í­  íì-->
      <div class="arlim">
        <nav>
          <ul>
            <li>ðì í¬ í¨ê»ê±¸ìì íìëì ê°ì¸ ì ë³´ë¥¼ ì ì¤í ì·¨ê¸íë©°, íìëì ëì ìì´ ê¸°ì¬íì  íìì ë³´ë¥¼ ê³µê°íì§ ììµëë¤.</li>
            <li>íìëì ê°ì¸ ì ë³´ë¥¼ ìì íê² ë³´í¸íê¸° ìí´ ìµì ì ë¤íê³  ììµëë¤. </li>
            <li>íìëì ì ë³´ë¥¼ í¹ì í  ì ìë ê²ì ìë ¥ì ì§ìí´ ì£¼ìê¸¸ ë°ëëë¤.</li>
          </ul>
        </nav>
      </div>
      <form action="" method="get"> 
        <!-- í¬ì¸í¸  ì¶©ì , ì¶©ì  ë´ì­ ì¹ì -->
        <div class="point_have">
          <div class="point_have_title">í¬ì¸í¸ ìì¡</div>
          <div class="point_point">10000 í¬ì¸í¸</div>
          <div class="button">
            <button type="button" id="chargeBtn">í¬ì¸í¸ ì¶©ì </button>
            <button type="button" id="chargehis">ì¶©ì  ë´ì­</button>
          </div>
        </div>
        <!-- í¬ì¸í¸ ì¬ì© ë´ì­ ì¹ì -->
        <div class="point_use">
          <div class="point_use_title">í¬ì¸í¸ ì¬ì© ë´ì­</div>
          <nav class="month">
            <ul>
              <li>&lt;</li>
              <li>8ì</li>
              <li>&gt;</li>
            </ul>
          </nav>
          <div class="point_total_use">
            <div class="point_month">8ì ì´ ì¬ì© í¬ì¸í¸ : 10,000p</div>
            <nav class="point_day">
              <ul>
                <li>ëªì¼ : ëë´íì ì´ë¦</li>
                <li>ëªì¼ : ëë´íì ì´ë¦</li>
                <li>ëªì¼ : ëë´íì ì´ë¦</li>
                <li>ëªì¼ : ëë´íì ì´ë¦</li>
              </ul>
            </nav>
          </div>
        </div>
      </form>
    </div>
    <!-- í¬ì¸í¸ ì¶©ì  ëª¨ë¬ -->
    <div class="modal">
      <div class="modal-content">
        <p>í¬ì¸í¸ ì¶©ì </p>
        <div class="payapi">
          <div>ê²°ì  api</div>
        </div>
        <div class="charge">
          <div><input type="text"></div>
        </div>
        <nav>
          <ul class="charge_point">
            <li>
              <ul>
                <li><div>ì¶©ì  ì  í¬ì¸í¸</div></li>
                <li><div>ì¶©ì ëì´ìë í¬ì¸í¸</div></li>
              </ul>
            </li>
            <li>
              <ul>
                <li><div>ì¶©ì  í  í¬ì¸í¸</div></li>
                <li><div>ì¶©ì  í  í¬ì¸í¸</div></li>
              </ul>
            </li>
            <li>
              <ul>
                <li><div>ì¶©ì  í í¬ì¸í¸</div></li>
                <li><div>ì¶©ì  ì  í¬ì¸í¸+ì¶©ì  í  í¬ì¸í¸</div></li>
              </ul>
            </li>
          </ul>
        </nav>
        <button type="button" id="deleteBtn">ì·¨ì</button>
        <button type="button" onclick="openpointcharge()" id="completeBtn">ìë£</button>
      </div>
    </div>
    <!-- í¬ì¸í¸ ì¶©ì  ë´ì­ ëª¨ë¬ -->
    <div class="modal_history">
      <div class="modal-content">
        <p>í¬ì¸í¸ ì¶©ì  ë´ì­</p>
        <div class="charge_history">
          <div>
            <nav class="charge_month">
              <ul>
                <li><button type="button">&lt;</button></li>
                <li><div>8ì</div></li>
                <li><button type="button">&gt;</button></li>
              </ul>
            </nav>
          </div>
          <div>
            <nav class="charge_day">
              <ul>
                <li>2ì¼ : 100,000</li>
                <li>2ì¼ : 100,000</li>
                <li>2ì¼ : 100,000</li>
                <li>2ì¼ : 100,000</li>
              </ul>
            </nav>
          </div>
        </div>
        <button type="button" id="deletebutton">ì·¨ì</button>
        <button type="button" onclick="openpointhis()" id="completeBtn">ìë£</button>
      </div>
    </div>
  </main>
  <div id="footer"></div>
</body>

</html>