<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist Result</title>
</head>
<body>
<h1>会員登録完了しました。</h1>

 会員ID<input type="text" value= ><br>
 会員名<input type="text" value= ${info.member_name }><br>
 <form action ="/library15/MemberServlet" method="post">
 <input type="hidden" name="action" value="confirm">
<button>OK</button>
</form>
</body>
</html>