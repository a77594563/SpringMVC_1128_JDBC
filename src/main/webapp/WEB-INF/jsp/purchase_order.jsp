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
                    <h1>Purchase Order</h1>
                    <h2>採購訂單資料維護</h2>
                </div>
                <table>
                    <td valign="top">
                        <div class="content">
                            <form:form modelAttribute="purchaseOrder" id="myform" class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/purchase_order/">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">Purchase Order-採購訂單資料維護</h2>
                                    </legend>
                                    <table>
                                        <tr>
                                            <td valign="top" style="padding: 5px"> 
                                                <form:input path="orderNum" placeholder="orderNum" /><form:errors path="orderNum" style="color: red" /><p/>
                                                <form:select path="customerId" 
                                                             items="${list_c}" 
                                                             itemLabel="name"  
                                                             itemValue="customerId"/><p/>
                                                <form:select path="productId" 
                                                             items="${list_p}" 
                                                             itemLabel="label" 
                                                             itemValue="productId"/><p/>
                                                <form:input path="quantity" placeholder="quantity" /><form:errors path="quantity" style="color: red" />
                                            </td>
                                            <td valign="top" style="padding: 5px">
                                                <form:input path="shippingCost" placeholder="shippingCost" /> <form:errors path="shippingCost" style="color: red" /><p/>
                                                <form:input path="salesDate" type="date" placeholder="salesDate" value="2020-01-09"/><p/>
                                                <form:input path="shippingDate" type="date" placeholder="shippingDate" value="2020-01-09"/><p/>
                                                <form:input path="freightCompany" placeholder="freightCompany" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">
                                                <input type="hidden" id="_method" name="_method" value="${_method}">
                                                <button type="submit" class="pure-button pure-button-primary">${_method}</button>
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </form:form>

                            <form class="pure-form">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">Purchase Order-採購訂單資料查詢</h2>
                                    </legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Update</th>
                                                <th>Delete</th>
                                                <th>orderNum</th>
                                                <th>customerId</th>
                                                <th>productId</th>
                                                <th>quantity</th>
                                                <th>shippingCost</th>
                                                <th>salesDate</th>
                                                <th>shippingDate</th>
                                                <th>freightCompany</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td title="按我一下可修改"><a href="${pageContext.request.contextPath}/mvc/purchase_order/${item.orderNum}" class="pure-button pure-button-primary">修改</a></td>
                                                    <td title="按我一下可刪除"><a href="${pageContext.request.contextPath}/mvc/purchase_order/${item.orderNum}" class="delete">刪除</a></td>
                                                    <td>${item.orderNum}</a></td>
                                                    <td>${item.customerId}</a></td>
                                                    <td>${item.productId}</a></td>
                                                    <td nowrap>${item.quantity}</td>
                                                    <td nowrap>${item.shippingCost}</td>
                                                    <td nowrap><fmt:formatDate pattern="yyyy-MM-dd" value="${item.salesDate}" /></td>
                                                    <td nowrap><fmt:formatDate pattern="yyyy-MM-dd" value="${item.shippingDate}" /></td>
                                                    <td>${item.freightCompany}</a></td>
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
