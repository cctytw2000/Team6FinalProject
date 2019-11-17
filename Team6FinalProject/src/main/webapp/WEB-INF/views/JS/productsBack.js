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



