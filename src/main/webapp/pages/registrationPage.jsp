<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 22.02.2019
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/enter">
    <input type="text" name="name">
    <input type="text" name="pass">
    <input type="text" name="email">
    <input type="submit" value="send">
</form>
</body>
</html>
