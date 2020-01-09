<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <%@include file="../fragment/head.jspf" %>
    </head>
    <body>
        <div id="layout">

            <%@include file="../fragment/menu.jspf" %>

            <div id="main">
                <div class="header">
                    <h1>發生了錯誤</h1>
                </div>

                <div class="content">
                    ${ex}
                </div>
                <div class="content">
                    請與我聯絡:03-3474878
                </div>

            </div>
        </div>
    </body>
</html>
