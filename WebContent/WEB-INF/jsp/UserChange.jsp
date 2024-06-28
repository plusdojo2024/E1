<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更 | ゆとりっぷ</title>
</head>
<link rel="stylesheet" type="text/css" href="/E1/css/Login.css">
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


<div class = "henkouzenbu">
    <h2>ユーザー情報変更</h2>
    <div class = "turk_mj">
    <form class="" method="get" action="">

        <label>メールアドレス(必須)<br>
             <input type="text" name="mailaddress" class="txt"><br>

          <label>氏名(必須)<br>
          <input type="text" name="nickname" class="txt"><br>

          <label>パスワード(必須)<br>
            <input type="text" name="password" class="txt"><br>

          <label>年齢(必須)<br>
          <input type="text" name="age" class="txt"><br>

          <label>性別<br>
          <input type="text" name="gender" class="txt"><br>

          <label>プロフィール画像<br>
          <input type="file" name="gazou" class="txt"><br>

          <br>

          <input type="submit" name="submit" value="変更"
          style="background-color:#FFFFFF;
                 border-radius:10px;
                 border:1px
                 solid #bcbbbb;
                 width: 80px;
                height: 50px;
                font-size: 30px;">

        </form>
    </div>

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
</html>