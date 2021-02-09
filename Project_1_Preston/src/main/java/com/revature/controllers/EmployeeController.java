package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeController {

	public static EmployeeService es = new EmployeeService();
	public static Gson gson = new Gson();

	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Employee emp = gson.fromJson(request.getReader(), Employee.class);
		emp = es.login(emp.getEmail(), emp.getPassword());

		// create a cookie to store the logged in users email
		// then you can use a doa to pull up info on user when needed

		if (emp != null) {
			Cookie cookie = new Cookie("loggedInUser", emp.getEmail());
			cookie.setSecure(true);
			response.addCookie(cookie);
			// response.getWriter().append(gson.toJson(e));

			response.getWriter().append(gson.toJson(emp));
		}

	}

	public static void loggedInUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		String email;

		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if (cookie.getName().equals("loggedInUser")) {
				System.out.println(cookie.getValue());
				email = cookie.getValue();
				Employee emp = es.getEmployeeByUsername(email);
				response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
				break;
			}
		}
	}
	
	public static void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// update tuition status
		
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cookie cookie = new Cookie("loggedInUser", "");
		cookie.setMaxAge(0);
		
		response.getWriter().append("Employee is logged out");
		
	}
}