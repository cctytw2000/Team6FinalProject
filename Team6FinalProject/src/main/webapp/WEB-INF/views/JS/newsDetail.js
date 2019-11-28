//顯示換行及空格
//$(document).ready(function() {
//	showMemoForNews();
//	var content = $('#article').text();
//	// alert(content)
//	$('#article').html((content.replace(/\n/g, '<br/>')).replace(/\s/g,"&nbsp;"));
//})

// 若無輸入遊戲發售日則顯示尚無確切發行日期
$(document).ready(function() {
	var id = $('#gameId').text();
	var publicationDate = $('#gamePublicationDate').text();
	// console.log("id="+id)
	// xxx.text().length如果該行沒加</p>且是空值一行長度為5
	// console.log("id.length="+id.length)
	// console.log("publicationDate="+publicationDate)
	// console.log("publicationDate.length="+publicationDate.length)
	if (id.length != 0) {
		if (publicationDate.length == 6) {
			$("#gamePublicationDate").text("遊戲發售日:尚無確切發行日期");
		}
		$("#gameDetail").show();
		$("#hr").show();
	}
	showMemoForNews()
})

// 依不同的活動日數顯示時間
$(document).ready(function() {
	var html = "";
	var id = $('#activityId').text();
	var startingDate_time = $('#startingDate_time').text();
	var startingTime_date = $('#startingTime_date').text();
	// console.log("startingTime_date="+startingTime_date)//活動時間:00:00:00
	var startingDate = $('#startingDate').text();
	var endingDate = $('#endingDate').text();
	if (id.length != 0) {
		if (startingDate_time.length == 5) {
			$("#startingDate_time").html(html);
			$("#startingDate_time").hide();
		}
		if (startingTime_date == "活動時間:00:00:00") {
			$("#startingTime_date").html(html);
			$("#startingTime_date").hide();
		}
		if (startingDate.length == 6) {
			$("#startingDate").html(html);
			$("#startingDate").hide();
		}
		if (endingDate.length == 6) {
			$("#endingDate").html(html);
			$("#endingDate").hide();
		}
		$("#activityDetail").show();
		$("#hr").show();
	}
})

// 點入消息的計次功能
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

//顯示評論
function showMemoForNews(){
	let showComment = "";
	let member_id = $("#member_id").val();
	let newsId = $('#newsId').val();
	$.ajax({
		url : "showMemoForNews.json",
		success : function(response) {
//			alert("成功");
			for(let i = 0; i < response.newsList.length; i++){
				if(!(typeof response.newsList[i].messages === "undefined")){
					for(let t = 0; t< response.newsList[i].messages.length; t++){
						//依messageId重新排序
						response.newsList[i].messages = response.newsList[i].messages.sort(function (a, b) {
							 return a.messageId > b.messageId ? 1 : -1;
							});
						if(!(typeof response.newsList[i].messages[t] === "undefined") && response.newsList[i].newsId == newsId ){
							console.log(response.newsList[i].messages[t]);
							showComment += '<div class="card" style="width:500px;clear: left;">';
							showComment += '<div class="card-body"  style="font-family: Microsoft JhengHei">';
							showComment += '<span style="font-size:20px;float:left">'+ response.newsList[i].messages[t].member.username +'  :</span>';
							showComment += '<span id="'+ response.newsList[i].messages[t].messageId +'" style="margin-left:10px;float:left;padding-top:4px">'+ response.newsList[i].messages[t].memo +'</span>';
							showComment += '<small style="margin-left:5%;float:left;padding-top:5px">'+ response.newsList[i].messages[t].publicationDate.replace(".0","")+'</small>';
							if(member_id == response.newsList[i].messages[t].member.member_id){
								showComment += '<button class="btn btn-warning btn-sm" style="float:right"><i onclick=\''+'editMessage('+'"'+ response.newsList[i].messages[t].messageId +'"'+','+'"'+response.newsList[i].messages[t].memo+'"'+')\''+'>編輯</i></button>';
							}
							showComment += '</div></div>';
						}
					}
				}
			}
			$("#memoForNews").html(showComment);
		},
	});
}

//新增評論
function addMemo() {
	let showComment = "";
	let newsId = $('#newsId').val();
	let member_id = $("#member_id").val();
	let memo = $("#addMemo").val();
	console.log("newsId=" + newsId);
	console.log("member_id=" + member_id);
	console.log("memo=" + memo);
	if (member_id == "") {
		alert("請先登入!!!!!")
	} else {
		$.ajax({
			type : "POST",
			url : "addMemo",
			dataType : "json",
			data : {
				newsId : newsId,
				member_id : member_id,
				memo : memo
			},
			success : function(response) {
				showMemoForNews();
				$("#addMemo").val("");
			}
		});
	}
}

//顯示修改評論欄位
function editMessage(messageId, memo){
	let info = "";
	info += '<form class="input-group">';
	info += '<input type="hidden" name="messageId" value="' + messageId
			+ '"></input>';
	info += '<input class="form-control" style="width: 200px;" type="text" name="memo" value="' + memo
			+ '"></input>';
	info += '<p><span class="input-group-btn"><button type="button" class="btn btn-warning btn-sm" style="width:80px; margin-left:5px" onclick="editMessage2('+messageId+')">送出</button></span></p>';
	info += '</form>';
	$("#"+messageId).html(info);
}


//修改評論
function editMessage2(messageId){
//	alert("messageId="+messageId);
	let editMemo = $("input[name='memo']").val();
//	alert("editMemo="+editMemo);
	$.ajax({
		type : "POST",
		url : "editMessage2",
		dataType : "json",
		data : {
			messageId : messageId,
			memo : editMemo
		},
		success : function(response) {
			showMemoForNews()
		}
	});
}