var windowHeight = $(window).height();
$("#projectsContainer").css("height", windowHeight);
$("#aboutContainer").css("height", windowHeight);
function showTab(id){
	$("#" + id).show();
	$("#" + id + "Container").show();
	if(id == "projects"){
		$("#aboutme").hide();
		$("#aboutContainer").hide();
	} else if (id == "about"){
		$("#projects").hide();
		$("#projectsContainer").hide();
	}
}
function hideTab(id){
	$("#" + id + "Container").hide();
	$("#" + id).hide();
}