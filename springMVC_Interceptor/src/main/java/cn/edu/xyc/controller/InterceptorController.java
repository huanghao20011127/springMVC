package cn.edu.xyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @RequestMapping("/testException")
    public String testException(){
        int a = 1/0;
        return "success";
    }
}
