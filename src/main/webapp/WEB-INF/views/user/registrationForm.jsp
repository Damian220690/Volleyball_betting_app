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
    <link href="../static/css/registrationStyle.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="container" id="externalContainer">
    <div class="jumbotron">
        <div class="container">
            <form:form method="post" class="my-1" modelAttribute="user">
                <div class="input-group mb-3 col-sm-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">First name</span>
                    </div>
                    <form:input type="text" class="form-control" name="firstName"
                                path="firstName"/>
                    <form:errors path="firstName"><span class="errors">This field is required</span></form:errors>
                </div>
                <div class="input-group mb-3 col-sm-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Last name</span>
                    </div>
                    <form:input type="text" class="form-control" name="lastName"
                                path="lastName"/>
                    <form:errors path="lastName"><span class="errors">This field is required</span></form:errors>
                </div>
                <div class="input-group mb-3 col-sm-5" id="formEmailDiv">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Email</span>
                    </div>
                    <form:input type="email" class="form-control" name="email" id="email" path="email"/>
                    <form:errors path="email"><span class="errors">This field is required</span></form:errors>
                </div>
                <div id="emailDiv">
                    <span class="errors" id="emailError">${msg}</span>
                </div>

                <div class="row">
                    <div class="btn-group btn-group-toggle mb-3 col-sm-5" data-toggle="buttons">
                        <label class="btn" for="Male" id="maleLabel">
                            <form:radiobutton path="gender" value="M" class="genderSelector" id="Male"/>Male
                        </label>
                        <label class="btn " for="Female">
                            <form:radiobutton path="gender" value="F" class="genderSelector" id="Female"/>Female
                        </label>
                        <form:errors path="gender"><span class="errors">This field is required</span></form:errors>
                    </div>
                </div>
                <div class="input-group mb-3 col-sm-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">User name</span>
                    </div>
                    <form:input type="text" id="username" path="userName"/>
                    <form:errors path="userName"><span class="errors">This field is required</span></form:errors>
                </div>

                <div class="input-group mb-3 col-sm-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Password</span>
                    </div>
                    <div>
                    <span class="passwordErrors">
                    </div>
                    <form:input type="password" id="password" path="password"/>
                    <form:errors path="password"><span class="errors">This field is required</span></form:errors>
                </div>

                <div class="input-group mb-3 col-sm-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Repeat password</span>
                    </div>
                    <form:input type="password" id="con-password" path="repeatPassword"/>
                    <form:errors path="repeatPassword"><span id="conPassword"
                                                             class="errors">This field is required</span></form:errors>
                    <span id="passwordError"
                          class="errors" style="display:none">Passwords do not match</span>
                </div>
                <button type="submit" id="sendButton" class="btn btn-primary">Register</button>
            </form:form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="../static/js/checkPasswords.js"></script>
</body>

</html>