$(function () {
    $("#deposit").keyup(function(){
        var deposit = $("input[type=number]").val();
        var course = $("#fullCourse").text();
        var result = deposit * course;
        $('#possibleWin').val(result);
    });
    setInterval(function () {
        fetch("/api/coupon").then(function (response) {
            return response.json();
        }).then(function (response) {
            $("#depositValue").text(response.toFixed(2));
        });
    }, 1000);
});