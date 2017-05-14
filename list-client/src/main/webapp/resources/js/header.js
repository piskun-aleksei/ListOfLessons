$(document).ready(function () {

    $('#scheduleButton').click(function () {
        $("#scheduleForm").submit();
    });

    $('#scheduleButton').attr('disabled', true);

    $('#userGroup').keyup(function () {
        var reg = /^\d+$/;
        var value = $(this).val();
        if (value.length == 6 && reg.test(value)) {
            $('#scheduleButton').attr('disabled', false);
        } else {
            $('#scheduleButton').attr('disabled', true);
        }
    });

});
