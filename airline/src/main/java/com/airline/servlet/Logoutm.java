package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.LoginUtil;

@WebServlet("/Logoutm")
public class Logoutm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie authTokenCookie = LoginUtil.findAuthTokenCookie(request);
		authTokenCookie.setMaxAge(0);
		response.addCookie(authTokenCookie);
		response.sendRedirect("login.jsp");
	}

}
