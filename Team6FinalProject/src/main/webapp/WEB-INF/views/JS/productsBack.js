$(document).ready(function () {

	// document.getElementById("productInfo").innerHTML = ""
	// document.getElementById("cancelProduct").innerHTML = ""




	let productOnInfo = ""
	let productOffInfo = ""
	$.ajax({
		url: "productsBackjson.json",

		success: function (response) {
			for (let i = 0; i < response.ProductJson.length; i++) {
				console.log(response.ProductJson[i].game_id);
				console.log(response.ProductJson[i].name);
				console.log(response.ProductJson[i].price);
				console.log(response.ProductJson[i].category.category);
				if (response.ProductJson[i].is_remove == "0") {
					productOnInfo += "<tr>"
					productOnInfo += "<td>" + response.ProductJson[i].game_id + "</td>"
					productOnInfo += '<td><a href="productsBack/productBack?game_id=' + response.ProductJson[i].game_id + '">' + response.ProductJson[i].name + '</a>'

					productOnInfo += "<td>" + response.ProductJson[i].price + "元</td>"
					productOnInfo += "<td>" + response.ProductJson[i].category.category + "</td>"
					productOnInfo += '<td><button type="button" class="btn btn-warning" onclick="offProduct (' + response.ProductJson[i].game_id + ')">下架</button>'
					productOnInfo += "</tr>"
				} else {
					productOffInfo += "<tr>"
					productOffInfo += "<td>" + response.ProductJson[i].game_id + "</td>"
					productOffInfo += '<td><a href="productsBack/productBack?game_id=' + response.ProductJson[i].game_id + '">' + response.ProductJson[i].name + '</a>'

					productOffInfo += "<td>" + response.ProductJson[i].price + "元</td>"
					productOffInfo += "<td>" + response.ProductJson[i].category.category + "</td>"
					productOffInfo += '<td><button type="button" class="btn btn-warning" onclick="onProduct (' + response.ProductJson[i].game_id + ')">上架</button>'
					productOffInfo += "</tr>"

				}


				document.getElementById("productInfo").innerHTML = productOnInfo
				document.getElementById("cancelProduct").innerHTML = productOffInfo
			}
		}
	});
});

function onProduct(id) {

	$.ajax({

		url: 'productsBack/products/reAdd?game_id=' + id,

		success: function (response) {

			showData()
		}
	});




}

function offProduct(id) {


	$.ajax({

		url: 'productsBack/products/delete?game_id=' + id,

		success: function (response) {
			showData()
		}
	});

}



function showData() {
	// document.getElementById("productInfo").innerHTML = ""
	// document.getElementById("cancelProduct").innerHTML = ""




	let productOnInfo = ""
	let productOffInfo = ""
	$.ajax({
		url: "productsBackjson.json",

		success: function (response) {
			for (let i = 0; i < response.ProductJson.length; i++) {
				console.log(response.ProductJson[i].game_id);
				console.log(response.ProductJson[i].name);
				console.log(response.ProductJson[i].price);
				console.log(response.ProductJson[i].category.category);
				if (response.ProductJson[i].is_remove == "0") {
					productOnInfo += "<tr>"
					productOnInfo += "<td>" + response.ProductJson[i].game_id + "</td>"
					productOnInfo += '<td><a href="productsBack/productBack?game_id=' + response.ProductJson[i].game_id + '">' + response.ProductJson[i].name + '</a>'

					productOnInfo += "<td>" + response.ProductJson[i].price + "元</td>"
					productOnInfo += "<td>" + response.ProductJson[i].category.category + "</td>"
					productOnInfo += '<td><button type="button" class="btn btn-warning" onclick="offProduct (' + response.ProductJson[i].game_id + ')">下架</button>'
					productOnInfo += "</tr>"
				} else {
					productOffInfo += "<tr>"
					productOffInfo += "<td>" + response.ProductJson[i].game_id + "</td>"
					productOffInfo += '<td><a href="productsBack/productBack?game_id=' + response.ProductJson[i].game_id + '">' + response.ProductJson[i].name + '</a>'

					productOffInfo += "<td>" + response.ProductJson[i].price + "元</td>"
					productOffInfo += "<td>" + response.ProductJson[i].category.category + "</td>"
					productOffInfo += '<td><button type="button" class="btn btn-warning" onclick="onProduct (' + response.ProductJson[i].game_id + ')">上架</button>'
					productOffInfo += "</tr>"

				}


				document.getElementById("productInfo").innerHTML = productOnInfo
				document.getElementById("cancelProduct").innerHTML = productOffInfo
			}
		}
	});
}






















$(document).ready(function () {
	let game = []
	let count = []
	let key = document.getElementsByName('key')
	let value = document.getElementsByName('value')
	// console.log(key)
	// console.log(value)

	for (let i = 0; i < key.length; i++) {
		game.push(key[i].value)
		count.push(value[i].value)
	}

	showdata(game, count)

});

function showdata(game, count) {

	var ctx = document.getElementById("chart").getContext('2d');
	var chart = new Chart(ctx, {
		type: 'pie',
		data: {
			labels: game,
			datasets: [{
				label: '商品購買人數',
				data: count,
				backgroundColor: [
					'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)'
				],
				borderColor: [
					'rgba(255,99,132,1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)'
				],
				borderWidth: 1
			}]
		}
	});
}



function add(){
	document.getElementById('addname').value = "《大富翁 10》中文版（數位下載版）";
	document.getElementById('addpublisher').value = "大宇資訊";
	document.getElementById('addprice').value = "399";
	document.getElementById('addstock').value = "10";
	var desc = ""
	desc += "《大富翁 10》採用回合制，初始所有玩家有一定的存款、現金、卡片。"
	desc += "通過投骰子決定移動步數。踩中無主的地產可以購買，踩中敵人的地產需要交過路費。除了地產格，地圖中還有銀行、新聞、商店、魔法屋等事件格，使遊戲充滿變數，富有娛樂性。"
	desc += "合理的利用手中的卡片可以主動干預隨機性，增強策略性，使自己的利益最大化，為最終的勝利打下良好的基礎。"
	desc += "而除了傳統的玩法，《大富翁　10》加入了最新熱鬥玩法。地圖中取消了小型地產格，大多數地圖格都是獲取卡片的格子，玩家通過大量拾取、使用卡片，給敵人造成金錢傷害，使之破產，最終獲得勝利。"
		document.getElementById('adddesc').value=desc
}

