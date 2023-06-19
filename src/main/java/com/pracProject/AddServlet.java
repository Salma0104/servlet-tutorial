package com.pracProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int firstNum = Integer.parseInt(req.getParameter("first_num"));
		int secondNum = Integer.parseInt(req.getParameter("second_num"));
		
		int result = firstNum + secondNum;
		
		PrintWriter out = res.getWriter();
		
		Cookie cookie = new Cookie("result",result + "");
		res.addCookie(cookie);
		
		// redirect method (new request to other servlet)
		res.sendRedirect("square");
		
		
		// forwards request to another servlet
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		req.setAttribute("result", result);
//		rd.forward(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Addition Result</title></head>");
		out.println("<body>");
		out.println("<h1>You have not submitted numbers for addition</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}
}
