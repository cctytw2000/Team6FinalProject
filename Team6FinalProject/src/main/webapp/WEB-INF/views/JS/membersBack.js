function openActive(id, type) {
	$.ajax({
		type : "POST",
		url : "member/changeActive",
		data : {
			id : id,
			type : type,
			action : "open"
		},

		success : function(response) {
			// alert(response)
			// window.location.reload()
			$.ajax({
				url : "membersBack.json",
				success : function(response) {
					console.log(response)
					showMemberInfo(response)
				}
			});
		}
	});
}

function closeActive(id, type) {
	$.ajax({
		type : "POST",
		url : "member/changeActive",
		data : {
			id : id,
			type : type,
			action : "close"
		},

		success : function(response) {
			// alert(response)
			// window.location.reload()
			$.ajax({
				url : "membersBack.json",
				success : function(response) {
					console.log(response)
					showMemberInfo(response)
				}
			});
		}
	});
}

$(document).ready(function() {
	$.ajax({
		url : "membersBack.json",
		success : function(response) {
			console.log(response)
			showMemberInfo(response)
		}
	});
});

function showMemberInfo(response) {

	let info = "";
	for (let i = 0; i < response.Memners.length; i++) {
		info += "<tr>"
		info += '<td><a href="member?id=' + response.Memners[i].member_id
				+ '">' + response.Memners[i].member_id + '</a></td>'
		info += "<td>" + response.Memners[i].account + "</td>"
		info += "<td>" + response.Memners[i].type + "</td>"
		info += "<td>" + response.Memners[i].username + "</td>"
		info += "<td>" + response.Memners[i].registeredtime.replace(".0", "")
				+ "</td>"

		if (response.Memners[i].isactive == 0) {
			info += '<td style="color: red">' + '封鎖' + "</td>"
			info += '<td><button onclick="openActive(' + "'"
					+ response.Memners[i].member_id + "','"
					+ response.Memners[i].type + "'"
					+ ')" type="button">開通</button></td>'

		} else {
			info += '<td style="color: green">' + '開啟' + "</td>"
			info += '<td><button onclick="closeActive(' + "'"
					+ response.Memners[i].member_id + "','"
					+ response.Memners[i].type + "'"
					+ ')" type="button">封鎖</button></td>'
		}
		info += "</tr>"
	}
	document.getElementById("memberInfo").innerHTML = info

}

$(document).ready(function() {
	let date = []
	let count = []
	$.ajax({
		type : "method",
		url : "memberLoginCount.json",

		success : function(response) {

			date=Object.keys(response.memberLoginCount[0])

		
			console.log(response.memberLoginCount.length)
			for (let i = 0; i < date.length; i++) {
	
				count.push(response.memberLoginCount[0][date[i]])
			}
			console.log(date)
			console.log(count)
			showLoginTimeCount(date,count)
		}
	});
});


		function showLoginTimeCount (date , count)  {
			var ctx = document.getElementById("chart").getContext('2d');
			var chart = new Chart(ctx, {
				type : 'bar',
				data : {
					labels : date,
					datasets : [ {
						label : '每日登入帳號人數',
						data : count,
						backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(255, 206, 86, 0.2)',
								'rgba(75, 192, 192, 0.2)',
								'rgba(153, 102, 255, 0.2)',
								'rgba(255, 159, 64, 0.2)' ],
						borderColor : [ 'rgba(255,99,132,1)',
								'rgba(54, 162, 235, 1)',
								'rgba(255, 206, 86, 1)',
								'rgba(75, 192, 192, 1)',
								'rgba(153, 102, 255, 1)',
								'rgba(255, 159, 64, 1)' ],
						borderWidth : 1
					} ]
				}
			});
		}
