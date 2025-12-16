package servlet;

import java.io.IOException;
import java.util.Enumeration;

import controller.UserController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet{
	
	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * res) throws ServletException, IOException {
	 * 
	 * System.out.println("SignupServlet - service"); RequestDispatcher dispatcher =
	 * req.getRequestDispatcher("/views/signup.jsp"); dispatcher.forward(req, res);
	 * }
	 */
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SignupServlet - doGet");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/signup.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SignupServlet - doPost");
		
		/*
		 * Enumeration<String> paramNames = req.getParameterNames();
		 * 
		 * while(paramNames.hasMoreElements()) { String parameterName =
		 * paramNames.nextElement(); System.out.println(parameterName + " -  " +
		 * req.getParameter(parameterName)); }
		 */
		
		UserController userCtrl = UserController.getInstance();
		
		userCtrl.signup(req, resp);
	}
}
