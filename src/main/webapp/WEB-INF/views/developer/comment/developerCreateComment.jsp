<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="comment" action="/developer/Task${task.id}AddComment" method="post">
    <table>
        <tr>
            <td>Комментарий</td>
        </tr>
        <tr>
            <td><form:input path="textComment"/></td>
        </tr>
            <td colspan="2" align="center"><input type="submit"  value="Save"></td>
        </tr>
    </table>
</form:form>

<a href="/">Home</a>
<br>
<a href="/managerPage">Back</a>
<br>


</body>
</html>
