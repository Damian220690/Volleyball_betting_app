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
            <li class="active"><a href="http://localhost:8080/schedule">Rozgrywki</a></li>
            <li class="active"><a href="http://localhost:8080/teamsTable">Tabela ligi</a></li>
            <li class="active"><a href="http://localhost:8080/user/coupons">Kupony</a></li>
            <li class="active"><a href="http://localhost:8080/matches">Wybierz mecze</a></li>
            <div id="userDiv" style="display: flex; align-items:center; padding-left: 300px">
                <i class="fas fa-user fa-3x"></i>
                <span id="depositValue" style="font-size: 20px">&nbsp 200.0</span>
            </div>
        </ul>

        <button class="btn btn-danger navbar-btn" onclick="location.href='/coupon'" id="couponButton">Kupon</button>
        <button class="btn btn-danger navbar-btn " onclick="location.href='/privBet'" id="logoutButton">Logout</button>
    </div>
</nav>
</body>
</html>
