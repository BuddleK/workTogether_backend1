<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_PwCheck</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalPwCheck.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalPwCheck.js"></script>
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
    <!-- ë¹ë°ë²í¸ íì¸ ì¹ì -->
    <div class="pw_check">
      <form action="" method="get"> 
        ë¹ë°ë²í¸<input id="pw_input" type="password" placeholder="ë¹ë°ë²í¸ 8ìë¦¬ ìë ¥">
        <div id="pwaccord">ì¼ì¹íì§ ìë ë¹ë°ë²í¸ ìëë¤</div>
      </form>
      <button type="button" onclick="chPw()" class="checkBtn">ë¹ë°ë²í¸ íì¸</button>
    </div>
  </main>
  <div id="footer"></div>
</body>
</html>