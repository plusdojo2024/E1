<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム | ゆとりっぷ</title>
 <link rel="stylesheet" type="text/css" href="css/Home.css">
</head>

<body>

 <!--header-->
    <header id="header">

        <!--ロゴ-->
        <a href="">
            <img src="img/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ロゴここまで-->

        <!--ユーザーアイコン-->
        <a href="">
            <img src="img/OIP (3).jpg" alt="アイコン" class="user-icon">
        </a>
        <!--ユーザーアイコンここまで-->
        <hr class="header_hr">
    </header>
    <!--headerここまで-->

    <!--おすすめ温泉表示-->
<div class="home1">
    <p>本日のおすすめ温泉</p>
    <div class = "osusume">

    <img src="" id='imageArea' width="480" height="429">
    <script>
        const imageArea = document.getElementById('imageArea');
        const images = ['img/OIP (1).jpg', 'img/tori.png', 'img/logo_yutoripu2.png' ];

        const imageNo = Math.floor( Math.random() * images.length);
        imageArea.src = images[imageNo];

    </script>

</div>
</div>

<!--ランキング表示画面-->
<div class = "ranking">
    <div class="Container">
        <div class="Box-Container">
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <div class="Box">
            <img src ="img\torionsen.jpg">
            </div>
          <!-- 必要な数の.Box要素を追加 -->
        </div>
        <div class= "Arrow left"> < </div>
        <div class= "Arrow right">></div>
      </div>
    <script src ="main.js"></script>

</div>
    <!--footer-->
    <footer id="footer">
        <hr>
        <div id="footer-tag">
            <a href="">
                <img src="img/home.png" alt="ホーム" class="footer-icon">
                <p>ホーム</p>
            </a>
            <a href="">
                <img src="img/chat.png" alt="チャット" class="footer-icon">
                <p>チャット</p>
            </a>
            <a href="">
                <img src="img/timeline.png" alt="タイムライン" class="footer-icon">
                <p>TL</p>
            </a>
            <a href="">
                <img src="img/checklist.png" alt="チェックリスト" class="footer-icon">
                <p>持ち物</p>
            </a>

            </div>
    </footer>
    <!--footerここまで-->

</body>

</body>
</html>