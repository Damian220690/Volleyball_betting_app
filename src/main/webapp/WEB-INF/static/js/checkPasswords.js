$(function () {

    $('#password, #con-password').on('keyup', function () {
        $('#passwordError').css('display', 'block');
        if($('#password').val().length > 0) {
            if ($('#password').val() == $('#con-password').val() && ($('#password').val().length > 5)) {
                $('#passwordError').html('Hasła pasują').css('color', 'green');
                $('#sendButton').attr('disabled', false);
            }
            else if ($('#password').val().length < 5){
                $('#passwordError').html('Hasło powinno składać się z conajmniej 5 znaków').css('color', 'red');
                $('#sendButton').attr('disabled', true);
            }
            else {
                $('#passwordError').html('Hasłą nie pasują do siebie').css('color', 'red');
                $('#sendButton').attr('disabled', true);
            }
        }
    });


        $(".genderSelector").click(function () {
        var label = $('label[for='+  this.id  +']');

        label.addClass("selectedBtn")
            .siblings('.btn').removeClass("selectedBtn");
    });
});