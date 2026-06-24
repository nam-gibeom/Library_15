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
    <div class = titletop>会員＞会員登録</div>
<form id="form" action ="/Library_15/MemberServlet" method="post">
<table border="1" >
            <tr><th id = lable colspan="2">会員登録申請</th></tr>
          
<tr><td id = lable >氏名</td><td ><input type="text" name="name" id="max" value="${name }"></td></tr>
<tr><td id = lable width="30%">住所</td><td ><input type="text" name="address" id="max" value="${address }"></td></tr>
<tr><td id = lable width="30%">電話番号</td><td ><input type="text" name="tel" id="max" value="${tel }"></td></tr>
<tr><td id = lable width="30%">E-mail</td><td ><input type="text" name="mail" id="max" value="${mail }"></td></tr>
<tr><td id = lable>生年月日</td><td text-align=center><input type="text" size="4" name="birthy" id="ymd">年<input type="text" size="1" name="birthm" id="ymd">月<input type="text" size="1" name="birthd" id="ymd">日</td></tr>
 </table>
<br>
<div class=center>${error }</div>
<br>
 <input type="hidden" id="actionname" name="action" value="">
<button type="button" class=btn-hover-20 onclick="popapp()">登録</button>

</form>

	<script>
        function popapp() {
            // confirm()trueかfalse
            let result = confirm("このデータで登録してもよろしいですか？");
            
            if (result) {
                document.getElementById("actionname").value = "regist";
                document.getElementById("form").submit();
            } else {
                //alert("戻る");
            }
        }
    </script>
</body>

</html>