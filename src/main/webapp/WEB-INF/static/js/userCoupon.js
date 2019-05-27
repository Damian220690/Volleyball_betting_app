$(function () {
    var deposit = $("input[type=number]").val();
    $("#deposit").keyup(function () {
        var course = $("#fullCourse").text();
        var result = deposit * course;
        $('#possibleWin').val(result);
    });

    setInterval(function () {
        fetch("/api/coupon").then(function (response) {
            return response.json();
        }).then(function (response) {
            $("#depositValue").text(response.toFixed(2));
            var depositRange = $('#depositValue').text();
            $('#deposit').attr('max', depositRange);
        });
    }, 1000);
});