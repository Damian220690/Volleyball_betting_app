<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link href="static/css/loginStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="login-box">
    <h1>Login</h1>
    <form:form modelAttribute="user">
        <div class="inputBox">
            <i class="fa fa-user"></i>
            <form:input class="input" path="email" id="email" type="email" placeholder="Email" ></form:input>
            <form:errors path="email"></form:errors>
        </div>
        <div class="inputBox">
            <i class="fa fa-lock"></i>
            <form:input path="password" class="input" id="password" type="password" placeholder="Password"></form:input>
            <form:errors path="password"></form:errors>
        </div>
        <div>
            <input type="submit" value="Sign in">
        </div>
        <div>
            <c:out value="${msg}"></c:out>
        </div>
    </form:form>
</div>
</body>
</html>
