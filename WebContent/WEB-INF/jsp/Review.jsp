<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>レビュー</title>
    <link rel="stylesheet" href="css/Reviewstyle.css">
</head>
<body id="top">
    <!--ヘッダー-->
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
    <!--ヘッダーここまで-->

    <!--メイン-->
    <main>
        <button type="button" onclilk="histyory.back()">戻る</button><!--画面左上に配置-->
        <form action="">
            <div class="submit">
                <input type="submit" value="送信"><!--画面右上に表示-->
            </div>
            <div>
                <textarea type="text" cols="50" rows="10"></textarea><!--レビューを記入する欄-->
            </div>
             <div class="rate-form"><!--ここに評価の星の画像を入れる-->
                <input id="star5" type="radio" name="rate" value="5">
                <label for="star5">★</label>
                <input id="star4" type="radio" name="rate" value="4">
                <label for="star4">★</label>
                <input id="star3" type="radio" name="rate" value="3">
                <label for="star3">★</label>
                <input id="star2" type="radio" name="rate" value="2">
                <label for="star2">★</label>
                <input id="star1" type="radio" name="rate" value="1">
                <label for="star1">★</label>
            </div>
              <!--<動画像をアップロードできる場所を作る-->
                <!--<div id="rv_img">
                    <h2>動画・画像</h2>
                    <Script>
                      function imgg(){
                        var str = "7.jpg";
                        var result = str.substr( str.length-3, 3 );
                        // 画像か動画の判別をしている。
                        if(result==="jpg"){
                          document.write("<img src='../imag/7.jpg'");
                        }else if(result=="mp4"){
                          document.write("<video controls width='250' src='../imag/OIP.mp4'>MP4</video>");
                        }
                      }
                      imgg();
                    </Script>
              </div>-->
              <hr>
              <h4>画像アップ・プレビュー</h4>
              <div class="preview-btn">
              <input type="file" accept='image/*' onchange="preview(this, 'previewImage');">
              </div>
              <br>
              <div class="img-box">
              <img class="preview" id="previewImage">
              </div>

              <h4>動画アップ・プレビュー</h4>
              <input type="file" accept='video/*' onchange="preview(this, 'previewVideo');">
              <br>
              <video  class="preview" id="previewVideo" controls="controls"></video>
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
                <a href="">
                    <img src="img/checklist.png" alt="チェックリスト" class="footer-icon">
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