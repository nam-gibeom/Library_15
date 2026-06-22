<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<table border="1">
		<tr>
			<td>会員ID</td>
			<td><input type="text"></td>
			<td><button>検索</button></td>
		</tr>
	</table>
	<br>
	<br>


	<h2>返却</h2>
	<table border="1">
		<tr>
			<td><input type="text" placeholder="資料ID"></td>
			<td><input type="text" placeholder="タイトル"></td>
			<td><button onclick="showRow('row6')">返却</button></td>
		</tr>
	</table>


	<div id="row2" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
				<td><input type="text" placeholder="タイトル"></td>
				<td><button onclick="showRow('row7')">返却</button></td>
			</tr>
		</table>

	</div>

	<div id="row3" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
				<td><input type="text" placeholder="タイトル"></td>
				<td><button onclick="showRow('row8')">返却</button></td>
			</tr>
		</table>
	</div>

	<div id="row4" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
				<td><input type="text" placeholder="タイトル"></td>
				<td><button onclick="showRow('row9')">返却</button></td>
			</tr>
		</table>
	</div>

	<div id="row5" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
				<td><input type="text" placeholder="タイトル"></td>
				<td><button onclick="showRow('row10')">返却</button></td>
			</tr>
		</table>
	</div>
	<br>

	<hr>

	<h2>貸出</h2>
	<div id="row6" class="hidden" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
			</tr>
		</table>
	</div>

	<div id="row7" class="hidden" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
			</tr>
		</table>
	</div>

	<div id="row8" class="hidden" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
			</tr>
		</table>
	</div>

	<div id="row9" class="hidden" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
			</tr>
		</table>
	</div>

	<div id="row10" class="hidden" class="input-row">
		<table border="1">
			<tr>
				<td><input type="text" placeholder="資料ID"></td>
			</tr>
		</table>
	</div>
	<br>
	<button>次へ</button>





	<script>
		// 指定行を非表示
		function hideRow(id) {
			const row = document.getElementById(id);
			if (row)
				row.classList.add('hidden');
		}

		// 指定行を表示
		function showRow(id) {
			const row = document.getElementById(id);
			if (row)
				row.classList.remove('hidden');
		}
	</script>

</body>
</html>