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
            console.log( $(this).parent().parent().next().children());
            $(this).parent().parent().next().children().toggle('slow');
        });
});