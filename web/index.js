$(document).ready(function() {

    initJQueryAjaxErrorHandler();

    $("#testjson").click(function() {
        $.ajax({
            url: "http://localhost:8780/appserver/json/hello",
            type: "POST",
            data: {name : "Leon"},
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
            url: "http://localhost:8780/appserver/jsonp/hello",

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
    // 跨域的异步请求没有X-Requested-With的Header信息。手动添加，用以登录校验同步还是异步时使用。
    $(document).ajaxSend(function(event, jqxhr, options) {
        jqxhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
        console.info(jqxhr);
    });

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