<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaaa</title>
<link rel="stylesheet" href="/E1/css/CheckListView.css">
</head>
<body>
    <br><br><br><br><br>
    <div id="Edit">

        <a href="/E1/CheckListServlet" id="back">
        	<img src="/E1/image/back.png">
        </a>
    </div>

新規チェックリスト名：
<form id="textbox-form" action="CheckRegistServlet" method="post">
	<input type="text" name="sinki" class="sinki" value="">
	<input type="submit" name="sinki" class="sinki_post" value="">
</form>






<!--テンプレート＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->
    <header id="header">

        <!--ロゴ-->
        <a href="">
            <img src="image/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ユーザーアイコン-->
        <a href="">
            <img src="/E1/image/${sessionScope.ic}" alt="アイコン" class="user-icon">
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
    <!--footerここまで＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->

