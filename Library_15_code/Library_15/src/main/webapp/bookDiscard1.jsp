<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryouhaiki layout</title>
</head>
<body>
    <form action="/Library_15/BookServlet" method="GET">
	<table border="1">
		<tr>
			<td><option>資料ID</option></td>
			<td><input type="text" name = "book_id"></td>
			<td><button name="action" value="searchDiscard">検索</button></td>
		</tr>
	</table>
	<p>${error }</p>
	<br>
	<c:if test="${show }">
	<table border="1">
	<tr>
		<th>資料ID</th>
		<th>ISBN番号</th>
		<th>資料名</th>
		<th>入荷年月日</th>
		<th>廃棄年月日</th>
		<th>備考</th>
	</tr>
	   
	<tr>
	    <td>${result.book_id}</td>
	    <td>${result.isbn}</td>
	    <td>${result.title}</td>
	    <td>${result.arrival_date}</td>
	    <td>${result.discard_date}</td>
	    <td>${result.remarks}</td>
		</tr>
	
	</table>
	<br>
	
	<form action="/Library_15/BookServlet" method="POST">
	<input type="hidden" name="book_id1" value="${result.book_id}">
	<input type="radio" name="remarks" value="紛失">紛失
	<input type="radio" name="remarks" value="老化">老化
	<input type="radio" name="remarks" value="others">その他
	<input type="text" name="other" >
	<br> 廃棄年月日：
	<input type="text" name="discard_date" value = "${current_date}">
	<br>
	<button name="action" value="discard">廃棄</button>
	</form>
	</c:if>

</body>
</html>