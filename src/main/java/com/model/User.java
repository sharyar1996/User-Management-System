package com.model;

public class User {

	private int id;
	private String userName;
	private String email;
	private String country;

	// GETTERS and SETTERS

	public User() {

	}

	public User(int id, String name, String email, String country) {

		this.id = id;
		this.userName = name;
		this.email = email;
		this.country = country;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
