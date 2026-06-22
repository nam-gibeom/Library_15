<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.login {
	max-width: 400px;
	margin: 0 auto;
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
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryoukasidasi kakuninn</title>
</head>
<body>


	<div class="login">
		<h1>貸出確認</h1>
		<form">
			<div class="form-group">
				資料ID<input type="text" class="form-control" readonly value=${info.book_id}> 
				資料名<input type="text" class="form-control" readonly value=${info.title}>
				返却期日<input type="text" class="form-control" readonly value=${info.return_deadline}>
			</div>
		</form>
		<form action="/Library_15/MemberServlet" method="post">
			<input type="hidden" name="action" value="rent">
			<button>完了</button>
		</form>
	</div>








</body>
</html>
