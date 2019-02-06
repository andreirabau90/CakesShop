<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 31.01.2019
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/getAllProduct">
    <table>
        <c:if test="${not empty myList}">
            <c:forEach items="${myList}" varStatus="Lt">
                <tr>
                    <td><input type="submit" value="${myList[Lt.index].group}"></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</form>
<c:forEach items="${product}" varStatus="Pr">
    <tr>${product[Pr.index].productName} ${product[Pr.index].price}</tr>
</c:forEach>
<form action="/getAllProduct">
    <input type="submit" value="allProduct">
</form>

</body>
</html>
<%--<c:forEach items="${pageContext.request.cookies}" varStatus="vs">--%>
<%--Name:  ${pageContext.request.cookies[vs.index].name}--%>
<%--Value: ${pageContext.request.cookies[vs.index].value}--%>
<%--</c:forEach>--%>


<%--<c:if test="${not empty messages}">--%>
<%--<c:forEach items="${messages}" var="m">--%>
<%--${m.author} : ${m.text}<br>--%>
<%--</c:forEach>--%>
<%--</c:if>--%>
<%--<spring:form action="/start" method="post" modelAttribute="messages">--%>
<%--<spring:input path="group"/>--%>
<%--<input type="submit" value="send"/>--%>
<%--</spring:form>--%>