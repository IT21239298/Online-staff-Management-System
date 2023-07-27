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

@WebServlet("/UpdateSallary")
public class UpdateSallary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("sal_id");
		String month =request.getParameter("month");
		String year =request.getParameter("year");
		String hour =request.getParameter("hour");
		String hour_pay =request.getParameter("hour_pay");
		String full_pay =request.getParameter("full_pay");
		String empl_id =request.getParameter("empl_id");
		
		boolean isTrue;
		
		isTrue = SalaryUtil.updateSallary(id, month, year, hour, hour_pay, full_pay, empl_id);

		if(isTrue==true) {
			 
			List<Sallary> salDetails = SalaryUtil.validate(id);
			request.setAttribute("employeeList",salDetails);
			 
			  RequestDispatcher dis = request.getRequestDispatcher("managehome.jsp");
			   dis.forward(request, response);
		}else {
			List<Sallary> salDetails = SalaryUtil.validate(id);
			request.setAttribute("employeeList",salDetails);
			 
			  RequestDispatcher dis = request.getRequestDispatcher("managehome.jsp");
			   dis.forward(request, response);
		}
		
	}

}
