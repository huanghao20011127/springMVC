package cn.edu.xyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    //查询
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUsers(){
        return "success";
    }
    //通过用户id查询
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") String id){
        System.out.println("id = " + id);
        return "success";
    }
    //添加用户信息
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(String username,String password){
        System.out.println("name = " + username + ",password = " + password);
        return "success";
    }
    //修改用户信息
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String alterUser(String username,String password){
        System.out.println("name = " + username + ",password = " + password);
        return "success";
    }
}
