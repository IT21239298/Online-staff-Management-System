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

import com.airline.DbSallary;
import com.airline.entities.Sallary;


@WebServlet("/ViewSallary")
public class ViewSallary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {

			Statement statement = DbSallary.getInstance().connection.createStatement();
			String sql = "SELECT * FROM salary";
			ResultSet resultSet = statement.executeQuery(sql);
			ArrayList<Sallary> salList = new ArrayList<Sallary>();

			Sallary sal = null;

			while (resultSet.next()) {

				System.out.println(resultSet.getString(1));

				sal = new Sallary(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7));
				salList.add(sal);
			}

			for (Sallary number : salList) {
				System.out.print(number.getSal_id());
			}

//			request.setAttribute("empList", empList);

			request.setAttribute("employeeList", salList);
			RequestDispatcher rs = 
		             request.getRequestDispatcher("Salarydetails.jsp");
	        rs.forward(request, response);

//			response.sendRedirect("SalaryInsert.jsp");
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
