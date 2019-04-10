$('#password, #con-password').on('keyup', function () {
    if ($('#password').val() == $('#con-password').val()) {
        $('#conPassword').html('Hasła pasują').css('color', 'green');
    } else
        $('#conPassword').html('Hasłą nie pasują do siebie').css('color', 'red');
});