// 傳消息類別更新資訊:
function updateNewsType(newsTypeId, newsTypeName) {
	// alert(newsTypeId)
	// alert(newsTypeName)
	var a = newsTypeId;
	var b = newsTypeName;
	document.getElementById("xxx").innerHTML = '<h5 class="modal-title" id="exampleModalLabel">更新消息類別</h5>'
			+ '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
			+ '<span>&times;</span>' + '</button>'
	document.getElementById("xxx1").innerHTML = '<form method="POST" action="updateNewsType">'
			+ '<input type="hidden" name="newsTypeId" value='
			+ a
			+ ' />'
			+ '<p>'
			+ '消息類別名稱:'
			+ '<input name="newsTypeName" type="text" size="50px" value='
			+ b
			+ ' />'
			+ '<p>'
			+ '<input type="submit" class="btn btn-warning" value="更新">	'
			+ '</form>'
}

// 傳消息類別刪除資訊:
function deleteNewsType(newsTypeId) {
//	alert(newsTypeId)
	var a = newsTypeId;
	document.getElementById("xxx").innerHTML = 
		'<h5 class="modal-title" id="exampleModalLabel">刪除消息類別</h5>'
		+ '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
		+ '<span>&times;</span>'
		+  '</button>'
	document.getElementById("xxx1").innerHTML = 
		'<form method="post" action="deleteNewsType">'
		+ '<input type="hidden" name="newsTypeId" value='
		+ a
		+ ' />'
		+ '<p>'
		+ '<input type="submit" class="btn btn-warning" value="確認刪除">	'
		+ '</form>'
}

//傳消息類別更新資訊:
function updateGameType(gmaeTypeId, gmaeTypeName) {
	// alert(gmaeTypeId)
	// alert(gmaeTypeName)
	var a = gmaeTypeId;
	var b = gmaeTypeName;
	document.getElementById("xxx").innerHTML = '<h5 class="modal-title" id="exampleModalLabel">更新遊戲類別</h5>'
			+ '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
			+ '<span>&times;</span>' + '</button>'
	document.getElementById("xxx1").innerHTML = '<form method="POST" action="updateGameType">'
			+ '<input type="hidden" name="gameTypeId" value='
			+ a
			+ ' />'
			+ '<p>'
			+ '遊戲類別名稱:'
			+ '<input name="gmaeTypeName" type="text" size="50px" value='
			+ b
			+ ' />'
			+ '<p>'
			+ '<input type="submit" class="btn btn-warning" value="更新">	'
			+ '</form>'
}

// 傳消息類別刪除資訊:
function deleteGameType(gmaeTypeId) {
//	alert(gmaeTypeId)
	var a = gmaeTypeId;
	document.getElementById("xxx").innerHTML = 
		'<h5 class="modal-title" id="exampleModalLabel">刪除遊戲類別</h5>'
		+ '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
		+ '<span>&times;</span>'
		+  '</button>'
	document.getElementById("xxx1").innerHTML = 
		'<form method="post" action="deleteGameType">'
		+ '<input type="hidden" name="gameTypeId" value='
		+ a
		+ ' />'
		+ '<p>'
		+ '<input type="submit" class="btn btn-warning" value="確認刪除">	'
		+ '</form>'
}