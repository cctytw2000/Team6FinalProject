$(document).ready(function() {
	
	for(let i = 0 ; i<3;i++){
		var article1 = $("#"+i).text();
		$("#"+i).text(article1.substr(0, 30))
	}

})

function countView(newsId) {
	$.ajax({
		type : "POST",
		url : "countForNews",
		dataType : "json",
		data : {
			count : 1,
			newsId : newsId
		},
		success : function() {
			// alert("成功")
		},
	});
}