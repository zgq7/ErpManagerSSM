<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Welcome.js"></script>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/Welcome.css">
</head>
<body>
<div id="div01">
    <form action="Login" name="loginForm" method="post">
        <span>账户</span><input type="text" name="cardNo" placeholder="请输入账号" width="100px" class="username"/><br>
        <span>密码</span><input type="password" name="password" placeholder="请输入密码" width="100px" class="password"/><br>
        <button type="submit" class="login">登录</button>
    </form>
</div>
</body>
</html>
