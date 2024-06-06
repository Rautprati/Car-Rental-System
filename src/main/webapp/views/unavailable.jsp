<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Cars</title>
</head>
<style>
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
h1{
text-align: center;
}

</style>
<body>
<div class="right-part">
			<h1>Unavailable Cars Details</h1>
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
</body>
</html>