let data, pagebotNO;
$(document).ready(function () {
	$.ajax({
		url: "ordersBack.json",
		success: function (response) {
			console.log(response);
			data = response;
			if (response.Orders.length > 0) {
				pagebot(response);
				$("div#totalspan").html("共" + response.Orders.length + "筆訂單");				
			}
			else {
				$("tbody#ordersInfo").html("沒訂單資料");
			}
		}
	});
	ordermember();
});
// function showOrdersInfoall(response) {
// 	let info = "";
// 	for (let i = 0; i < response.Orders.length; i++) {
// 		info += "<tr>";
// 		info += '<td><a href="order/?order_id=' + response.Orders[i].order_id
// 			+ '">' + response.Orders[i].order_id + '</a></td>';
// 		info += '<td><a href="member?id=' + response.Orders[i].member.member_id
// 			+ '">' + response.Orders[i].member.username + '</a></td>';
// 		info += "<td>" + response.Orders[i].member.account + "</td>";
// 		info += "<td>" + response.Orders[i].ordertime.replace(".0", "") + "</td>";
// 		info += "<td>" + response.Orders[i].total + "元</td>";

// 		switch (response.Orders[i].state) {
// 			case 1:
// 				info += "<td style='color:red'>未付款</td>";
// 				info += "<td><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#mwin' onclick='deleteOrders(" + response.Orders[i].order_id + ")'>取消</button></td>";
// 				break;
// 			case 4:
// 				info += "<td>已付款</td>";
// 				info += "<td></td>";
// 				break;
// 		}
// 		info += "</tr>";
// 	}
// 	$("tbody#ordersInfo").html(info);
// }
function deleteOrders(orderId) {
	//alert(orderId);	
	$("div#mheader").html(
		'<h5 class="modal-title" id="exampleModalLabel">取消訂單</h5>'
		+ '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
		+ '<span>&times;</span>'
		+ '</button>');
	$("div#mbody").html(
		'<form method="post" action="./orderBack/delete">'
		+ "<div>確定取消訂單(" + orderId + ")?</div><p>"
		+ '<input type="hidden" name="order_id" value='
		+ orderId
		+ ' /><p>'
		+ '<input type="submit" class="btn btn-warning" value="確認取消"></form>');
}
function pagebot(response) {
	let pagebottom = "";
	pagebottom += '<li class="page-item" id="previous"><a class="page-link" href="#">Previous</a></li>'
	console.log(response.Orders.length);
	console.log(parseInt(response.Orders.length / 10) + 1);

	for (let i = 1; i <= parseInt(response.Orders.length / 10) + 1; i++) {
		pagebottom += '<li class="page-item" id="' + i + '"><a class="page-link" href="#">' + i
			+ '</a></li>';
	}
	pagebottom += '<li class="page-item" id="next"><a class="page-link" href="#">Next</a></li>'
	$("ul#pageBottom").html(pagebottom);

	document.getElementById("previous").addEventListener("click", previousChenge);
	for (let i = 1; i <= parseInt(response.Orders.length / 10) + 1; i++) {
		document.getElementById(i).addEventListener("click", chengeOrdersInfo);
	}
	document.getElementById("next").addEventListener("click", nextChenge);

	pagebotNO = 1;
	showOrdersInfo(response, pagebotNO);
}
function showOrdersInfo(response, pageNo) {
	let info = "";
	let item = 10;
	for (let i = (pageNo - 1) * item; i < response.Orders.length; i++) {
		info += "<tr>";
		info += '<td><a href="order/?order_id=' + response.Orders[i].order_id
			+ '">' + response.Orders[i].order_id + '</a></td>';
		info += '<td><a href="member?id=' + response.Orders[i].member.member_id
			+ '">' + response.Orders[i].member.username + '</a></td>';
		info += "<td>" + response.Orders[i].member.account + "</td>";
		info += "<td>" + response.Orders[i].ordertime.replace(".0", "") + "</td>";
		info += "<td>" + response.Orders[i].total + "元</td>";

		switch (response.Orders[i].state) {
			case 1:
				info += "<td style='color:red'>未付款</td>";
				info += "<td><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#mwin' onclick='deleteOrders(" + response.Orders[i].order_id + ")'>取消</button></td>";
				break;
			case 4:
				info += "<td>已付款</td>";
				info += "<td></td>";
				break;
		}
		info += "</tr>";
		if (i == pageNo * item - 1) {
			break;
		}
	}
	$("tbody#ordersInfo").html(info);
	document.getElementById("previous").removeEventListener("click", previousChenge);
	if (pagebotNO == 1) {
		$("li#previous").attr("class", "page-item disabled");
	} else {
		$("li#previous").attr("class", "page-item");
		document.getElementById("previous").addEventListener("click", previousChenge);
	}
	document.getElementById("next").removeEventListener("click", nextChenge);
	if (pagebotNO == parseInt(response.Orders.length / 10) + 1) {
		$("li#next").attr("class", "page-item disabled");
	} else {
		$("li#next").attr("class", "page-item");
		document.getElementById("next").addEventListener("click", nextChenge);
	}
}

function chengeOrdersInfo() {
	pagebotNO = this.id;
	showOrdersInfo(data, this.id);
}
function previousChenge() {
	pagebotNO--;
	showOrdersInfo(data, pagebotNO);
}
function nextChenge() {
	pagebotNO++;
	showOrdersInfo(data, pagebotNO);
}

function ordermember() {	
	$.ajax({
		url: "memberOrdercount.json",
		success: function (response) {
			console.log(response);
			console.log(response.countlist);
			let date = [];
			let count = [];
			for (let i = 0; i < response.countlist.length; i++) {				
				date.push(response.countlist[i].name);
				count.push(response.countlist[i].count);
			}	
			console.log(date);
			console.log(count);	
			showorderCount(date, count);	
		}
	});
}
function showorderCount(date, count) {
	var ctx = document.getElementById("chart").getContext('2d');
	var chart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: date,
			datasets: [{
				label: '訂單數量',
				data: count,
				backgroundColor: 'blue',
				borderColor: 'brack',
				borderWidth: 1
			}]
		}
	});
}