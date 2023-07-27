package com.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbEmployee {
	private static DbEmployee instance = null;
	
	public Connection connection;
	
	public static DbEmployee getInstance() {
		if (instance == null) {
			instance = new DbEmployee();
		}
		return instance;
	}
	
	private DbEmployee() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.err.println("Failed to load database driver class : com.mysql.jdbc.Driver");
			e1.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(DbConfig.DB_URL, DbConfig.DB_USERNAME, DbConfig.DB_PASSWORD);
		} catch (SQLException e) {
			connection = null;
			System.err.println("Failed to create database connection : " + DbConfig.DB_URL);
			e.printStackTrace();
		}
	}
}
