<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 20.01.2019
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/getGroup">
    <input type="text" name="id" value=1>
    <input type="submit" value="getGroup">
</form>

<form action="/saveOrUpdate">
    <input type="text" name="id" value=4>
    <input type="text" name="name" value="test">
    <input type="submit" value="save Or update">
</form>
<form action="/allGroupProduct">
    <input type="submit" value="sendAll">
</form>
<form action="/delete">
    <input type="text" name="id" value=4>
    <input type="submit"  value="delete">
</form>
</body>
</html>
