<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Post_Modify</title>
  <link rel="stylesheet" href="./../../assets/css/post/postModify.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/post/postModify.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
    <!-- ê²ìë¬¼ ìì   ëíì¼ íì´ì§-->
    <form action="">
      <nav class="post_title">
        <ul>
          <li class="post_name"> ìëíì¸ì</li>
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
              <li class="post_view">
                <div>4</div>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <div class="api">ê¸ì°ê¸° api?</div>
      <div class="input">
        <textarea></textarea>
        <input type="text">
      </div>
      <div class="button">
        <button class="list"><a href="./postMain.html">ëª©ë¡</a></button>
        <button class="button_write">ìì íê¸°</button>
      </div>
    </form>
  </main>
  <!-- ìì  íì¸ ëª¨ë¬ -->
  <div class="notmodal" id="editModal">
    <div class="modal_box">
      <p>ìì íìê² ìµëê¹?</p>
      <div class="modal_buttons">
        <a href="./postDetaillogin.html"><button id="check">íì¸</button></a>
        <button id="cancle">ì·¨ì</button>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>
</html>