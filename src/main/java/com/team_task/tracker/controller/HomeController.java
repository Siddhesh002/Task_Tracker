package com.team_task.tracker.controller;

import com.team_task.tracker.entity.Employee;
import com.team_task.tracker.entity.Task;
import com.team_task.tracker.service.employee.EmployeeService;
import com.team_task.tracker.service.task.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private EmployeeService employeeService;
    private TaskService taskService;

    public HomeController(EmployeeService employeeService, TaskService taskService) {
        this.employeeService = employeeService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String showEmployeeHome(Model model) {
//        return "home";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {

            String userName = authentication.getName();
            Employee user = employeeService.findByUsername(userName);
            List<Task> tasks = null;

            if(user != null) {
                model.addAttribute("user", user);
                tasks =  taskService.findByUserId(user.getId());
            }

            if(tasks != null) {
                model.addAttribute("tasks", tasks);
            }

            if (authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_EMPLOYEE"))) {
                return "home";
            } else if (authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_MANAGER"))) {
                return "manager-home";
            } else if (authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
                return "admin";
            }
        }

        // Default to home page if no matching role found
        return "home";
    }
}
