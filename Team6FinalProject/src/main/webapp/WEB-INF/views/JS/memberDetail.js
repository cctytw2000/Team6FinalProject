let open = 0
function openUpdate() {
	if (open == 0) {
		document.getElementById("nickname").innerHTML = "<label>暱稱：</label> <br><input type='text'"
				+ "name='nickname' placeholder='來個新名字吧(ゝ∀･)'"
				+ "value='${MemberDetial.memberdetail.nickname}'></input> <br><input type='submit' value='更新'> <button id='update'"
				+ "type='button' onclick='openUpdate()'>編輯</button>"
		open = 1
	} else {
		document.getElementById("nickname").innerHTML = "<label>暱稱：</label> <br><input style='border-width: 0; background-color: white' type='text'"
				+ "name='nickname' placeholder='來個新名字吧(ゝ∀･)' disabled='disabled' readonly='readonly'"
				+ "value='${MemberDetial.memberdetail.nickname}'></input> <button id='update'"
				+ "type='button' onclick='openUpdate()'>取消</button>"
		open = 0
	}

}

function headshot(id) {
	let chenge = ""
	chenge += '<input name="memberId" type="hidden" value="' + id + '"/>'
	chenge += '<input id="memberimg" name="memberimg" type="file" onchange="readURL(this)"/> <input type="submit" />'
	document.getElementById("Changeheadshot").innerHTML = chenge

}


function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#preview_progressbarTW_img").attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}