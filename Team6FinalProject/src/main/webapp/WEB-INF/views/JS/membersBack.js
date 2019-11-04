function openActive(id, type) {
	$.ajax({
		type : "POST",
		url : "member/changeActive",
		data : {
			id : id,
			type : type,
			action:"open"
		},

		success : function(response) {
			alert(response)
			window.location.reload()
		}
	});
}

function closeActive(id, type) {
	$.ajax({
		type : "POST",
		url : "member/changeActive",
		data : {
			id : id,
			type : type,
			action:"close"
		},

		success : function(response) {
			alert(response)
			window.location.reload()
		}
	});
}