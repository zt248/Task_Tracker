<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Developer</title>
</head>
<body>
<hr />
<security:authorize access="isAuthenticated()">
    <b>Welcome! <security:authentication property="principal.username" /></b>
</security:authorize>
<br />
<security:authorize access="isAuthenticated()">
    <a href="/logoutNew"><button>Logout</button></a>
</security:authorize>

<h1>Мой Список проектов</h1>
<table cellspacing="2" border="1" cellpadding="5" width="300">
    <thead>
    <tr>
        <th>Имя проекта</th>
        <form:forEach items="${userList}" var="project">
    <tr>
        <td>
            <form:forEach items="${project.projects}" var="proj">
                <a href="<c:url value="/developer/developerProjectGetBy/${proj.id}" /> ">${proj.name}</a>
                <br>
            </form:forEach>
        </td>


    </tr>

    </form:forEach>

    <form:forEach items="${projectList}" var="project">

    </form:forEach>


    </tr>
    </thead>

</table>



</html>