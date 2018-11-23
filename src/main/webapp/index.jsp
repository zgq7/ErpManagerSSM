<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/Welcome.css">
</head>
<body>
<form action="Login">
    账户<input type="text" name="cardNo" placeholder="请输入账号" width="100px"/><br>
    密码<input type="password" name="password" placeholder="请输入密码" width="100px"/><br>
    <button type="submit">登录</button>
</form>
</body>
</html>
