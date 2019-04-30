<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PrivBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="../static/css/style.css" rel="stylesheet" type="text/css"/>
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
                <li class="active"><a href="http://localhost:8080/schedule">Harmonogram meczy</a></li>
                <li class="active"><a href="http://localhost:8080/matches">Dodaj mecz</a></li>
            </ul>
            <button class="btn btn-danger navbar-btn" onclick="location.href='/coupon'">Kupon</button>
            <button class="btn btn-danger navbar-btn " onclick="location.href='/privBet'">Logout</button>
        </div>
    </nav>
    <h2>Harmonogram rozgrywek:</h2>
    <% int count =1;%>
    <c:forEach var="rounds" items="${rounds}">
        <table class="table .table-sm" id="schedule">

            <thead>
            <tr id="roundCounter">Runda ${rounds.roundNumber}:</tr>
            <tr>
                <th scope="col" class="text-center">drużyna</th>
                <th scope="col" class="text-center">&nbsp</th>
            </tr>
            </thead>

            <c:forEach var="match" items="${rounds.match}">
            <tbody>
                <tr>
                    <td id="match" class="text-center">${match}</td>
                    <td class="text-center" id="<%= count++ %>">${result}</td>
                </tr>
            </tbody>
            </c:forEach>

        </table>
    </c:forEach>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="../static/js/matchProgress.js"></script>
</body>
</html>
