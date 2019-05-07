
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li class="active"><a href="http://localhost:8080/user/account">Moje konto</a></li>
                <li class="active"><a href="http://localhost:8080/schedule">Harmonogram meczy</a></li>
                <li class="active"><a href="http://localhost:8080/matches">Dodaj mecz</a></li>
            </ul>
            <button class="btn btn-danger navbar-btn" onclick="location.href='/coupon'">Kupon</button>
            <button class="btn btn-danger navbar-btn " onclick="location.href='/privBet'">Logout</button>
        </div>
    </nav>
</div>
<div>
    <p>Doładuj środki:</p>
    <form method="post">
        <input type="number" placeholder="Wprowadź kwotę" step="0.01" min="2" max="20" name="boost">
        <input type="submit" value="Doładuj">
    </form>
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

