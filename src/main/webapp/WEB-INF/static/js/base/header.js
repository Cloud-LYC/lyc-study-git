
//init
$(function() {

    switchTenant();

});

function switchTenant() {

    var data = {};

    //layer.load(1);
    $.ajax({
        url: "/tenant/list/ajax",
        async: true, //异步请求
        dataType: "json",
        type: "POST",
        //contentType:"application/json",
        data: data,
        success: function (data) {
            if (data.code == 200) {
                var result = [];
                var originUrl = window.location.origin + window.location.pathname;
                $.each(data.data, function (id, name) {
                    result.push("<a href='"+ originUrl +"?tenantId=" + id + "' class='dropdown-item'><div class='small mb-1'>" + name + "</div></a>");
                });
                $("#tenantlist").append(result.join(""));
            } else {
                $("#tenantlist").append("<a href='#' class='dropdown-item'><div class='small mb-1'>" + data.message + "</div></a>");
            }

        },
        complete: function () {
            //layer.closeAll();
            return;
        }
    });
}

function validateString(value){
    if(value == undefined || value == null || value == ''){
        return false;
    }else{
        return true;
    }
}

function validateInt(value){
    if(value == undefined || value == null || value == 0){
        return false;
    }else{
        return true;
    }
}

