var room = 1;
function education_fields() {

    room++;
    var objTo = document.getElementById('education_fields')
    var divtest = document.createElement("div");
	divtest.setAttribute("class", "form-group removeclass"+room);
	var rdiv = 'removeclass'+room;
    divtest.innerHTML = '<div class="col-sm-3 nopadding"><div class="form-group"> ' + $('.to-copy').html() + '</div></div><div class="col-sm-3 nopadding"><div class="form-group"><div class="input-group"> <input type="text" class="form-control" id="skilllevel" name="skilllevel[]" value="" placeholder="Skill Level"><div class="input-group-btn"> <button class="btn btn-danger" type="button" onclick="remove_education_fields('+ room +');"> <span class="glyphicon glyphicon-minus" aria-hidden="true"></span> </button></div></div></div></div><div class="clear"></div>';

    objTo.appendChild(divtest)
}
   function remove_education_fields(rid) {
	   $('.removeclass'+rid).remove();
   }


function addSkill() {

    room++;
    var objTo = document.getElementById('education_fields')
    var divtest = document.createElement("div");
  divtest.setAttribute("class", "form-group removeclass"+room);
  var rdiv = 'removeclass'+room;
    divtest.innerHTML = '<div class="form-group"> ' + $('.skills-to-copy').html() + '</div><div class="form-group"><div class="input-group"> <input type="text" class="form-control" id="skilllevel" name="skilllevel[]" value="" placeholder="Skill Level"><div class="input-group-btn"> <button class="btn btn-danger" type="button" onclick="remove_education_fields('+ room +');"> <span class="glyphicon glyphicon-minus" aria-hidden="true"></span> </button></div></div></div>';

    objTo.appendChild(divtest)
}
   function removeAddSkillfields(rid) {
     $('.removeclass'+rid).remove();
   }