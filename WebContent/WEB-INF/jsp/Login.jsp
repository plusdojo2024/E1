<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン | ゆとりっぷ</title>
<link rel="stylesheet" href="css/Login.css">
</head>

<body>
<div class="br1">
<div class ="log">
<img src="img/login_logo.png" width="516" height="450" >
</div>
</div>

<div class = "loginform">
  <form id="login_form" method="post" action="" >
    <table>
      <tr>
        <td>
          <label>メールアドレス<br>
          <input type="email" name="log"  >

        </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>パスワード<br>
          <input type="password" name="pw"  >

          </label>
        </td>
      <tr>
      <tr>
        <td colspan="2">
            <input type="submit" name="submit"  style="background-color:#FFFFFF; border-radius:10px;border: 1px solid #bcbbbb;">

         <!--エラーメッセージ表示 わからん-->
          <span id="error_message"></span>
        <td>
      </tr>
    </table>
  </form>

</div>
</body>


<!-- JavaScript（ここから） なんじゃこれ動かん-->
<script>
  /* HTML要素をオブジェクトとして取得する */
  let formObj = document.getElementById('login_form');
  let errorMessageObj = document.getElementById('error_message');

  /* [ログイン]ボタンをクリックしたときの処理 */
  formObj.onsubmit = function() {
    if (!formObj.id.value || !formObj.pw.value) {
      errorMessageObj.textContent = '※IDとパスワードを入力してください！';
      return false;
    }
    errorMessageObj.textContent = null;
  };


  </script>
  <!-- JavaScript（ここまで） -->


 <div class = "shinki">
<li><a href="User_touroku.html">新規アカウント登録はこちら</a></li>
 </div>
</html>


</body>
</html>