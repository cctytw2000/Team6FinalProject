//顯示換行及空格
$(document).ready(function() {
			var content = $('#article').text();
//			alert(content)
			$('#article').html((content.replace(/\n/g, '<br/>')).replace(/\s/g,"&nbsp;"));
})

$(document).ready(function() {
			var id = $('#gameId').text();
			var publicationDate = $('#gamePublicationDate').text();
//			console.log("id="+id)
//			xxx.text().length如果該行沒加</p>且是空值一行長度為5
//			console.log("id.length="+id.length) 
//			console.log("publicationDate="+publicationDate)
//			console.log("publicationDate.length="+publicationDate.length)
			if(id.length != 0){
				if(publicationDate.length == 6){
					$("#gamePublicationDate").text("遊戲發售日:尚無確切發行日期");
				}
				$("#gameDetail").show();
			}			
})

$(document).ready(function() {
			var html ="";
			var id = $('#activityId').text();
			var startingDate_time = $('#startingDate_time').text();
			var startingTime_date = $('#startingTime_date').text();
//			console.log("startingTime_date="+startingTime_date)//活動時間:00:00:00
			var startingDate = $('#startingDate').text();
			var endingDate = $('#endingDate').text();
			if(id.length != 0){
				if(startingDate_time.length == 5){
					$("#startingDate_time").html(html);
				}
				if(startingTime_date == "活動時間:00:00:00"){
					$("#startingTime_date").html(html);
				}
				if(startingDate.length == 6){
					$("#startingDate").html(html);
				}
				if(endingDate.length == 6){
					$("#endingDate").html(html);
				}
				$("#activityDetail").show();
			}			
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

