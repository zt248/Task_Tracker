<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
         <%--pageEncoding="ISO-8859-1"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<h2>Spring Security 4 - Hello World Example</h2>
<hr />
<h3>
    Welcome !
    <security:authorize access="isAnonymous()">
        Guest
    </security:authorize>
    <!-- Print the logged in user name -->
    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username" />
    </security:authorize>
</h3>
<security:authorize access="isAnonymous()">
    Login as <a href="/developerPage">Developer</a> or <a href="/managerPage">Manager</a>
</security:authorize>

<security:authorize access="isAuthenticated()">
    <security:authorize access="hasRole('DEVELOPER')">
        <a href="/developerPage">Developer Profile</a>
    </security:authorize>
    <security:authorize access="hasRole('MANAGER')">
        <a href="/managerPage">Manager Profile</a>
    </security:authorize>
    <a href="/logoutNew">Logout</a>
</security:authorize>
<br>
<a href="<c:url value="/registUser"/> "><button>Регистрация</button></a>
</body>
</html>