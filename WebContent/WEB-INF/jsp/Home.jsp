<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム | ゆとりっぷ</title>
 <link rel="stylesheet" type="text/css" href="/E1/css/Home.css">
</head>

<body>

 <!--header-->
    <header id="header">

        <!--ロゴ-->
        <a href="">
            <img src="/E1/image/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ロゴここまで-->
 		<a href="/E1/LoginServlet">ログイン</a>
        <!--ユーザーアイコン-->
        <a href="">
            <img src="/E1/image/${sessionScope.ic}" alt="アイコン" class="user-icon">
        </a>
        <!--ユーザーアイコンここまで-->
        <hr class="header_hr">
    </header>
    <!--headerここまで-->

    <!--おすすめ温泉表示-->
<div class="home1">

    <p class="bordering01">本日のおすすめ温泉</p>
    <div class = "osusume">
	<p class = "onmei">${os[1]}</p><br>
    <img src="/E1/image/${os[2]}" id='imageArea' width="480" height="429">


</div>
</div>

<!--ランキング表示画面-->
<div class = "ranking">
    <div class="Container">
        <div class="Box-Container">
        <div class="Box" width="700px" height="">
            <img src="image/rank1.png" width="120" height="150" class="rankimg">
              <p>${osrn[0][1] }</p>
            <img src="/E1/image/${osrn[0][2]}" width="500px" height="400px" class="oimo">
            </div>

          <div class="Box">
           <img src="image/rank2.png" width="120" height="150" class="rankimg">
             <p> ${osrn[1][1]}</p>
            <img src="/E1/image/${osrn[1][2]}" width="500px" height="400px" class="oimo">
            </div>
          <div class="Box">
           <img src="image/rank3.png" width="120" height="150" class="rankimg">
             <p>${osrn[2][1]}</p>
            <img src="/E1/image/${osrn[2][2]}" width="500px" height="400px" class="oimo">
            </div>

         <!--  <div class="Box">
            <p>${osrn[3][1]}</p>
            <img src="/E1/${osrn[3][2]}" width="500px" height="400px" class="oimo">
            </div>
          <div class="Box">

            <img src="/E1/${osrn[4][2]}"width="500px" height="400px" class="oimo">
            </div> -->

          <!-- 必要な数の.Box要素を追加 -->
        </div>
        <div class= "Arrow left"> < </div>
        <div class= "Arrow right">></div>
      </div>
    <script src ="/E1/js/main.js"></script>

</div>
 <footer id="footer">
<div id="footer-wrapper">
	<hr>
		<!--画面下アイコン-->
		<div id="footer-tag">
			<a href="/E1/HomeServlet"> <img src="/E1/image/home.png" alt="ホーム"
				class="footer-icon">
					<p>ホーム</p></a> <a href="/E1/ChatSearchServlet"> <img src="/E1/image/chat.png" alt="チャット"
				class="footer-icon">
					<p class="nimoji">検索</p></a> <a href="/E1/TimeLineServlet"> <img
				src="/E1/image/timeline.png" alt="タイムライン" class="footer-icon">
					<p id="timel" class="nimoji">TL</p></a> <a href="/E1/CheckListServlet"> <img
				src="/E1/image/checklist.png" alt="チェックリスト" class="footer-icon">
					<p>持ち物</p></a>
		</div>
</div>
</footer>

</body>

</body>
</html>