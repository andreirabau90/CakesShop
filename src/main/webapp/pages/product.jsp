<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 19.01.2019
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/getProduct">
    <input type="text" name="id" value=1>
    <input type="submit" value="getProduct">
</form>

<form action="/saveOrUpdateProduct">
    <input type="text" name="id" value=4>
    <input type="text" name="name" value="test">
    <input type="text" name="price" value=4>
    <input type="text" name="groupProductId" value=1>
    <input type="submit" value="save Or update">
</form>
<form action="/getAllProduct">
    <input type="submit" value="sendAll">
</form>
<form action="/deleteProduct">
    <input type="text" name="id" value=4>
    <input type="submit"  value="delete">
</form>
</body>
</html>
