<%@page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="error.jsp" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add result</title>
</head>
<body>
	<%
		int firstNum = Integer.parseInt(request.getParameter("first_num"));
		int secondNum = Integer.parseInt(request.getParameter("second_num"));
		
		int k = firstNum + secondNum;
		k = 9/0;
	%>
	<h1>The result of the addition is: <%=k %></h1>
</body>
</html>