<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryou touroku</title>
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
	<form action="/Library_15/BookServlet" method="post">
		<table border="1">
		<tr>
			<td>会員ID</td>
			<td><input type="text" name="member_id" value="${member_id }"></td>
			<td><button name="action" value="rentsearch">検索</button>
			</td>
		</tr>
	</table>
	</form>
	<p>${error }</p>
	
	
	<c:if test="${show}">
	<c:if test="${fn:length(rent_list) >= 1 }">
	<h2>返却</h2>
	<table border="1">
	<tr><th>資料ID</th><th>資料名</th><th>返却</th></tr>

	<c:forEach items="${rent_list }" var="rent">
		<tr><td>${rent.book_id }</td>
		<td>${rent.title }</td>
		<td>
		<form action="/Library_15/BookServlet">
		<input type="hidden" name="book_id" value="${rent.book_id }">
		<input type="hidden" name="member_id" value="${member_id }">
		<button name="action" value="return">返却</button>
		</form>
		</tr>
	</c:forEach>
	</tr>
	</table>
	</c:if>
	

	<h2>貸出</h2>
	<form action="/Library_15/BookServlet" method="post">
	<table >
	<tr><th>資料ID</th></tr>
	<c:forEach begin="1" end="${5 - fn:length(rent_list)}" var="i">
		<tr><th><input type="text" name="book_id${i }"></th></tr>
	</c:forEach>
	</table>
	<input type="hidden" name="member_id" value="${member_id }">
	<button name="action" value="rent">貸出</button>
	</form>
	<p>${error1 }</p>
	</c:if>
	
	



</body>
</html>