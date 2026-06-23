<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Update</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/updateCSS.css">
</head>
<body>
    <div class = titletop>会員＞会員変更</div>
 <form action ="/Library_15/MemberServlet" method="post">
<table border="1" class="search">
        <tr><td id=lable>会員ID</td><td class="resulttd"><input type="text" id="max" name="memberid"></td><td class="resulttd">
         <input type="hidden" name="action" value="searchupdate">
        <button class="btn-hover-20">検索</button></td></tr>
         </table>
</form>
<div class=center>${error }</div>
         
         
<c:if test="${show }">
	<form id="form" action ="/Library_15/MemberServlet" method="post">
	<table border="1" class=result>
		<tr><th id=lable colspan="2">会員情報</th></tr>
		<tr><td id=lable >氏名</td><td class="resulttd"><input type="text" id="ymd" name="name"value=${info.member_name }></td></tr>
		<tr><td id=lable>住所</td><td class="resulttd"><input type="text" id="ymd" name="address" value=${info.member_address }></td></tr>
		<tr><td id=lable>電話番号</td><td class="resulttd"><input type="text" id="ymd" name="tel" value=${info.member_tel } ></td></tr>
		<tr><td id=lable>E-mail</td><td class="resulttd"><input type="text" id="ymd" name="mail" value=${info.member_mail } ></td></tr>
		<tr><td id=lable>生年月日</td><td class="resulttd"><input type="text" id="ymd" size="4" name="birthy" value=${info.member_birth_year } >年<input type="text" id="ymd" size="1" name="birthm" value=${info.member_birth_month }>月
	  	<input type="text" id="ymd" size="1" name="birthd"value=${info.member_birth_day }>日</td></tr>
	</table>
	<br>
  	<input type="hidden" name="memberid" value=${info.member_id}>
  	<input type="hidden" id="actionname" name="action" value="">
	<button type="button" class=button-hover-20 onclick="popapp()">変更</button>
	</form>
</c:if>        


	<script>
        function popapp() {
            // confirm()trueかfalse
            let result = confirm("このデータで登録してもよろしいですか？");
            
            if (result) {
                alert("登録が完了しました");

                document.getElementById("actionname").value = "update";
                document.getElementById("form").submit();
            } else {
                //alert("戻る");
            }
        }
    </script>
	
</body>
</html>