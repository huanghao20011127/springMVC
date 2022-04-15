package cn.edu.xyc.controller;

import cn.edu.xyc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "index删除Pull";
    }

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }

    @RequestMapping("/success/{id}/{username}")
    public String success(@PathVariable("id") String id,@PathVariable("username") String username){
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }

//    //使用字符串方式接收参数
//    @RequestMapping("/testPath")
//    public String testPath(String username,String password,String hobby){
//        System.out.println("name:" + username + ",password:" + password + ",hobby:" + hobby);
//        return "success";
//    }
//    //使用数组的方式接收参数
//    @RequestMapping("/testPath")
//    public String testPath(String username,String password,String[] hobby){
//        System.out.println("name:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));
//        return "success";
//    }


/*    @RequestParam是将请求参数和控制器方法的形参创建映射关系

    @RequestParam注解一共有三个属性：

    value：指定为形参赋值的请求参数的参数名

    required：设置是否必须传输此请求参数，默认值为true

    若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null

    defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值

*/
    @RequestMapping("/testPath")
    public String testPath(@RequestParam(value = "user_name",required = false,defaultValue = "hehe") String username,
                           String password,
                           String[] hobby,
                           @RequestHeader("Host") String host
    ){
        System.out.println("name:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println("Host:" + host);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testpojo(User user){
        System.out.println(user);
        return "success";
    }
}
