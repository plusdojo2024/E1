<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>温泉のおすすめ</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    .chat-log {
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 10px;
      margin-bottom: 20px;
    }
    .chat-message { /* 新しいスタイル */
      display: flex;
      margin-bottom: 10px;
    }
    .user-message,
    .bot-message { /* 新しいスタイル */
      padding: 10px;
      border-radius: 10px;
      max-width: 70%;
    }
    .user-message { /* 新しいスタイル */
      background-color: #e9ffe9;
      margin-left: auto;
    }
    .bot-message { /* 新しいスタイル */
      background-color: #f2f2f2;
      margin-right: auto;
    }
  </style>
</head>
<body>
  <h1>温泉のおすすめ</h1>
  <div class="chat-log" id="chat-log"></div>
  <input type="text" id="answer-input" />
  <button id="answer-btn">回答</button>
<footer>
<script src="/E1/js/chat.js"></script>
</footer>

</body>
</html>
