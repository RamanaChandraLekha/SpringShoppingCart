


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Signup Form</title>
<style>
h2 {
	color: blue;
}

body {
	color: blue;
}

table {
	bordersize: 0;
}
</style>
<body><center>
	<h1 align="center">Registration form</h1>
	<table align="center">
		<tr>
			<td>Name :</td>
			<td><input type="text" name="username" value="" id="name"
				required></br>
			</br></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="password" value=""
				id="password" required></br> </br></td>
		</tr>
		<tr>
			<td>Company :</td>
			<td><input type="text" name="companyName" value="" id="cmpny"></br>
			</br></td>
		</tr>
		<tr>
			<td>Designation :</td>
			<td><input type="text" name="designation" value="" id="desgn"></br>
			</br></td>
		</tr>
		<tr>
			<td>Experience :</td>
			<td><input type="text" name="exp" value="" id="exp"></br>
			</br></td>
		</tr>
		<tr>
			<td>city :</td>
			<td><input type="text" name="city" value="" id="city" required></br>
			</br></td>
		</tr>
		<tr>
			<td>Stream :</td>
			<td><input type="text" name="stream" value="" id="branch"
				required></br>
			</br></td>
		</tr>

		
	</table>
	<button type="button"  onclick="func()">submit</button></center>
	<script>
		function func() {
			var name = document.getElementById("name").value;
			var pwd = document.getElementById("password").value;
			var company = document.getElementById("cmpny").value;
			var desig = document.getElementById("desgn").value;
			var experience = document.getElementById("exp").value;
			var City = document.getElementById("city").value;
			var Stream = document.getElementById("branch").value;
			var userObj = {
				username : name,
				password : pwd,
				companyName : company,
				designation : desig,
				exp : experience,
				city : City,
				stream : Stream
			};
			var JsonObj = JSON.stringify(userObj);
			httpRequest = new XMLHttpRequest();
			httpRequest.onreadystatechange = function() {

				if (httpRequest.readyState == XMLHttpRequest.DONE) {
					if (httpRequest.status == 200) {
						
						//window.location.href = "/loginPage";
					} else {
						alert('There was a problem with the request.');
						document.write(httpRequest.responseText);
						
					}

				}

				
			};
			httpRequest.open("POST", "/signup", true);
			 httpRequest.setRequestHeader("Content-Type", "application/json; charset=utf8");
			//httpRequest.setRequestHeader("Accept","application/json"); 
			/* httpRequest.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded'); */
			httpRequest.send(JsonObj);
		};


	</script>
</body>

</html>