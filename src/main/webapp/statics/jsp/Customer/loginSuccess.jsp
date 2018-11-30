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
</div>
<div id="top2">
    <div id="top2-1">
        <ul class="ul01">
            <li class="level01">
                <a href="#">
                    <button class="gl">管理一</button>
                </a>
                <ul class="ul02">
                    <li>
                        <button class="gl-z">1</button>
                    </li>
                    <li>
                        <button class="gl-z">1</button>
                    </li>
                    <li>
                        <button class="gl-z">1</button>
                    </li>
                </ul>
            </li>
            <li class="level01">
                <a href="#">
                    <button class="gl">管理二</button>
                </a>
                <ul class="ul02">
                    <li>
                        <button class="gl-z">1</button>
                    </li>
                    <li>
                        <button class="gl-z">1</button>
                    </li>
                    <li>
                        <button class="gl-z">1</button>
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
