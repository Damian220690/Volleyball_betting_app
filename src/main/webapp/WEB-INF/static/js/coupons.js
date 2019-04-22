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

    $('input[type=\'radio\']').on('change', function(e) {
        $(location).attr('href',"http://localhost:8080/coupon/add/"+this.value);
    });
});