<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Test JSP </h1>
	
	
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	%>
	
	<h1><%=id%></h1>
	<h1><%=pw%></h1>
	<h1> if()</h1>

</body>
</html>