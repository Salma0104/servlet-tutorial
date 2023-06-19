package com.pracProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		int square = (int) req.getAttribute("result");
		int num1 = Integer.parseInt(req.getParameter("first_num"));
		int num2 = Integer.parseInt(req.getParameter("second_num"));
		square = square * square;
		
		out.println("<html>");
		out.println("<head><title>Square Result</title></head>");
		out.println("<body>");
		out.println("<h1>The Result of the addition squared: " + square + "<h1>");
		out.println("<h2>The input: " + num1 + " + "+num2+"<h2/>");
		out.println("</body>");
		out.println("</html>");
	}
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		PrintWriter out = res.getWriter();
		int result = 0;
		
		Cookie cookies[] = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("result"))
				result = Integer.parseInt(c.getValue());
		}
		result = result * result;
		
		out.println("<html>");
		out.println("<head><title>Square Results</title></head>");
		out.println("<body>");
		out.println("<h1>Get Request for Square Page [Using Cookies!!!]</h1>");
		out.println("<p>result squared: " + result + "</p>");
		out.println("</body>");
		out.println("</html>");
	
	}
}
