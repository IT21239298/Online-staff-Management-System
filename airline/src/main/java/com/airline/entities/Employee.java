          package com.airline.entities;

public class Employee {
	public final int id;
	public final String name;
	public final String email;
	public final String phone;
	public final String username;
	
	
	public Employee(int id, String name, String email, String phone, String username) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
	
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}
	public int getId() {
		return id;
	}
}
