<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Coupons</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/privBet">PrivBet</a>
            </div>
            <ul class="nav navbar-nav m4-auto">
                <li class="active"><a href="">Moje konto</a></li>
                <li class="active"><a href="schedule">Harmonogram meczy</a></li>
            </ul>
            <button id=" btn" class="btn btn-danger navbar-btn " onclick="location.href='/privBet'">Logout</button>
        </div>
    </nav>
</div>
<div>
    <h2>Wybrane mecze:</h2>
    <table class="table .table-sm" id="couponMatchList">
        <thead>
        <tr>
            <th scope="col" class="text-center">mecz</th>
            <th scope="col" class="text-center">kurs</th>
            <th scope="col" class="text-center">wybór</th>
            <th scope="col" class="text-center">&nbsp</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="selectedMatch" items="${selectedMatches}">
            <tr>
                <td>${selectedMatch.match}</td>
                <td>${selectedMatch.singleCourse}</td>
                <td>${selectedMatch.choice}</td>
                <td><button>Usuń</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<p>Kurs całkowity:</p>
<p>Stawka:</p>


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
