let page = 1
let data;

function loginInfo(id) {
	let pagebottom = "";
	url = "member/" + id + ".json"
	$
			.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					pagebottom += '<li class="page-item"><a class="page-link" href="#">Previous</a></li>'
					console.log(response.infoList.length)
					console.log(response.infoList.length / 10)

					for (let i = 1; i <= response.infoList.length / 10 + 1; i++) {
						pagebottom += '<li class="page-item"><a id="' + i
								+ '" class="page-link" href="#">' + i
								+ '</a></li>'
					}
					pagebottom += '<li class="page-item"><a class="page-link" href="#">Next</a></li>'

					document.getElementById("pageBottom").innerHTML = pagebottom

					data = response
					for (let i = 1; i <= response.infoList.length / 10 + 1; i++) {
						document.getElementById(i).addEventListener("click",
								chengeInfo)
					}

					showInfo(data);

				}
			});

}

function showInfo(response) {
	page = page * 10 - 1
	document.getElementById("infoBody").innerHTML = ""
	let info = "";
	for (let i = page - 9; i < page; i++) {

		if (i < data.infoList.length) {
			info += "<tr>"
			info += "<td>" + data.infoList[i].clientIP + "</td>"
			info += "<td>" + data.infoList[i].type + "</td>"
			info += "<td>" + data.infoList[i].loginTime.replace(".0", "")
					+ "</td>"
			info += "<td>" + data.infoList[i].accountType + "</td>"
			if (data.infoList[i].isSuccess == 1) {
				info += "<td style='color:green'>" + "成功" + "</td>"
			} else {
				info += "<td style='color:red'>" + "失敗" + "</td>"

			}

			info += "</tr>"
		} else {
			break
		}
	}
	document.getElementById("infoBody").innerHTML = info
}

function chengeInfo() {
	page = this.id * 10 - 1
	document.getElementById("infoBody").innerHTML = ""
	let info = "";
	for (let i = page - 9; i < page; i++) {
		if (i < data.infoList.length) {
			info += "<tr>"
			info += "<td>" + data.infoList[i].clientIP + "</td>"
			info += "<td>" + data.infoList[i].type + "</td>"
			info += "<td>" + data.infoList[i].loginTime.replace(".0", "")
					+ "</td>"
			info += "<td>" + data.infoList[i].accountType + "</td>"
			if (data.infoList[i].isSuccess == 1) {
				info += "<td style='color:green'>" + "成功" + "</td>"
			} else {
				info += "<td style='color:red'>" + "失敗" + "</td>"

			}
			info += "</tr>"
		} else {
			break
		}

	}
	document.getElementById("infoBody").innerHTML = info

}


/* <select name="YourLocation">
　<option value="Taipei">台北</option>
　<option value="Taoyuan">桃園</option>
　<option value="Hsinchu">新竹</option>
　<option value="Miaoli">苗栗</option>
　...
</select> */




function  openUpdate() {
	let opention = ""
	$.ajax({
		url: "memberLevel.json",
		success: function (response) {
			console.log(response)
			opention += '<td>會員身分</td>'
			opention += '<select name="levelChange">'
			for(let i = 0 ; i< response.levelList.length ; i++){
				opention += '<option value="'+response.levelList[i].levelId+'">'+response.levelList[i].levelName+'</option>'
			}
			opention += '</select>'+"<input type='submit' value='變更'>"		
			document.getElementById("level").innerHTML = opention
		}

	});
//	document.getElementById("level").innerHTML = '\
//	<td>會員身分</td>\
//	<td><input type="text" value="${member.memberlevel.levelName}"></td>'
}

