<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 15.02.2019
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form action="/valid" modelAttribute="user">
    <div>
        name:
        <spring:input path="userName"/>
        <spring:errors path="userName"/>
    </div>
    <div>
        password:
        <spring:input path="pass"/>
        <spring:errors path="pass"/>
    </div>
    <div>
        email:
        <spring:input path="email"/>
        <spring:errors path="email"/>
    </div>

    <input type="submit" value="addUser">
</spring:form>
<form action="/allGroupProduct">
    <input type="submit" value="back">
</form>
</body>
</html>
