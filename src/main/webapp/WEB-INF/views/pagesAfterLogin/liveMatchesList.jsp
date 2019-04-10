<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int numberOfRounds = 1; %>
<%session.setAttribute( "numberOfRounds",  numberOfRounds);%>
<html>
<head>
    <title>PrivBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="static/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">PrivBet</a>
            </div>
            <ul class="nav navbar-nav m4-auto">
                <li class="active"><a href="#">Home</a></li>
            </ul>
            <button class="btn btn-danger navbar-btn ">Rejestracja / Logowanie</button>
        </div>
    </nav>
    <h2>Harmonogram rozgrywek:</h2>
<c:forEach var="matches" items="${matches}">
    <table class="table .table-sm" id="schedule">

        <thead>
        <tr id="roundCounter"><%=numberOfRounds++%></tr>
        <tr>
            <th scope="col" class="text-center">drużyna</th>
            <th scope="col" class="text-center">mecze</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="match" items="${matches}">
            <tr>
                <td class="text-center">${match}</td>
                <td class="text-center"><a>Szczegóły meczu</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
