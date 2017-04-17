

function call() {
  var msg   = $('#extended').serialize();
  $.ajax({
    type: 'GET',
    url: '/employee/search/people',
    data: msg,
    success: function(data) {
      var found = $('.to-replace', data);
         $(".to-replace").replaceWith($(found));
    },
    error:  function(xhr, str){
      alert('Error: ' + xhr.responseCode);
    }
  });

}