$(document).ready(function() {
    $("#addnewimg").click(function(e) {

        document.getElementById("addHeadShot").innerHTML = ' <input type="file" name="headshotImg" id="headshotImg" multiple="multiple">  <button type="submit" class="btn btn-primary">新增大頭貼</button>'


    });
});