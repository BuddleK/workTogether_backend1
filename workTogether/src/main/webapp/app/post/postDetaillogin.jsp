<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="./../../assets/css/post/postDetaillogin.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/post/postDetaillogin.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
    <!-- ê¸ì´ì´ê° ìì  ê²ìê¸ë³´ë ëíì¼ íì´ì§ -->
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
              <li>
                <div>ìì ì¼</div>
              </li>
              <li class="post_modifyDay">
                <div>2025-08-10</div>
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
            <a href="./postMain.html"><button type="button" class="button_list">ëª©ë¡</button></a>
            <button type="button" class="button_delete">ì­ì </button>
            <a href="./postModify.html"><button type="button" class="button_enroll">ìì </button></a>
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
  </main>
  <!-- ê²ìê¸ ì­ì  íì¸ ëª¨ë¬ -->
  <div class="checkmodal" id="editModal">
    <div class="modal_box">
      <p>ì´ ê²ìê¸ì ì­ì íìê² ìµëê¹?</p>
      <div class="modal_buttons">
        <a href="./postMain.html"><button id="check">íì¸</button></a>
        <button id="cancle">ì·¨ì</button>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>
</html>