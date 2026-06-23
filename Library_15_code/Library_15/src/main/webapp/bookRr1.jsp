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
	<c:if test="${fn:length(rent_list) > 1 }">
	<h2>返却　　　　　　　貸出</h2>
	<div class=tables-wrapper>
	<table border="1" class=test>
	<tr><th>資料ID</th><th>資料名</th><th>返却</th></tr>

	<c:forEach items="${rent_list }" var="rent">
		<tr><td id=lable>${rent.book_id }</td>
		<td>${rent.title }</td>
		<td id=lable>
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



	<form action="/Library_15/BookServlet" method="post">
	<table class=test>
	<tr><th>資料ID</th></tr>
	<c:forEach begin="1" end="${5 - fn:length(rent_list)}" var="i">
		<tr><th ><input type="text" name="book_id${i }"></th></tr>
	</c:forEach>
	</table>
	<input type="hidden" name="member_id" value="${member_id }">
	<button name="action" value="rent">貸出</button>
	</form>
	</c:if>
	</div>
	



</body>
</html>