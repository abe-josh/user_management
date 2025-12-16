<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup - User Management</title>
</head>
<body>

	<div>
		<h2>Get started</h2>
		
		<form action="signupUser" method="post">
		
			<label for="firstname">Name</label>
			<input type="text" name="firstname" placeholder="First name" required/>
			<input type="text" name="lastname" placeholder="Last name" required/>
			
			<br>
			
			<label for="email">Email</label>
			<input type="email" name="email" placeholder="email" required/>
			
			<br>
			
			<label for="mobileNumber">Mobile number</label>
			<input type="tel" name="mobileNumber" placeholder="09XXXXXXXXXXX" pattern="[0-9]{11}" required/>
			
			<br>
			
			<label for="birthdate">Date of birth</label>
			<input type="date" name="birthdate" required/>
			
			<br>
			
			
			<label for="password">Password</label>
			<input type="password" name="password" required/>
			
			<button type="submit">Submit</button>
			
		</form>
	</div>
</body>
</html>