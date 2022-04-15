package cn.edu.xyc.controller;

import cn.edu.xyc.bean.Employee;
import cn.edu.xyc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getEmployees (Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "employeeInformation";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String delEmployee (@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmoloyee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getUpdateById(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
