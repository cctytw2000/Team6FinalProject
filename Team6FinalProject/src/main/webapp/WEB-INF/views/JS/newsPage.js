$(document).ready(function() {
	$.ajax({
		url : "searchNewsByAjax.json",
		success : function(data) {
//			console.log(data)
			var html = "";
			for (var i = 0; i < data.newsList.length; i++) {
				if (data.newsList[i].isVisable == true) {
					if((data.newsList[i].views) == null){
						data.newsList[i].views=0;
					}
					html += "<thead><tr><th colspan='2'>";
					html += (data.newsList[i].publicationDate).split(' ')[0];
					html += "</tr></thead><tbody><tr>";
					html += "<td style='text-align: center;'>";
					html += "<a onclick='countView("+data.newsList[i].newsId+")' href='newsDetail?newsId="+ data.newsList[i].newsId +"'><img width='200' height='200' src='getNewsPicture/"+ data.newsList[i].newsId+ "'></a>";
					html += "<td><a onclick='countView("+data.newsList[i].newsId+")' href='newsDetail?newsId="+ data.newsList[i].newsId +"'>"+ data.newsList[i].title+ "</a>";
					html += "<p>觀看人數:" + data.newsList[i].views + "</p>"
					html += "<p>"+ (data.newsList[i].article).substr(0, 100);
					html += " ...<a onclick='countView("+data.newsList[i].newsId+")' href='newsDetail?newsId="+ data.newsList[i].newsId +"'>繼續閱讀</a></p>";
					html += "</tr></tbody>";
				}
			}
			$("#newsOrderByTime").html(html);
		}
	});
})

function countView(newsId){
	$.ajax({
		type : "POST",
		url : "countForNews",
		dataType : "json",
		data : {
			count : 1,
			newsId : newsId
		},
		success : function() {
//			alert("成功")
		},
	});
}


