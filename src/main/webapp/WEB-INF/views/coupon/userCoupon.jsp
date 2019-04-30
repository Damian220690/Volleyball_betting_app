<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Coupon</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../../../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../../../static/css/userCouponStyle.css" rel="stylesheet" type="text/css"/>
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
            <button id=" btn" class="btn btn-danger navbar-btn " onclick="location.href='/privBet'">Logout</button>
        </div>
    </nav>
</div>
<div>
    <form method="post">
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
                    <td><input name="matches" id="matches" type="text" value="${selectedMatch.match}"
                               readonly="readonly"></td>
                    <td class="course">${selectedMatch.singleCourse}</td>
                    <td>${selectedMatch.choice}</td>
                    <td><a id="deleteButton" href="http://localhost:8080/coupon/delete/${selectedMatch.id}">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p>Kurs całkowity: <span id="fullCourse">${fullCourse}</span></p>
        <label for="deposit">Stawka</label>
        <input type="number" min="2" max="5000" step=".01" id="deposit" name="deposit" required>
        <input type="submit" value="Postaw">
        <p>Do wygrania: <input id="possibleWin" name="possibleWin" readonly="readonly"/></p>
        <p><a href="http://localhost:8080/matches">Powrót</a></p>
        <footer class="footer">
            <p>
                <label for="couponNum">Numer kuponu:</label>
                <input name="couponNumber" id="couponNum" type="text" value="${couponNumber}" readonly="readonly">
            </p>
        </footer>
    </form>
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
<script src="../../../../static/js/userCoupon.js"></script>
</body>
</html>
