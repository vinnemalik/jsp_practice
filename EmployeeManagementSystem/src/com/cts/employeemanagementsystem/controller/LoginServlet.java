package com.cts.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagementsystem.service.LoginService;
import com.cts.employeemanagementsystem.service.LoginServiceImpL;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LoginService loginService = LoginServiceImpL.getInstance();
		
		
		String userName = request.getParameter("userId");
		String password = request.getParameter("password");
		
		RequestDispatcher requestDispatcher = null ;
		System.out.println("User Name is : "+userName);
		System.out.println("Password is : "+password);
		if(loginService.authenticate(userName, password))
		{
			int userStatus = loginService.getUserStatus(userName);
			String authorization = loginService.authorization(userName);
			if("A".equals(authorization))
			{
				if(userStatus == 0)
				{
					requestDispatcher = request.getRequestDispatcher("admin.html");
					requestDispatcher.forward(request , response);	
				}
				else if(userStatus == 1)
				{
					requestDispatcher = request.getRequestDispatcher("alreadyLoggedIn.html");
					requestDispatcher.forward(request , response);	
				}
				else
				{
					requestDispatcher = request.getRequestDispatcher("deactivate.html");
					requestDispatcher.forward(request , response);	
				}
			}
			if("V".equals(authorization))
			{
				if(userStatus == 0)
				{
					requestDispatcher = request.getRequestDispatcher("vendorHome.html");
					requestDispatcher.forward(request , response);	
				}
				else if(userStatus == 1)
				{
					requestDispatcher = request.getRequestDispatcher("alreadyLoggedIn.html");
					requestDispatcher.forward(request , response);	
				}
				else
				{
					requestDispatcher = request.getRequestDispatcher("deactivate.html");
					requestDispatcher.forward(request , response);	
				}
			}
			if("U".equals(authorization))
			{
				if(userStatus == 0)
				{
					requestDispatcher = request.getRequestDispatcher("userHome.html");
					requestDispatcher.forward(request , response);	
				}
				else if(userStatus == 1)
				{
					requestDispatcher = request.getRequestDispatcher("alreadyLoggedIn.html");
					requestDispatcher.forward(request , response);	
				}
				else
				{
					requestDispatcher = request.getRequestDispatcher("deactivate.html");
					requestDispatcher.forward(request , response);	
				}
			}
		
			
			
			//response.sendRedirect("admin.html");
			
		}
		else
		{
			requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.forward(request , response);
		}
	}

}
