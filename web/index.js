$(document).ready(function() {

    initJQueryAjaxErrorHandler();

    $("#testjson").click(function() {
        $.ajax({
            url: "http://localhost:8080/appserver/json/hello",
            type: "GET",
            success: function(result) {
                console.info("success");
                console.info(result);
                alert(result);
            },
            error: function(result) {
                console.info("error");
                console.info(result);
            }
        });
    });

    $("#testjsonp").click(function() {
        $.ajax({
            url: "http://localhost:8080/appserver/jsonp/hello",
            type: "GET",
            success: function(result) {
                console.info("success");
                console.info(result);
                alert(result);
            },
            error: function(result) {
                console.info("error");
                console.info(result);
            }
        });
    });

});

/**
 * 设定jquery异步的错误统一捕获逻辑
 */
function initJQueryAjaxErrorHandler() {
    $(document).ajaxError(function(event, jqxhr, options, ex) {
        // 弹出统一的异常提示框
        switch (jqxhr.status) {
            case 400:
                if (jqxhr.responseJSON) {
                    console.info(jqxhr.responseJSON);
                } else {
                    console.info("400");
                }
                break;
            case 401:
                console.info("401");
                break;
            case 404:
                console.info("404");
                break;
            default:
                if (jqxhr.responseJSON) {
                    console.info(jqxhr.responseJSON);
                } else if (jqxhr.responseText) {
                    console.info(jqxhr.responseText);
                }
                break;
        }
    });
}