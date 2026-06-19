<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
    <title>メイン画面</title>

    <style>
  .container {
 
 display: flex;
 
         
        }
   .tablecenter{
	
	 margin-left: auto;
	     margin-right: auto;
	     border-collapse: collapse; 
	  
	   
	      
}
   
    </style>
</head>
<body>


   <div class="container">
        <jsp:include page="/menu.jsp" />
 	
  <div class="tablecenter">
        <jsp:include page="/memberRegist.jsp" />
        </div>
  </div>
   

</body>
</html>