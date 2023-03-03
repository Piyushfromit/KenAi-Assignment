<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Student Percentage</title>
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
        width: 15%;
        gap: 5px;
        border: 1px solid navy;
        padding: 15px 15px;
        margin: auto;
    }
    input{
        padding: 10px;
        border-radius: 5px;
        font-size: 15px;
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

<h1>Average Percentage of Whole Class in Recent Semester</h1>

<form method="post">
    <input type="number" name="semester" placeholder="Enter Semester">
    <br>
  
    <button>Submit</button>
</form>

</body>
</html>