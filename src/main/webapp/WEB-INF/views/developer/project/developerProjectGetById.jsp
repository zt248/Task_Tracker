<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>
<body>
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>nameTask</th>
        <th>description</th>
        <th>Status</th>
    <tr>
        <c:forEach var="task" items="${taskList}">
        <td>${task.nameTask}</td>
        <td>${task.description}</td>
        <td>${task.status}</td>
    </tr>
    </c:forEach>
    </tr>
    </thead>

</table>
<br>

<a href="<c:url value="/manager/taskNew/${projectById.id}"/>">
    <button>Новый таск</button>
</a>
<a href="<c:url value="/manager/developerAddProject/${projectById.id}"/>">
    <button>Новый Developer</button>
</a>

<br>
<br>
<a href="/manager/projectPage">Back</a>
<br>
<%--<form:select path="project" itemValue="${project.id}" itemLabel="${project.name}">--%>
<%--<form:option value="NONE" label="--- Select ---"/>--%>
<%--<form:option value="${project.name}"/>--%>
<%--</form:select>--%>
</body>
</html>
