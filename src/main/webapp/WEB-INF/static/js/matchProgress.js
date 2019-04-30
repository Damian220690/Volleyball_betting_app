$(function () {
    setInterval(function () {
        fetch("/api/schedule").then(function (response) {
            return response.json();
        }).then(function (response) {
                for (var volleyballMatch of response) {
                    let id = volleyballMatch.id;
                    var matchName = $("#" + id).prev().text();
                    console.log(matchName);
                    console.log(matchName==="Rafał Kruczkowski / Arkadiusz Żołnierczyk - Piotr Niewęgłowski / Jacek Zięba");
                    // var matchName = $("#" + id).prev().text(volleyballMatch.team1 + " - " + volleyballMatch.team2)
                    // let result = volleyballMatch.setsTeam1 +" : " + volleyballMatch.setsTeam2 + "  |  "+ volleyballMatch.pointsTeam1 + " : "+ volleyballMatch.pointsTeam2;
                    $("#" + id).text(volleyballMatch.setsTeam1 + " : " + volleyballMatch.setsTeam2 + "  |  " + volleyballMatch.pointsTeam1 + " : " + volleyballMatch.pointsTeam2);
                    // console.log($("tbody").find('#match').text());
                }
        });
    }, 1000);
});

