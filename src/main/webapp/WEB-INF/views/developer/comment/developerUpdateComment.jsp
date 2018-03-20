<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Comment</title>
</head>
<body>
<form:form method="post" modelAttribute="comment" action="/developer/developerUpdateComment${idTask}">

    <form:hidden path="id"/>

    <label>Текст комментария</label>
    <form:input path="textComment"/>
    <br>
    <br>
    <input type="submit" value="Редактировать">
</form:form>


</body>
</html>
