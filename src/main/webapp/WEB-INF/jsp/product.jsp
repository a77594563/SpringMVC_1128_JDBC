<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <%@include file="fragment/head.jspf" %>
        <script>
            $(document).ready(function () {
                $(".delete").click(function () {
                    var href = $(this).attr("href");
                    $("#_method").val("DELETE")
                    $("#myform").attr("action", href).submit();
                    return  false;
                })
            })
        </script>
    </head>
    <body>
        <div id="layout">

            <%@include file="fragment/menu.jspf" %>

            <div id="main">
                <div class="header">
                    <h1>Product</h1>
                    <h2>商品資料維護</h2>
                </div>

                <table>
                    <td valign="top">
                        <div class="content">
                            <form:form modelAttribute="po" id="myform" class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/product/">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">商品資料維護</h2>
                                    </legend>
                                    <form:input path="productId" placeholder="productId" /><p/>
                                    
                                    <form:select path="manufacturerId" 
                                                 items="${list_mf}" 
                                                 itemLabel="name" 
                                                 itemValue="manufacturerId"/><p/>
                                    
                                    <form:select path="productCode" 
                                                 items="${list_pc}" 
                                                 itemLabel="prodCode" 
                                                 itemValue="prodCode"/><p/>
                                    
                                    <form:input path="purchaseCost" placeholder="purchaseCost" /><p/>
                                    <form:input path="quantityOnHand" placeholder="quantityOnHand" /><p/>
                                    <form:input path="markup" placeholder="markup" /><p/>
                                    <form:input path="available" placeholder="available" /><p/>
                                    <form:input path="description" placeholder="description" /><p/>
                                    <input type="hidden" id="_method" name="_method" value="${_method}">
                                    <button type="submit" class="pure-button pure-button-primary">${_method}</button>
                                    <button type="button" class="pure-button pure-button-primary" onclick="location.href = '${pageContext.request.contextPath}/mvc/product/input';">reset</button>
                                </fieldset>
                            </form:form>
                        </div>
                    </td>
                    <td valign="top">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">商品資料列表</h2>
                                    </legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Delete</th>
                                                <th>productId</th>
                                                <th>manufacturerId</th>
                                                <th>productCode</th>
                                                <th>purchaseCost</th>
                                                <th>quantityOnHand</th>
                                                <th>markup</th>
                                                <th>available</th>
                                                <th>description</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td title="按我一下可刪除"><a href="${pageContext.request.contextPath}/mvc/product/${item.productId}" class="delete">刪除</a></td>
                                                    <td title="按我一下可修改"><a href="${pageContext.request.contextPath}/mvc/product/${item.productId}">${item.productId}</a></td>
                                                    <td title="按我一下可連結製造商頁面"><a href="${pageContext.request.contextPath}/mvc/manufacturer/${item.manufacturerId}">${item.manufacturerId}</a></td>
                                                    <td title="按我一下可連結商品代碼頁面"><a href="${pageContext.request.contextPath}/mvc/product_code/${item.productCode}">${item.productCode}</a></td>
                                                    <td>${item.purchaseCost}</td>
                                                    <td>${item.quantityOnHand}</td>
                                                    <td>${item.markup}</td>
                                                    <td>${item.available}</td>
                                                    <td>${item.description}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>
                    </td>
                </table>

            </div>
        </div>



    </body>
</html>
