<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
    background-color: #e5e4e2;
  }
  h2 {
    margin-bottom: 20px;
    text-align: center;
  }
  form {
    max-width: 400px;
    margin: auto;
  }
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  input[type="text"],
  input[type="password"],
  input[type="number"],
  input[type="file"] {
    width: 100%;
    padding: 8px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
<body>

<h2>Sign up</h2>

<form action="sign" >

  <label for="name">Enter Your Name:</label>
  <input type="text" id="name" name="name">
  
  <label for="EmailId">Email Id:</label>
  <input type="text" id="emailId" name="emailId">

  <label for="Username">Username:</label>
  <input type="text" id="username" name="username">

  <label for="Password">Password:</label>
  <input type="password" id="password" name="password">


  <input type="submit" value="Sign Up">
</form> 

</body>
</html>