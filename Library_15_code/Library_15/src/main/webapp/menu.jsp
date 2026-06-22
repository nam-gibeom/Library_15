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
<body>

	<div class="top">
		<div class="logo">
			<img class=left src="logo.jpeg" alt="やろうロゴ">
		</div>
		<h2 class=right>新宿図書館</h2>

	</div>
<div class = name>職員：${names}さんようこそ</div>
	

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
			<a href="/Library_15/MenuServlet?action=search">検索</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=rent">貸出・返却</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=login">延滞状況</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=add">登録</a>
		</dd>
		<dd>
			<a href="/Library_15/MenuServlet?action=discard">紛失・廃棄</a>
		</dd>
	</dl>

	<form action="/Library_15/MenuServlet" method="post">
		<input type="hidden" name="action" value="logout">
		<button>ログアウト</button>
	</form>
</div>




</body>
</html>
