<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="/E1/css/TimeLine.css">
</head>
<body>

	<header class="header"> <!--ロゴ--> <a href=""> <img
		src="/E1/image/logo_yutoripu2.png" alt="ロゴ" class="logo"></a> <!--ユーザーアイコン-->
	<a href=""> <img src="/E1/image/${sessionScope.ic}" alt="アイコン"
		class="user-icon"></a>
	<hr class="header_hr">
	</header>




	<div class="oll">
		<div class="items">
			<div class="item">
				<input type="button" value="タイムライン" onclick="">
					<h2></h2>
			</div>
			<div class="item">
			  
				<input type="submit" value="レビューの作成" onclick="location.href='/E1/ReviewCreateServlet';">
			</div>
		</div>
		<c:forEach var="k" items="${tlud}">
			<c:set var="name" value="" />
			<c:set var="icon" value="" />
			<c:set var="remark" value="" />
			<c:set var="rvimg" value="" />
			<c:set var="point" value="" />
			<!-- 複数のレビューを抽出  -->
			<c:set var="count" value="0" />
			<c:set var="eqDivid" value="${k}" />
			<c:set var="array1" value="${fn:split(eqDivid, '=')}" />
			<div class="frame1">
				<c:forEach var="item0" items="${array1[1]}">
					<!-- イコールの右辺だけ取り出す  -->

					<c:set var="commaDivid" value="${item0}" />
					<c:set var="array2" value="${fn:split(commaDivid, ',')}" />
				 <!-- カンマ区切りで取り出す  --> 
				<c:forEach var="item" items="${array2}">

							<c:if test="${count == 0}">
								<c:set var="name" value="${item}" />
							</c:if>
							<c:if test="${count == 1}">
								<c:set var="icon" value="${item}" />
							</c:if>
							<c:if test="${count == 2}">
								<c:set var="remark" value="${item}" />
							</c:if>
							<c:if test="${count == 3}">
								<c:set var="rvimg" value="${item}" />
							</c:if>
							<c:if test="${count == 4}">
								<c:set var="point" value="${item}" />
							</c:if>
							
							<c:set var="count" value="${count+1}" />
						</c:forEach>
			</div>
	</c:forEach>
	<div class="TOPTL">
			<div class="TimeLine">
				<div class="items">
					<div class="item">
						<img src="/E1/image/${icon}" alt="アイコン" class="rvuser-icon">
					</div>
					<div class="item">
						<div id="p_Nickname">
							<p class="uname">ユーザーネーム:${name}</p>
						</div>
					</div>
				</div>
					
				<!-- レビュー文の表示 -->
				<div id="rv_remark">
					<h2>投稿画像</h2>
					<img src="/E1/image/${rvimg}">
					<h2>レビュー</h2>
					<div id="rv_honbun">
						<p>${remark}</p>
						<br>
							<p>${e.rvRemark}</p>
					</div>
				</div>


				
				
				<div class="itemstr">
					
						<c:if test="${point == 1}">
								<a class="yes">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
							<%-- 条件に当てはまる場合 --%>
						</c:if>
						<c:if test="${point == 2}">
								<a class="yes">★</a>
								<a class="yes">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
							<%-- 条件に当てはまる場合 --%>
						</c:if>
						<c:if test="${point == 3}">
								<a class="yes">★</a>
								<a class="yes">★</a>
								<a class="yes">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
							<%-- 条件に当てはまる場合 --%>
						</c:if>
						<c:if test="${point == 4}">
								<a class="yes">★</a>
								<a class="yes">★</a>
								<a class="yes">★</a>
								<a class="yes">★</a>
								<a class="no">★</a>
							<%-- 条件に当てはまる場合 --%>
						</c:if>
						<c:if test="${point == 5}">
						<a class="yes">★</a>
						<a class="yes">★</a>
						<a class="yes">★</a>
						<a class="yes">★</a>
						<a class="yes">★</a>
							<%-- 条件に当てはまる場合 --%>
						</c:if>
						<c:if test="${point == 0}">
								<a class="no">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
								<a class="no">★</a>
						</c:if>
				
			
				
			</div>
			<!-- ユーザー側の乗せた画像・動画の表示 -->
			<div id="rv_img">
				<h2>動画・画像</h2>
				<img src="">
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
							<!--レビューidデータを、idに格納してボタンを押したらidの中身をセッションに入れ込むか送信する。。例）text.html?word=“季節の花”&order=“DESC”-->
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
		</c:forEach>
	</div>
	</div>
<div class="last">
  <h2>これ以上はレビューがありません</h2>
</div>
</body>


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
</html>