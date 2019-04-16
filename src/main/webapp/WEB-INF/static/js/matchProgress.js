$(function () {

    setInterval(function () {
        fetch("/api/schedule").then(function (response) {
            return response.json();
        }).then(function (response) {
            $("tbody").children().children().next().text(response);
        });
    }, 1000);
});

