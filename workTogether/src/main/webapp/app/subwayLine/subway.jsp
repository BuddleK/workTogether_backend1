<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RB</title>
  <link rel="stylesheet" href="./../../assets/css/header.css">
  <link rel="stylesheet" href="./../../assets/css/footer.css">
  <script defer src="./../../assets/js/main/include.js"></script>
  <link rel="stylesheet" href="./../../assets/css/subwayLine/subway.css">
  <script defer src="./../../assets/js/subwayLine/subway.js"></script>
</head>

<body>
  <div id="header"></div>

  <main>
    <h1>ì§íì²  ë¸ì ë</h1>
    <div class="subway">
      <div class="subway_subwayLine">
        <button id="all"> ì ì²´ </button>
        <button id="line2"> 2í¸ì  </button>
        <button id="line3"> 3í¸ì  </button>
        <button id="line4"> 4í¸ì  </button>
        <button id="line7"> 7í¸ì  </button>
        <button id="line9"> 9í¸ì  </button>
        <button id="dxline"> ì ë¶ë¹ì  </button>
      </div>
    </div>
    <!-- ìì´ ì ì²´ ì§íì²  ë¸ì ë -->
    <div class="map_section">
      <div class="subway_allline_img">
        <img src="./../../assets/img/subwayLine/allline.png" alt="ì ì²´í¸ì ì¬ì§">
      </div>
      <!-- ìì´ 2í¸ì  ì§íì²  ë¸ì ë -->
      <div class="subway_line2_img">
        <img src="./../../assets/img/subwayLine/line2.png" alt="2í¸ì ì¬ì§">
      </div>
      <!-- ìì´ 3í¸ì  ì§íì²  ë¸ì ë -->
      <div class="subway_line3_img">
        <img src="./../../assets/img/subwayLine/line3.png" alt="3í¸ì ì¬ì§">
      </div>
      <!-- ìì´ 4í¸ì  ì§íì²  ë¸ì ë -->
      <div class="subway_line4_img">
        <img src="./../../assets/img/subwayLine/line4.png" alt="4í¸ì ì¬ì§">
      </div>
      <!-- ìì´ 7í¸ì  ì§íì²  ë¸ì ë -->
      <div class="subway_line7_img">
        <img src="./../../assets/img/subwayLine/line7.png" alt="7í¸ì ì¬ì§">
      </div>
      <!-- ìì´ 9í¸ì  ì§íì²  ë¸ì ë -->
      <div class="subway_line9_img">
        <img src="./../../assets/img/subwayLine/line9.png" alt="9í¸ì ì¬ì§">
      </div>
      <!-- ìì´ ì ë¶ë¹ì  ì§íì²  ë¸ì ë -->
      <div class="subway_dxline_img">
        <img src="./../../assets/img/subwayLine/dxline.png" alt="ì ë¶ë¹ì ì¬ì§">
      </div>

      <!-- ì ì²´ ì­ ëª©ë¡ -->
      <div class="station_list" id="allline_station">
        <h3>ì ì²´ ì­ ëª©ë¡</h3>
        <ul>
          <!-- ìì´ ì§ëê°ë ì­ ì´ë¦, ì ë³´ ì¹¸ -->
          <li class="station_name"><a href="./../../app/subwayLine/dongjack.html">ëì</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gubanpo.html">êµ¬ë°í¬</a></li>
          <li class="station-name"><a href="./../../app/subwayLine/shinbanpo.html">ì ë°í¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gosukterminner.html">ê³ ìí°ë¯¸ë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/sapeung.html">ì¬í</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/sinnonehyun.html">ì ë¼í</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/chungshindae.html">ì´ì ëìêµ¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nebang.html">ë´ë°©</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/banpo.html">ë°í¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nonehyune.html">ë¼í</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/sadang.html">ì¬ë¹</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/bangbae.html">ë°©ë°°</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/seacho.html">ìì´</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gyudae.html">êµë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gangnam.html">ê°ë¨</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/shinsa.html">ì ì¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/yangjae.html">ìì¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/yangjeaforest.html">ìì¬ìë¯¼ìì²</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/chunggyae.html">ì²­ê³ì°ìêµ¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/jameone.html">ì ì</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nambuterminer.html">ë¨ë¶í°ë¯¸ë</a></li>
        </ul>
      </div>

      <div class="station_list" id="line2_stations">
        <!-- ìì´ 2í¸ì  ì´ë¦, ì ë³´ ì¹¸ -->

        <h3>2í¸ì  ì­ ëª©ë¡</h3>
        <ul>
          <li class="station_name"><a href="./../../app/subwayLine/sadang.html">ì¬ë¹</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/bangbae.html">ë°©ë°°</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/seacho.html">ìì´</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gyudae.html">êµë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gangnam.html">ê°ë¨</a></li>
        </ul>
      </div>

      <div class="station_list" id="line3_stations">
        <!-- ìì´ 3í¸ì  ì´ë¦, ì ë³´ ì¹¸ -->
        <h3>3í¸ì  ì­ ëª©ë¡</h3>
        <ul>
          <li class="station_name"><a href="./../../app/subwayLine/shinsa.html">ì ì¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/jameone.html">ì ì</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gosukterminner.html">ê³ ìí°ë¯¸ë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gyudae.html">êµë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nambuterminer.html">ë¨ë¶í°ë¯¸ë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/dongjack.html">ìì¬</a></li>
        </ul>
      </div>

      <div class="station_list" id="line4_stations">
        <!-- ìì´ 4í¸ì  ì´ë¦, ì ë³´ ì¹¸ -->
        <h3>4í¸ì  ì­ ëª©ë¡</h3>
        <ul>
          <li class="station_name"><a href="./../../app/subwayLine/dongjack.html">ëì</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/chungshindae.html">ì´ì ëìêµ¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/sadang.html">ì¬ë¹</a></li>
        </ul>
      </div>

      <div class="station_list" id="line7_stations">
        <!-- ìì´ 7í¸ì  ì´ë¦, ì ë³´ ì¹¸ -->
        <h3>7í¸ì  ì­ ëª©ë¡</h3>
        <ul>
          <li class="station_name"><a href="./../../app/subwayLine/chungshindae.html">ì´ì ëìêµ¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nebang.html">ë´ë°©</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gosukterminner.html">ê³ ìí°ë¯¸ë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/banpo.html">ë°í¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nonehyune.html">ë¼í</a></li>
        </ul>
      </div>

      <div class="station_list" id="line9_stations">
        <!-- ìì´ 9í¸ì  ì´ë¦, ì ë³´ ì¹¸ -->
        <h3>9í¸ì  ì­ ëª©ë¡</h3>
        <ul>
          <li class="station_name"><a href="./../../app/subwayLine/dongjack.html">ëì</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gubanpo.html">êµ¬ë°í¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/shinbanpo.html">ì ë°í¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gosukterminner.html">ê³ ìí°ë¯¸ë</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/sapeung.html">ì¬í</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/dongjack.html">ì ë¼í</a></li>
        </ul>
      </div>

      <div class="station_list" id="dxline_stations">
        <!-- ìì´ ì ë¶ë¹ì  ì´ë¦, ì ë³´ ì¹¸ -->
        <h3>ì ë¶ë¹ì  ì­ ëª©ë¡</h3>
        <ul>
          <li class="station_name"><a href="./../../app/subwayLine/shinsa.html">ì ì¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/nonehyune.html">ë¼í</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/sinnonehyun.html">ì ë¼í</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/gangnam.html">ê°ë¨</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/yangjae.html">ìì¬</a></li>
          <li class="station_name"><a href="./../../app/subwayLine/yangjeaforest.html">ìì¬ìë¯¼ìì²</a></li>
          <li class="station_item"><a href="./../../app/subwayLine/chunggyae.html">ì²­ê³ì°ìêµ¬</a></li>
        </ul>
      </div>
    </div>

  </main>
  <div id="footer"></div>
</body>

</html>