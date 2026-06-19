<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kaiintouroku rayout</title>

<style type="text/css">

a{
  transition: color 0.3s;
}


a:hover{
  color : #ff7043;
}

h3 {
  color: #505050;/*文字色*/
  padding: 0.5em;/*文字周りの余白*/
  display: inline-block;/*おまじない*/
  line-height: 1.3;/*行高*/
  background: #dbebf8;/*背景色*/
  vertical-align: middle;
  border-radius: 25px 0px 0px 25px;/*左側の角を丸く*/
}

h3:before {
  content: '●';
  color: white;
  margin-right: 8px;
}
button {
    background-color: #FFE4E1;
    color: ; /*文字のカラー変更*/
    display: inline-block;/*要素の整列*/
    font-weight: 700;
    padding: 0.5rem 0.5rem;
    text-decoration: none;
    transition: 0.3s;
    border-radius: 25px 25px 25px 25px;/*を丸く*/
    border: none;
}

button:hover {
    box-shadow: 0px 12px 24px #0b5dae63;
    transform: translateY(-4px);
}
.line {
  position: relative;
  padding-left: 20px; /* 線と文字の間隔を確保 */
}

.line::before {
  content: "";
  position: absolute;
  top: 0px;
  left: 170px;
  width: 2px; /* 線の太さ */
  height: 100em; /* 線の高さ */
  background-color: #333; /* 線の色 */
}

.left-background {
  position: relative;
}

.left-background::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 12%; /* 左側30%だけ塗る場合 */
  height: 100px;
  background-color: #E6FFE9;
  z-index: -1; /* 文字の背面に配置 */
  margin: 0;
  padding: 0;
  min-height: 100vh;
}

</style>


</head>
<body>
	
	<div class = left-background>
	<div class = "line"></div>
	
	${names}さんようこそ<br>
	<form action="/Library_15/MenuServlet" method="post">
	<input type ="hidden" name="action" value="logout">
	<button>ログアウト</button>
	</form>
	<br><br>
	<dl>
	<form action="/Library_15/MenuServlet" method="post">
<dt><h3>会員</h3></dt>
		<dd>・<a href="/Library_15/MenuServlet?action=regist">登録</a></dd>
		<dd>・<a href="/Library_15/MenuServlet?action=update">変更</a></dd>
		<dd>・<a href="/Library_15/MenuServlet?action=cancel">退会</a></dd>
	</form>
	</dl>
	<dl>
<dt><h3>資料</h3></dt>
		<dd>・<a href="/Library_15/MenuServlet?action=search">検索</a></dd>
		<dd>・<a href="/Library_15/MenuServlet?action=rent">貸出・返却</a></dd>
		<dd>・<a href="/Library_15/MenuServlet?action=login">延滞状況</a></dd>
		<dd>・<a href="/Library_15/MenuServlet?action=add">登録</a></dd>
		<dd>・<a href="/Library_15/MenuServlet?action=discard">紛失・廃棄</a></dd>
</dl>


	</div>
	
	
</body>
</html>
