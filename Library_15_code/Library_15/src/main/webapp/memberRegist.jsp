<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Regist</title>
</head>
<body>
<form action ="/library15/MemberServlet" method="post">
<table border="1">
            <tr><th colspan="2">会員登録申請</th></tr>
<!--<tr><td>申請日</td><td><input type="text" size="4" >年<input type="text" size="1">月<input type="text" size="1">日</td></tr>-->
<tr><td>氏名</td><td><input type="text" name="name"></td></tr>
<tr><td>住所</td><td><input type="text" name="address"></td></tr>
<tr><td>電話番号</td><td><input type="text" name="tel"></td></tr>
<tr><td>E-mail</td><td><input type="text" name="mail"></td></tr>
<tr><td>生年月日</td><td><input type="text" size="4"name="birthy">年<input type="text" size="1" name="birthm">月<input type="text" size="1" name="birthd">日</td></tr>
 </table>
 <input type="hidden" name="action" value="regist">
	<button>登録</button>
</body>
</body>
</html>