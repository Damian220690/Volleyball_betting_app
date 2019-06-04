<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New coupon</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Akronim" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="tooltipster/dist/css/tooltipster.bundle.min.css"/>
    <script type="text/javascript" src="tooltipster/dist/js/tooltipster.bundle.min.js"></script>
    <link href="../static/css/couponCreatorStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body id="couponCreator">
<%@ include file="../navigationPanel/navbar.jsp" %>
<div class="roundsDiv">
    <h2 id="couponMatchesHeader">Wybierz mecze:</h2>
    <c:forEach var="round" items="${rounds}">
        <h4 class="roundCounter" data-toggle="tooltip"><span class="roundSpan"
                                                             id="roundSpan${round.roundNumber}">Round ${round.roundNumber}</span>
        </h4>
        <div class="roundDiv" id="div ${round.roundNumber}">
            <table class="table .table-sm" id="matchesTable">
                <thead>
                <tr>
                    <th scope="col" class="text-center">mecz</th>
                    <th scope="col" class="text-center">&nbsp</th>
                </tr>
                </thead>
                <tbody>
                <% int count = 1;%>
                <c:forEach var="match" items="${round.match}">
                <tr>
                    <td class="text-center" data-match="${match}" data-status=" ">${match}</td>
                    <td class="text-center">
                        <button class="open" id="selectionButton">Wybierz</button>
                    </td>
                </tr>
                <tr class="t">
                    <td class="options">
                        <div id="betOptions">
                            <label class="firstTeam"><input type="radio" name="toggle"
                                                            value="${round.roundNumber}/<%= count%>/1"><span>1</span></label>
                            <label class="secondTeam"><input type="radio" name="toggle"
                                                             value="${round.roundNumber}/<%= count%>/2"><span>2</span></label>
                            <%= count++ %>
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
