function updateviews(id) {
	$.ajax({
		type : "POST",
		url : "updateMoviesViews",
		data : {
			movieId : id
		},

		success : function(response) {
			document.getElementById(id).setAttribute("onclick", "")
		}
	});
}

function deleteMemberMovie(id) {
	x = confirm("是否要刪除您辛辛苦苦上傳的影片?")
	if (x) {

	} else {
		return;
	}

	$.ajax({

		url : "../moviepersonal/deleteMovie?movie_ID=" + id,

		success : function(response) {
			location.reload();
		}
	});
}