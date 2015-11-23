<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <sec:csrfMetaTags />
    <title>Login</title>
</head>
<body>


<div >
    <h2>Login</h2>
    <form name="j" method="post" action="j_spring_security_check">
        <sec:csrfInput />

        <input type="text" class="form-control" placeholder="登录名" required autofocus name="j_username">
        <input type="password" class="form-control" placeholder="密码" required name="j_password">
        <button type="submit" name="submit" >登 录</button>
    </form>
</div>

</body>
</html>