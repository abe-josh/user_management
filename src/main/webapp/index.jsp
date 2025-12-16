<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
</head>
<body>
	<!-- <h1>Hello!</h1>
	
	<form action=signin method="post">
		<h3>Input your credentials!</h3>
		
		<div>
			<label>Username:</label>
			<input type="text" name="username" id="username" required>
		</div>
		
		<div>
			<label>Password:</label>
			<input type="password" name="password" id="password" required>
		</div>
		
		<div>
			<button type="submit">Login</button>
		</div>
	</form> -->
	
	
	
	<div>
		<h1>Welcome to MyWebApp</h1>
			
		<form action="signin" method="post">
			<h3>Log in</h3>
			
			<label>User name</label>
			<input type="text" name="username" required>
			
			<label>Password</label>
			<input type="password" name="password" required>
			
			<button type="submit">Log in</button>
		</form>
	</div>
	
	<br>
	
	<a href="${pageContext.request.contextPath}/Signup">Sign up</a>
</body>
</html>