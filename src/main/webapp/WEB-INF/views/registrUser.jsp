<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="user" action="/userAdd" method="post">

    <tr>
        <td>
        Имя : -- <form:input path="lastName"/>
        </td>
    </tr>
    <tr>
        <td>
        Фамилия : -- <form:input path="firstName"/>
        </td>
    </tr>
    <tr>
        <td>
        Email : -- <form:input path="email"/>
            <%="true".equals(request.getParameter("errore"))? "Введите правильно e-mail":""%>
        </td>
    </tr>
    <tr>
        <td>
       Пароль : -- <form:input path="password"/>
        </td>
    </tr>
    <tr>
        <td>
        Роль : --  <form:select path="role">
            <form:option value="ROLE_MANAGER"/>
            <form:option value="ROLE_DEVELOPER"/>
        </form:select>
        </td>
    </tr>
    <input type="submit" name="Добвить">
</form:form>

</body>
</html>
