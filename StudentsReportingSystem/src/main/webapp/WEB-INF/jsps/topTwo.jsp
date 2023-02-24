<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top two students</title>
</head>
<style>
    *{
        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    }
    h1{
        text-align: center;
      
        
    }
    
    form{
        display: flex;
        flex-direction: column;
        width: 20%;
        gap: 5px;
        border: 1px solid navy;
        padding: 5px 10px;
        margin: auto;
    }
    h2{
        text-align: center;
        color: rgb(27, 110, 88);
    }
    button{
        padding: 10px;
        border-radius: 5px;
        color: black;
        background-color: red;
        font-size: 30px;
    }
    button:hover{
        background-color: green;
        color: white;
    }
</style>

<body>

<h1>Top 2 Students</h1>
<form method="post">
    <h1>Click to get top 2 Students</h1>
    <button>Click</button>
</form>

</body>
</html>