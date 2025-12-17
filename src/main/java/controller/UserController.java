package controller;

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

	public void signup(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController - signup()");

		Enumeration<String> paramNames = request.getParameterNames();
  
		while(paramNames.hasMoreElements()) { 
			String parameterName = paramNames.nextElement(); 
			System.out.println(parameterName + " -  " + request.getParameter(parameterName)); 
			}
 
		UserModel user = new UserModel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setMobileNumber(Long.parseLong(request.getParameter("mobileNumber")));
		user.setDateOfBirth(LocalDateTime.parse(request.getParameter("birthdate").concat(" 00:00:00"), dtf) );
		user.setPassword(request.getParameter("password"));
		
		userSrvc.addUser(user);
	}
}
