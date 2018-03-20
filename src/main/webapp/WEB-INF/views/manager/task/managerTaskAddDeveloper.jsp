<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Developer</title>
</head>
<body>
<table cellspacing="2" id="example" class="display" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <form:forEach items="${userSetProject}" var="developer">
    <tr>
        <td>${developer.lastName}</td>
        <td>${developer.firstName}</td>
        <td><a href="<c:url value="/manager/developer${developer.id}UpTask${task.id}"/> "><button>Добавить</button></a> </td>
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
