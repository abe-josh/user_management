package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainController {

	private static MainController  mainController;
	
	private MainController() {
		
	}
	
	public static MainController getInstance() {
		if(mainController == null) {
			mainController = new MainController();
		}
		
		return  mainController;
	}
	
	public void initialize(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MainController - initialize()");
		
		try {
			System.out.println("session id : " + request.getSession().toString());
			request.getRequestDispatcher("/views/homepage.jsp").forward(request, response);
		} catch (Exception e) {
			System.err.println("Failed to  load homepage.jsp!\n" + e.getMessage());
			e.printStackTrace();
		}
	}
}
