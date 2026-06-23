<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.login {
	max-width: 400px;
	margin: 4em auto;
	padding: 2rem;
	background: #fff;
	border-radius: 12px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.login h2 {
	text-align: center;
	margin-bottom: 2rem;
	color: #333;
	font-weight: 600;
}

.login .form-group {
	margin-bottom: 1.5rem;
}

.login .form-label {
	display: block;
	margin-bottom: 0.5rem;
	font-weight: 500;
	color: #555;
}

.login .form-control {
	width: 100%;
	padding: 12px 16px;
	border: 2px solid #e1e5e9;
	border-radius: 8px;
	font-size: 16px;
	transition: border-color 0.3s ease, box-shadow 0.3s ease;
	background-color: #fff;
	box-sizing: border-box;
}

.login .form-control:focus {
	outline: none;
	border-color: #ff6b6b;
	box-shadow: 0 0 0 3px rgba(255, 107, 107, 0.1);
}

.login .btn-login {
	width: 100%;
	padding: 12px;
	background: linear-gradient(135deg, #ff6b6b, #ff8e8e);
	color: white;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: 600;
	cursor: pointer;
	transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.login .btn-login:hover {
	transform: translateY(-2px);
	box-shadow: 0 8px 25px rgba(255, 107, 107, 0.3);
}

.login .form-check {
	display: flex;
	align-items: center;
	margin-bottom: 1.5rem;
}

.login .form-check-input {
	margin-right: 0.5rem;
}

.login .form-check-label {
	font-size: 14px;
	color: #666;
}

.button-hover-20 {
	display: flex;
	justify-content: center;
	align-items: center;
	position: relative;
	width: 100px;
	margin: 0 auto 32px;
	padding: .9em 2em;
	font-weight: 600;
	text-decoration: none;
	transition: all 0.3s ease;
	z-index: 1;
	border-radius: 5px;
}

.button-hover-20 span {
	position: relative;
	z-index: 2;
}

.button-hover-20 {
	border: 1px solid olivedrab;
	background-color: white;
	color: olivedrab;
	
	
}

.button-hover-20:hover {
/*	background-color: darkolivegreen;*/
	background-color: olivedrab;
	color: #FFFFEE;
}
</style>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist Result</title>
</head>

<div class="login">
	<h2>会員登録完了</h2>
	<form>
		<div class="form-group">
			会員ID <input type="text" class="form-control" readonly value=${info.member_id}><br>
			会員名 <input type="text" class="form-control" readonly value=${info.member_name}> <br>
		
		</div>
		<div class="form-group"></div>
	</form>


	<form action="/Library_15/MemberServlet" method="post">
		<input type="hidden" name="action" value="confirm">
		<button class = button-hover-20>完了</button>
	</form>
</div>


</html>
