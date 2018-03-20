<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${userList}">
    <br>
    ${user.firstName}
    <br>
    ${user.lastName}
    <br>
</c:forEach>
</body>
</html>
