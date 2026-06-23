<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryou touroku</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/RrCSS.css">
<style>
.hidden {
	display: none;
}

.input-row {
	margin: 8px 0;
}
</style>

</head>
<body>
	<div class = titletop>資料＞貸出・返却</div>
	<form action="/Library_15/BookServlet" method="post">
		<table border="1"class=search>
		<tr>
			<td id= lable>会員ID</td>
			<td class=searchtd><input type="text" id=max name="member_id" value="${member_id }"></td>
			<td class=searchtd><button name="action" class=btn-hover-20 value="rentsearch">検索</button>
			</td>
		</tr>
	</table>
	</form>
	
	
	<c:if test="${show}">
	<c:if test="${fn:length(rent_list) > 0 }">
	
	<div class=tables-wrapper>
	
	<table border="0" class=result>
	<tr><th id=lable1 colspan=3>返却</th></tr>
	<tr><th id=lable>資料ID</th><th id=lable>資料名</th><th id=lable>返却</th></tr>

	<c:forEach items="${rent_list }" var="rent">
		<tr><td id=lable>${rent.book_id }</td>
		<td class=resulttd>${rent.title }</td>
		<td class=resulttd>
		<form action="/Library_15/BookServlet" method="post">
		<input type="hidden" name="book_id" value="${rent.book_id }">
		<input type="hidden" name="member_id" value="${member_id }">
		<button name="action" class=btn-hover-20 value="return">返却</button>
		</form></td>
		</tr>
	</c:forEach>
	</tr>
	</table>
	</c:if>



	<form action="/Library_15/BookServlet" method="post">
	<table border=1 class=result1>
	<tr><th id=lable1>貸出</th></tr>
	<c:forEach begin="1" end="${5 - fn:length(rent_list)}" var="i">
		<tr><th class=resulttd><input type="text" id=max name="book_id${i }" placeholder="資料ID"></th></tr>
	</c:forEach>
	</table>
	<input type="hidden" name="member_id" value="${member_id }">
	<button class=button-hover-20 name="action" value="rent">貸出</button>
	</form>
	</c:if>
	</div>
	



</body>
</html>