<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryouhaiki layout</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/discardCSS.css">
</head>
<body>

	<div class=titletop>資料＞貸出・返却</div>
	<form action="/Library_15/BookServlet1" method="GET">



		
		<form action="/Library_15/BookServlet" method="post">
			<table border="1" class=search>
				<tr>
					<td id=lable>会員ID</td>
					<td class=searchtd><input type="text" id=max name="book_id"></td>
					<td class=searchtd><button name="action" class=btn-hover-20
						value="searchDiscard">検索</button></td>
				</tr>
			</table>
		</form>
		<br><br><br><br><br>



		<table border="1" class=result>
			<tr>
				<th id=lable>資料ID</th>
				<th id=lable>ISBN番号</th>
				<th id=lable>資料名</th>
				<th id=lable>入荷年月日</th>
				<th id=lable>廃棄年月日</th>
				<th id=lable>備考</th>
			</tr>

			<tr>
				<td class=resulttd1>${result.book_id}</td>
				<td class=resulttd>${result.isbn}</td>
				<td class=resulttd>${result.title}</td>
				<td class=resulttd>${result.arrival_date}</td>
				<td class=resulttd>${result.discard_date}</td>
				<td class=resulttd>${result.remarks}</td>
			</tr>


			<form action="/Library_15/BookServlet" method="POST">

				<tr>
					<input type="hidden" name="book_id1" value="${result.book_id}">
					<td class=resulttd><name="remarks">廃棄理由</td>
					<td class=resulttd><input type="radio" name="remarks" value="紛失">紛失</td>
					<td class=resulttd><input type="radio" name="remarks" value="老化">老化</td>
					<td colspan="4" class=resulttd><input type="radio" name="remarks"
						value="others">その他 :<input type="text" id= max1 name="other"</td>

				</tr>

				<tr>
					<td class=resulttd>廃棄年月日</td>
					<td colspan="5" class=resulttd1><input type="text" id="max"
						name="discard_date" value="${current_date}"></td>

				</tr>

			</form>
			</c:if>

		</table>
		<button name="action" value="discard" class="button-hover-20">廃棄</button>

	</form>

	</form>

</body>
</html>