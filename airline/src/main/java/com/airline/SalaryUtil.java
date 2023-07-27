package com.airline;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airline.entities.Employee;
import com.airline.entities.Sallary;

public class SalaryUtil {
	
	private static boolean isSuccess;
	
	public static void insertSalary(String id, String month, String year, String hours, String hourPay, String fullPay) {
		if (DbEmployee.getInstance().connection != null) {
			Employee emp = null;

			// Get user first
			try {
				Statement statement = DbEmployee.getInstance().connection.createStatement();
				String sql = "select * from employee where employee_id ='" +id + "'";
				System.out.println(sql);
				ResultSet resultSet = statement.executeQuery(sql);
				if (resultSet != null && resultSet.next()) {
					int em_id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String email = resultSet.getString(3);
					String phone = resultSet.getString(4);
					
					
					emp= new Employee(em_id, name, email, phone, id);
				} else {
					System.out.println("employee data not found in database  " +id);
				}
			} catch (SQLException e) {
				System.err.println("Failed to get Manager data from database.");
				e.printStackTrace();
			}

			// User available?
			// Then insert salary data for the user
			if (emp != null) {
				try {
					Statement statement = DbEmployee.getInstance().connection.createStatement();
					String sql = "insert into salary values (NULL,'" + month + "','" + year + "','" + hours + "','" + hourPay + "','" + fullPay + "'," + emp.id+ ")";
					System.out.println(sql);
					statement.executeUpdate(sql);
				} catch (SQLException e) {
					System.err.println("Failed to insert salary data in to database.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static List <Sallary> validate(String sal_id){
	
		ArrayList<Sallary> sall = new ArrayList<>();
		
		if (DbSallary.getInstance().connection != null) {
			 Sallary s = null;

			// Get user first
			try {
				Statement statement = DbSallary.getInstance().connection.createStatement();
				String sql = "select * from salary where salary_id ='" +sal_id + "'";
				System.out.println(sql);
				ResultSet resultSet = statement.executeQuery(sql);
				if (resultSet != null && resultSet.next()) {
					
					int sall_id = resultSet.getInt(1);
					String month = resultSet.getString(2);
					String year = resultSet.getString(3);
					String hours = resultSet.getString(4);
					String hour_pay = resultSet.getString(5);
					String full_pay = resultSet.getString(6);
					int employee_id = resultSet.getInt(7);
					
					 s= new Sallary(sall_id,month,year,hours,hour_pay,full_pay,employee_id);
					
					sall.add(s);
					
				} else {
					System.out.println("sallary data not found in database  " +sal_id);
				}
			} catch (SQLException e) {
				System.err.println("Failed to get Sallary data from database.");
				e.printStackTrace();
			}

		
		}
		return sall;
	
	}
	public static boolean updateSallary(String id,String month,String year,String hour,String hour_pay,String full_pay,String empl_id) {
		
		//update walata use krnne excecuteUpdate eaka eaka return krnne boolean value
	
		if (DbSallary.getInstance().connection != null) {
			

			// Get user first
			try {
				Statement statement = DbSallary.getInstance().connection.createStatement();
				String sql = "update salary set month='"+month+"',year='"+year+"',hours='"+hour+"',hour_pay='"+hour_pay+"',full_pay='"+full_pay+"'"+"where salary_id ='"+id+"'";
				System.out.println(sql);
				int resultSet = statement.executeUpdate(sql);
				if (resultSet > 0) {
					
					isSuccess = true;
					
				} else {
					isSuccess = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
		}
		return isSuccess;
	}
	public static boolean deleteSallary(String id) {
		
		int convId = Integer.parseInt(id);//using raper classes
		
		if (DbSallary.getInstance().connection != null) {
		try {
			Statement statement = DbSallary.getInstance().connection.createStatement();
			String sql = "delete from salary where salary_id='"+convId+"'";
			int resultSet = statement.executeUpdate(sql);
			if (resultSet > 0) {
				
				isSuccess = true;
				
			} else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		return isSuccess;
	}
		
}
	
