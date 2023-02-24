<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Student Data</title>
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
        width: 30%;
        gap: 1px;
        border: 1px solid black;
        padding: 10px 10px;
        margin: auto;
    }
    input{
        padding: 5px;
        border-radius: 5px;
        font-size: 15px;
    }
    button{
        padding: 10px;
        border-radius: 5px;
        color: black;
        background-color: red;
        font-size: 30px;
        width: 50%;
        margin: auto;
        
    }
    button:hover{
        background-color: green;
        color: white;
    }
</style>
<body>

<h1>Save Student Data</h1>
<form method="post">
    <input type="number" name="studentId" placeholder="Student Id">
    <br>
    <input type="text" name="studentName" placeholder="Student Name">
    <br>
    <input type="number" name="mathematics" placeholder="Mathematics Marks">
    <br>
    <input type="number" name="science"placeholder="Science Marks">
    <br>
    <input type="number" name="english" placeholder="English Marks">
    <br>
    <input type="number" name="semester" placeholder="Semester">
    <br>
    <button>Submit</button>
</form>

</body>
</html>