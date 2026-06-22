<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>メイン画面</title>
    <style>
    
 body {
  height: 100%;
  margin: 0; 
}
.container {
  display: flex;
  width: 100%;
  min-height: 100vh;
}


.left-side {
  width: 15%;
  background-color: #E6FFE9;
  
  display: flex; /*flexbox*/
  flex-direction: column;         
  justify-content: space-around;  
  align-items: center;
}


.right-side {
  width: 85%;
  background-color: #FFFFEE;
  
  display: flex;
  flex-direction: column;         
  justify-content: space-around;  
  align-items: center;
}
        
    </style>
</head>
<body>
<jsp:include page="title.jsp"/>
<div class="container">
  <div class="left-side"><jsp:include page="menu.jsp" /></div>
  <div class="right-side"><jsp:include page="bookConfirm1.jsp" /></div>
</div>

</body>
</html>