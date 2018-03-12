<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProjectCreate</title>
</head>
<body>
<form:form modelAttribute="project" action="/manager/projectCreate" method="post">
    <table>
        <tr>
            <td>Название проекта</td>
        </tr>
        <tr>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>


<a href="/">Home</a>
<br>
<a href="/managerPage">Back</a>
<br>
</body>
</html>

