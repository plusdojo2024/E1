<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaaa</title>
<link rel="stylesheet" href="css/CheckListEdit.css">
</head>

<body>
<br><br><br><br><br><br><br><br><br><br>
<div id="Edit">
    <a href="/E1/CheckListServlet" id="back">
        <img src="image/back.png">
    </a>
</div>

<br>
<div class="midasi">
・編集画面
</div>

<div class="koumoku_iti">
<form id="item${i}" class="save_post" method="POST" action="/E1/CheckListServlet">>
<c:forEach begin="1" end="10" step="1" var="i">
	項目${i}:
    <input id="item${i}" class="textbox" type="text" value="">
    <br>
</c:forEach>
</form>
</div>



<!--テンプレート＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->
    <header id="header">

        <!--ロゴ-->
        <a href="">
            <img src="image/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ユーザーアイコン-->
        <a href="">
            <img src="image/OIP (3).jpg" alt="アイコン" class="user-icon">
        </a>
        <hr class="header_hr">
    </header>
    <!--headerここまで-->

    <!--footer-->
    <!--htmlの<body>の最後に挿入
            もしかしたら作った画面と被るかもしれないので、その時は作った画面の一番下のコンテンツのcssに
            margin-bottom:10vh;
            を入れてみてください-->

    <footer id="footer">
        <div id="footer-wrapper">
            <hr>
            <!--画面下アイコン-->
            <div id="footer-tag">
                <a href="/E1/HomeServlet">
                    <img src="image/home.png" alt="ホーム" class="footer-icon">
                    <p>ホーム</p>
                </a>
                <a href="/E1/ChatSearchServlet">
                    <img src="image/chat.png" alt="チャット" class="footer-icon">
                    <p class="nimoji">検索</p>
                </a>
                <a href="/E1/TimeLineServlet">
                    <img src="image/timeline.png" alt="タイムライン" class="footer-icon">
                    <p class="nimoji">投稿</p>
                </a>
                <a href="CheckListServlet.java">
                    <img src="image/checklist.png" alt="チェックリスト" class="footer-icon">
                    <p>持ち物</p>
                </a>
          </div>
    </div>
    </footer>
    <!--footerここまで＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->





</body>
</html>
