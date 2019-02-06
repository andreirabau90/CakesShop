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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CakesShop</title>
</head>
<body>
    <table>
        <c:forEach items="${listGr}" varStatus="list">
            <tr>  <td>  ${listGr[list.index].group}
                    ${listGr[list.index].productList}
            </c:forEach></td></tr>
    </table>






</body>
</html>
