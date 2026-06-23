<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/booksearchCSS.css">
</head>
<body>
<form action="/Library_15/BookServlet" method="post">
	<table border="1" class= "search">
     <tr><td id= lable>
     <select size="1" name="type" id=max2>
     <option selected value="title">資料名</option>
     <option value="book_id">資料ID</option>
     <option value="isbn">ISBN番号</option>
     </select>
     </td><td class="resulttd"><input type="text" name="value" id=max></td><td class="resulttd"><button name="action" value="booksearch" class=btn-hover-20>検索</button></td></tr>
      </table>
</form>


<c:if test="${show }">
<table border="1" class=result>
       <tr><th id= lable>資料名</th><th id= lable>類目名</th><th id= lable>出版日</th><th id= lable>貸出日数</th><th id= lable>貸出可能</th></tr>
       <c:forEach var="result1" items="${result }">
       	<tr><td class="resulttd">${result1.title }</td><td class="resulttd">${result1.category_name }</td><td class="resulttd">${result1.publish_date }</td><td class="resulttd">${result1.canRentDay }</td><td class="resulttd">${result1.rentAvailable }</td></tr>
       </c:forEach>
      </table>
</c:if>
	
</body>
</html>