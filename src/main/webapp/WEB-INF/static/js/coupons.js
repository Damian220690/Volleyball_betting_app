$(function () {
    $(".roundDiv").hide();
    $(".options").hide();

    $(".roundCounter").click(function (e) {
        e.preventDefault();
        $(this).next('div').toggle('slow');
    });

    var open = $('.open'),
        a = $('ul').find('a');

    $(".open").click(function (e) {
        e.preventDefault();
        $(this).parent().parent().next().children().toggle('slow');
    });

    $('input[type=\'radio\']').on('change', function (e) {
        $(location).attr('href', "http://localhost:8080/coupon/add/" + this.value);
    });

    setInterval(function () {
        fetch('/api/matches').then(function (response) {
            return response.json();
        }).then(function (response) {
            for (var matchProgress of response) {
                var matchNameFromResponse = matchProgress.team1 + "-" + matchProgress.team2;
                var tdWithMatchName = $('td[data-match= "' + matchNameFromResponse + '"]');
                $('td[data-match= "' + matchNameFromResponse + '"]').attr('data-status', matchProgress.matchStatus);

                if ((tdWithMatchName.attr('data-status') === 'LIVE') || (tdWithMatchName.attr('data-status') === '2 WINNER') || (tdWithMatchName.attr('data-status') === '1 WINNER')) {
                    var divId = $('td[data-match= "' + matchNameFromResponse + '"]').parent().parent().parent().parent().attr('id');
                    var idArr = divId.split(" ");
                    var roundCounterHeader = $('#roundSpan'+ idArr[1]).parent();
                    roundCounterHeader.attr('style', 'background-color: #ff7370');

                    roundCounterHeader.attr("title", "Betting in this round has been blocked");
                    roundCounterHeader.off('click');
                }
            }
        });
    }, 200);

    $('.roundCounter').tooltip();
});