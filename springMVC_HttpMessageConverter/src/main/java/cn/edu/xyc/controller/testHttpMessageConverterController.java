package cn.edu.xyc.controller;

import cn.edu.xyc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class testHttpMessageConverterController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        HttpHeaders headers = requestEntity.getHeaders();
        String body = requestEntity.getBody();
        System.out.println("headers:" + headers);
        System.out.println("body:" + body);
        return "success";
    }

    @RequestMapping("/testResponseByServletAPI")
    public void testResponseByServletAPI(HttpServletResponse response) throws IOException {
        response.getWriter().print("helloWorld!!!");
    }

    @RequestMapping("/testResponseByResponseBody")
    @ResponseBody
    public String testResponseByResponseBody(){
        return "helloWorld!!!";
    }

    @RequestMapping("/testResponseJson")
    @ResponseBody
    public User testResponseJson(){
        return new User(1,"张三","123456");
    }

    @RequestMapping("/testResponseAjax")
    @ResponseBody
    public String testResponseAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "helloWorld!!!";
    }
}
