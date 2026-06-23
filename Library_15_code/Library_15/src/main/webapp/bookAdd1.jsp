<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryoutouroku layout</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/addCSS.css">
</head>
<body>
<div class = titletop>資料＞資料登録</div>
	<form action="/Library_15/BookServlet" method="post">
		<table border="1"class= search>
			<tr>
				<td id = lable>ISBN番号</td>
				<td class=searchtd><input type="text" name="isbn" id="max" value=${isbn }></td>
				<td class=searchtd><button name="action" value="addsearch" class="btn-hover-20">検索</button></td>
			</tr>
		</table>
	</form>
	<p>${error }</p>

	<br>
	<br>


	<!--この下を隠す-->
	<c:if test="${exist_true }">
		<form action="/Library_15/BookServlet" method="post">
			<table border="1" class=result2>
				<tr>
					<th id = lable1>ISBN番号</th>
					<th id = lable1>資料名</th>
					<th id = lable1>分類名</th>
					<th id = lable1>作者</th>
					<th id = lable1>出版社</th>
					<th id = lable1>出版日</th>
				</tr>
				<tr>
					<td class=resulttd>${exist.isbn}</td>
					<td class=resulttd>${exist.title}</td>
					<td class=resulttd>${exist.category_name}</td>
					<td class=resulttd>${exist.author}</td>
					<td class=resulttd>${exist.publisher}</td>
					<td class=resulttd>${exist.publish_date}</td>
				</tr>
			</table>
			<div class=center>同じ資料を追加しますか？</div> <input type="hidden" name="isbn" value="${exist.isbn }">
			<button name="action" value="add1" class=button-hover-20>登録</button>
		</form>
	</c:if>






	<c:if test="${exist_false }">
	 <div class=center>存在しない資料です。情報を入力してください。</div>
	<form action="/Library_15/BookServlet" method="post">
			<table border="1" class=result>
				<tr>
					<th id = lable>資料名</th>
					<td class=resulttd><input type="text" id="max" name="title" ></td>
				</tr>
				<tr>
					<th id = lable>分類名</th>
					<td class=resulttd><select size="1" id="max1" name="category_name">
							<option name="総記">総記</option>
							<option name="哲学">哲学</option>
							<option name="歴史">歴史</option>
							<option name="社会科学">社会科学</option>
							<option name="自然科学">自然科学</option>
							<option name="技術">技術</option>
							<option name="産業">産業</option>
							<option name="芸術">芸術</option>
							<option name="言語">言語</option>
							<option name="文学">文学</option>
					</select></td>
				</tr>
				<tr>
					<th id = lable>作者</th>
					<td class=resulttd><input type="text" name="author" id="max"></td>
				</tr>
				<tr>
					<th id = lable>出版社</th>
					<td class=resulttd><input type="text" name="publisher" id="max"></td>
				</tr>
				<tr>
					<th id = lable>出版日</th>
					<td class=resulttd><input type="text" id="max" name="publish_date"
						placeholder="yyyymmdd(8桁)"></td>
				</tr>
			</table>
			<input type="hidden" name="isbn" value="${isbn }">
			<button class=button-hover-20 name="action" value="add2">登録</button>

		</form>


	</c:if>



</body>
</html>