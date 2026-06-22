<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryoukasidasi kakuninn</title>
</head>
<body>
	<h1>貸出確認</h1>
	<table border="1">
		<tr>
			<td>資料ID</td>
			<td>資料名</td>
			<td>返却期日</td>
		</tr>
		<c:forEach items="${rent_result }" var="result">
		<tr>
			<td>${result.book_id }</td>
			<td>${result.title }</td>
			<td>${result.return_deadline }</td>
		</tr>
		</c:forEach>
		
	</table>
	<form action="/Library_15/BookServlet" method="post">
		<button name="action" value="rentconfirm">貸出確定</button>
	</form>
</body>
</html>