<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>検索結果｜ゆとりっぷ</title>
    <link rel="stylesheet" href="/E1/css/header_footer.css">
    <link rel="stylesheet" type="text/css" href="/E1/css/ChatSearchResult.css">
</head>
<body>
<header id="header">

        <!--ロゴ-->
        <a href="/E1/HomeServlet">
            <img src="image/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ユーザーアイコン-->
        <a href="/E1/UserChangeServlet">
            <img src="image/OIP (3).jpg" alt="アイコン" class="user-icon">
        </a>
        <hr class="header_hr">
    </header>
    <!-- ↑山本さん作成 -->
    <main>
    <a href="E1/ChatSearchResyultServlet"></a>

    <div ><img src="image/fuwa.png" class="bird"></div>

<!-- 写真横スライドさせるための始まり -->

    <c:set var="end" value="${answer.size() - 1}" />
<c:if test="${end >= 0}">
	<c:forEach begin="0" end="${end}" step="1" var="i">
		<form id="Box${i}" class="itiran_form" method="POST" action="/E1/ChatResultServlet">
			<img src="${hs_img }">
			<input class="detail" type="submit" class="post_button" name="detail" value="詳細">
		</form>
	<br>
</c:forEach>
</c:if>
</div>
    <div class="Container">
        <div class="Box-Container">


            <!-- 必要な数の.Box要素を追加 -->
        </div>
        <div class="Arrow left">
            <</div>
                <div class="Arrow right">></div>
        </div>
    </div>
<!-- スライド終了 -->
    </main>
        <!-- 山本さん作成↓ -->
        <footer id="footer">
            <div id="footer-wrapper">
                <hr>
                <!--画面下アイコン-->
                <div id="footer-tag">
                    <a href="/E1/HomeServlet">
                        <img src="image/home.png" alt="ホーム" class="footer-icon">
                        <p>ホーム</p>
                    </a>
                    <a href="/E1/ChatSearchServlet">
                        <img src="image/chat.png" alt="チャット" class="footer-icon">
                        <p class="nimoji">検索</p>
                    </a>
                    <a href="/E1/TimeLineServlet">
                        <img src="image/timeline.png" alt="タイムライン" class="footer-icon">
                        <p class="nimoji">TL</p>
                    </a>
                    <a href="/E1/CheckListServlet">
                        <img src="image/checklist.png" alt="チェックリスト" class="footer-icon">
                        <p>持ち物</p>
                    </a>
        </footer>
        <script>
            const container = document.querySelector('.Container');
            const boxContainer = document.querySelector('.Box-Container');
            const leftArrow = document.querySelector('.Arrow.left');
            const rightArrow = document.querySelector('.Arrow.right');
            const scrollAmount = 841; // ３回で最大値まで行く程度の数値

            leftArrow.addEventListener('click', () => {
            const containerWidth = container.offsetWidth;
            const maxScrollAmount = boxContainer.offsetWidth - containerWidth;
            const currentScrollAmount = Math.abs(parseInt(boxContainer.style.transform.split('(')[1])) || 0;
            const newScrollAmount = Math.max(currentScrollAmount - scrollAmount, 0);
            boxContainer.style.transform = `translateX(-${newScrollAmount}px)`;
            updateArrowVisibility(newScrollAmount, maxScrollAmount);
            });

            rightArrow.addEventListener('click', () => {
            const containerWidth = container.offsetWidth;
            const maxScrollAmount = boxContainer.offsetWidth - containerWidth;
            const currentScrollAmount = Math.abs(parseInt(boxContainer.style.transform.split('(')[1])) || 0;
            const newScrollAmount = Math.min(currentScrollAmount + scrollAmount, maxScrollAmount);
            boxContainer.style.transform = `translateX(-${newScrollAmount}px)`;
            updateArrowVisibility(newScrollAmount, maxScrollAmount);
            });

            function updateArrowVisibility(scrollAmount, maxScrollAmount) {
            if (scrollAmount === 0) {
                leftArrow.classList.add('Hide');
            } else {
                leftArrow.classList.remove('Hide');
            }

            if (scrollAmount === maxScrollAmount) {
                rightArrow.classList.add('Hide');
            } else {
                rightArrow.classList.remove('Hide');
            }
            }
        </script>
</body>
</html>