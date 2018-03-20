<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>
<body>
<h1>Мой Список проектов</h1>
<table cellspacing="2" border="1" cellpadding="5" width="300">
    <thead>
    <tr>
        <th>Имя проекта</th>
        <form:forEach items="${userList}" var="project">
    <tr>
        <td>
            <form:forEach items="${project.tasks}" var="tasks">
                <a href="<c:url value="/developer/TaskGetBy/${tasks.id}" /> ">${tasks.nameTask}</a>
                <br>
            </form:forEach>
        </td>


    </tr>

    </form:forEach>



    </tr>
    </thead>

</table>

</body>
</html>
