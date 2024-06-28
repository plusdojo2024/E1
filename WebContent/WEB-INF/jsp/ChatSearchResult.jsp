<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
            <img src="/E1/image/logo_yutoripu2.png" alt="ロゴ" class="logo">
        </a>
        <!--ユーザーアイコン-->
        <a href="/E1/UserChangeServlet">
            <img src="/E1/image/${sessionScope.ic}" alt="アイコン" class="user-icon">
        </a>
        <hr class="header_hr">
    </header>
    <!-- ↑山本さん作成 -->
    <main>
    <a href="E1/ChatSearchResyultServlet"></a>

    <div ><img src="/E1/image/fuwa.png" class="bird"></div>
${cardlist}
<div class="koumoku_iti">
<form id="item0" method="POST" action="/E1/ChatResultServlet">
<img src="/E1/image/33.jpg" >
<div class="kesu">
  	  		<input type="text" value="1">
  	  		</div>
  	  		<input type="hidden" name="hantei" value="1"> 
    		<input type="submit" value="詳細">
    	
    	</div>
    	
  <div class="koumoku_iti">
<form id="item1" method="POST" action="/E1/ChatResultServlet">
<img src="/E1/image/34.jpg" >
<div class="kesu">
  	  		<input type="text" value="2">
  	  		</div>
  	  		<input type="hidden" name="hantei" value="2"> 
    		<input type="submit" value="詳細">
    	
    	</div>
   <form id="item2" method="POST" action="/E1/ChatResultServlet">
<img src="/E1/image/32.jpg" >
<div class="kesu">
  	  		<input type="text" value="3">
  	  		</div>
  	  		<input type="hidden" name="hantei" value="3"> 
    		<input type="submit" value="詳細">
    	
    	</div>
    	
    	   <form id="item3" method="POST" action="/E1/ChatResultServlet">
<img src="/E1/image/30.jpg" >
<div class="kesu">
  	  		<input type="text" value="4">
  	  		</div>
  	  		<input type="hidden" name="hantei" value="4"> 
    		<input type="submit" value="詳細">
    	
    	</div>
    	
<!-- 写真横スライドさせるための始まり -->
<!--<div class="koumoku_iti">
<c:set var="array" value="${fn:split(cardlist, '=')}" />
<c:set var="i" value="0"/> 
<c:forEach var="item0" items="${array}" >
<c:if test="${number < 4}" >
<c:set var="a" value="${fn:split(item0, ',')}" />
<c:set var="b" value="0"/>
<form id="item${i}" method="POST" action="/E1/ChatResultServlet">
<c:forEach var="list" items="${a}" >
<p><c:out value="${cardlist}" />aaaa</p>

     
     <c:if test="${i == 6}">
    	<img src="${list}" >
    	</c:if>
    	<c:if test="${i == 0}">
    	<div class="kesu">
  	  		<input type="text" value="${list}">
    	</div>
    	
    		<input type="hidden" name="hantei" value=""> 
    		<input type="submit" value="詳細">
    	</c:if>
   
    
    <c:set var="b" value="${b + 1}"/>
    </c:forEach>
     </form>
   </c:if>
    <c:set var="i" value="${i + 1}"/>
   </c:forEach>
</div>-->
<!-- スライド終了 -->
    </main>
        <!-- 山本さん作成↓ -->
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