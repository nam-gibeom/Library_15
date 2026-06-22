<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Update</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/registcss.css">
</head>
<body>
 <form action ="/Library_15/MemberServlet" method="post">
<table border="1">
        <tr><td id=lable>会員ID</td><td><input type="text" name="memberid" ></td><td>
         <input type="hidden" name="action" value="searchupdate">
        <button>検索</button></td></tr>
         </table>
</form>
         
         
        
<form action ="/Library_15/MemberServlet" method="post">
<table border="1">
	<tr><th id=lable colspan="2">会員情報</th></tr>
	<tr><td id=lable>氏名</td><td><input type="text"name="name"value=${info.member_name }></td></tr>
	<tr><td id=lable>住所</td><td><input type="text"name="address" value=${info.member_address } ></td></tr>
	<tr><td id=lable>電話番号</td><td><input type="text" name="tel" value=${info.member_tel }></td></tr>
	<tr><td id=lable>E-mail</td><td><input type="text"name="mail" value=${info.member_mail }></td></tr>
	<tr><td id=lable>生年月日</td><td><input type="text" size="4" name="birthy" value=${info.member_birth_year }>年<input type="text" size="1" name="birthm" value=${info.member_birth_month }>月
	     					  <input type="text" size="1" name="birthd"value=${info.member_birth_day }>日</td></tr>
 </table>
  <input type="hidden" name="memberid" value=${info.member_id }>
  <input type="hidden" name="action" value="update">
	<button>変更</button>
	</form>
</body>
</html>