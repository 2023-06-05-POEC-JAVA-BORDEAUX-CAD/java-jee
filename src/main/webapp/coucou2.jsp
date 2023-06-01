<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<title>Date JSP</title>
</head>
<% SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy"); %>
<body>
<h1>Welcome to Tomcataaa!!!! Today is <%= "Hello World" %> </h1>
Hey, tu as entré le paramètre : <%= request.getParameter("coucou") %>.
<form action="do-it" method="get" >
	<input type="text" name="text-field" />
	<input type="submit" value="Envoyer requête" />
</form>
</body>
</html>