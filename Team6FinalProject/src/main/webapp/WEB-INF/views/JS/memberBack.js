let page = 1
let data;

function loginInfo(id) {
    let pagebottom = "";
    url = "member/" + id + ".json"
    $.ajax({
        type: "GET",
        url: url,
        success: function(response) {
            pagebottom += '<li class="page-item"><a class="page-link" href="#">Previous</a></li>'
            console.log(response.infoList.length)
            console.log(response.infoList.length / 10)


            for (let i = 1; i <= response.infoList.length / 10 + 1; i++) {
                pagebottom += '<li class="page-item"><a id="' + i + '" class="page-link" href="#">' + i + '</a></li>'
            }
            pagebottom += '<li class="page-item"><a class="page-link" href="#">Next</a></li>'

            document.getElementById("pageBottom").innerHTML = pagebottom

            data = response
            for (let i = 1; i <= response.infoList.length / 10 + 1; i++) {
                document.getElementById(i).addEventListener("click", chengeInfo)
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
            info += "<td>" + data.infoList[i].loginTime.replace(".0", "") +
                "</td>"
            info += "<td>" + data.infoList[i].accountType + "</td>"
            info += "<td>" + data.infoList[i].isSuccess + "</td>"
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
            info += "<td>" + data.infoList[i].loginTime.replace(".0", "") +
                "</td>"
            info += "<td>" + data.infoList[i].accountType + "</td>"
            info += "<td>" + data.infoList[i].isSuccess + "</td>"
            info += "</tr>"
        } else {
            break
        }

    }
    document.getElementById("infoBody").innerHTML = info

}