<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <%@include  file="fragment/head.jspf" %>
</head>
<body>

<div id="layout">
    <!-- Menu  -->
    <%@include  file="fragment/menu.jspf" %>
    <!-- Body -->
    <div id="main">
        <div class="header">
            <h1>Discount Code</h1>
            <h2>A subtitle for your page goes here</h2>
        </div>

        <div class="content">
            <h2 class="content-subhead">How to use this layout</h2>
            ${list}
        </div>
    </div>
</div>
</body>
</html>
