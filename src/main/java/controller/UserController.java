package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;
import service.UserService;
import service.UserServiceImp;

public class UserController {

	private static UserController userController;
	private UserService userSrvc;

	private UserController() {
		this.userSrvc = new UserServiceImp();
	}

	public static UserController getInstance() {

		if (userController == null) {
			userController = new UserController();
		}

		return userController;
	}
	
	public void signin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController - signin()");
		
		System.out.println("getContextPath() : " + request.getContextPath());
		
		Enumeration<String> paramNames = request.getParameterNames();
		  
		while(paramNames.hasMoreElements()) { 
			String parameterName = paramNames.nextElement(); 
			System.out.println(parameterName + " -  " + request.getParameter(parameterName)); 
		}
		
		try {
			if(userSrvc.validateUser(request.getParameter("username"), request.getParameter("password"))) {
				System.out.println("User validated");
				System.out.println("session id : " + request.getSession());
				response.sendRedirect("/UserManagement/home");
			}
			else {
				response.sendRedirect("/UserManagement");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void signup(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController - signup()");

		Enumeration<String> paramNames = request.getParameterNames();
  
		while(paramNames.hasMoreElements()) { 
			String parameterName = paramNames.nextElement(); 
			System.out.println(parameterName + " -  " + request.getParameter(parameterName)); 
		}
 
		UserModel user = new UserModel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setUserName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setMobileNumber(Long.parseLong(request.getParameter("mobileNumber")));
		user.setDateOfBirth(LocalDate.parse(request.getParameter("birthdate"), dtf));
		user.setPassword(request.getParameter("password"));
		
		if(userSrvc.addUser(user)) {
			
			try {
				response.sendRedirect("/UserManagement");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
