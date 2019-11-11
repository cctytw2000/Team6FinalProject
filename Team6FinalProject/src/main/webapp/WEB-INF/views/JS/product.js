
function update(id, comment, game_id) {
	let info = "";
	info += '<form action="/Team6FinalProject/edditComment">'
	info += '<input type="hidden" name="game_id" value="' + game_id
			+ '"></input>'
	info += '<input type="hidden" name="comment_id" value="' + id
			+ '"></input>'
	info += '<input class="form-control" style="width: 200px;float:left" type="text" name="comment" value="' + comment
			+ '"></input>'
	info += '<input class="btn btn-success" type="submit" value="送出"></input></form>'
		
	document.getElementById(id).innerHTML = info

}
