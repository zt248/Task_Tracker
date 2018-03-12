<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Manager</title>
</head>
<body>
<h2>Spring Security 4 - Hello World Example</h2>
<hr />
<h3>Manager</h3>
<security:authorize access="isAuthenticated()">
    <b>Welcome! <security:authentication property="principal.username" /></b>
</security:authorize>
<br />
<security:authorize access="isAuthenticated()">
    <a href="/">Home</a> | <a href="/logoutNew">Logout</a>
    <br>
    <br>
    <a href="/manager/projectPage">ProjectPage</a>
    <br>
    <br>
    <a href="/manager/taskPage">TaskPage</a>
    <br>
    <br>
    <a href="/manager/developerPage">DeveloperPage</a>
</security:authorize>
</body>
</html>