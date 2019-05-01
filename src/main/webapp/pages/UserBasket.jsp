<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 30.04.2019
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
<c:forEach items="${listProductInBasket}" varStatus="index">
    <form action="/deleteProductInBasket">
        <p>
            Name:${listProductInBasket[index.index].product.productName}
            price:${listProductInBasket[index.index].product.price}
            quantity: ${listProductInBasket[index.index].quantity}
        </p>
        <input type="hidden" name="deleteId" value=${listProductInBasket[index.index].basketAndProductId}>
        <input type="submit" value="delete">
    </form>
</c:forEach>
<form action="/">
    <input type="hidden" name="user" value="${user}">
    <input type="submit" value="back">
</form>
</body>
</html>
