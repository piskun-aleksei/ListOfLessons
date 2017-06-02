$(document).ready(function() {
    //$('#datatable').dataTable();

    //$("[data-toggle=tooltip]").tooltip();

    $('#addMarkButton').attr('disabled', true);

        $('#studentMark').keyup(function () {
            var reg = new RegExp("[0-9]{1}|10");
            var value = $(this).val();
            if (reg.test(value)) {
                $('#addMarkButton').attr('disabled', false);
            } else {
                $('#addMarkButton').attr('disabled', true);
            }
        });

} );


function getValues(el) {
    var studentId = el.parentNode.parentNode.cells[0].getAttribute("value");
    var scheduleId = el.parentNode.getAttribute("value");
    $("#studentId").val(studentId);
    $("#scheduleId").val(scheduleId);
}

