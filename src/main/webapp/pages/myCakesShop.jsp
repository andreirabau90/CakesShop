<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 04.02.2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"  %>
<html>
<head>
    <title>CakesShop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<p>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>

<c:if test="${user!=null}">
<form action="/getBasket">
<input type="hidden" name="user" value="${user.userId}">
    <input type="submit" value="Basket">
</form>
    </c:if>

    <form action="/getGroupProducts">
        <input type="hidden" name="user" value="${user.userId}">
        <div class="btn-group-vertical" role="group" aria-label="Basic example">
            <c:if test="${user!=null}">
                Name:  ${user.userName}
            </c:if>
            <c:forEach items="${listGr}" varStatus="list">
                <p>
                    <button name="id" class="btn btn-outline-success"
                            value="${listGr[list.index].id}">${listGr[list.index].group} </button>
                </p>
                <div class="btn-group-vertical" role="group" aria-label="Basic example">
                    <c:forEach items="${listPr}" varStatus="pr">
                        <c:if test="${listPr[pr.index].groupProduct.id==listGr[list.index].id}">
                            <p>
                                <button name="idProduct" value="${listPr[pr.index].id}"
                                        class="btn btn-default">${listPr[pr.index].productName}</button>
                            </p>
                        </c:if>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>

        <c:if test="${product!=null}">
            <h1> ${product.productName}</h1>  ${product.description}
            <h3>Price for 1 kg:${product.price} </h3>

        </c:if>
    </form>

    <c:if test="${product!=null&&user!=null}">
    <form action="/buy">
        <input type="hidden" name="user" value="${user.userId}">
        <input type="hidden" name="product" value="${product.id}">
        <input type="text" name="quantity" value="">
        <input type="submit" value="pay">
    </form>
    </c:if>
    <c:if test="${!empty error }">
        ${error}
    </c:if>

    <form action="/pages/registrationPage.jsp" method="get">
        <input type="submit" value="registration">
    </form>
    <form action="/pages/CheckIn.jsp" method="get">
        <input type="submit" value="check in">
    </form>

</body>
</html>
