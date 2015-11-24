package demo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AppController {

    @RequestMapping(value="/app/test", method= RequestMethod.GET)
    public String index() {
        return "app/test";
    }

    @RequestMapping(value = "/app/hello")
    @ResponseBody
    public Object hello() {

        return "hello world!";
    }
}
