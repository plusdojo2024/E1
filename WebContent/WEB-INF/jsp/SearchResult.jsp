<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <title>検索結果詳細｜ゆとりっぷ</title>
    <link rel="stylesheet" href="/E1/css/SearchResult.css">
    <link rel="stylesheet" type="text/css" href="/E1/css/header_footer.css">
</head>
<body>
 <!--header-->
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
<!--headerここまで-->

<main>
    <div id="onsen">


        <h1 class="ttl_line">温泉詳細</h1>

        <c:set var="end" value="${cardlist.size() - 1}" />
        <c:if test="${end >= 0 }">
         <c:forEach var="e" items="${cardlist}">
        <tr>
            <th><img src="/E1/${e.HS_IMG}.jpg" class="hs_pic"></th>
            <td></td>
        </tr>
        <table class="shosai">
        <tr>
            <th>温泉名</th>
            <td>${e.ONSEN_NAME}</td>
        </tr>

        <tr>
            <th>住所</th>
            <td>${e.HS_ADDRESS}</td>
        </tr>

        <tr>
            <th>電話番号</th>
            <td>${e.HS_PHONE}</td>
        </tr>

        <tr>
            <th>公式HP</th>
            <td>${e.HS_URL}</td>
        </tr>

        <tr>
            <th>値段</th>
            <td>${e.HS_VALUE}</td>
        </tr>

        <tr>
            <th>効能</th>
            <td>${e.HS_EFFECT}</td>
        </tr>

        </table>
        </c:forEach>
        </c:if>
    </div>
</main>

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
</body>
</html>