package com.team_task.tracker.controller;

import com.team_task.tracker.entity.Employee;
import com.team_task.tracker.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "admin-employee-list";
    }

    @PostMapping("/showFormForEmployeeUpdate")
    public String showFormForEmployeeUpdate(@RequestParam(value = "employeeId",defaultValue = "-1") int employeeId, Model model) {

        Employee theEmployee;

        if(employeeId == -1)
            theEmployee = new Employee();
        else
            theEmployee = employeeService.findEmployeeById(employeeId);

        List<Employee> managers= employeeService.findEmployeesByRoleName("ROLE_MANAGER");

        model.addAttribute("employee", theEmployee);
        model.addAttribute("managers", managers);

        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/employee-list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/admin/employee-list";

    }
}
