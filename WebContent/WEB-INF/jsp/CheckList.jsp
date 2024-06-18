<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaaa</title>


<link rel="stylesheet" href="css/CheckListView.css">


</head>
<body>


<a href="/YuTrip test/CheckListViewServlet"><img id="kago" src="img/kago.png" alt="gazou" width="300"></a>
<br>
<img src="img/boarder.png" alt="boarder" class="boarder">








<script>
    function onoff() {
        var kago = document.getElementById('kago');
        if(kago.src.includes('kago_off.png')) {
            kago.src = 'kago.png';
        }

        else {
            kago.src = 'kago_off.png';
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
</body>
<!--footerここまで＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->


</body>
</html>
