<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Post_Write</title>
  <link rel="stylesheet" href="./../../assets/css/post/postWrite.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/post/postWrite.js"></script>
</head>
<body>
  <div id="header"></div>
  <main>
    <!-- ê²ìë¬¼ ìì± ëíì¼ íì´ì§ -->
    <form action="">
      <div class="title"><input type="text" placeholder="ì ëª©"></div>
      <div class="write">
        <textarea></textarea>
        <input type="text">
      </div>
      <div class="button">
        <button type="button" class="list"><a href="./postMain.html">ëª©ë¡</a></button>
        <button type="button" class="button_write">ìì±</button>
      </div>
    </form>
  </main>
  <div class="writecheckmodal">
    <div class="modal_box">
      <p>ìì±íìê² ìµëê¹?</p>
      <div class="modal_buttons">
        <button type="button" id="writecheck">íì¸</button>
        <button type="button" id="writecancel">ì·¨ì</button>
      </div>
    </div>
  </div>
  <div class="writemodal">
    <div class="modal_box">
      <p>ìì±ëììµëë¤</p>
      <div class="modal_buttons">
        <a href="./postMain.html"><button type="button" id="reportcheck">íì¸</button></a>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>
</html>