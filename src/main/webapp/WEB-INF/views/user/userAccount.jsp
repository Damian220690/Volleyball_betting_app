<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PrivBet</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
    <link href="../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../static/css/userAccountStyle.css" rel="stylesheet" type="text/css"/>

</head>
<body id="userAccount">
<%@ include file="../navigationPanel/navbar.jsp" %>
<div>
    <p id="mainParagraph">Top up your account:</p>
    <form method="post">
        <div class="input-group">
            <input id="boostBox" class="form-control" type="number" placeholder="Enter the amount" step="0.01" min="2"
                   max="50" name="boost" required="required" style="height: 43.979166px;">
            <div class="input-group-btn">
                <button type="submit" id="confirmButton" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="../static/js/matchProgress.js"></script>
</body>
</html>

