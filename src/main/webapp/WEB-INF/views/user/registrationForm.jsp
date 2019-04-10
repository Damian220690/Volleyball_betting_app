<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

<body>
<form:form method="post" modelAttribute="user">
    <label for="fullname">Name</label>
    <div class="row" id="fullname">
        <div class="mb-3 col-3">
            <form:input type="text" class="form-control" name="firstName" placeholder="First name" path="firstName"/>
            <form:errors path="firstName"><span class="errors">To pole jest wymagane</span></form:errors>
        </div>
        <div class="mb-3 col-3">
            <form:input type="text" class="form-control" name="lastName" placeholder="Last name" path="lastName"/>
            <form:errors path="lastName"><span class="errors">To pole jest wymagane</span></form:errors>
        </div>
    </div>
    <div class="mb-3 col-3">
        <label for="email">Email address</label>
        <form:input type="email" class="form-control" name="email" id="email" placeholder="Email" path="email"/>
        <form:errors path="email"><span class="errors">To pole jest wymagane</span></form:errors>
    </div>

    <label for="gender-div">Gender</label>
    <div id="gender-div" class="mb-3 col-3">
        Male: <form:radiobutton path="gender" value="M"/>
        Female: <form:radiobutton path="gender" value="F"/>
        <form:errors path="gender"><span class="errors">To pole jest wymagane</span></form:errors>
    </div>

    <label for="username">Username</label>
    <div class="mb-3 col-3">
        <form:input type="text" id="username" path="userName"/>
        <form:errors path="userName"><span class="errors">To pole jest wymagane</span></form:errors>
    </div>

    <div class="mb-3 col-3 ">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password"/>
        <form:errors path="password"><span class="errors">To pole jest wymagane</span></form:errors>
    </div>

    <div class="mb-3 col-3">
        <label for="con-password">Confirm password</label>
        <form:input type="password" id="con-password" path="repeatPassword"/>
        <form:errors path="repeatPassword"><span id = "conPassword" class="errors">To pole jest wymagane</span></form:errors>
    </div>
    <button type="submit" id="sendButton" class="btn btn-primary">Agree and Join</button>
</form:form>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="static/js/checkPasswords.js"></script>
</body>

</html>