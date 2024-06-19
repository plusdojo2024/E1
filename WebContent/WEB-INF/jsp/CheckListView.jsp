<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaaa</title>
<link rel="stylesheet" href="css/CheckListView.css">
</head>

<body>
<br><br><br><br><br><br><br><br><br>
<div id="Edit">
    <a href="/YuTrip test/CheckListServlet" id="back">
        <img src="img/back.png">
    </a>

    <a href="/YuTrip test/CheckListEditServlet" id="go">
        <編集する>
    </a>
</div>

<br><br><br>
<div class="koumoku_iti">
    <input id="koumoku" class="textbox" type="text" size="80" disabled value="${cl_value}">
    <img id="check" " src="img/check_off.png" alt="toggle" di>
    <br><br><br>
</div>

<c:forEach var="e" items-"${CheckList }">
	<input type="text" name="cl_Name" value="${e.cl_Name }"><br>
</c:forEach>



<script>
    /*　 チェックマーク処理ーーーーーーーーーーーーーーーーーーーーーーーーーー*/
    document.getElementById('check').onclick = function() {
        var image = document.getElementById('check');
        if (image.src.includes('img/check_off.png')) {
            image.src = 'img/check_on.png';
        }
        else {
                image.src = 'img/check_off.png';
        }
    }

    /*  テキストボックス処理ーーーーーーーーーーーーーーーーーーーーーーーーーー-*/
    function addTextbox(currentTextbox) {
        // テキストボックスに入力がある場合のみ新しいテキストボックスを追加
        if (currentTextbox.value.trim() !== "") {
            // 新しいテキストボックスを作成
            var newTextbox = document.createElement('input');
                newTextbox.type = 'text';
                newTextbox.className = 'textbox';
                newTextbox.oninput = function() { addTextbox(newTextbox); };


                // テキストボックスコンテナに追加
                var container = document.getElementById('koumoku');
                container.appendChild(newTextbox);

                // 入力イベントを解除することで重複追加を防止
                currentTextbox.oninput = null;
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
                    <img src="img/home.png" alt="ホーム" class="footer-icon">
                    <p>ホーム</p>
                </a>
                <a href="">
                    <img src="img/chat.png" alt="チャット" class="footer-icon">
                    <p class="nimoji">検索</p>
                </a>
                <a href="">
                    <img src="img/timeline.png" alt="タイムライン" class="footer-icon">
                    <p class="nimoji">投稿</p>
                </a>
                <a href="CheckListServlet.java">
                    <img src="img/checklist.png" alt="チェックリスト" class="footer-icon">
                    <p>持ち物</p>
                </a>
          </div>
    </div>
    </footer>
    <!--footerここまで＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->





</body>
</html>
