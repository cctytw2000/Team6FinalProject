function movieHomeDelete(movieId) {
	
//	var movieId = "#movieId";
	alert(movieId.get);
//	document.getElementById("deleteMovieId").value="movieId";
	var deleteMovieId = movieId;
//	alert (deleteMovieId);
	document.getElementById("deleteMovieIdCheck").value=deleteMovieId;
//	return movieId;
}

function movieHomeUpdate(movieId,movieName) {
	var updateMovieId = movieId;
	var updateMovieName = movieName;
//	alert (updateMovieId);
//	alert (updateMovieName);
	document.getElementById("updateMovieId").value=updateMovieId;
	document.getElementById("updateMovieName").value=updateMovieName;
}

function movieHomeSetIndex(movieId){
	alert (movieId);
	$.ajax({
		type : "POST",
		url : "homeSetIndex",
		data : {
			movieId : movieId
		},

		success : function(response) {
			
			document.getElementById(movieId).setAttribute("onclick", "");
			document.getElementById(movieId).setAttribute("type","hidden");
		}
	});
}