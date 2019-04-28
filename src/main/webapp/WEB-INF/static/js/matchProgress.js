$(function () {
    setInterval(function () {
        fetch("/api/schedule").then(function (response) {
            return response.json();
        }).then(function (response) {
            // $("tbody").children().children().next().text(response);
            for(var volleyballMatch of response){
                let id = volleyballMatch.id;
                console.log("#"+volleyballMatch.id);
                let result = volleyballMatch.setsTeam1 +" : " + volleyballMatch.setsTeam2 + "  |  "+ volleyballMatch.pointsTeam1 + " : "+ volleyballMatch.pointsTeam2;
                $("#"+id).text(result);
            }
        });
    }, 1000);
});

