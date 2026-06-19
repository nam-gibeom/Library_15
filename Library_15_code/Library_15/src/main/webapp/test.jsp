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

        
        .sidebar-wrapper {
        
           	height: 100vh;   
            background-color: #f4f4f4;
            
        }

        
        .content-wrapper {
            flex: 1;              
            padding: 20px;
            
        }
    </style>
</head>
<body>

<div class="container">
    <div class="sidebar-wrapper">
        <jsp:include page="menu.jsp" />
    </div>

    <div class="content-wrapper">
        <jsp:include page="top.jsp" />
    </div>
</div>

</body>
</html>