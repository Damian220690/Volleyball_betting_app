$(function () {
    setInterval(function () {
        fetch("/api/schedule").then(function (response) {
            return response.json();
        }).then(function (response) {
            for (var volleyballMatch of response) {
                let id = volleyballMatch.id;
                var matchName = $("#" + id).prev().text();

                for (var volleyballMatch of response) {
                    var matchNameFromResponse = volleyballMatch.team1 + "-" + volleyballMatch.team2;
                    if (matchName === matchNameFromResponse) {
                        $("#" + id).text(volleyballMatch.setsTeam1 + " : " + volleyballMatch.setsTeam2 + "  |  " + volleyballMatch.pointsTeam1 + " : " + volleyballMatch.pointsTeam2);
                        break;
                    }
                }
            }
        });
    }, 1000);
});

