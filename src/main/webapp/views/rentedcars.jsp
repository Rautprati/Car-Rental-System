<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h1>Rented Cars Details</h1>
			<p>${rented_car}</p>
			<div class="inside-right-part">

				<table>
					<thead>
						<tr>
							<th>Sr.No</th>
							<th>Brand</th>
							<th>Model</th>
							<th>Total Rent</th>
							<th>Contact</th>
							<th>Days</th>
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach var="s" items="${list2}" >
						<tbody>
							<tr>
								<td>${s.id}</td>
								<td>${s.carBrand}</td>
								<td>${s.carModel}</td>
								<%-- <td><img
									src="findimage/${list.carId}" width="100px"
									height="100px"></td>--%>
								<td>${s.carRent}</td>
								<td>${s.carContact}</td>
								<td>${s.days}</td>
								<td><a href="returnCar?carModel=${s.carModel}&id=${data.id}"><button
											class="btn">Return</button></a></td>
							</tr>
						</tbody>
					</c:forEach>	
				</table>

			</div>
		</div>
</body>
</html>