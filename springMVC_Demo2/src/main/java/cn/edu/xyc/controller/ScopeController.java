package cn.edu.xyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("name","我是ServletAPI");
        return "success";
    }

    @RequestMapping("/testRequestByModelAndView")
    public ModelAndView testRequestByModelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","我是ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testRequestByModel")
    public String testRequestByModel(Model model){
        model.addAttribute("name","我是Model");
        return "success";
    }

    @RequestMapping("/testRequestByMap")
    public String testRequestByMap(Map<String,Object> map){
        map.put("name","我是map");
        return "success";
    }

    @RequestMapping("/testRequestByMouelMap")
    public String testRequestByMouelMap(ModelMap modelMap){
        modelMap.addAttribute("name","我是ModelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("nameSession","我是Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("nameApplication","我是Application");
        return "success";
    }
}
