$(function () {

    $("#deposit").keyup(function () {
        var deposit = $("input[type=number]").val();
        var course = $("#fullCourse").text();
        var result = deposit * course;
        console.log(deposit);
        $('#possibleWin').val(result.toFixed(2));
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