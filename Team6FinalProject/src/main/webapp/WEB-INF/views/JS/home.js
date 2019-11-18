$(document).ready(function() {
	var article = $(".test").text();
	console.log(article)
	console.log(article.substr(0, 30))
	$(".test").text(article.substr(0, 30));
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