package cn.edu.xyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }
    //转发
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }
    //重定向
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
