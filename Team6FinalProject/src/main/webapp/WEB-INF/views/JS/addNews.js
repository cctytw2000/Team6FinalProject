function GoBack() {
		history.go(-1)
	}
	// 	依照使用者選取的新聞類別來顯示遊戲或活動細節
	function PickGOrA() {
		var e = document.getElementById("pickGOrA");
		var gOrA = e.options[e.selectedIndex].value;
		var g = document.getElementById("game");
		var a = document.getElementById("activity");
		if (gOrA == 1) {
			g.style.display = "block";
			a.style.display = "none";
		} else if (gOrA == 2) {
			g.style.display = "none";
			a.style.display = "block";
		} else {
			g.style.display = "none";
			a.style.display = "none";
		}
		//避免活動或是遊戲id同時送出
		if (gOrA == 1) {
			document.getElementById("activitySelect").selectedIndex = 0;
			$("#activityDetail").hide();
		} else
			(gOrA == 2)
		{
			document.getElementById("gameSelect").selectedIndex = 0;
			$("#gameDetail").hide();
		}

	}

	//用ajax取回gameDetail
	function gameDetail(number) {
		//避免表格跳出
		if (number == -1) {
			$("#gameDetail").hide();
			return false;
		}
		$.ajax({
			type : "POST",
			url : "searchGameByAjax",
			dataType : "json",
			data : {
				gameId : number,
			},
			success : function(data) {
				$("#gameDetail").show();
				var gameName = data.name;
				$("#gameName").html(gameName);
				var gamepublicationDate = data.publicationDate;
				$("#gamepublicationDate").html(gamepublicationDate);
				var gamepublisher = data.publisher;
				$("#gamepublisher").html(gamepublisher);
				var gameplatform = data.platform;
				$("#gameplatform").html(gameplatform);

			}
		});
	}

	//用ajax取回activityDetail
	function activityDetail(number) {
		//避免表格跳出
		if (number == -1) {
			$("#activityDetail").hide();
			return false;
		}
		$.ajax({
			type : "POST",
			url : "searchActivityByAjax",
			dataType : "json",
			data : {
				activityId : number,
			},
			success : function(data) {
				$("#activityDetail").show();

				var activityName = data.name;
				$("#activityName").html(activityName);

				var activityLocation = data.location;
				$("#activityLocation").html(activityLocation);

				var activityStartingDate_time = data.startingDate_time;
				if (activityStartingDate_time == null) {
					$("#activityStartingDate_time1").hide();
				} else {
					$("#activityStartingDate_time1").show();
					$("#activityStartingDate_time").html(
							activityStartingDate_time);
				}

				var activityStartingTime_date = data.startingTime_date;
				if (activityStartingTime_date == null) {
					$("#activityStartingTime_date1").hide();
				} else {
					$("#activityStartingTime_date1").show();
					$("#activityStartingTime_date").html(
							activityStartingTime_date);
				}

				var activityStartingDate = data.startingDate;
				if (activityStartingDate == null) {
					$("#activityStartingDate1").hide();
				} else {
					$("#activityStartingDate1").show();
					$("#activityStartingDate").html(activityStartingDate);
				}

				var activityEndingDate = data.endingDate;
				if (activityEndingDate == null) {
					$("#activityEndingDate1").hide();
				} else {
					$("#activityEndingDate1").show();
					$("#activityEndingDate").html(activityEndingDate);
				}
			}
		});
	}