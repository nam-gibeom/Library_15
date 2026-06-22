<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>enntaishaitirann layout</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/topCSS.css">


</head>
<body>
	<table border="1">
		<tr>
			<th id = lable colspan="5">延滞者一覧</th>
		</tr>
		<tr>
			<th>会員ID</th>
			<th>資料ID</th>
			<th>資料名</th>
			<th>返却日</th>
			<th>延滞日数</th>
		</tr>

		<c:forEach items="${overdues }" var="overdue">
			<tr>
			<td>${overdue.member_id }</td>
			<td>${overdue.book_id }</td>
			<td>${overdue.title }</td>
			<td>${overdue.return_deadline }</td>
			<td>${overdue.overdue_date }</td>
			</tr>
		</c:forEach>
			

	</table>
</body>
</html>