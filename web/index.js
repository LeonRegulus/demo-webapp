$(document).ready(function() {

    $("#testAjax").click(function() {
        $.ajax({
            url: "http://localhost:8080/appserver/app/hello",
            type: "GET",
            dataType: "jsonp",
            jsonp: "callback",
            success: function(result) {
                console.info(result);
                alert(result);
            }
        });
    });

});