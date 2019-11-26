$(document).ready(function () {
    $("input#order_id").blur(checkorder);
    membersales();
});

function checkorder() {
    $("tbody#orderInfo1").html("");
    $("span#err_msg1").html("");
    let orderdata = $("input#order_id").val();
    if (!orderdata == "") {
        let re = /^\+?[1-9][0-9]*$/;
        if (re.test(orderdata)) {
            let falge = false;
			for (let i = 0; i < orders.length; i++) {
				if (orderdata == orders[i]) {
					falge = true;
				}
			}
			if (falge) {
                showOrderInfo1(orderdata);
			} else {
				$("span#err_msg1").html("<img src='Images/noway.jpg'>無此訂單編號");
			}           
        }
        else {
            $("span#err_msg1").html("<img src='Images/noway.jpg'>請輸入訂單編號(非零正整數)");
        }
    }
    else {
        $("span#err_msg1").html("<img src='Images/noway.jpg'>請輸入訂單編號");
    }
}
function showOrderInfo1(orderid) {
    $.ajax({
        url: "order/" + orderid + ".json",
        success: function (response) {
            console.log(response);
            let info = "";
            info += "<tr>";
            info += '<td><a class="card-link" data-toggle="collapse" href="#oo' + response.order.order_id + '">' + response.order.order_id + '</a></td>';
            info += '<td><a href="member?id=' + response.order.member.member_id
                + '">' + response.order.member.username + '</a></td>';
            info += "<td>" + response.order.member.account + "</td>";
            info += "<td>" + response.order.ordertime.replace(".0", "") + "</td>";
            info += "<td>" + response.order.total + "元</td>";

            switch (response.order.state) {
                case 1:
                    info += "<td style='color:red'>未付款</td>";
                    info += "<td><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#mwin' onclick='deleteOrders(" + response.order.order_id + ")'>取消</button></td>";
                    break;
                case 4:
                    info += "<td style='color:green'>已付款</td>";
                    info += "<td></td>";
                    break;
            }
            info += "</tr>";
            info += "<tr><td colspan='7'>";
            info += "<div id='oo" + response.order.order_id + "' class='collapse show' data-parent='#accordion1'>";
            info += "<div class='card-body'>";
            info += "<table style='text-align: center; width: 100%'>";
            info += "<tr><th>商品編號</th><th>商品名稱</th><th>數量</th><th>金額</th></tr>";
            info += "<tbody id='ooitem" + response.order.order_id + "'></tbody>";
            info += "</table>";
            info += "</div>";
            info += "</div>";
            info += "</td></tr>";
            $("tbody#orderInfo1").html(info);
            orderDeail_1(response.order.order_id);
        }
    });
}
function orderDeail_1(orderid) {
	$.ajax({
		url: "orderDeail/" + orderid + ".json",
		success: function (response) {
			console.log(response);
			if (response.orderDeail.length > 0) {
				let info = "";
				for (let i = 0; i < response.orderDeail.length; i++) {
					info += "<tr>";
					info += "<td>" + response.orderDeail[i].product.game_id + "</td>";
					info += "<td>" + response.orderDeail[i].product.name + "</td>";
					info += "<td>" + response.orderDeail[i].count + "個</td>";
					info += "<td>" + response.orderDeail[i].subtotal + "元</td>";
					info += "</tr>";
				}
				$("tbody#ooitem" + orderid).html(info);
			}
			else {
				$("tbody#ooitem" + orderid).html("<tr><td colspan='4'>沒訂單詳細資料</td></tr>");
			}
		}
	});
}
function membersales() {
	$.ajax({
		url: "memberSales.json",
		success: function (response) {
			//console.log(response);
			console.log(response.membersales);
			let date = [];
			let count = [];
			for (let i = 0; i < response.membersales.length; i++) {
				date.push(response.membersales[i][0]);
				count.push(response.membersales[i][1]);
			}
			console.log(date);
			console.log(count);
			showorderCount2(date, count);
		}
	});
}
function showorderCount2(date, count) {
	var ctx = document.getElementById("chart2").getContext('2d');
	var chart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: date,
			datasets: [{
				label: '消費金額(元)',
				data: count,				
				backgroundColor: 'blue',
				borderColor: 'black',
				borderWidth: 1
			}]
		}
	});
}