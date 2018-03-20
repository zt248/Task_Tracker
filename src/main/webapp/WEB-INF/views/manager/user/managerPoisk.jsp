<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/manager/poisk">
    <label>Имя:</label> <input name="last_name" id="last_name">
    <label>Фамилия:</label> <input name="first_name" id="first_name">
    <input type="submit" value="button">
</form:form>
</body>
</html>
