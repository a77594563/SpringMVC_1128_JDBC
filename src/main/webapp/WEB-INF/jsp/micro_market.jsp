<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <!-- Menu  -->
            <%@include file="fragment/menu.jspf" %>
            <!-- Body -->
            <div id="main">
                <div class="header">
                    <h1>Micro Market</h1>
                    <h2>A subtitle for your page goes here</h2>
                </div>

                <div class="content">
                    <h2 class="content-subhead">市場區域維護</h2>
                    <form:form modelAttribute="po" id="myform" method="post" action="${pageContext.request.contextPath}/mvc/micro_market/" class="pure-form">
                        <fieldset>
                            <form:input path="zipCode" placeholder="請輸入 zipCode" /><p/>
                            <form:input path="radius" placeholder="請輸入 radius" /><p/>
                            <form:input path="areaLength" placeholder="請輸入 areaLength" /><p/>
                            <form:input path="areaWidth" placeholder="請輸入 areaWidth" /><p/>
                            <input type="hidden" id="_method" name="_method" value="${_method}">
                            <button type="submit" class="pure-button pure-button-primary">${_method}</button>
                            <button type="reset" class="pure-button pure-button-primary">reset</button>
                        </fieldset>
                    </form:form>
                    <h2 class="content-subhead">市場區域列表</h2>
                    <table class="pure-table pure-table-bordered">
                        <thead>
                            <tr>
                                <th>刪除</th>
                                <th>zipCode</th>
                                <th>radius</th>
                                <th>areaLength</th>
                                <th>areaWidth</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="mm" items="${list}">
                                <tr>
                                    <td><a href="${pageContext.request.contextPath}/mvc/micro_market/${mm.zipCode}" class="delete">刪除</a></td>
                                    <td><a href="${pageContext.request.contextPath}/mvc/micro_market/${mm.zipCode}">${mm.zipCode}</a></td>
                                    <td>${mm.radius}</td>
                                    <td>${mm.areaLength}</td>
                                    <td>${mm.areaWidth}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
