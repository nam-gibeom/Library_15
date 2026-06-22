<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>enntaishaitirann layout</title>

<style type="text/css">
table {
  width: 80%;
  height: 80%;         
  table-layout: fixed;   
  border-collapse: collapse; 
}

th, 
td {
  width: 16%;
  vertical-align: middle;           
  word-break: break-all; 
  padding: 0;
}
td input {
  width: 100%;
  height: 100%;
  box-sizing: border-box;
 
  border: none;       
  outline: none;
}
#lable{
	background-color:olivedrab;
}

</style>
</head>
<body>
	<table border="1">
		<tr>
			<th id = lable colspan="5">延滞者一覧</th>
		</tr>
		<tr>
			<th>会員ID</th>
			<th>資料ID</th>
			<th>資料名</th>
			<th>返却日</th>
			<th>延滞日数</th>
		</tr>
		<tr>
			<td><input type="text" size="5" placeholder="会員ID"></td>
			<td><input type="text" size="5" placeholder="資料ID"></td>
			<td><input type="text" size="5" placeholder="資料名"></td>
			<td><input type="text" size="5" placeholder="返却日"></td>
			<td><input type="text" size="30" placeholder="延滞日数(赤い文字、古い順で)"></td>
		</tr>

		<tr>
			<td><input type="text" size="5"></td>
			<td><input type="text" size="5"></td>
			<td><input type="text" size="5"></td>
			<td><input type="text" size="5"></td>
			<td><input type="text" size="30"></td>
		</tr>
	</table>
</body>
</html>