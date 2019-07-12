<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PrivBet</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Akronim" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
    <link href="../../static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body id="couponDetails">
<%@ include file="../navigationPanel/navbar.jsp" %>
<div>
    <h2 id="selectedMatchesHeader">Selected matches:</h2>
    <table class="table .table-sm" id="couponMatchList">
        <thead>
        <tr>
            <th scope="col" class="text-center">&nbsp</th>
            <th scope="col" class="text-center">Match</th>
            <th scope="col" class="text-center">Result</th>
            <th scope="col" class="text-center">Choice</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${fullDetailsAboutCouponMatch}" var="detailAboutCouponMatch">

            <tr>
                <td><img id="status${detailAboutCouponMatch.matchId}" src=""/></td>
                <td>${detailAboutCouponMatch.match}</td>
                <td id="${detailAboutCouponMatch.matchId}">${detailAboutCouponMatch.setTeam1}
                    : ${detailAboutCouponMatch.setTeam2}</td>
                <td>${detailAboutCouponMatch.matchType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<p><span class="detailsParagraph">Rate: </span><span id="fullCourse">${fullCourse}</span></p>
<p><span class="detailsParagraph">Deposit: </span><span id="depositField">${couponDeposit}</span></p>
<p><span class="detailsParagraph">Possible win: </span><span id="possibleWinField">${possibleWin}</span></p>
<p id="backParagraph"><a href="http://localhost:8080/user/coupons" id="backButton">Powrót</a></p>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="../../../../static/js/couponDetails.js"></script>
</body>
</html>
