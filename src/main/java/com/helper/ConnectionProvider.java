package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	static private Connection con;

	static private String url = "jdbc:mysql://localhost:3306/usermanagement";
	static private String name = "root";
	static private String password = "fcbBC123";

	static public Connection getConnection() {

		if (con == null) {

			try {
				// Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
				// Create connection
				con = DriverManager.getConnection(url, name, password);
				System.out.println("Connection Established");

			} catch (Exception e) {
				System.out.println("Connection could not be established");
				e.printStackTrace();
			}

		}

		return con;

	}

}
