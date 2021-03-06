<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Coupon</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Akronim" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="tooltipster/dist/js/tooltipster.bundle.min.js"></script>
    <link href="../../../../../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/../../../../static/css/userCouponStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body id="userCoupon">
<%@ include file="../navigationPanel/navbar.jsp" %>
<div>
    <form method="post">
        <h2 id="selectedMatchesHeader">Selected matches:</h2>
        <table class="table .table-sm" id="couponMatchList">
            <thead>
            <tr>
                <th scope="col" class="text-center">Match</th>
                <th scope="col" class="text-center">Course</th>
                <th scope="col" class="text-center">Choice</th>
                <th scope="col" class="text-center"><button id="cleaningButton" onclick="location.href='http://localhost:8080/coupon/deleteAll'"
                                                            data-toggle="tooltip" title="Remove all bets" >
                <i class="fas fa-trash-alt fa-1x"></i></button></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="selectedMatch" items="${selectedMatches}">
                <tr id="selectedRow" style="background-color: #9999ff; border: 3px solid #4d4dff;" >
                    <td style="background-color: #9999ff"><input name="matches" id="matches" type="text" value="${selectedMatch.match}"
                               readonly="readonly" style="background-color: #9999ff"></td>
                    <td class="course">${selectedMatch.singleCourse}</td>
                    <td>${selectedMatch.choice}</td>
                    <td><a id="deleteButton" href="http://localhost:8080/coupon/delete/${selectedMatch.id}">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p id="course">Total rate: <span id="fullCourse">${fullCourse}</span></p>
        <label id="depositLabel"for="deposit">Deposit</label>
        <input type="number" min="2" step=".01" id="deposit" name="deposit" required>
        <input type="submit" id="confirmButton" value="Confirm">
        <p id="prize">Price: <input id="possibleWin" name="possibleWin" readonly="readonly"/></p>
        <p id="backParagraph"><a href="http://localhost:8080/matches" id="backButton">
            Return to the selection of matches</a></p>
        <footer class="footer">
            <p>
                <label for="couponNum">Coupon number:</label>
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
