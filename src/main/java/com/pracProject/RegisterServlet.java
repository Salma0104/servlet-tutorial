package com.pracProject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher("/Register.html");
		rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// adding input as session attributes bc cookies is annoying :)
		
		HttpSession session = req.getSession();
		
		// Remove all existing attributes
	    Enumeration<String> attributeNames = session.getAttributeNames();
	    while (attributeNames.hasMoreElements()) {
	        String attributeName = attributeNames.nextElement();
	        session.removeAttribute(attributeName);
	    }
	    
		session.setAttribute("firstName", req.getParameter("first_name"));
		session.setAttribute("surname", req.getParameter("surname"));
		// format date of birth
		LocalDate dt = LocalDate.parse(req.getParameter("dob"));
        String dob= dt.format(DateTimeFormatter.ofPattern("EEEE d/MM/uuuu", Locale.ENGLISH));
		session.setAttribute("dob", dob);
		session.setAttribute("username", req.getParameter("username"));
		session.setAttribute("password", req.getParameter("password"));
		
		res.sendRedirect("login");
	}
}
