$(function () {
    var urlAdress = window.location.href+ "/app";
    var winnerIcon = src="../../static/images/winnerIcon.png";
    var loserIcon = src="../../static/images/loserIcon.png";
    var liveIcon = src="../../static/images/LIVEIcon.png";
    setInterval(function () {
        fetch(urlAdress).then(function (response) {
            return response.json();
        }).then(function (response) {
            for(var details of response){
                if(details.matchStatus==="1 WINNER" && details.matchType === 1){
                    $("#status"+details.matchId).attr("src", winnerIcon);
                }
                else if(details.matchStatus==="2 WINNER" && details.matchType === 2){
                    $("#status"+details.matchId).attr("src", winnerIcon);
                }
                else if(details.matchStatus==="1 WINNER" && details.matchType === 2){
                    $("#status"+details.matchId).attr("src", loserIcon);
                }
                else if(details.matchStatus==="2 WINNER" && details.matchType === 1){
                    $("#status"+details.matchId).attr("src", loserIcon);
                }
                else if(details.matchStatus==="LIVE"){
                    $("#status"+details.matchId).attr("src", liveIcon);
                }

                if($("#status"+details.matchId).attr("src")===loserIcon){
                    console.log($("#status"+details.matchId));
                    $("#possibleWinField").text("--");
                }
                $("#" + details.matchId).text(details.setTeam1 +  " : " + details.setTeam2);
            }
        });
    }, 1000);
});

