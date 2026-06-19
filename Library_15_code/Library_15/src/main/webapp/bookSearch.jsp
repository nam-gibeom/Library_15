<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Library_15/BookServlet" method="post">
	<table border="0">
     <tr><td>
     <select size="1" name="type">
     <option selected value="title">資料名</option>
     <option value="book_id">資料ID</option>
     <option value="isbn">ISBN番号</option>
     </select>
     </td><td><input type="text" name="value"></td><td><button name="action" value="booksearch">検索</button></td></tr>
      </table>
</form>
	
         <br>
         <br>
		<table border="1">
        <tr><th>資料名</th><th>類目名</th><th>出版日</th><th>貸出日数</th><th>貸出可能</th></tr>
        <c:forEach var="result1" items="${result }">
        	<tr><td>${result1.title }</td><td>${result1.category_name }</td><td>${result1.publish_date }</td><td>${result1.canRentDay }</td><td>${result1.rentAvailable }</td></tr>
        </c:forEach>
        
        </table>
	
</body>
</html>