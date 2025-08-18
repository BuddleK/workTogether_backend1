<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="./../../assets/css/post/postDetailNotlogin.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/post/postDetailNotlogin.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
    <!-- ê¸ì´ì´ê° ìëê±°ë ë¹ë¡ê·¸ì¸ ì¼ë ë³´ì´ë ê²ìê¸ ëíì¼ íì´ì§ -->
    <form action="">
      <nav class="post_title">
        <ul>
          <li class="post_name">ìëíì¸ì</li>
          <li>
            <ul class="post_info">
              <li>
                <div>ë±ë¡ìëª</div>
              </li>
              <li class="post_member">
                <div>íê¸¸ë</div>
              </li>
              <li>
                <div>ë±ë¡ì¼</div>
              </li>
              <li class="post_day">
                <div>2025-08-09</div>
              </li>
            </ul>
          </li>
          <li>
            <ul class="post_info">
              <li>ì¡°íì</li>
              <li class="post_view"><div>4</div></li>
            </ul>
          </li>
        </ul>
      </nav>
      <nav class="post_content">
        <ul>
          <li>
            <div>ìëíì¸ì</div>
          </li>
          <li class="button">
            <button class="button_list"><a href="./postMain.html">ëª©ë¡</a></button>
          </li>
        </ul>
      </nav>
      <!-- ëê¸ ì¹ì -->
      <div class="post_total_reply"><div>ëê¸[1]</div></div>
      <nav class="post_reply">
        <ul>
          <li>íê¸¸*</li>
          <li>2025-08-09</li>
        </ul>
        <ul class="reply_content">
          <li>ëê¸ ë´ì©</li>
        </ul>
      </nav>
      <nav class="post_reply">
        <ul>
          <li>íê¸¸*</li>
          <li>2025-08-09</li>
        </ul>
        <ul class="reply_content">
          <li>ëê¸ ë´ì©</li>
        </ul>
      </nav>
      <!-- ëê¸ ìì± ì¹ì -->
      <nav class="reply_write">
        <ul>
          <li>ëê¸ ìì±</li>
          <li><input type="text" placeholder="ëê¸ ìì±ì¤"><button>ìì±</button></li>
        </ul>
      </nav>
    </form>
    <!-- ì ê³  ë²í¼ -->
    <div class="del"><button class="button_del">ì ê³ </button></div>
  </main>
  <!-- ì ê³  íì¸ ëª¨ë¬ -->
  <div class="checkmodal" id="editModal">
    <div class="modal_box">
      <p>ì´ ê²ìê¸ì  ì ê³ íìê² ìµëê¹?</p>
      <div class="exit-value">
              <select class="exit-select">
                <option disabled selected>ì ê³  ì¬ì ë¥¼ ìë ¥íì¬ ì£¼ì­ìì¤.</option>
                <option>ë¶ì ì í ê¸ì´ í¬í¨ëì´ ììµëë¤.</option>
                <option>ë¶ì ì í íëì´ í¬í¨ëì´ ììµëë¤.</option>
                <option>ê´ê³ ì± ë¨ì´ê° í¬í¨ëì´ ììµëë¤</option>
              </select>
            </div>
      <div class="modal_buttons">
        <button id="check">íì¸</button>
        <button id="cancle">ì·¨ì</button>
      </div>
    </div>
  </div>
  <!-- ìì ì´ ì´ë¯¸ ì ê³ í ê²ìê¸ì¼ë ëª¨ë¬ -->
  <div class="notmodal" id="editModal">
    <div class="modal_box">
      <p>ì´ë¯¸ ì ê³ í ê²ìê¸ìëë¤</p>
      <div class="modal_buttons">
        <button id="notcheck">íì¸</button>
      </div>
    </div>
  </div>
  <div class="reportmodal">
    <div class="modal_box">
      <p>ì ê³ ëììµëë¤</p>
      <div class="modal_buttons">
        <button id="reportcheck">íì¸</button>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>
</html>