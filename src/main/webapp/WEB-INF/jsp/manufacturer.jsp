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
                    <h1>Manufacturer</h1>
                    <h2>製造商資料維護</h2>
                </div>
                <table>
                    <td valign="top">
                        <div class="content">
                            <form:form modelAttribute="po" id="myform" class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/manufacturer/">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">製造商資料維護</h2>
                                    </legend>
                                    <table>
                                        <tr>
                                            <td valign="top" style="padding: 5px"> 
                                                <form:input path="manufacturerId" placeholder="manufacturerId" type="number"/><p/>
                                                <form:input path="name" placeholder="name" /><p/>
                                                <form:input path="addressline1" placeholder="addressline1" /><p/>
                                                <form:input path="addressline2" placeholder="addressline2" />
                                            </td>
                                            <td valign="top" style="padding: 5px">
                                                <form:input path="city" placeholder="city" /><p/>
                                                <form:input path="state" placeholder="state" /><p/>
                                                <form:input path="zip" placeholder="zip" /><p/>
                                            </td>
                                            <td valign="top" style="padding: 5px">
                                                <form:input path="phone" placeholder="phone" /><p/>
                                                <form:input path="fax" placeholder="fax" /><p/>
                                                <form:input path="email" placeholder="email" /><p/>
                                                <form:input path="rep" placeholder="rep" />
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
                                        <h2 class="content-subhead">製造商資料列表</h2>
                                    </legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Delete</th>
                                                <th>manufacturerId</th>
                                                <th>name</th>
                                                <th>addressline1</th>
                                                <th>addressline2</th>
                                                <th>city</th>
                                                <th>state</th>
                                                <th>zip</th>
                                                <th>phone</th>
                                                <th>fax</th>
                                                <th>email</th>
                                                <th>rep</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td title="按我一下可刪除"><a href="${pageContext.request.contextPath}/mvc/manufacturer/${item.manufacturerId}" class="delete">刪除</a></td>
                                                    <td title="按我一下可修改"><a href="${pageContext.request.contextPath}/mvc/manufacturer/${item.manufacturerId}">${item.manufacturerId}</a></td>
                                                    <td>${item.name}</td>
                                                    <td>${item.addressline1}</td>
                                                    <td>${item.addressline2}</td>
                                                    <td>${item.city}</td>
                                                    <td>${item.state}</td>
                                                    <td>${item.zip}</td>
                                                    <td>${item.phone}</td>
                                                    <td>${item.fax}</td>
                                                    <td>${item.email}</td>
                                                    <td>${item.rep}</td>
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
