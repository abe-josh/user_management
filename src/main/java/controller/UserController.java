package controller;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

public class UserController {
	
	private static UserController userController;
	
	private UserController() {}
	
	public static UserController getInstance() {
		
		if(userController == null) {
			userController = new UserController();
		}
		
		return userController;
	}
	
	public void signup(HttpServletRequest request, HttpServletResponse response) {
	}
}
