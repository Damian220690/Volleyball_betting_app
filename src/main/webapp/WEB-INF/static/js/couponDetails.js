$(function () {
    var urlAdress = window.location.href+ "/app";
    setInterval(function () {
        fetch(urlAdress).then(function (response) {
            return response.json();
        }).then(function (response) {
            for(var details of response){
                console.log(details.match + details.matchId);
                $("#" + details.matchId).text(details.setTeam1 +  " : " + details.setTeam2);
            }
        });
    }, 1000);
});

