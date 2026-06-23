<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Cancel</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/cancelCSS.css">
</head>
<body>
 <form action ="/Library_15/MemberServlet" method="post">
<table border="1"class="search">
        <tr><td id=lable>会員ID</td><td class=resulttd><input type="text" id="max" name ="memberid"></td><td class=resulttd>
        <input type="hidden" name="action" value="searchcancel">
        <button class=btn-hover-20>検索</button></td></tr>
         </table>
</form>         
<br>


 <form action ="/Library_15/MemberServlet" method="post">
<table border="1" class="search">
<tr><td id=lable>会員ID</td><td class=resulttd><input type="text" size="2" id="max" name = "id" value=${info.member_id }></td><td class=resulttd><input type="text" id="ymd" name="name" value=${info.member_name }>さん</td>
<td class=resulttd>
<input type="hidden" name="action" value="cancel">
<button class=btn-hover-20>退会</button></td></tr>
 </table>
</form>
<br>


<table border="1" class="search">
        <tr><td class=resulttd><input type="text" size="1" id="max" value="(ID)"></td><td class=resulttd><input type="text" size="5" id="max" value="(資料ID)"></td><td class=resulttd><input type="text" size="5" id="max" value="資料名"></td>
        <td class=resulttd><input type="text" size="5" id="max" value="貸出日"></td><td class=resulttd><button class=btn-hover-20>返却</button></td></tr>
</table><br>

貸出が2点あるため退会できません　

</body>
</html>