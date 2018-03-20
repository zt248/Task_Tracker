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
        <th>Название таска</th>
        <th>Описание</th>
        <th>Статус</th>
        <%--<th>Комментарий</th>--%>
        <th>Имя разработчика</th>
        <th>Фамилия разработчика</th>
    <tr>
        <td>${task.nameTask}</td>
        <td>${task.description}</td>
        <td>${task.status}</td>
        <td>${task.user.lastName}</td>
        <td>${task.user.firstName}</td>
        <td><a href="<c:url value="/manager/taskDelete${task.id}"/> ">
            <button>Удалить таск</button>
        </a>
        </td>
        <td><a href="<c:url value="/developer/Task${task.id}CreateComment" /> ">
            <button>Добавить комментарий</button>
        </a></td>
        <td><a href="<c:url value="/developer/developerUpdateTask${task.id}Status"/> ">
            <button>Изменить статус таска</button>
        </a>

        </td>
    </tr>
    </tr>
    </thead>

</table>

<br>
<table cellspacing="2" border="1" cellpadding="5" width="300">
    <thead>
    <tr>
        <th>Комментарий</th>
    </tr>

    <form:forEach items="${task.comments}" var="comments">
        <tr>
            <td>
                ${comments.textComment}
            </td>

            <td><a href="<c:url value="/developer/developerUpdateComment${comments.id}Page/${task.id}" /> ">
                <button>Редактировать комментарий</button>
            </a></td>
            <td><a href="<c:url value="/developer/developerDeleteComment${comments.id}/${task.id}" /> ">
                <button>Удалить комментарий</button>
            </a></td>
        </tr>
    </form:forEach>
    </thead>
</table>
<br>
<a href="/managerPage">Back</a>
<br>

</body>
</html>
