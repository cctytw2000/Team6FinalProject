/**
 * 
 * function updateviews(id) {
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
 */

function movieHomeDelete(movieId) {
	
//	var movieId = "#movieId";
//	alert(movieId.get);
//	document.getElementById("deleteMovieId").value="movieId";
	var deleteMovieId = movieId;
//	alert (deleteMovieId);
	document.getElementById("deleteMovieIdCheck").value=deleteMovieId;
//	return movieId;
}

function movieHomeUpdate(movieId,movieName) {
	var updateMovieId = movieId;
	var updateMovieName = movieName;
	alert (updateMovieId);
	alert (updateMovieName);
	document.getElementById("updateMovieId").value=updateMovieId;
	document.getElementById("updateMovieName").value=updateMovieName;
}