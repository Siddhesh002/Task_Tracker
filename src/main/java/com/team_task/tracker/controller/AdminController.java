package com.team_task.tracker.controller;

import com.team_task.tracker.entity.Employee;
import com.team_task.tracker.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    EmployeeService employeeService;

    @Autowired
    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-list")
    public String showAllEmployees(Model model) {

        List<Employee> employees= employeeService.findAll();

        model.addAttribute("employees", employees);
//
//        System.out.println(employees);
        return "admin-employee-list";
    }
}
