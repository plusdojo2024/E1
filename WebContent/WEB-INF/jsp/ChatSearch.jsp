<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="java.util.List" %>
  <%@ page import="model.Chat" %>
<!DOCTYPE html>
<html lang="ja">


<head>
  <meta charset="UTF-8">
  <title>検索|ゆとりっぷ</title>
  <link rel="stylesheet" href="/E1/css/ChatSearch.css">
  <link rel="stylesheet" type="text/css" href="/E1/css/header_footer.css">
</head>

<body>
  <!--ヘッダー-->
  <header id="header">

    <!--ロゴ-->
    <a href="">
      <img src="/E1/image/logo_yutoripu2.png" alt="ロゴ" class="logo">
    </a>
    <!--ユーザーアイコン-->
    <a href="">
      <img src="/E1/image/${sessionScope.ic}" alt="アイコン" class="user-icon">
    </a>
    <hr class="header_hr">
  </header>

  <!--メイン-->
        <!--アキネーター-->
	<main>
     <div class="search-background">
      <img src="/E1/image/akine-ta-.png" class="akine-ta-">
      <div id="speech-bubble" class="speech-bubble">
      <!--  質問文をランダムに表示 -->
		<div id="question"></div>
		<div id="chat-log"></div>
      </div>
    </div>

    <!--入力フォーム-->
    <div class="search-form">
     <input type="text" id="answer-input"  placeholder="ここに入力"/>
      <!-- <input type="text" id="input-text" name="answer" placeholder="ここに入力"> -->
        <button id="answer-btn"class="search-form-button">回答</button>
      <!--<button type="button" class="search-form-button" id="submit-button">
        送信
      </button>-->



    </div>

    <hr>

    <!--質問、回答のチャット履歴-->
    <div class="chat-wrapper">
      <p>これまでの質問と回答の履歴が表示されます</p>
      <div class="chat-container">
      <div class="question-log" id="question-log"></div>
      <div class="answer-log" id="answer-log"></div>
    </div>
    </div>
  </main>

  <!--フッター-->
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
<script src="/E1/js/chat.js"></script>
</body>
</html>
