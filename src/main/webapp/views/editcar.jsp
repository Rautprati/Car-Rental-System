<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Car Details</title>
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
<h2>Car Registration Form</h2>

<form action="update_car" method="post" enctype="multipart/form-data">
  
 
  <input type="hidden" id="carBrand" name="carId" value="${data.carId}" >
  
  <label for="carBrand">Car Brand:</label>
  <input type="text" id="carBrand" name="carBrand" value="${data.carBrand}">

  <label for="carModel">Car Model:</label>
  <input type="text" id="carModel" name="carModel" value="${data.carModel}">

  <label for="carYear">Car Year:</label>
  <input type="number" id="carYear" name="carYear" value="${data.carYear}">

  <label for="carPicture">Car Picture:</label>
  <input type="file" id="carPicture" name="carPicture" value="${data.carPicture}">

  <label for="carRent">Car Rent:</label>
  <input type="text" id="carRent" name="carRent" value="${data.carRent}">

  <label for="carContact">Car Contact:</label>
  <input type="text" id="carContact" name="carContact" value="${data.carContact}">
  
  <label for="carAvailability">Car Availability:</label>
  <input type="text" id="carContact" name="carAvailability" value="${data.carAvailability}">

  <input type="submit" value="Update">
</form> 
</body>
</html>