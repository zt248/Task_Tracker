<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellspacing="2" id="example" class="display" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <form:forEach items="${developers}" var="developer">
    <tr>
        <td>${developer.lastName}</td>
        <td>${developer.firstName}</td>
        <td><a href="<c:url value="/manager/developerUpProject/${project.id}/${developer.id}"/> "><button>Добавить</button></a> </td>
    </tr>
    </form:forEach>
    </tr>

    </thead>

</table>
<br>
<a href="/manager/projectGetBy/${project.id}">Back</a>
<br>
</body>
</html>
</body>
</html>
