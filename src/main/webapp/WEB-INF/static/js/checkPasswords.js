$(function () {

    $('#password, #con-password').on('keyup', function () {
        $('#passwordError').css('display', 'block');
        if($('#password').val().length > 0) {
            if ($('#password').val() == $('#con-password').val() && ($('#password').val().length > 5)) {
                $('#passwordError').html(' The passwords match').css('color', 'green');
                $('#sendButton').attr('disabled', false);
            }
            else if ($('#password').val().length < 5){
                $('#passwordError').html('The password should be at least 5 characters long').css('color', 'red');
                $('#sendButton').attr('disabled', true);
            }
            else {
                $('#passwordError').html('The passwords do not match').css('color', 'red');
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