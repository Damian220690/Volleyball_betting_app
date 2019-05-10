$(function () {
    var urlAdress = window.location.href+ "/app";
    var winnerIcon = src="../../static/images/winnerIcon.png";
    var loserIcon = src="../../static/images/loserIcon.png";
    setInterval(function () {
        fetch(urlAdress).then(function (response) {
            return response.json();
        }).then(function (response) {
            for(var details of response){
                if(details.couponStatus==="WON") {
                    $("#" + details.couponNumber).attr("src", winnerIcon);
                }
                else if(details.couponStatus==="LOST"){
                    $("#" + details.couponNumber).attr("src", loserIcon);
                    $("#win" + details.couponNumber).text("--");
                }
            }
        });
    }, 1000);
});

