package servlet;

import java.io.IOException;

import controller.MainController;
import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		MainController mainController = MainController.getInstance();
		
		switch(path) {
			case "/home":
				mainController.initialize(request, response);
				break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		 
		System.out.println("Hi " + username + "!");
		System.out.println("Your password is : " + password);
		
		UserController userCtrl = UserController.getInstance();
		
		String path = request.getServletPath();
		
		switch(path) {
			case "/signin":
				userCtrl.signin(request, response);
			break;
		}

	}
}
