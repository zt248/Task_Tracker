<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Developer Page</title>
</head>
<body>

<table cellspacing="2" id="example" class="display" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Проекты</th>
        <th>Таски</th>
        <form:forEach items="${developers}" var="developer">
    <tr>
        <td>${developer.lastName}</td>
        <td>${developer.firstName}</td>
        <form:forEach items="${developer.projects}" var="developerProject">
            <td>${developerProject.name}</td>
        </form:forEach>
        <form:forEach items="${developer.tasks}" var="developerTast">
            <td>${developerTast.nameTask}</td>
        </form:forEach>
    </tr>
    </form:forEach>
    </tr>
    </thead>

</table>
<a href="/">Home</a>
<br>
<a href="/managerPage">Back</a>
<br>

</body>
</html>
