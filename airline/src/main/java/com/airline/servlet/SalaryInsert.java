package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.SalaryUtil;


@WebServlet("/SalaryInsert")
public class SalaryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id =request.getParameter("empID");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String hours = request.getParameter("hours");
		String hourPayment = request.getParameter("hour-pay");
		String salary = request.getParameter("salary");
		
		SalaryUtil.insertSalary(id, month, year, hours, hourPayment, salary);
	}

}
