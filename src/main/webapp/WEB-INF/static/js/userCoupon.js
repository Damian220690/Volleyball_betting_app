$(function () {
    $("")
    // console.log($("input[type=number]").val());
    $("#deposit").keyup(function(){
        var deposit = $("input[type=number]").val();
        var course = $("#fullCourse").text();
        var result = deposit * course;
        $('#possibleWin').text(result);
    });

});