<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New coupon</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="../static/css/addCouponStyle.css" rel="stylesheet" type="text/css"/>
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
            <button class="btn btn-danger navbar-btn" onclick="location.href='/newCoupon'">Kupon</button>
            <button id=" btn" class="btn btn-danger navbar-btn " onclick="location.href='/privBet'">Logout</button>
        </div>
    </nav>
</div>
<div class="roundsDiv">
    <h2>Wybierz mecze:</h2>
    <c:forEach var="rounds" items="${rounds}">
        <h4 class="roundCounter"><b>Runda ${rounds.roundNumber}</b></h4>
        <div class="roundDiv">
            <table class="table .table-sm" id="schedule">
                <thead>
                <tr>
                    <th scope="col" class="text-center">mecz</th>
                    <th scope="col" class="text-center">&nbsp</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="match" items="${rounds.match}">
                <tr>
                    <td class="text-center">${match}</td>
                    <td class="text-center">
                        <button class="open">Wybierz</button>
                    </td>
                </tr>
                <tr class="t">
                    <td class="options">
                        <div id="betOptions">
                            <label class="firstTeam"><input type="radio" name="toggle" value="1"><span>1</span></label>
                            <label class="secondTeam"><input type="radio" name="toggle" value="2"><span>2</span></label>
                        </div>
                    </td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
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
<script src="../static/js/coupons.js"></script>
</body>
</html>