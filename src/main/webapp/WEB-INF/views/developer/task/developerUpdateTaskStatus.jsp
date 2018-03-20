<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="task" method="post" action="/developer/developerUpdateTaskStatus${task.id}">

    <form:hidden path="id"/>
    <form:hidden path="description"/>
    <form:hidden path="nameTask"/>

    <label>Статус такска</label>
    <form:select path="status">
        <form:option value="waiting"/>
        <form:option value="implementation"/>
        <form:option value="verifying"/>
        <form:option value="releasing"/>
    </form:select>

    <input type="submit" value="Изменить">
</form:form>

</body>
</html>
