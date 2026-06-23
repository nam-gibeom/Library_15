<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>メイン画面</title>
    <style>
    /* 1. 画面全体のスクロールを完全に禁止 */
    html, body {
      height: 100%;
      margin: 0; 
      overflow: hidden;
    }

    /* 2. 全体を「縦並び」のFlexboxにする（上と下に分割） */
    .app-wrapper {
      display: flex;
      flex-direction: column;
      height: 100vh;
    }

    /* 3. 上部タイトルエリア（縮まないように固定） */
    .header-area {
      flex-shrink: 0;
    }

    /* 4. 下半分（左と右を横並びにするコンテナ） */
    .container {
      display: flex;
      width: 100%;
      flex: 1;          /* 残りの高さをすべてこのエリアに割り当てる */
      overflow: hidden; /* 子要素のスクロールを邪魔しない */
    }

    .left-side {
      width: 15%;
      background-color: #E6FFE9;
      overflow-y: auto;
      display: flex; /*flexbox*/
      flex-direction: column;         
      justify-content: space-around;  
      align-items: center;
    }

    .right-side {
      width: 85%;
      background-color: #FFFFEE;
      overflow-y: auto;
      display: flex;
      flex-direction: column;         
      align-items: center;
    }
    </style>
</head>
<body>

<div class="app-wrapper">

  <div class="header-area">
    <jsp:include page="title.jsp"/>
  </div>

  <div class="container">
    <div class="left-side"><jsp:include page="menu.jsp" /></div>
    <div class="right-side"><jsp:include page="memberRegist1.jsp" /></div>
  </div>

</div>

</body>
</html>