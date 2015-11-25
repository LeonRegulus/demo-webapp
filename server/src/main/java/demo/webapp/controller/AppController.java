package demo.webapp.controller;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class AppController {

    @RequestMapping(value="/app/test", method= RequestMethod.GET)
    public String index() {
        return "app/test";
    }

    @RequestMapping(value = "/app/hello")
    @ResponseBody
    public Object hello(HttpServletRequest request) {

        return "hello world!";
    }

    @RequestMapping(value = "/jsonp/hello")
    @ResponseBody
    public JSONPObject newsList(HttpServletRequest request) throws IOException {

        return new JSONPObject("callback", "hello world!");
    }
}
