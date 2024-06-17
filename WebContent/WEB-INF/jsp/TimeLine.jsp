<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="/E1/css/TimeLine.css">
</head>
<body>
<!--header-->
<!--htmlの<body>の最初に挿入-->
  <header class="header">

    <!--ロゴ-->
    <a href="">
        <img src="/E1/image/logo_yutoripu2.png" alt="ロゴ" class="logo">
    </a>
    <!--ユーザーアイコン-->
    <a href="">
        <img src="/E1/image/OIP (3).jpg" alt="アイコン" class="user-icon">
    </a>
    <hr class="header_hr">
</header>


<!--headerここまで-->



  <div class="items">
    <div class="item">
      <input type="button" value="タイムライン" onclick="">
      <h2></h2>
    </div>
    <div class="item">
      <input type="button" value="ブックマーク" onclick="">

    </div>
  </div>
 
  <!-- タイムラインの表示処理です。 -->
  <div class="TimeLine">
    <!-- ユーザーアイコン-->
    <div id="p_Img">

    </div>
    <!-- ユーザーネーム -->
    <div id="p_Nickname">
      <p>ユーザーネーム</p>
    </div>
    <!-- レビュー文の表示 -->
    <div id="rv_remark">
      <h2>レビュー</h2>
      <div id="rv_honbun">
        <p>レビュー本文</p>
      </div>
    </div>
    <!-- 評価★５段階 -->

    <div id="rv_point">
      <h2>五段階評価</h2>
      <div class="rate-form">
        <input id="star5" type="radio" name="rv_point" value="5">
        <label for="star5">★</label>
        <input id="star4" type="radio" name="rv_point" value="4">
        <label for="star4">★</label>
        <input id="star3" type="radio" name="rv_point" value="3">
        <label for="star3">★</label>
        <input id="star2" type="radio" name="rv_point" value="2">
        <label for="star2">★</label>
        <input id="star1" type="radio" name="rv_point" value="1">
        <label for="star1">★</label>
      </div>
    </div>
    <!-- ユーザー側の乗せた画像・動画の表示 -->
    <div id="rv_img">
      <h2>動画・画像</h2>
      <Script>
        function imgg() {
          var str = "kuri.mp4";
          var result = str.substr(str.length - 3, 3);
          // 画像か動画の判別をしている。
          if (result === "jpg") {
            document.write("<img src='/E1/image/OIP.jpg'");
          } else if (result == "mp4") {
            document.write("<video controls width='250' src='/E1/image/kuri.mp4'>MP4</video>");
          }
        }
        imgg();
      </Script>

    </div>
    <div class="bt">
    <div class="itemsbt">
      <!-- お気に入り登録をするbutton -->
      <div class="item">
        <div class="HEART">
          <label for="star1">❤</label>
          <!-- 個々のハートの表示は,daoの方でユーザーidが❤した人の中になければ0であれば1にしてデータを返してそれを判別して表示を変える。 -->
          <!-- いいねの実装処理アイディア　裏画面で処理してデータベース接続し❤した人欄をコロン区切りで保存しているのでそれをsolitで配列にして全部比較して指定のものを削除して戻せばいい。 -->
        </div>
      </div>
      <!-- コメントに飛ぶbutton -->
      <div class="item">
        <div class="comment">
          <a  href="text.html">💬</a><!--レビューidデータを、idに格納してボタンを押したらidの中身をセッションに入れ込むか送信する。。例）text.html?word=“季節の花”&order=“DESC”-->
        </div>
      </div>
      <!-- ブックマークに入れるbutton -->
      <div class="item">
        <div class="bookmark">
          <a>✔</a>
        </div>
      </div>
</div>

    </div>


  </div>
<!-- タイムラインの表示処理です。 -->
<div class="TimeLine">
  <!-- ユーザーアイコン-->
  <div id="p_Img">

  </div>
  <!-- ユーザーネーム -->
  <div id="p_Nickname">
    <p>ユーザーネーム</p>
  </div>
  <!-- レビュー文の表示 -->
  <div id="rv_remark">
    <h2>レビュー</h2>
    <div id="rv_honbun">
      <p>レビュー本文</p>
    </div>
  </div>
  <!-- 評価★５段階 -->

  <div id="rv_point">
    <h2>五段階評価</h2>
    <div class="rate-form">
      <input id="star5" type="radio" name="rv_point" value="5">
      <label for="star5">★</label>
      <input id="star4" type="radio" name="rv_point" value="4">
      <label for="star4">★</label>
      <input id="star3" type="radio" name="rv_point" value="3">
      <label for="star3">★</label>
      <input id="star2" type="radio" name="rv_point" value="2">
      <label for="star2">★</label>
      <input id="star1" type="radio" name="rv_point" value="1">
      <label for="star1">★</label>
    </div>
  </div>
  <!-- ユーザー側の乗せた画像・動画の表示 -->
  <div id="rv_img">
    <h2>動画・画像</h2>
    <Script>
      function imgg() {
        var str = "kuri.mp4";
        var result = str.substr(str.length - 3, 3);
        // 画像か動画の判別をしている。
        if (result === "jpg") {
          document.write("<img src='/E1/image/OIP.jpg'");
        } else if (result == "mp4") {
          document.write("<video controls width='250' src='/E1/image/kuri.mp4'>MP4</video>");
        }
      }
      imgg();
    </Script>

  </div>
  <div class="bt">
  <div class="itemsbt">
    <!-- お気に入り登録をするbutton -->
    <div class="item">
      <div class="HEART">
        <label for="star1">❤</label>
        <!-- 個々のハートの表示は,daoの方でユーザーidが❤した人の中になければ0であれば1にしてデータを返してそれを判別して表示を変える。 -->
        <!-- いいねの実装処理アイディア　裏画面で処理してデータベース接続し❤した人欄をコロン区切りで保存しているのでそれをsolitで配列にして全部比較して指定のものを削除して戻せばいい。 -->
      </div>
    </div>
    <!-- コメントに飛ぶbutton -->
    <div class="item">
      <div class="comment">
        <a href="text.html">💬</a>
      </div>
    </div>
    <!-- ブックマークに入れるbutton -->
    <div class="item">
      <div class="bookmark">
        <a>✔</a>
      </div>
    </div>
	</div>

  </div>


</div>
<div class="last">
  <h2>これ以上はレビューがありません</h2>
</div>

      <!--footerここまで-->
    </body>
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
                      <img src="/E1/image/home.png" alt="ホーム" class="footer-icon">
                      <p>ホーム</p>
                  </a>
                  <a href="">
                      <img src="/E1/image/chat.png" alt="チャット" class="footer-icon">
                      <p class="nimoji">検索</p>
                  </a>
                  <a href="">
                      <img src="/E1/image/timeline.png" alt="タイムライン" class="footer-icon">
                      <p id="timel" class="nimoji">TL</p>
                  </a>
                  <a href="">
                      <img src="/E1/image/checklist.png" alt="チェックリスト" class="footer-icon">
                      <p>持ち物</p>
                  </a>
              </div>
          </div>

</html>