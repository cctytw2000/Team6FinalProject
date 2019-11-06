document.addEventListener("DOMContentLoaded", function() {
    for (let i = 1; i <= 3; i++) {
        document.getElementById(i).addEventListener("click", chengeInfo)
    }

});

let page = 1
let data;

function loginInfo(id) {

    url = "member/" + id + ".json"
    $.ajax({
        type: "GET",
        url: url,
        success: function(response) {
            data = response
            showInfo(data);

        }
    });

}

function showInfo(response) {
    page = page * 10 - 1
    document.getElementById("infoBody").innerHTML = ""
    let info = "";
    for (let i = page - 9; i < page; i++) {

        info += "<tr>"
        info += "<td>" + data.infoList[i].clientIP + "</td>"
        info += "<td>" + data.infoList[i].type + "</td>"
        info += "<td>" + data.infoList[i].loginTime.replace(".0", "") +
            "</td>"
        info += "<td>" + data.infoList[i].accountType + "</td>"
        info += "<td>" + data.infoList[i].isSuccess + "</td>"
        info += "</tr>"
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