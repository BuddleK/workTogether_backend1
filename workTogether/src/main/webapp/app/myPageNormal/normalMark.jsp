<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Mark</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalMark.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/NormalMark.js"></script>
</head>

<body>
  <div id="header"></div>
  <main>
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
        <div class="title">ì°í ëª©ë¡</div>
        <nav class="mark_nav">
          <ul>
            <li><input onclick="toggleMarksAll()" id="checkbox_col" name="mark_check_col" type="checkbox"></li>
            <li class="name_col">
              <div>ì´ë¦</div>
            </li>
            <li class="location_col">
              <div>ìì¹</div>
            </li>
            <li class="phone_col">
              <div>ì íë²í¸</div>
            </li>
          </ul>
        </nav>
        <ul class="mark_list">
        </ul>
        <div>
          <ul class="page">
            <li><a href="">&lt;</a></li>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
            <li><a href="">4</a></li>
            <li><a href="">&gt;</a></li>
          </ul>
        </div>
        <div class="div_delete">
          <button type="button" id="btnDelete">ì° ì­ì </button>
        </div>
      </div>
    </form>

  </main>
  <!-- ì­ì  ë²í¼ í´ë¦­ì íì¸ ëª¨ë¬ -->
  <div class="modal" id="deleteModal">
    <div class="modal_box">
      <p>ì°í ê°ê²ë¥¼ ì­ì íìê² ìµëê¹?</p>
      <div class="modal_buttons">
        <button type="button" id="confirmDelete">íì¸</button>
        <button type="button" id="cancelDelete">ì·¨ì</button>
      </div>
    </div>
  </div>
  <!-- ì° ì­ì íì¸ ëª¨ë¬ íì¸ ë²í¼ í´ë¦­ì ëª¨ë¬ -->
  <div class="modal" id="chek_deleteModal">
    <div class="modal_box">
      <p>ì°ì´ ì­ì  ëììµëë¤.</p>
      <div class="modal_buttons">
        <button type="button" id="check_confirmDelete">íì¸</button>
      </div>
    </div>
  </div>
  <div id="footer"></div>
</body>

</html>