<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログイン画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css">
    
</head>

<body>
<form action="/Library_15/MenuServlet" method="POST">
    <div class="login-container">
        <h2>ログイン</h2>
            <div class="input-group">
                <label for="username">社員ID</label>
                <input type="text" id="username" name="staffid">
            </div>
            <div class="input-group">
                <label for="password">パスワード</label>
                <input type="password" id="password" name="password">
            </div>
            <button type="submit">ログイン</button>
            <input type ="hidden" name = "action" value="login">
        </form>
    </div>
</body>
</html>