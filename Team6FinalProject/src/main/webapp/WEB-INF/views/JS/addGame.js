$(function() {
	$("#datepicker").datepicker({
		changeMonth : true,
		changeYear : true
	});
});

function GoBack() {
	history.go(-1)
}

$(document).ready(function() {
	$("#button").click(function() {
		if ($("#gameType_").val() == "-1") {
			alert("你尚未選取遊戲類別");
			$("#gameType_").focus().css("background-color", "#FFF673");
		} else if ($("#gameName").val().replace(/\s+/g, "").length ==0 || $("#gameName").val() == "" ) {
			alert("你尚未填寫遊戲名稱");
			$("#gameName").focus().css("background-color", "#FFF673");
		} else if ($("#publisher").val().replace(/\s+/g, "").length ==0 || $("#publisher").val() == "") {
			alert("你尚未填寫發行商名稱");
			$("#publisher").focus().css("background-color", "#FFF673");
		} else if ($("#platform").val().replace(/\s+/g, "").length ==0 ||$("#platform").val() == "") {
			alert("你尚未填寫發行平台");
			$("#platform").focus().css("background-color", "#FFF673");
		} else {
			$("#game").submit();
		}
	})
})