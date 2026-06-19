<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login rayout</title>
</head>

<body>
<form action="/Library_15/MenuServlet" method="post">
    <div style="text-align: center;">
<h1>新宿図書館管理システム</h1>
<h2>今日も頑張って！</h2><br>
  社員ID：<input type="text" name="staffid"><br>
password：<input type="text" name="password"><br>
<button>ログイン</button>
<input type ="hidden" name="action" value="login">
</div>

</form>
</body>
</html>

</body>
</html>