<html>
<head>
    <title></title>
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
        </ul>
        <button class="btn btn-danger navbar-btn" onclick="location.href='/coupon'" id="couponButton">Kupon</button>
        <button class="btn btn-danger navbar-btn " onclick="location.href='/privBet'" id="logoutButton">Logout</button>
    </div>
</nav>
</body>
</html>
