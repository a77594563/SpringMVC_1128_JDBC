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
                    <h1>Customer</h1>
                    <h2>客戶資料資料維護</h2>
                </div>
                <table>
                    <td valign="top">
                        <div class="content">
                            <form:form modelAttribute="po" id="myform" class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/customer/">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">客戶資料資料維護</h2>
                                    </legend>
                                    <table>
                                        <tr>
                                            <td valign="top" style="padding: 5px"> 
                                                <form:input path="customerId" placeholder="customerId" /><p/>
                                                <form:select path="discountCode" 
                                                             items="${list_dc}" 
                                                             itemLabel="label" 
                                                             itemValue="discountCode"/><p/>
                                                <form:select path="zip" 
                                                             items="${list_mm}" 
                                                             itemLabel="zipCode" 
                                                             itemValue="zipCode"/><p/>
                                                <form:input path="name" placeholder="name" />
                                            </td>
                                            <td valign="top" style="padding: 5px">
                                                <form:input path="addressline1" placeholder="addressline1" /><p/>
                                                <form:input path="addressline2" placeholder="addressline2" /><p/>
                                                <form:input path="city" placeholder="city" /><p/>
                                                <form:input path="state" placeholder="state" />
                                            </td>
                                            <td valign="top" style="padding: 5px">
                                                <form:input path="phone" placeholder="phone" /><p/>
                                                <form:input path="fax" placeholder="fax" /><p/>
                                                <form:input path="email" placeholder="email" /><p/>
                                                <form:input path="creditLimit" placeholder="creditLimit" type="number" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">
                                                <input type="hidden" id="_method" name="_method" value="${_method}">
                                                <button type="submit" class="pure-button pure-button-primary">${_method}</button>
                                                <button type="button" class="pure-button pure-button-primary" onclick="location.href = '${pageContext.request.contextPath}/mvc/customer/input';">reset</button>
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </form:form>

                            <form class="pure-form">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">客戶資料資料列表</h2>
                                    </legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Delete</th>
                                                <th>customerId</th>
                                                <th>discountCode</th>
                                                <th>zip</th>
                                                <th>name</th>
                                                <th>addressline1</th>
                                                <th>addressline2</th>
                                                <th>city</th>
                                                <th>state</th>
                                                <th>phone</th>
                                                <th>fax</th>
                                                <th>email</th>
                                                <th>creditLimit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td title="按我一下可刪除"><a href="${pageContext.request.contextPath}/mvc/customer/${item.customerId}" class="delete">刪除</a></td>
                                                    <td title="按我一下可修改"><a href="${pageContext.request.contextPath}/mvc/customer/${item.customerId}">${item.customerId}</a></td>
                                                    <td title="按我一下可連結優惠碼頁面"><a href="${pageContext.request.contextPath}/mvc/discount_code/${item.discountCode}">${item.discountCode}</a></td>
                                                    <td title="按我一下可連結市場區域頁面"><a href="${pageContext.request.contextPath}/mvc/micro_market/${item.zip}">${item.zip}</a></td>
                                                    <td>${item.name}</td>
                                                    <td>${item.addressline1}</td>
                                                    <td>${item.addressline2}</td>
                                                    <td>${item.city}</td>
                                                    <td>${item.state}</td>
                                                    <td>${item.phone}</td>
                                                    <td>${item.fax}</td>
                                                    <td>${item.email}</td>
                                                    <td>${item.creditLimit}</td>
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
