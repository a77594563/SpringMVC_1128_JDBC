<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <%@include file="fragment/head.jspf" %>
    </head>
    <body>
        <div id="layout">

            <%@include file="fragment/menu.jspf" %>

            <div id="main">
                <div class="header">
                    <h1>PU_View</h1>
                    <h2>訂購單資料查詢</h2>
                </div>
                <table>
                    <td valign="top">
                        <div class="content">

                            <table class="pure-table pure-table-bordered">
                                <thead>
                                    <tr>
                                        <th>orderNum</th>
                                        <th>customerId</th>
                                        <th>customerName</th>
                                        <th>productId</th>
                                        <th>productName</th>
                                        <th>productCodeName</th>
                                        <th>quantity</th>
                                        <th>purchaseCost</th>
                                        <th>rate</th>
                                        <th>subtotal</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${list}">
                                        <tr>
                                            <td>${item.orderNum}</td>
                                            <td>${item.customerId}</td>
                                            <td>${item.customerName}</td>
                                            <td>${item.productId}</td>
                                            <td>${item.productName}</td>
                                            <td>${item.productCodeName}</td>
                                            <td>${item.quantity}</td>
                                            <td>${item.purchaseCost}</td>
                                            <td>${item.rate}</td>
                                            <td>${item.subtotal}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>    
                    </td>
                </table>
            </div>
        </div>
    </body>
</html>
