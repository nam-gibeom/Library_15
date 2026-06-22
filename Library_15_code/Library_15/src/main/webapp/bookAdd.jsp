<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<div class="container">
  <div class="left-side"><jsp:include page="menu.jsp" /></div>
  <div class="right-side"><jsp:include page="bookAdd1.jsp" /></div>
</div>

>>>>>>> 7e7fe65ac5859c84702e38125af24ae11d53f725
</body>
</html>