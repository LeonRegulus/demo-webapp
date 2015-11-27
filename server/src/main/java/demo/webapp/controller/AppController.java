package demo.webapp.controller;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class AppController {

    @RequestMapping(value="/app/test", method= RequestMethod.GET)
    public String index() {
        return "app/test";
    }

    @RequestMapping(value = "/json/hello")
    @ResponseBody
    public Object hello(HttpServletRequest request,
                        @RequestParam(value = "name", required = false) String name) {

        String result = "Hello ";

        if (name != null && !name.isEmpty()) {
            result += name;
        } else {
            result += "World!";
        }

        return result;
    }

    @RequestMapping(value = "/jsonp/hello")
    @ResponseBody
    public JSONPObject newsList(HttpServletRequest request) throws IOException {

        return new JSONPObject("callback", "hello world!");
    }
}
