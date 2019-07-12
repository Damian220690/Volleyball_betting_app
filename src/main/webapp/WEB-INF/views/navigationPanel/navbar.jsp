<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/privBet">PrivBet</a>
        </div>
        <ul class="nav navbar-nav m4-auto">
            <li class="active"><a href="http://localhost:8080/schedule">Competition</a></li>
            <li class="active"><a href="http://localhost:8080/teamsTable">League table</a></li>
            <li class="active"><a href="http://localhost:8080/user/coupons">My coupons</a></li>
            <li class="active"><a href="http://localhost:8080/matches">Select matches</a></li>
            <li class="active"><a href="http://localhost:8080/user/account">Recharge account</a></li>
            <div id="userDiv" style="display: flex; align-items:center; padding-left: 300px">
                <div>
                <i class="fas fa-user fa-3x" style="color: white"></i>
                </div>
                <div>
                <span id="depositValue" style="font-size: 20px; color: white; padding-left: 10px"><fmt:formatNumber value="${deposit}" minFractionDigits="2" maxFractionDigits="2"/></span>
                </div>
            </div>
        </ul>

        <button class="btn btn-danger navbar-btn" onclick="location.href='/coupon'" id="couponButton">Coupon</button>
        <button class="btn btn-danger navbar-btn " onclick="location.href='/privBet'" id="logoutButton">Logout</button>
    </div>
</nav>
</body>
</html>
