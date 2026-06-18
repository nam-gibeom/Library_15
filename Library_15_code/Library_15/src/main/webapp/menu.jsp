<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kaiintouroku rayout</title>


</head>
<body>
	
	さんようこそ<br>
	<form action="/library_15/MenuServlet" method="post">
	<input type ="hidden" name="action" value="logout">
	<button>ログアウト</button>
	</form>
	<br><br>
	<dl>
	<form action="/library_15/MenuServlet" method="post">
		<dt>　会員</dt>
		<dd>・<button action = "regist">登録</button></a></dd>
		<dd>・<a><button action = "update">変更</button></a></dd>
		<dd>・<a><button action = "cancel">退会</button></a></dd>
	</form>
	</dl>
	<dl>
<dt>　資料</dt>
		<dd>・<a><button action = "search">検索</button></a></dd>
		<dd>・<a><button action = "rent">貸出・返却</button></a></dd>
		<dd>・<a><button action = "login">延滞状況</button></a></dd>
		<dd>・<a><button action = "add">登録</button></a></dd>
		<dd>・<a><button action = "discard">紛失・廃棄</button></a></dd>		
	</dl>
	
	
	
</body>
</html>
