<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PrivBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" media="screen" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="static/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/privBet">PrivBet</a>
        </div>
        <ul class="nav navbar-nav m4-auto">
            <li class="active"><a href="#">Moje konto</a></li>
            <li class="active"><a href="http://localhost:8080/schedule">Harmonogram meczy</a></li>
            <li class="active"><a href="http://localhost:8080/matches">Dodaj mecz</a></li>
        </ul>
        <ul class="nav navbar-nav m4-auto">
            <li><i class="fa fa-money fa-4x" aria-hidden="true"></i></li>
        </ul>
        <button class="btn btn-danger navbar-btn" onclick="location.href='/coupon'">Kupon</button>
        <button class="btn btn-danger navbar-btn " onclick="location.href='/privBet'">Logout</button>
    </div>
</nav>
<div>
    <h2 >Tabela ligi:</h2>
    <table class="table .table-sm" id="teamTable">
        <thead>
        <tr>
            <th scope="col" class="text-center">miejsce</th>
            <th scope="col" class="text-center">drużyna</th>
            <th scope="col" class="text-center">mecze</th>
            <th scope="col" class="text-center">punkty</th>
            <th scope="col" class="text-center">sety</th>
        </tr>
        </thead>
        <tbody>
        <% int placeInTable =1;%>
        <c:forEach var="volleyballTeam" items="${volleyballTeams}">
            <tr id="row<%= placeInTable%>">
                <th scope="row" class="text-center"><%= placeInTable++ %></th>
                <td class="text-center">${volleyballTeam.teamMembers}</td>
                <td class="text-center">${volleyballTeam.numberOfMatches}</td>
                <td class="text-center">${volleyballTeam.mainPoints}</td>
                <td class="text-center">${volleyballTeam.winSets} : ${volleyballTeam.lostSets} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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