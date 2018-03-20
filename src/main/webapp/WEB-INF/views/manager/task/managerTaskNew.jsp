<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProjectCreate</title>
</head>
<body>
<form:form modelAttribute="task" action="/manager/taskCreate/${projectTask.id}" method="post">
    <table>
        <tr>
            <td>Название таска</td>
        </tr>
        <tr>
            <td><form:input path="nameTask"/></td>
        </tr>
        <tr>
            <td>Описание</td>
        </tr>
        <tr>
            <td><form:textarea path="description"/></td>
        </tr>
        <tr>
            <td>Статус</td>
        </tr>
        <tr>
            <td>
                <form:select path="status">
                    <form:option value="NONE" label="--- Select ---"/>
                    <form:option value="waiting"/>
                    <form:option value="implementation"/>
                    <form:option value="verifying"/>
                    <form:option value="releasing"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>


<br>
<a href="/manager/projectGetBy/${projectTask.id}">Back</a>
<br>
</body>
</html>

