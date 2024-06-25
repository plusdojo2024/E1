<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aaaa</title>


<link rel="stylesheet" href="css/CheckListView.css">


</head>
<body>
<div class="onaka">
<br><br><br>
<p class="midasi">・作成したチェックリスト</p>
<a href="/E1/CheckListRegistServlet">
	<img src="/image/plus.png">
</a>

<c:set var="end" value="${CheckList.size() - 1}" />
<c:if test="${end >= 0}">
	<c:forEach begin="0" end="${end}" step="1" var="i">
		<form id="item${i}" class="itiran_form" method="POST" action="/E1/CheckListViewServlet">
			<input class="itiran_text" type="text" name="cl_Name" value="${CheckList[i].cl_Name }" readonly>
			<input class="detail" type="submit" class="post_button" name="detail" value="詳細">
		</form>
	<br>
</c:forEach>
</c:if>
</div>



<!--テンプレート＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->
    <header id="header">

        <!--ロゴ-->
        <a href="">
            <img src="image/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ユーザーアイコン-->
        <a href="">
            <img src="image/OIP (3).jpg" alt="アイコン" class="user-icon">
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
                    <p class="nimoji">投稿</p>
                </a>
                <a href="CheckListServlet.java">
                    <img src="image/checklist.png" alt="チェックリスト" class="footer-icon">
                    <p>持ち物</p>
                </a>
          </div>
    </div>
    </footer>
    <!--footerここまで＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->


</body>
</html>
