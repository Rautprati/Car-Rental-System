<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<body>
<div class="d-flex justify-content-center align-center">
		<div class="w-50 align-middle border border-info border-3 mt-2"
			style="height: 500px">
			<h6 class="p-3 text-primary ">
				<u>Your Bill Details:-</u>
			</h6>
			<div class="border border-secondary m-3 p-2">
				<table class="table table-hover border border-secondary ">
					<tbody>
						<tr class="table-primary fs-6">
							<th>User Name</th>
							<td>${list.name}</td>
						</tr>
						<tr class="table-primary fs-6">
							<th>Car Brand</th>
							<td>${data.carBrand}</td>
						<tr class="table-primary fs-6">
							<th>Car Model</th>
							<td>${data.carModel}</td>
						</tr>

						<tr class="table-primary fs-6">
							<th>Car Per Day Rent</th>
							<td>${data.carRent}</td>
						</tr>
						<tr class="table-danger fs-6">
							<th>Car Contact</th>
							<td>${data.carContact}</td>
						</tr>

					</tbody>
				</table>
				<form action="rented">
					<div class="bg-dark p-2 d-flex justify-content-between">
						<label for="amount" class="text-info"><b>Enter no of days to rent a car
							
						</b></label>
						<input type="hidden" name="carId" value="${data.carId}">
						<input type="hidden" name="carBrand" value="${data.carBrand}">
						<input type="hidden" name="carModel" value="${data.carModel}">
						<input type="hidden" name="carRent" value="${data.carRent}">
						<input type="hidden" name="carContact" value="${data.carContact}">
						<input type="number" name="days">
						<input type="hidden" name="id" value="${list.id}">
					</div>
					<div class="d-flex justify-content-center pt-5">
						<button class="btn btn-success btn-sm ">Rent Car</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>