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
        <th>nameTask</th>
        <th>description</th>
        <th>Status</th>
        <th>Комментарий</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <form:forEach items="${taskList}" var="task">
    <tr>
        <td>${task.nameTask}</td>
        <td>${task.description}</td>
        <td>${task.status}</td>
        <td>
            <form:forEach items="${task.comments}" var="comments">
                ${comments.textComment}
            </form:forEach>
        </td>
        <td>${task.user.lastName}</td>
        <td>${task.user.firstName}</td>
        <td><a href=""><button>Посмотреть подробности</button></a> </td>
        <td><a href=""><button>Обновить</button></a> </td>
        <td><a href="<c:url value="/manager/taskDelete${task.id}"/> "><button>Удалить</button></a> </td>
    </tr>

    </form:forEach>

    </tr>
    </thead>

</table>
<a href="/">Home</a>
<br>
<a href="/managerPage">Back</a>
<br>
<%--<a href="/manager/taskNew">Create</a>--%>
</body>
</html>
