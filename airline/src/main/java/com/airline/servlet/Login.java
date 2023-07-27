package com.airline.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.LoginUtil;
import com.airline.entities.Manager;




@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Manager user = LoginUtil.validateUsernamePassword(username, password);

		// User logged in successfully?
		if (user != null) {
			String authToken = LoginUtil.createAuthToken(user);
			System.out.println("Auth token created for user - " + user.name + " : " + authToken);

			Cookie authTokenCookie = new Cookie("auth-token", authToken);
			response.addCookie(authTokenCookie);

			response.sendRedirect("managehome.jsp");
		} else {
			response.getWriter().append("User log in failed");
		}
	}

}
