<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login Success </title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/LoginSuccess.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/LoginSuccess.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div id="top1">
    欢 迎 来 到 EMS
    <div id="head">
        <ul>
            <li class="glyphicon glyphicon-log-in"></li>
        </ul>
    </div>
</div>
<div id="top2">
    <div id="top2-1">
        <ul id="ul">
            <li class="levels">
                <span class="glyphicon glyphicon-plus"></span>
                <button class="btn btn-info">管理1</button>
                <ul class="ul-gls">
                    <li class="li-gls">
                        <button class="btn btn-xs">管理1.1</button>
                    </li>
                    <li class="li-gls">
                        <button class="btn btn-xs">管理1.1</button>
                    </li>
                    <li class="li-gls">
                        <button class="btn btn-xs">管理1.1</button>
                    </li>
                </ul>
            </li>
            <li id="levels" class="levels">
                <span class="glyphicon glyphicon-plus"></span>
                <button class="btn btn-info">管理1</button>
                <ul id="ul-gls" class="ul-gls">
                    <li class="li-gls">
                        <button class="btn btn-xs">管理1.1</button>
                    </li>
                    <li class="li-gls">
                        <button class="btn btn-xs">管理1.1</button>
                    </li>
                    <li class="li-gls">
                        <button class="btn btn-xs">管理1.1</button>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div id="top2-2">
        <iframe src="toError" id="customer">

        </iframe>
    </div>
</div>
</body>

</html>
