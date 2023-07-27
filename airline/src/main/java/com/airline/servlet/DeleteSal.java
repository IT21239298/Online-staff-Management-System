package com.airline.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.SalaryUtil;
import com.airline.entities.Sallary;


@WebServlet("/DeleteSal")
public class DeleteSal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("sal_id");
		boolean isTrue;
			isTrue = SalaryUtil.deleteSallary(id);
			
			
		
		if(isTrue==true) {
			
			List<Sallary> salDetails = SalaryUtil.validate(id);
			request.setAttribute("employeeList",salDetails);
			 
			  RequestDispatcher dis = request.getRequestDispatcher("managehome.jsp");
			   dis.forward(request, response);
		}else {
			List<Sallary> salDetails = SalaryUtil.validate(id);
			request.setAttribute("employeeList",salDetails);
			 
			  RequestDispatcher dis = request.getRequestDispatcher("");
			   dis.forward(request, response);
		}
	}
}
