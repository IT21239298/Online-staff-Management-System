package com.airline.entities;

public class Manager {
	public final int id;
	public final String name;
	public final String email;
	public final String phone;
	public final String username;
	public final String password;
	
	public Manager(int id, String name, String email, String phone, String username, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}
}