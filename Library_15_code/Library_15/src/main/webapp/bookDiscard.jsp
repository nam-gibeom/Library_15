<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryouhaiki layout</title>
</head>
<body>
	<table border="1">
		<tr>
			<td><select size="1"><option selected>資料名</option>
					<option>資料ID</option>
					<option>ISBN番号</option></select></td>
			<td><input type="text"></td>
			<td><button>検索</button></td>
		</tr>
	</table>
	<br>
	<br>

	<table border="1">
		<tr>
			<th>資料ID</th>
			<th>ISBN番号</th>
			<th>資料名</th>
			<th>入荷年月日</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>
	<input type="radio" name="reason">紛失
	<input type="radio" name="reason">老化
	<input type="radio" name="reason">その他
	<input type="text">
	<br> 廃棄年月日：
	<input type="text" placeholder="default=今日の日付">
	<br>
	<button>廃棄</button>
</body>
</html>