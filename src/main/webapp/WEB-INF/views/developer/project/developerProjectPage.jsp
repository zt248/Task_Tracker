<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Мой Список проектов</h1>
<table cellspacing="2" border="1" cellpadding="5" width="300">
    <thead>
    <tr>
        <th>Имя проекта</th>
        <form:forEach items="${userList}" var="project">
        <%--<form:forEach items="${project}" var="projects">--%>
    <tr>
        <td>
            <%--${projects.name}--%>
            <form:forEach items="${project.projects}" var="proj">
              <a href="<c:url value="/developer/developerProjectGetBy/${proj.id}" /> ">${proj.name}</a>
                <br>
            </form:forEach>
        </td>


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
