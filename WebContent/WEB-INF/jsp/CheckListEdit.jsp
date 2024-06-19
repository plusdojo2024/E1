<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaaa</title>
<link rel="stylesheet" href="css/CheckListEdit.css">
</head>
<body>
    <br><br><br><br><br><br><br><br><br>
    <div id="Edit">
        <a href="/YuTrip test/CheckListViewServlet.java">
            <戻る>
        </a>
    </div>
<!--
    <div id="input">
        <div id="number">
            <1>
        </div>

        <form id="textbox-form" action="CheckListEditServlet" method="post">
            <div id="textbox-container">
                <input type="text" name="cl_element" class="textbox first-textbox" oninput="checkAndAddTextbox()">
            </div>
            <br><br><br>
            <button class="post_button" type="submit" >保存する</button>
        </form>
    </div>
-->

	<c:forEach var="e" items="${CheckList}">
		<form method="post" action="/E1/CheckListServlet">
		<input type="text" name="cl_element" value="${e.cl_element }"><br>"
		<input type="submit" name="save" value="保存">
		</form>
		<hr>
	</c:forEach>






    <script>
        function checkAndAddTextbox() {
            var container = document.getElementById('textbox-container');
            var textboxes = container.getElementsByClassName('textbox');

            var lastTextbox = textboxes[textboxes.length - 1];
            if (lastTextbox.value.trim() !== "") {
                var newTextbox = document.createElement('input');
                newTextbox.type = 'text';
                newTextbox.name = 'cl_element'; // サーブレットで取得するためのname属性を追加
                newTextbox.className = 'textbox'; // 新しいテキストボックスのクラスを設定
                newTextbox.oninput = checkAndAddTextbox;
                container.appendChild(newTextbox);
            }

            var emptyCount = 0;
            for (var i = 0; i < textboxes.length; i++) {
                if (textboxes[i].value.trim() === "") {
                    emptyCount++;
                    if (emptyCount > 1) {
                        container.removeChild(textboxes[i]);
                        i--; // Remove the item and decrement the index
                    }
                }
            }
        }
    </script>










<!--テンプレート＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->
    <header id="header">

        <!--ロゴ-->
        <a href="">
            <img src="img/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ユーザーアイコン-->
        <a href="">
            <img src="img/OIP (3).jpg" alt="アイコン" class="user-icon">
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
                <a href="">
                    <img src="image/home.png" alt="ホーム" class="footer-icon">
                    <p>ホーム</p>
                </a>
                <a href="">
                    <img src="image/chat.png" alt="チャット" class="footer-icon">
                    <p class="nimoji">検索</p>
                </a>
                <a href="">
                    <img src="image/timeline.png" alt="タイムライン" class="footer-icon">
                    <p class="nimoji">投稿</p>
                </a>
                <a href="CheckListServlet">
                    <img src="image/checklist.png" alt="チェックリスト" class="footer-icon">
                    <p>持ち物</p>
                </a>
           </div>
    </div>
    </footer>
</body>
    <!--footerここまで＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->

