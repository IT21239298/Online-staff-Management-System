package com.airline.servlet;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.DbEmployee;

import com.airline.entities.Employee;

@WebServlet("/CalEmployee")
public class CalEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {

			Statement statement = DbEmployee.getInstance().connection.createStatement();
			String sql = "SELECT * FROM employee";
			ResultSet resultSet = statement.executeQuery(sql);
			ArrayList<Employee> empList = new ArrayList<Employee>();

			Employee emp = null;

			while (resultSet.next()) {

				System.out.println(resultSet.getString(2));

				emp = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
				empList.add(emp);
			}

			for (Employee number : empList) {
				System.out.print(number.getId());
			}

//			request.setAttribute("empList", empList);

			request.setAttribute("employeeList", empList);
			RequestDispatcher rd = 
		             request.getRequestDispatcher("SalaryInsert.jsp");
	        rd.forward(request, response);

//			response.sendRedirect("SalaryInsert.jsp");
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
