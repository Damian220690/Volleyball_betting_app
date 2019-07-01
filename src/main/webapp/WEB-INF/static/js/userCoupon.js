$(function () {

    $("#deposit").keyup(function () {
        var deposit = $("input[type=number]").val();
        var course = $("#fullCourse").text();
        var result = deposit * course;
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


    setInterval(function(){
        alertStatus = false;
        fetch('/api/matches').then(function (response) {
            return response.json();
        }).then(function (response) {
            var submitButton = $("#confirmButton");
            for (var matchProgress of response) {
                var matchNameFromResponse = matchProgress.team1 + "-" + matchProgress.team2;
                var inputWithMatchesName =  $('input[value="' + matchNameFromResponse + '"]');
                inputWithMatchesName.attr('data-status', matchProgress.matchStatus);
                var statusAttr = inputWithMatchesName.attr('data-status');
                if(statusAttr !== undefined){
                    inputWithMatchesName.attr('style','background-color: #264075');
                    inputWithMatchesName.parent().attr('style','background-color: #264075');
                    inputWithMatchesName.parent().parent().attr('style','background-color: #264075; border: 3px solid #EA1818');
                    submitButton.click(function(){
                        if(alertStatus === false) {
                            alert('Accepting bets on certain events has been stopped, to continue please remove invalid matches from the coupon!!');
                            alertStatus = true;
                        }
                        submitButton.attr("disabled", true);
                    })
                }
                else{
                    submitButton.attr("disabled", false);
                }
            }
        });
        }, 200);


    $("#cleaningButton").click(function(){
        $("tbody").empty();
    });

});