function openActive(id, type) {
	$.ajax({
		type: "POST",
		url: "member/changeActive",
		data: {
			id: id,
			type: type,
			action: "open"
		},

		success: function (response) {
			alert(response)
			window.location.reload()
		}
	});
}

function closeActive(id, type) {
	$.ajax({
		type: "POST",
		url: "member/changeActive",
		data: {
			id: id,
			type: type,
			action: "close"
		},

		success: function (response) {
			alert(response)
			window.location.reload()
		}
	});
}

$(document).ready(function () {
	$.ajax({
		url: "membersBack.json",
		success: function (response) {
			console.log(response)
			showMemberInfo(response)
		}
	});
});

function showMemberInfo(response) {

	let info = "";
	for (let i = 0; i < response.Memners.length; i++) {
		info += "<tr>"
		info += '<td><a href="member?id=' + response.Memners[i].member_id + '">' + response.Memners[i].member_id + '</a></td>'
		info += "<td>" + response.Memners[i].account + "</td>"
		info += "<td>" + response.Memners[i].type + "</td>"
		info += "<td>" + response.Memners[i].username + "</td>"
		info += "<td>" + response.Memners[i].registeredtime.replace(".0", "") + "</td>"

		if (response.Memners[i].isactive == 0) {
			info += '<td style="color: red">' + '封鎖' + "</td>"
			info += '<td><button onclick="openActive(' +"'"+ response.Memners[i].member_id + "','" + response.Memners[i].type + "'" + ')" type="button">開通</button></td>'


		} else {
			info += '<td style="color: green">' + '開啟' + "</td>"
			info += '<td><button onclick="closeActive('+"'" + response.Memners[i].member_id + "','" + response.Memners[i].type + "'" + ')" type="button">封鎖</button></td>'
		}
		info += "</tr>"
	}
	document.getElementById("memberInfo").innerHTML = info

}

