<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Welcome.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Welcome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div id="register">
    <input type="text" name="name" placeholder="请输入姓名" width="100px" class="name"/><br>
    <input type="text" name="cardNo" placeholder="请输入6位以上账号" width="100px" class="username"/><br>
    <input type="password" name="password" placeholder="请输入6位以上密码" width="100px" class="password"/><br>
    <input type="text" name="mobile" placeholder="请输入11位手机号码" width="100px" class="mobile"/><br>
    <button type="submit" class="postCus">提交</button>
</div>

<div id="div01">
    <form action="Login" name="loginForm" method="post">
        <input type="text" name="cardNo" placeholder="请输入账号" width="100px" class="usernameL"/><br>
        <input type="password" name="password" placeholder="请输入密码" width="100px" class="passwordL"/><br>
        <button type="submit" class="login">登录</button>
        <button type="button" class="register">注册</button>
        <div id="msg">${msg}</div>
    </form>
</div>
</body>
</html>
