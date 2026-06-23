<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.titletop{
	color:grey;
	text-decoration: underline;
	font-size: 150%;
	margin-top:20px;
	  margin-left:-850px;       
	  padding: 0;
}

.search {
	font-size: 120%;
	border-collapse: collapse;
	border: solid 1px black;
	width: 600px;
	height: 20px;
	/* ここを自由に調整 */
	border-collapse: collapse;
	 box-sizing: border-box;
	 margin: 4em 0em 0em 0em;
	 box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
}



#lable {
	background-color: rgb(215, 235, 171);
	color: darkolivegreen;
	text-align: center;
	border: solid 2px olivedrab;

		vertical-align: middle;
		word-break: break-all;
		padding: 0;
	

}

table {
	font-size: 120%;
	border-collapse: collapse;
	border: solid 1px black;
	width: 700px;
	height: 200px;
	/* ここを自由に調整 */
	border-collapse: collapse;
	margin: -8em 1em 0em 1.5em;
}

table th, table td {
	border: solid 2px olivedrab;
	vertical-align: middle;
	word-break: break-all;
	padding: 0;
	/*実線 1px 黒*/
}

.container {
	display: flex; /* フレックスボックスを有効化 */
}

#max {
	width: 100%;
	height: 100%;
	box-sizing: border-box;
	border: none;
	outline: none;
	background-color: #FFFFEE;
	font-size: 125%;
}

#ymd {
	border: none;
	outline: none;
	background-color: #FFFFEE;
	text-align: center;
	font-size: 125%;
}

.btn {
	display: inline-block;
	color: darkolivegreen;
	text-decoration: none;
	background-color: rgb(215, 235, 171);
	/*	background-color: darkolivegreen;*/
	border-radius: 0.4em;
	padding: 0.5em 1em;
	transition: 0.5s;
}

.btn-hover-20 {
	display: flex;
	justify-content: center;
	align-items: center;
	position: relative;
	width: 100px;
	margin: 0 auto 32px;
	padding: .9em 2em;
	font-weight: 600;
	text-decoration: none;
	transition: all 0.3s ease;
	z-index: 1;
	border-radius: 5px;
}

.btn-hover-20 span {
	position: relative;
	z-index: 2;
}

.btn-hover-20 {
	border: 1px solid olivedrab;
	background-color: white;
	color: olivedrab;
}

.btn-hover-20:hover {
	/*	background-color: darkolivegreen;*/
	background-color: olivedrab;
	color: #FFFFEE;
}






.btn2 {
	display: flex;
	    justify-content: center;
	    align-items: center;
	    width: 100%;
	    height: 100%;
	    font-weight: 600;
	    text-decoration: none;
	    transition: all 0.3s ease;
	    z-index: 1;
	  
	    border: none; /* 칸 테두리와 겹치지 않게 */
	    background-color: #fff; /* 칸 배경색과 맞추기 */
	    color: #6b8e23; /* 텍스트 색상 */
	    cursor: pointer;
}

.btn2 span {
	position: relative;
	z-index: 2;
}

.btn2 {
	border: 1px solid olivedrab;
	background-color: white;
	color: olivedrab;
	
	
}

.btn2:hover {
/*	background-color: darkolivegreen;*/
	background-color: olivedrab;
	color: #FFFFEE;
}

.but2 {
	display: flex;
	justify-content: center;
	align-items: center;
	position: relative;
	width: 100px;
	margin: 0 auto 32px;
	padding: .9em 2em;
	font-weight: 600;
	text-decoration: none;
	transition: all 0.3s ease;
	z-index: 1;
	border-radius: 5px;
}

.button-hover-20 span {
	position: relative;
	z-index: 2;
}

.button-hover-20 {
	border: 1px solid olivedrab;
	background-color: white;
	color: olivedrab;
	
	
}

.button-hover-20:hover {
/*	background-color: darkolivegreen;*/
	background-color: olivedrab;
	color: #FFFFEE;
}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>siryouhaiki layout</title>
</head>
<body>


	<form action="/Library_15/BookServlet1" method="GET">



		<div class=titletop>資料＞貸出・返却</div>
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



		<table border="1">
			<tr>
				<th id=lable>資料ID</th>
				<th id=lable>ISBN番号</th>
				<th id=lable>資料名</th>
				<th id=lable>入荷年月日</th>
				<th id=lable>廃棄年月日</th>
				<th id=lable>備考</th>
			</tr>

			<tr>
				<td id=lable>${result.book_id}</td>
				<td id=lable>${result.isbn}</td>
				<td id=lable>${result.title}</td>
				<td id=lable>${result.arrival_date}</td>
				<td id=lable>${result.discard_date}</td>
				<td id=lable>${result.remarks}</td>
			</tr>


			<form action="/Library_15/BookServlet" method="POST">

				<tr>
					<input type="hidden" name="book_id1" value="${result.book_id}">
					<td><name="remarks">廃棄理由</td>
					<td><input type="radio" name="remarks" value="紛失">紛失</td>
					<td><input type="radio" name="remarks" value="老化">老化</td>
					<td colspan="4"><input type="radio" name="remarks"
						value="others">その他<input type="text" name="other"</td>

				</tr>

				<tr>
					<td>廃棄年月日</td>
					<td colspan="5"><input type="text" id="max"
						name="discard_date" value="${current_date}"></td>

				</tr>

			</form>
			</c:if>

		</table>
		<br>
		<button name="action" value="discard" class="btn-hover-20">廃棄</button>

	</form>

	</form>

</body>
</html>