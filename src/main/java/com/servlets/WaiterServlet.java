package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessService.UserDataAccessObject;
import com.model.User;

//@WebServlet(description = "Servlet Handles the the incoming request and transport them to BusinessService(cook) and View(presenter)", urlPatterns = {
//		"/" })

public class WaiterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDataAccessObject model;

	public WaiterServlet() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		String requestFromListPage = request.getParameter("addUserBtn");
		writer.println("request from user-list page is " + requestFromListPage);

		if (requestFromListPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(requestFromListPage);
			rd.forward(request, response);
		}
		if (request.getParameter("editUserBtn") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("./editUser.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("editSubmitBtn") != null) {

			int userId = Integer.parseInt(request.getParameter("id"));
			String userName = request.getParameter("name");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			User user = new User(userId, userName, email, country);

			try {
				boolean rowsUpdated = UserDataAccessObject.updateUser(user);

				if (rowsUpdated) {
					RequestDispatcher rd = request.getRequestDispatcher("./user-list.jsp");
					rd.forward(request, response);
					writer.println("User updated in Database successfully");
				} else {
					writer.println("Sorry! User cant be updated in Database.");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (request.getParameter("formSubmitBtn") != null) {

			int userId = Integer.parseInt(request.getParameter("id"));
			String userName = request.getParameter("name");
			String email = request.getParameter("email");
			String country = request.getParameter("country");

			User user = new User(userId, userName, email, country);

			try {
				int rowsUpdated = UserDataAccessObject.insertUser(user);

				if (rowsUpdated > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("./user-list.jsp");
					rd.forward(request, response);
					writer.println("User added to Database successfully");
				} else {
					writer.println("Sorry! User cant be added to Database.");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
	}

}
