<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Developer</title>
</head>
<body>
<h2>Spring Security 4 - Hello World Example</h2>
<hr />
<h3>Developer </h3>
<security:authorize access="isAuthenticated()">
    <b>Welcome! <security:authentication property="principal.username" /></b>
</security:authorize>
<br />
<security:authorize access="isAuthenticated()">
    <a href="/developer/developerGetAllProject">developerGetAllProject</a>
<br>
<br>
    <a href="/developerCreate">developerCreate</a>
    <a href="/">Home</a> | <a href="/logoutNew">Logout</a>
</security:authorize>


</html>