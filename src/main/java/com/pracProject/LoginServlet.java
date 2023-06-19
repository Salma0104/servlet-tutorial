package com.pracProject;

import java.io.IOException;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher("/login.html");
		rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// check user name and password equal to session user name + password + redirect 2 wel
		
		String username = req.getParameter("username");
		System.out.println(username);
		String password = req.getParameter("password");
		System.out.println(password);
		HttpSession session = req.getSession();
		String savedUsername = (String) session.getAttribute("username");
		System.out.println(savedUsername);
		String savedPassword = (String) session.getAttribute("password");
		System.out.println(savedPassword);
		
		boolean success = savedUsername.equals(username) && savedPassword.equals(password);
		session.setAttribute("success", success);
		res.sendRedirect("welcome");
		

	}

}
