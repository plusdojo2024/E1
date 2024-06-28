<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>レビュー</title>
    <link rel="stylesheet" href="css/Review.css">
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
        <img src="/E1/image/${sessionScope.ic}" alt="アイコン" class="user-icon">
    </a>
    <hr class="header_hr">
    </header>
    <!--ヘッダーここまで-->

    <!--メイン-->
    <main>
        <form action="/E1/ReviewCreateServlet" method="post" enctype="multipart/form-data">
        <div class="file_btn">
		<input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
		</div>
		<div class="can">
		    <canvas id="preview" style="max-width:390px;text-align: center;position: relative;bottom: 160px;"></canvas><br>
		</div>
            <div class="submit">
                <input type="submit" value="送信"><!--画面右上に表示-->
            </div>
            	<input type="date" name="example" value="2024-01-01">
            <div>
            	<p>温泉名：<br>
				<input id="text" type="text" name="name"></p>
			</div>
           <div>
            	<textarea type="text" name="text" cols="50" rows="10"placeholder="こちらに感想を入力してください。"></textarea>
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
              </div>
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
              <video  class="preview" id="previewVideo" controls="controls"></video>-->

              </form>
			<!--<img src="${'/E1/images/'+=image}" id="gazo">-->
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
<script>
	function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
		console.log(fileReader.result) // ← (確認用)null
	}
</script>
</html>