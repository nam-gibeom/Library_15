<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>Member Regist</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/registcss.css">
</head>
<body>
<form action ="/Library_15/MemberServlet" method="post">
<table border="1" >
            <tr><th id = lable colspan="2">会員登録申請</th></tr>
          
<tr><td id = lable>氏名</td><td ><input type="text" name="name" id="max" ></td></tr>
<tr><td id = lable>住所</td><td ><input type="text" name="address" id="max"></td></tr>
<tr><td id = lable>電話番号</td><td ><input type="text" name="tel" id="max"></td></tr>
<tr><td id = lable>E-mail</td><td ><input type="text" name="mail" id="max"></td></tr>
 <div class="wrap"> 
<tr><td id = lable>生年月日</td><td><input type="text" size="4"name="birthy" id="ymd"><span>年</span><input type="text" size="1" name="birthm" id="ymd"><span>月</span><input type="text" size="1" name="birthd" id="ymd"><span>日</span></td></tr>
 </table>

 <input type="hidden" name="action" value="regist">
	<button class=btn-hover-20>登録</button>
	</form>
</body>

</html>