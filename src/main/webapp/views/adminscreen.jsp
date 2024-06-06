<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Screen</title>
</head>
<style>
* {
	margin: 0%;
}

body {
	
}

.header {
	border: 2px solid black; width : 100%;
	display: flex;
	background-color: #87cefa;
	height: 60px;
	justify-content: space-between;
	width: 100%;
}

.header h1 {
	position: relative;
	top: 10px;
	width: 200px;
	margin-left: 70px;
}

.header a {
	position: relative;
	top: 10px;
	text-decoration: none;
	font-weight: bold;
	color: black;
	font-size: 20px;
	border:1px solid black;
border-radius:10px;
height:20px;
padding:10px;
transition:background-color 0.5s;
}

.header a:hover{
background-color: orange;
}

.side-bar {
	background-color: #414a4c;
	width: 300px;
	height: 630px;
}

.middle-part {
	display: flex;
}

.right-part {
	background-color: #f5f5f5;
	width: 100%;
	
}

.right-part h1{
text-align: center;
margin-top:10px;
text-decoration: underline;
}

.inside-right-part {
    display:flex;
	text-align: center;
	justify-content: center;
	margin-top: 30px;
	
}

.enroll{	
margin-left: 65%;
}
.logout{
margin-right: 40px;
}

table, th, td{
border: 2px solid black;
border-collapse: collapse;
padding: 10px;
}
table{
width: 90%;
}

table thead{
background-color: black;
color: white;
}
</style>
<body>
	<div>
		<div class="header">
			<h1>Admin Panel</h1>
			<a href="enroll" class="enroll">Enroll Car</a>
			<a href="/" class="logout">Logout</a>
		</div>
		<div class="middle-part">
			<div class="side-bar">
				<h1>This is side bar</h1>

			</div>

			<div class="right-part">
			<h1>Cars Details</h1>
				<div class="inside-right-part">

				<table>
				<thead>
				<tr>
				<th>Sr.No</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Year</th>
				<th>Picture</th>
				<th>Per Day Rent</th>
				<th>Contact</th>
				<th>Details</th>
				<th>Action</th>
				</tr>
				</thead>
				<c:forEach var="s" items="${data}" >
				<tbody>
				<tr >
				<td>${s.carId}</td>
				<td>${s.carBrand}</td>
				<td>${s.carModel}</td>
				<td>${s.carYear}</td>
				<td><img src="findimage/${s.carId}" width="100px" height="100px"></td>
				<td>${s.carRent}</td>
				<td>${s.carContact}</td>
				<td>${s.carAvailability}</td>
				<td><a href="edit?carId=${s.carId}"><button>Edit</button></a> <a href="remove?carId=${s.carId}"><button>Delete</button></a></td>
				</tr>
		
				</tbody>
				</c:forEach>
				</table>
				
				</div>
				
				
			</div>
		</div>

	</div>
</body>
</html>