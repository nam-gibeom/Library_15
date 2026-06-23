<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Cancel</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/cancelCSS.css">
</head>
<body>
	<div class = titletop>会員＞会員退会</div>
 <form action ="/Library_15/MemberServlet" method="post">
<table border="1"class="search">
        <tr><td id=lable>会員ID</td><td class=resulttd><input type="text" id="max" name ="memberid"></td><td class=resulttd>
        <input type="hidden" name="action" value="searchcancel">
        <button class=btn-hover-20>検索</button></td></tr>
         </table>
</form>         

<c:if test="${show }" >
	<table border="1" class=search>
	<tr><td id=lable>会員ID</td><td class=resulttd1>${info.member_id }</td>
	<td class=resulttd><input type="text" id="max"value="${info.member_name }　さん"></td></tr>
	 </table>

</c:if>
	
<c:if test="${show && fn:length(rent_list) > 0 }">
	<table border="0" class=result>
	        <tr><th id=lable1>資料ID</th><th id=lable>資料名</th><th id=lable2>返却</th></tr>
	        <c:forEach items="${rent_list }" var="rent">
	        	<tr><td class=resulttd>${rent.book_id }</td><td class=resulttd>${rent.title }
	        	<td class=resulttd><form action ="/Library_15/MemberServlet" method="post">
	        	<input type="hidden" name="member_id" value="${info.member_id }">
	        	<input type="hidden" name="book_id" value="${rent.book_id }">
	        	
	        	<button name="action" value="return" class=btn-hover-20>返却</button>
	        	</form></td>
	        	</tr>
	        </c:forEach>
	</table>
	<p>まだ貸出の資料が「${fn:length(rent_list) }冊」 ありますので、退会できません。</p>
</c:if>

	<c:if test="${show && fn:length(rent_list) == 0 }">
		<form action="/Library_15/MemberServlet" method="post">
		<input type="hidden" name="id" value="${info.member_id }">
		<button name="action" value="cancel">退会</button>
		</form>
	</c:if>
	


</body>
</html>