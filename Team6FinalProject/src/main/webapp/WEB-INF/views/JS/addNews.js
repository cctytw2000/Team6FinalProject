function GoBack() {
		history.go(-1)
	}
// 製造newsType下拉式選單
$(document).ready(function() {	
	$.ajax({
		type : "POST",
		url : "searchNewsTypeByAjax",
		dataType : "json",
		success : function(data) {
			const newsTypeIdList = Object.values(data).map(item => item.newsTypeId);
			const newsTypenameList = Object.values(data).map(item => item.newsTypeName);
// alert(data.length);
// alert(NewsTypeIdList);
// alert(NewsTypenameList);
// for(var i=0;i<NewsTypeIdList.length;i++){
// var id = NewsTypeIdList[i];
// alert(id)
// }
			 var html = "<select name='newsType'>";
			 html += "<option value='-1'>請挑選</option>";
			 for(var i=0;i<data.length;i++){ 
		            var id = newsTypeIdList[i]; 
		            var name = newsTypenameList[i]; 
		            html +="<option value="+ id +">"+name+"</option>";
		          }
			 html += "</select>";
			 $("#newsType").html(html);
		}
	});
})
// 製造game下拉式選單
$(document).ready(function() {
    $('input[type=radio][name=showGame]').change(function() {
    	var status=this.value;
    	if(status == 1){
    		$.ajax({
    			type : "POST",
    			url : "searchGameByAjax",
    			dataType : "json",
    			success : function(data) {
    				const gameIdList = Object.values(data).map(item => item.gameId);
    				const gameNameList = Object.values(data).map(item => item.gameName);
// alert(data.length);
// alert(gameIdList);
// alert(gameNameList);
    				var html = "遊戲:<span><select name='game' onchange='gameDetail(this.value)'>";
    				html += "<option value='-1'>請挑選</option>";
    				for(var i=0;i<data.length;i++){
    					var id = gameIdList[i];
    					var name = gameNameList[i];
    					html +="<option value="+ id +">"+name+"</option>";
    				}
    				html += "</select></span";
    				$("#showGame1").show();
    				$("#showGame1").html(html);
    			}
    		});
    	} else if(status == 0){
    		var html1="";
        	$("#showGame1").html(html1);
        	$("#showGame2").html(html1);
    	}
            
    });
});

// 產生gameDetail
function gameDetail(number){
	if(number == -1){
		var html1 ="";
		$("#showGame3").html(html1);
	}
	$.ajax({
		type : "POST",
		url : "searchGameByAjax1",
		dataType : "json",
		data : {
			gameId : number,
		},
		success : function(data) {
			var html ='<table id="showGame3"border=2 RULES=ALL><tr><th>遊戲名稱</th><th>遊戲類別</th><th>遊戲發售日</th><th>遊戲發行商</th><th>遊戲平台</th></tr><tbody><tr>';
			html +="<td>"+data.name+"</td>";
			html +="<td>"+data.gameTypeName+"</td>";
			html +="<td>"+data.publicationDate+"</td>";
			html +="<td>"+data.publisher+"</td>";
			html +="<td>"+data.platform+"</td>";
			html += '</tr></tbody></table>'	
			$("#showGame2").html(html);
		}
	});
}

// 製造activity下拉式選單
$(document).ready(function() {
    $('input[type=radio][name=showActivity]').change(function() {
    	var status=this.value;
    	if(status == 1){
    		$.ajax({
    			type : "POST",
    			url : "searchActivityByAjax",
    			dataType : "json",
    			success : function(data) {
    				const activityIdList = Object.values(data).map(item => item.activityId);
    				const activityNameList = Object.values(data).map(item => item.activityName);
// alert(data.length);
// alert(activityIdList);
// alert(activityNameList);
    				var html = "活動:<span><select name='activity' onchange='activityDetail(this.value)'>";
    				html += "<option value='-1'>請挑選</option>";
    				for(var i=0;i<data.length;i++){
    					var id = activityIdList[i];
    					var name = activityNameList[i];
    					html +="<option value="+ id +">"+name+"</option>";
    				}
    				html += "</select></span";
    				$("#showActivity1").show();
    				$("#showActivity1").html(html);
    			}
    		});
    	} else if(status == 0){
    		var html1="";
    		$("#showActivity1").html(html1);
    		$("#showActivity2").html(html1);
    	}
            
    });
})

//產生activityDetail
function activityDetail(number) {
	if(number == -1){
		var html1 ="";
		$("#showActivity3").html(html1);
	}
	$.ajax({
		type : "POST",
		url : "searchActivityByAjax1",
		dataType : "json",
		data : {
			activityId : number,
		},
		success : function(data) {
			var html1="";
			if(!(data.startingDate_time == null) && !(data.startingTime_date == null)){
				var html ='<table id="showActivity3" border=2 RULES=ALL><tr><th>活動名稱</th><th>活動類別</th><th>活動地點</th><th>活動日期</th><th>活動時間</th></tr><tbody><tr>';
				html +="<td>"+data.name+"</td>";
				html +="<td>"+data.activityTypeName+"</td>";
				html +="<td>"+data.location+"</td>";
				html +="<td>"+data.startingDate_time+"</td>";
				html +="<td>"+data.startingTime_date+"</td>";
				html += '</tr></tbody></table>'	
				$("#showActivity2").html(html);
			} else if(!(data.startingDate == null) && !(data.endingDate == null)){
				var html ='<table id="showActivity3" border=2 RULES=ALL><tr><th>活動名稱</th><th>活動類別</th><th>活動地點</th><th>活動起始日</th><th>活動結束日</th></tr><tbody><tr>';
				html +="<td>"+data.name+"</td>";
				html +="<td>"+data.activityTypeName+"</td>";
				html +="<td>"+data.location+"</td>";
				html +="<td>"+data.startingDate+"</td>";
				html +="<td>"+data.endingDate+"</td>";
				html += '</tr></tbody></table>'	
				$("#showActivity2").html(html);
			}
		}
	});
}