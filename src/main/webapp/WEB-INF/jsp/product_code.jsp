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
                    <h1>Product Code</h1>
                    <h2>商品代碼資料維護</h2>
                </div>

                <table>
                    <td valign="top">
                        <div class="content">
                            <form:form modelAttribute="po" id="myform" class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/product_code/">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">商品代碼資料維護</h2>
                                    </legend>
                                    <form:input path="prodCode" placeholder="productCode" /><p/>
                                    <form:select path="discountCode" 
                                                 items="${list_dc}" 
                                                 itemLabel="label" 
                                                 itemValue="discountCode"/><p/>
                                    <form:input path="description" placeholder="description" /><p/>
                                    <input type="hidden" id="_method" name="_method" value="${_method}">
                                    <button type="submit" class="pure-button pure-button-primary">${_method}</button>
                                </fieldset>
                            </form:form>
                        </div>
                    </td>
                    <td valign="top">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">商品代碼資料列表</h2>
                                    </legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Delete</th>
                                                <th>prodCode</th>
                                                <th>discountCode</th>
                                                <th>description</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td title="按我一下可刪除"><a href="${pageContext.request.contextPath}/mvc/product_code/${item.prodCode}" class="delete">刪除</a></td>
                                                    <td title="按我一下可修改"><a href="${pageContext.request.contextPath}/mvc/product_code/${item.prodCode}">${item.prodCode}</a></td>
                                                    <td title="按我一下可連結優惠碼頁面"><a href="${pageContext.request.contextPath}/mvc/discount_code/${item.discountCode}">${item.discountCode}</a></td>
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
