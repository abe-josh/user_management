package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserModel;
import service.SessionService;
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
		SessionService sessSrvc = new SessionService();
		  
		while(paramNames.hasMoreElements()) { 
			String parameterName = paramNames.nextElement(); 
			System.out.println(parameterName + " -  " + request.getParameter(parameterName)); 
		}
		
//		try {
//			if(userSrvc.validateUser(request.getParameter("username"), request.getParameter("password"))) {
//				System.out.println("User validated");
//				System.out.println("session id : " + request.getSession().toString());
//				response.sendRedirect("/UserManagement/home");
//			}
//			else {
//				response.sendRedirect("/UserManagement");
//			}
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
		long userid = userSrvc.validateUser1(request.getParameter("username"), request.getParameter("password"));
		
		try {
			if(userid > 0) {
				System.out.println("User validated");
				
				String sessionId = sessSrvc.createSession(userid);
				
				if(sessionId != null) {
					System.out.println("session id is not null");
					addSessionCookie(response, sessionId);
				}
				
				// assigned a "session" object associated with the request, and create if there is none (true)
				// using servlet built in session object
//				HttpSession session = request.getSession(true);
//				session.setAttribute("userId", userid);
				
				//System.out.println("session id : " + request.getSession().toString());
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
	
	private String getCookie(HttpServletRequest request, String name) {
		if(request.getCookies() == null) {
			return null;
		}
		
		for(Cookie cookie : request.getCookies()) {
			System.out.println("Cookie : "  + cookie);
			if(cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}
		
		return null;
	}
	
	private void addSessionCookie(HttpServletResponse response, String sessionId) {
		Cookie cookie = new Cookie("UserSessionId", sessionId);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
