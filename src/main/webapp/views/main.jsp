<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
</head>
<style>
* {
	margin: 0%;
}
body{
font-family: sans-serif;
}
.right-part {
	background-color: #f5f5f5;
	width: 100%;
}

.right-part h1 {
	text-align: center;
	margin-top: 10px;
	text-decoration: underline;
}

.inside-right-part {
	display: flex;
	text-align: center;
	justify-content: center;
	margin-top: 30px;
}

table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	padding: 10px;
}

table {
	width: 90%;
}

table thead {
	background-color: black;
	color: white;
}

.btn {
	background-color: #22b4f2;
	border: none;
	padding: 5px 10px 5px 10px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #73cff7;
	color: white;
	font-weight: bold;
}

.top-part {
	background-color: #006b3c;
	padding: 15px;
	display: flex;
	justify-content: space-between;
}

.top-part h1 {
    margin-left:50px;
	font-size: 20px;
}

.top-part a{
text-decoration: none;
color: black;
margin-right: 20px;
font-size: 20px;

}

.middle-part {
	display: flex;
}

.left-part {
	background-color: #333333;
	height: 645px;
	width: 20%;
	
}

.left-top img{
border-radius: 100px;
margin-top: 10px;
}
.left-top{
display: flex;
height: 108px;
}
.left-top h2{
color: white;
opacity:0.8;
margin-top:20px;
margin-left: 10px;
font-size: 18px;
}

.left-bottom a, button{
border: none;
width:100%;
font-size: 20px;
background-color: #333333;
color: white;
padding-top: 15px;
padding-bottom: 15px;
padding-right: 30px;
cursor:pointer;
}

.left-bottom a, button:hover{
background-color: #3b3c36;
}
.left-bottom p{
margin-top: 10px;
background-color:#353839;
padding-top:15px;
padding-bottom:15px;
padding-left:50px;
opacity:0.6;
color: white;
}
</style>
<body>


	<div class="top-part">

		<h1>
			<i class="fa-solid fa-car"></i>&nbsp;CarRental
		</h1>
		
		<a href="/">Logout</a>
	</div>


	<div class="middle-part">
		<div class="left-part">
		<div class="left-top">
		<img alt="profile" src="./images/wp6209910.jpg" width=80px height= 80px>
		<h2>${list.name } <br><span style="font-size: 14px">-&nbsp;User</span></h2>
		</div>
		<div class="left-bottom">
		<p>Navigation Forms</p>
		<a href="User_Profile?id=${list.id}"><button>Your Profile</button></a>
		<a href="rented_cars?id=${list.id}"><button>Rented Cars</button></a>
		<a href="available_cars?id=${list.id}&username=${list.username}&password=${list.password}"><button>Available Cars</button></a>
		<a href="unavailable_cars?id=${list.id}"><button>Unavailable Cars</button></a>
		</div>
		</div>

		<div class="right-part">
			<h1>Cars Details</h1>
			<p>${rented_car}</p>
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
					<c:forEach var="s" items="${data}">
						<tbody>
							<tr>
								<td>${s.carId}</td>
								<td>${s.carBrand}</td>
								<td>${s.carModel}</td>
								<td>${s.carYear}</td>
								<td><img alt="car"
									src="findimage/${s.carId}" width="100px"
									height="100px"></td>
								<td>${s.carRent}</td>
								<td>${s.carContact}</td>
								<td>${s.carAvailability}</td>
								<td><a href="rentcar?carId=${s.carId}&id=${list.id}&username=${list.username}&password=${list.password}"><button
											class="btn">Rent</button></a></td>
							</tr>
						</tbody>
					</c:forEach>

				</table>

			</div>
		</div>

	</div>
</body>
</html>