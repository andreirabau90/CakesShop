<%@ taglib prefix="FORM" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 04.02.2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<script src="http://code.jquery.com/jquery-2.0.3.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div>
    <c:forEach items="${listGr}" varStatus="list">
        <form:form action="/getGroupProducts" id="${listGr[list.index].id}">
            <input type="hidden" name="id" value=${listGr[list.index].id}>
            <input type="submit" value="${listGr[list.index].group}"/>
        </form:form>
    </c:forEach>
</div>

<c:forEach items="${listPr}" varStatus="p">
    <FORM:form action="/getDescription" id="${listPr[p.index].id}">
        <ul>
            <li><input type="submit" value="${listPr[p.index].productName}">
                <input type="hidden" name="id" value=${listPr[p.index].id}></li>
        </ul>
    </FORM:form>

</c:forEach>
<div>
    ${description}

</div>
<form action="/allGroupProduct">
    <input type="submit" value="back">
</form>

<form action="/valid" method="get">
    <input type="submit" value="Registration">
</form>

</body>
</html>
