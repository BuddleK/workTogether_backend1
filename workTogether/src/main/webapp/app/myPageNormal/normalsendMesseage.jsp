<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Normal_Messeage</title>
  <link rel="stylesheet" href="./../../assets/css/myPageNormal/normalsendMesseage.css">
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <script defer src="./../../assets/js/myPageNormal/normalsendMesseage.js"></script>
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
    <form action="" method="get">
      <div class="div_mark">
        <!-- ë©ë´ ì ëª© -->
        <div class="title">ìª½ì§í¨</div>
        <!-- ë°ì ìª½ì§, ë³´ë¸ ìª½ì§ ì´ë -->
        <nav class="div_choose">
          <ul>
            <li class="send"><a href="./normalsendMesseage.html">ë°ì ìª½ì§</a></li>
            <li>|</li>
            <li class="reseive"><a href="./normalreseiveMesseage.html">ë³´ë¸ ìª½ì§</a></li>
          </ul>
        </nav>
        <!-- ë°ì ìª½ì§ ì»¬ë¼ -->
        <nav class="mark_nav">
          <ul>
            <li><input onclick="toggleMarksAll()" id="checkbox_col" name="mark_check_col" type="checkbox"></li>
            <li class="name_col">
              <div>ë³´ë¸ ì¬ë</div>
            </li>
            <li class="location_col">
              <div>ì ëª©</div>
            </li>
            <li class="phone_col">
              <div>ë ì§</div>
            </li>
            <li class="read_col">
              <div>ì½ì ìí</div>
            </li>
          </ul>
        </nav>
        <!-- ë°ì ìª½ì§ ëª©ë¡ ë¦¬ì¤í¸ -->
        <ul class="mark_list">
        </ul>
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
        <!-- ë°ì ìª½ì§ ì­ì  ë²í¼ -->
        <div class="div_delete">
          <button type="button" onclick="delMarks()" id="delete">ì­ì </button>
        </div>
      </div>
    </form>
  
  </main>
<!-- ìª½ì§ row í´ë¦­ì ëì¤ë ëª¨ë¬ì°½ -->
  <div class="modal_bg" id="msgModal">
    <div class="modal_box">
      <div class="modal_read">
        <span class="modal_title">ë°ì ìª½ì§ ì½ê¸°</span>
        <span class="modal_close" onclick="closeMsgModal()">&times;</span>
      </div>
      <div class="modal_info">
        <div class="sender_info">
          <span>ë³´ë¸ ì¬ë : </span>í°ë¼ë¸ì¬ì°ë£¨ì¤ | <span class="sender_id">Trano</span>
        </div>
        <div class="message_content">
          ëëëë ì¡ì ê³µë£¡ íë¼ê¸°ë ìë¨¹ì§
        </div>
      </div>
      <!-- í´ë¹ ëª¨ë¬ì ìë ëª¨ë¬ì°½ -->
      <div class="modal_button">
        <button class="btn_reply">ëµì¥</button>
        <button class="btn_delete">ì­ì </button>
      </div>
    </div>
  </div>
  <!-- ëµì¥ ë²í¼ í´ë¦­ ì ëª¨ë¬ ì¶ë ¥ -->
  <div class="modal_bg" id="sendMsgModal">
    <div class="modal_box">
      <div class="modal_read">
        <span class="modal_title">ìª½ì§ ë³´ë´ê¸°</span>
        <span class="modal_close" onclick="closeSendMsgModal()">&times;</span>
      </div>
      <div class="modal_info">
        <div class="sender_info">
          <span>ë°ë ì¬ë : </span>ì¤íê³ ì¬ì°ë£¨ì¤ | <span class="sender_id">stago</span>
        </div>
        <textarea id="message_textarea" placeholder="ë´ì©ì ìë ¥íì¸ì"></textarea>
      </div>
      <div class="modal_button">
        <button class="btn_send">ë³´ë´ê¸°</button>
        <button class="btn_cancel">ì·¨ì</button>
      </div>
    </div>
  </div>
  <!-- ë³´ë´ê¸° ë²í¼ í´ë¦­ ì ëª¨ë¬ ì¶ë ¥ -->
  <div class="modal_bg" id="sendSuccessModal">
    <div class="modal_box modal_send">
      <p class="send_message">ìª½ì§ë¥¼ ë³´ëìµëë¤.</p>
      <div class="modal_button">
        <button class="btn_confirm" onclick="closeSendModal()">íì¸</button>
      </div>
    </div>
  </div>
  <!-- ì­ì  ë²í¼ í´ë¦­ ì ëª¨ë¬ ì¶ë ¥ -->
  <div class="modal_bg" id="deleteMsgModal">
    <div class="modal_box confirm_modal">
      <p class="confirm_text">ì ë§ë¡ ìª½ì§ë¥¼ ì­ì íìê² ìµëê¹?</p>
      <div class="confirm_buttons">
        <button class="btn_confirm" onclick="confirmDelete()">íì¸</button>
        <button class="btn_cancel" onclick="closeDeleteModal()">ì·¨ì</button>
      </div>
    </div>
  </div>
  <!-- ì­ì  ëª¨ë¬ìì íì¸ í´ë¦­ì ëª¨ë¬ ì¶ë ¥ -->
  <div class="modal_bg" id="sendSuccessModal">
    <div class="modal_box modal_send">
      <p class="send_message">ìª½ì§ê° ì­ì ëììµëë¤.</p>
      <div class="modal_button">
        <button class="btn_confirm" onclick="closeSendModal()">íì¸</button>
      </div>
    </div>
  </div>
  <!-- ë³´ë¸ ìª½ì§ íì´ì§ìì ì¬ì©íë ëª¨ë¬ -->
  <div class="modal_bg" id="sentMsgReadModal">
    <div class="modal_box read_modal">
      <div class="modal_header">
        <span class="modal_title">ë³´ë¸ ìª½ì§ ì½ê¸°</span>
        <span class="modal_close" onclick="closeSentMsgModal()">&times;</span>
      </div>
    </div>
  </div>


  <div id="footer"></div>
</body>
</html>