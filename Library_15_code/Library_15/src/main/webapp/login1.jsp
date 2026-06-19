<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style type="text/css">
	body {
    font-family: sans-serif;
    background-color:#E6FFE9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.login-container {
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
}

h2 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

.input-group {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
    color: #666;
}

input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}

button:hover {
    background-color: #0056b3;
}
	
	</style>
	
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン画面</title>
    
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