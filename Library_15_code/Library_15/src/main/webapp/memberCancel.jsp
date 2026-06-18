<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kaiintaikai layout</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>会員ID</td>
			<td><input type="text"></td>
			<td><button>検索</button></td>
		</tr>
	</table>
	<br>
	<br>
	<table border="1">
		<tr>
			<td>会員ID</td>
			<td><input type="text" size="2" value="(ID)"></td>
			<td><input type="text">さん</td>
		</tr>
	</table>
	<br>
	<br>

	<table border="1">
		<tr>
			<td><input type="text" size="1" value="(ID)"></td>
			<td><input type="text" size="5" value="(資料ID)"></td>
			<td><input type="text" size="5" value="資料名"></td>
			<td><input type="text" size="5" value="貸出日"></td>
			<td><button>返却</button></td>
		</tr>
	</table>
	<br> 貸出が2点あるため退会できません
	<button>退会</button>
</body>
</html>