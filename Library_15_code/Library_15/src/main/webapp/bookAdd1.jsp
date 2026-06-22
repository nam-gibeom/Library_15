<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryoutouroku layout</title>
</head>
<body>
	<form action="/Library_15/BookServlet" method="post">
	<table border="1">
		<tr>
			<td>ISBN番号</td>
			<td><input type="text" name="isbn"></td>
			<td><button name="action" value="addsearch">検索</button></td>
		</tr>
	</table>
	</form>
	
	<br>
	<br>

<!--この下を隠す-->
	<c:if test="${exist_true }">
	<form action="/Library_15/BookServlet" method="post">
	<table border="1">
		<tr>
			<th>ISBN番号</th>
			<th>資料名</th>
			<th>分類名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>出版日</th>
		</tr>
		<tr>
			<td>${exist.isbn}</td>
			<td>${exist.title}</td>
			<td>${exist.category_name}</td>
			<td>${exist.author}</td>
			<td>${exist.publisher}</td>
			<td>${exist.publish_date}</td>
		</tr>
	</table>
	同じ物を登録しますか？
	<input type="hidden" name="isbn" value="${exist.isbn }">
	<button name="action" value="add1">登録</button>
	</form>
	</c:if>

	
	<c:if test="${exist_false }">
	 存在しない資料です。情報を入力してください。
	<form action="/Library_15/BookServlet" method="post">
		<table border="1">
		<tr>
			<th>資料名</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>分類名</th>
			<td><select size="1" name="category_name">
					<option name= "総記">総記</option>
					<option name= "哲学">哲学</option>
					<option name= "歴史">歴史</option>
					<option　name= "社会科学">社会科学</option>
					<option name = "自然科学">自然科学</option>
					<option name = "技術">技術</option>
					<option name = "産業">産業</option>
					<option name = "芸術">芸術</option>
					<option name = "言語">言語</option>
					<option name = "文学">文学</option>
			</select></td>
		</tr>
		<tr>
			<th>作者</th>
			<td><input type="text" name="author"></td>
		</tr>
		<tr>
			<th>出版社</th>
			<td><input type="text" name = "publisher"></td>
		</tr>
		<tr>
			<th>出版日</th>
			<td><input type="text" name = "publish_date" placeholder="20260622(８桁)"></td>
		</tr>
	</table>
	<input type="hidden" name="isbn" value="${isbn }">
	<button name="action" value = "add2" >登録</button>
	
	</form>
	
	
	</c:if>

</body>
</html>