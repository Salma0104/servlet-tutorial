package com.pracProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		boolean success = (boolean) session.getAttribute("success");
		String firstName = (String) session.getAttribute("firstName");
		String surname = (String) session.getAttribute("surname");
		String username = (String) session.getAttribute("username");
		String dob = (String) session.getAttribute("dob");
		out.println("<html>");
		out.println("<head><title>Welcome</title></head>");
		out.println("<body>");
		if(success) {
			out.println("<h1>Welcome to this page</h1>");
			out.println("<span style='float:left;color:blue;'> Logged in as: " + username + "</span>");
			out.println("<br><br>");
			out.println("<p>First Name: " + firstName + "</p>");
			out.println("<p>Surname: " + surname + "</p>");
			out.println("<p>Date of Birth: " + dob + "</p>");
		} else {
			out.println("<h1 style='background-color:red;color:white;'>Login details were incorrect</h1>");
			
		}
		out.println("<button><a style='color:black;text-decoration:none;' href='login\'>Back to Login </a></button>");
		out.println("</body>");
		out.println("</html>");
	}

}
