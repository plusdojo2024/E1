<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報登録 | ゆとりっぷ</title>
<link rel="stylesheet" type="text/css" href="/E1/css/Login.css">
</head>

<body>

 <!--header-->
  <header id="header">

      <!--ロゴ-->
      <a href="">
          <img src="img/logo_yutoripu2.png" alt="ロゴ" class="logo" width="400" height="125">
      </a>
      <!--ロゴここまで-->
      </header>

      <div class = "henkouzenbu">
<h2>ユーザー情報登録</h2>
<div class = "turk_mj">
<form class="" method="get" action="">

    <label>メールアドレス(必須)<br>
      <input type="text" size="large" name="mailaddress" class="txt" ><br>

      <label>氏名(必須)<br>
      <input type="text" name="password" class="txt"><br>

      <label>パスワード(必須)<br>
        <input type="text" name="gender" class="txt"><br>

      <label>年齢(必須)<br>
      <input type="text" name="age" class="txt"><br>

      <label>性別<br>
      <input type="text" name="gender" class="txt"><br>

      <label>プロフィール画像<br>
      <input type="file" name="gazou" class="txt"><br>

      <br>

      <input type="submit" name="submit" value="登録"
      style= "background-color:#FFFFFF;
              border-radius:10px;
              border:1px
              solid #bcbbbb;
              width: 80px;
              height: 50px;
              font-size: 30px;">

    </form>
</div>
      </div>

      <!--ログイン画面に戻るボタン-->
      <li><a href="login_yutori.html"><img src="img\icon_114.png" width="130" height="130" style="margin-top: 150px;"></a></li>


</body>
</html>