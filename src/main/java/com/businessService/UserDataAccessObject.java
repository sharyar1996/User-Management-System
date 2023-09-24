package com.businessService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.helper.ConnectionProvider;
import com.model.User;

//This DataAccessObject class provides CRUD database oeprations for the table users in the database.
public class UserDataAccessObject {

	private static Connection con;
	private static PreparedStatement statement;

	// create
	public static final String INSERT_USERS_TABLE = "INSERT INTO users" + "(id,name,email,country) VALUES "
			+ "(?,?,?,?);";
	// read
	public static final String SELECT_USER_BY_ID = "SELECT name,email,country FROM users WHERE id =? ";
	public static final String SELECT_ALL_USERS = "SELECT * FROM users";
	// update
	public static final String UPDATE_USER = "UPDATE users SET name=? ,email=? , country=? WHERE id=?";
	// delete
	public static final String DELETE_USER = "DELETE FROM users WHERE id=?";

	// METHODS

	public static Connection establishConnection() {

		con = ConnectionProvider.getConnection();
		return con;

	}

	// create/insert user
	public static int insertUser(User user) throws SQLException {

		if (con == null) {
			establishConnection();
		}

		int rowsUpdated = 0;
		statement = con.prepareStatement(INSERT_USERS_TABLE);

		statement.setInt(1, user.getId());
		statement.setString(2, user.getUserName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getCountry());

		rowsUpdated = statement.executeUpdate(); //// The executeUpdate() method returns the no. of rows affected by the
		// SQL statement.An INSERT typically affects 1 row but an UPDATE or DELETE
		//// statement can affect more.

		System.out.println("Inserted new user into USERS table. rowsUpdated = " + rowsUpdated);

		return rowsUpdated;

	}

	// checkUserExists
	public static boolean checkUserExist(int id) throws SQLException {

		if (con == null) {
			establishConnection();
		}

		statement = con.prepareStatement(SELECT_USER_BY_ID);
		statement.setInt(1, id);
		statement.executeUpdate();

		ResultSet rset = statement.executeQuery(SELECT_USER_BY_ID);
		while (rset.next()) {
			return true;
		}

		return false;
	}

	public static boolean checkUserExist(User user) throws SQLException {

		if (con == null) {
			establishConnection();
		}

		return checkUserExist(user.getId());
	}

	// update user

//	public boolean updateUser(int id) throws SQLException {
//
//		User existingUser = getUserById(id);
//
//		if (existingUser == null) {
//			return false;
//		}
//		return true;
//	}

	public static boolean updateUser(User user) throws SQLException {

		if (con == null) {
			establishConnection();
		}

		boolean rowUpdated = false;

		if (checkUserExist(user) == false) {
			return rowUpdated;
		}

		statement = con.prepareStatement(UPDATE_USER);

		statement.setString(1, user.getUserName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());
		statement.setInt(4, user.getId());

		rowUpdated = statement.executeUpdate() > 0; // The executeUpdate() method returns the no. of rows affected by
													// the
													// SQL statement.An INSERT typically affects 1 row but an UPDATE or
													// DELETE statement
													// can affect more.

		return rowUpdated;

	}

	// get user

	public static User getUserById(int id) throws SQLException {

		if (con == null) {
			establishConnection();
		}

		User user = null;

		statement = con.prepareStatement(SELECT_USER_BY_ID);
		statement.setInt(1, id);
		System.out.println(
				"preparedstatement on lin 129 of dao which we will store inResultSet after executing  is " + statement);

		ResultSet rset = statement.executeQuery(SELECT_USER_BY_ID);
		System.out.println(rset);

		int rows = 0;

		while (rset.next()) {

			if (rows > 0) {
				break;
			}

			String name = rset.getString("name");
			String email = rset.getString("email");
			String country = rset.getString("country");

			user = new User(id, name, email, country);
			rows++;

		}

		return user;
	}

	// get All users

	public static ArrayList<User> getAllUsers() throws SQLException {

		if (con == null) {
			if (con == null) {
				establishConnection();
			}
		}

		ArrayList<User> users = new ArrayList<>();

		statement = con.prepareStatement(SELECT_ALL_USERS);

		ResultSet rset = statement.executeQuery();
		int rows = 0;
		while (rset.next()) {

			int id = rset.getInt("id");
			String name = rset.getString("name");
			String email = rset.getString("email");
			String country = rset.getString("country");

			users.add(new User(id, name, email, country));

		}

		return users;
	}

	// delete a User

	public static User deleteUser(int id) throws SQLException {

		if (con == null) {
			establishConnection();
		}

		User user = null;

		boolean rowDeleted = false;

		statement = con.prepareStatement(DELETE_USER);
		statement.setInt(1, id);

		// check if the user is acutally deleted or not
		rowDeleted = statement.executeUpdate() > 0;

		if (rowDeleted) {
			user = getUserById(id);
		}

		return user;

	}

}
