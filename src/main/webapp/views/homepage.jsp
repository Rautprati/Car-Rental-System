<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>

<style>
body {
	margin: 0px 20% 0px 10%;
	height: 100vh;
	background-image: linear-gradient(180deg, rgba(0, 0, 0, 0.3) 0%,
		rgba(0, 0, 0, 0.8) 100%), url(images/wp6209910.jpg);
	background-size: cover;
	font-family: sans-serif;
}

.heading {
	color: #ff4500;
	font-size: 35px;
}

.navbar {
	display: flex;
	margin-top: 30px;
}

.options {
	margin-top: 18px;
	margin-left: 160px;
}

.options a {
	text-decoration: none;
	color: black;
	font-size: 15px;
	font-weight: bold;
	margin: 30px;
}

.admin-option {
	background-color: #ff4500;
	padding: 10px;
	border-radius: 10px;
}

.middle-part {
	display: flex;
	justify-content: space-between;
}

.content {
	margin-top: 80px;
}

.content h1 {
	font-size: 40px;
}

.content h1 span {
	color: orange;
	font-size: 50px
}

.para {
	color: white;
	line-height: 1.5;
	letter-spacing: 2px;
}

.join-button {
	background-color: #ff4500;
	text-decoration: none;
	color: black;
	padding: 10px;
	padding-left: 30px;
	padding-right: 30px;
	border-radius: 10px;
}

.login-form {
	margin-top: 90px;
	width: 250px;
	height: 430px;
	background-color : black;
	opacity: 0.5;
	border-radius: 10px;
	background-color: black;
}

.login-form h2 {
	text-align: center;
	background-color: white;
	padding: 10px;
	border-radius: 10px;
	color: orange;
	width: 200px;
	margin-left: 13px;
}

.input-box {
	position: relative;
	margin: 30px 0px 30px 13px;
	width: 200px;
	border-bottom: 2px solid #ff4500;
}

.input-box input {
	width: 100%;
	height: 50px;
	background: transparent;
	border: none;
	outline: none;
	font-size: 1em;
	color: white;
	padding: 0px 35px 0px 5px;
}

input:focus ~ label, input:valid ~ label {
	top: -5px;
}

.input-box label {
	position: absolute;
	top: 50%;
	left: 5px;
	color: white;
	font-size: 1em;
	pointer-events: none;
	transition: .5s;
}

.input-box button {
	width: 100%;
	background: transparent;
	border: none;
	outline: none;
}

#btn {
	position: relative;
	left: 80px;
}

.sign-up {
	color: white;
	text-align: center;
}
.sign-up a{
text-decoration: none;
color:#ff4500;
}
</style>
<body>
	<div>
		<div class="header">
			<div class="navbar">
				<span class="heading">CaRs</span>

				<div class="options">
					<a href="/">Home</a> <a href="about">About</a> <a href="services">Services</a> <a
						href="contact">Contact</a> <a href="admin" class="admin-option">ADMIN
						LOGIN</a>
				</div>

			</div>
		</div>

		<div class="middle-part">
			<div class="content">
				<h1>
					Rent Your <br>
					<span>Dream Car</span>
				</h1>
				<p class="para">
					Live the life of Luxury.<br> Just rent a car of your wish from
					our vast collection<br> Enjoy a very moment with your family<br>
					Join us to make this family vast.
				</p>
				<br> <br> <a href="" class="join-button">JOIN US</a>
			</div>

			<div class="login-form">
				<form action="login">
					<h2>Login Here</h2>
					<p style="color:white; margin-left: 10px">${message}</p>
					<div class="input-box">
						<input type="text" name="username"> <label for="">Enter
							Username Here</label>
					</div>
					<div class="input-box">
						<input type="password" name="password"> <label for="">Enter
							Password Here</label>
					</div>
					<div class="input-box center-btn">
						<button type="submit">Login</button>
						<label for="" id="btn">Login</label>
					</div>
					<div class="sign-up">
						<label>Don't have an account? <br>
						<a href="signup">Sign up</a> here
						</label>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>