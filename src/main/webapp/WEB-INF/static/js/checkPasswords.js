$(function () {

    $('#password, #con-password').on('keyup', function () {
        if($('#password').val().length > 0) {
            if ($('#password').val() == $('#con-password').val()) {
                $('#conPassword').html('Hasła pasują').css('color', 'green');
            } else
                $('#conPassword').html('Hasłą nie pasują do siebie').css('color', 'red');
        }
    });


    $(".genderSelector").click(function () {
        var label = $('label[for='+  this.id  +']');

        label.addClass("selectedBtn")
            .siblings('.btn').removeClass("selectedBtn");
    });
});