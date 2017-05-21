package by.training.nc.dev5.unit3.controller;

import by.training.nc.dev5.unit3.dto.EmployeeDTO;
import by.training.nc.dev5.unit3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Andrei Tishkovski
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getEmployees(ModelMap model){
        model.addAttribute("employees", employeeService.getEmployee());
        return "employees";
    }

}
