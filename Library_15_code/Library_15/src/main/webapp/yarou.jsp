<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img {
	width: 500px; /* 横幅を300pxに固定 */
	height: auto; /* 高さは自動調整 */
}

body {
	display: flex;
	align-items: center;
	flex-direction: column;
	background-color: #EEFFFF;
}

table {
	width: 60%;
	border-collapse: collapse;
	font-family: sans-serif;
	color: #333;
	border: #333;
	margin-top: 2em;
}

th {
	background-color: #2c3e50; /* 見出しの背景色 */
	color: #fff;
	padding: 12px;
	text-align: left;
}

.resulttd {
	padding: 12px;
	border-bottom: 1px solid #ddd;
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
	border: 1px solid #2c3e50;
	background-color: white;
	color: #2c3e50;
	margin-top: 1em;
}

.btn-hover-20 span {
	position: relative;
	z-index: 2;
}

.btn-hover-20:hover {
	background-color: #2c3e50;
	color: #FFFFEE;
}

.lable {
	background: #2c3e50;
	color: #FFFFEE;
	align-items: center;
}

.resulttd1 {
	padding: 12px;
	border-bottom: 1px solid #333;
}
 #img {
            width:400px;
            height: auto;
            
        }
        
        .link {
  color: black;           
  text-decoration: none;     
}
.link:hover {
  color: red;           
  text-decoration: none;     
}
</style>
</head>
<body>

	<h1 class=lable>15班 やろうチーム</h1>
	
    
    <img id="img" src="IMG_4341.JPG" alt="写真">

    <script>
       
        const imgElement = document.getElementById('img');

        
        imgElement.addEventListener('click', function() {
            
            
            if (imgElement.src.includes('IMG_4341.JPG')) {
                imgElement.src = 'QR.png';
            } else {
                imgElement.src = 'IMG_4341.JPG';
            }
            
        });
    </script>

	<table border="1" class=result2>
		<tr>
			<th id=lable1>名前</th>
			<th id=lable1>役割</th>

		</tr>
		<tr>
		
			<td class=resulttd><a href="#" class="link" onclick="alert('趣味：ギター、筋トレ\n出身：大阪'); return false;">平 奨瑛</a></td>
			<td class=resulttd>プロジェクトリーダー</td>

		</tr>
		<tr>
			<td class=resulttd><a href="#" class="link" onclick="alert('趣味：旅行、カメラ\n出身：韓国'); return false;">ナム・ギボム</a></td>
			<td class=resulttd>テクニカルリーダー</td>

		</tr>
		<tr>
			<td class=resulttd><a href="#" class="link" onclick="alert('趣味：ドライブ\n出身：中国'); return false;">高 崇然 </a></td>
			<td class=resulttd>データベースリーダー</td>

		</tr>
		<tr>
			<td class=resulttd><a href="#" class="link" onclick="alert('趣味：ゲーム\n出身：韓国'); return false;">ジャン・ジウ</a></td>
			<td class=resulttd>デザインリーダー</td>

		</tr>
		<tr>
			<td class=resulttd1><a href="#" class="link" onclick="alert('趣味：筋トレ\n出身：東京'); return false;">若松 大晟</a></td>
			<td class=resulttd1>テストリーダー</td>

		</tr>
	</table>
	<form action="login.jsp">
		<button class=btn-hover-20>戻る</button>
	</form>


</body>
</html>