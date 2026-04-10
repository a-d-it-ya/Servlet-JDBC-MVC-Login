<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failure</title>
</head>
<body>
<h1><marquee>Failed to Register</marquee></h1>
<%String name = (String)session.getAttribute("name"); %>
<h2>Sorry <%=name %> , an error occurred</h2>
</body>
</html>