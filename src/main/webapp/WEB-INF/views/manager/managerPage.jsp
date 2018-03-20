<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Manager</title>
</head>
<body>
<hr />
<h3>Manager</h3>
<security:authorize access="isAuthenticated()">
    <b>Welcome! <security:authentication property="principal.username" /></b>
</security:authorize>
<br />
<security:authorize access="isAuthenticated()">
    <a href="/logoutNew"><button>Logout</button></a>
    <br>
    <br>
</security:authorize>

<table cellspacing="2" border="1" cellpadding="5" width="300">
    <thead>
    <tr>
        <th>Проекты:</th>
        <c:forEach items="${projectList}" var="project">
    <tr>
        <td><a href="<c:url value="/manager/projectGetBy/${project.id}"/> ">${project.name}</a></td>

        <td><a href="<c:url value="/manager/projectDelete${project.id}"/> ">
            <button>Удалить</button>
        </a></td>
    </tr>

    </c:forEach>

    </tr>
    </thead>

</table>

<br>
<a href="/manager/projectNew"><button>Create Project</button></a>
<br>
<br>
<a href="/manager/managerPoisk"><button>Search Developer</button></a>
</body>
</html>