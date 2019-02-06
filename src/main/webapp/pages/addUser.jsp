<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 01.02.2019
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myUser</title>
</head>
<body>
<form action="/addMyUser">
    <input type="text" name="name" value="Andrey">
    <input type="text" name="pass" value="1234">
    <input type="text" name="email" value="123@1.com">
    <input type="submit" value="senNewUser">
</form>
<form action="/deleteUser">
    <input type="text" name="id" value="2">
    <input type="submit" value="delete">
</form>
</body>
</html>
