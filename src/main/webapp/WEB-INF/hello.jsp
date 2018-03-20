<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<security:authorize access="isAnonymous()">
    <a href="<c:url value="/managerPage"/> "><button>Вход</button></a> of <a href="<c:url value="/registUser"/> "><button>Регистрация</button></a>
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

</body>
</html>
