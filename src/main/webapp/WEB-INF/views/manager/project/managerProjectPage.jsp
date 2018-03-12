<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table cellspacing="2" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>Tasks</th>
        <th>Developers</th>
        <form:forEach items="${projectList}" var="project">
    <tr>
        <td>${project.id}</td>
        <td>${project.name}</td>
        <td>
            <form:forEach items="${project.tasks}" var="projectTask">
                ${projectTask.nameTask}
            </form:forEach>
        </td>
        <td>
            <form:forEach items="${project.users}" var="user">
                ${user.firstName}
                ${user.lastName}
            </form:forEach>
        </td>

        <td><a href="<c:url value="/manager/projectGetBy/${project.id}"/> ">
            <button>Посмотреть подробности</button>
        </a></td>
        <td><a href="">
            <button>Обновить</button>
        </a></td>
        <td><a href="<c:url value="/manager/projectDelete${project.id}"/> ">
            <button>Удалить</button>
        </a></td>
    </tr>

    </form:forEach>

    </tr>
    </thead>

</table>
<a href="/">Home</a>
<br>
<a href="/managerPage">Back</a>
<br>
<a href="/manager/projectNew">Create</a>
</body>
</html>
