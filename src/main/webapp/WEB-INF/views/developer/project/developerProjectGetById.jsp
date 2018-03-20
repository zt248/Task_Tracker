<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>
<body>
<table cellspacing="2" border="1" cellpadding="5" width="300">
    <thead>
    <tr>
        <th>nameTask</th>
    <tr>
        <c:forEach var="task" items="${taskList}">
            <td><a href="<c:url value="/developer/TaskGetBy/${task.id}" /> "/>${task.nameTask}</td>
    </tr>
    </c:forEach>
    </tr>
    </thead>

</table>
<br>

<a href="<c:url value="/developer/taskNew/${projectById.id}"/>"><button>Новый таск</button></a>
<br>
<br>
<a href="<c:url value="/developer/developerGetMyTask"/>"><button>Мои таски</button></a>


<br>
<br>
<a href="/developerPage"><button>Back</button></a>

</body>
</html>
