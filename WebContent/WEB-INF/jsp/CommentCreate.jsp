<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>コメント</title>
    <link rel="stylesheet" href="css/CommentCreate.css">
</head>
<body id="top">
    <!--ヘッダー-->
    <header id="header">
        <!--ロゴ-->
    <a href="/E1/HomeServlet">
        <img src="image/logo_yutoripu2.png" alt="ロゴ" class="logo">
    </a>
    <!--ユーザーアイコン-->
    <a href="">
        <img src="image/OIP (3).jpg" alt="アイコン" class="user-icon">
    </a>
    <hr class="header_hr">
    </header>
    <!--ヘッダーここまで-->

    <!--メイン-->
    <main>
        <div style="width:100%">
           <input type="submit" value="送信"><!--画面右上に表示-->
           <button type="button" onclilk="histyory.back()">戻る</button><!--画面左上に配置-->
        </div>
        <div class="p_Nickname"><!--ユーザー名-->
            <p>ユーザーネーム</p>
        </div>

        <form action="">

            <div class="p_Img"><!--プロフィール画像-->
                <p>プロフィール画像</p>
            </div>
            <div id="rv_remark"><!--コメントの表示-->
                <p>コメント表示</p>
            </div>
            <div id="rv_img">
                <h2>動画・画像</h2>
                <Script>
                  function imgg() {
                    var str = "";
                    var result = str.substr(str.length - 3, 3);
                    // 画像か動画の判別をしている。
                    if (result === "jpg") {
                      document.write("<img src='../imag/OIP.jpg'");
                    } else if (result == "mp4") {
                      document.write("<video controls width='250' src='../imag/*'>MP4</video>");
                    }
                  }
                  imgg();
                </Script>
            <div>
                <textarea type="text" cols="50" rows="10"></textarea><!--レビューを記入する欄-->
            </div>
        </form>

    </main>
    <!--メインここまで-->
    <!--footer-->
<!--htmlの<body>の最後に挿入
        もしかしたら作った画面と被るかもしれないので、その時は作った画面の一番下のコンテンツのcssに
        margin-bottom:10vh;
        を入れてみてください-->
    <!--フッター-->
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
                <a href="">
                    <img src="image/checklist.png" alt="チェックリスト" class="footer-icon">
                    <p>持ち物</p>
                </a>
    </footer>
    <!--footerここまで-->
    <!--フッターここまで-->
</body>
<script>
    function preview(obj, previewId) {
    let fileReader = new FileReader();
    fileReader.onload = (function () {
    document.getElementById(previewId).src = fileReader.result;
    });
    fileReader.readAsDataURL(obj.files[0]);
    }
</script>
</html>