<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kaiintouroku rayout</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/menuCSS.css">

</head>
<body height=100vh>

<!--	<div class="top">-->
<!--		<div class="logo">-->
<!--			<img class=left src="logo.jpeg" alt="やろうロゴ">-->
<!--		</div>-->
<!--		<h2 class=right>新宿図書館</h2>-->

<!--	</div>-->
<h3 class = admin>職員：${names}さん</h3>
		<form action="/Library_15/MenuServlet" method="post">
		<input type="hidden" name="action" value="logout">
		<button id=logout>ログアウト</button>
	</form>

<div class="menu">
	<dl>
		<dt>
			<h3 class = member>会員</h3>
		</dt>
		<dd>
			<a href="/Library_15/MenuServlet?action=regist">登録</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=update">変更</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=cancel">退会</a>
		</dd>
	</dl>
	<dl>
		<dt>
			<h3 class = book>資料</h3>
		</dt>
		<dd>
			<a href="/Library_15/MenuServlet?action=bookSearch">検索</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=rentSearch">貸出・返却</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=delay">延滞状況</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=addSearch">登録</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=discardSearch">紛失・廃棄</a>
		</dd>
	</dl>

	
</div>




</body>
</html>
