package com.team_task.tracker.controller;

import com.team_task.tracker.entity.Task;
import com.team_task.tracker.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    TaskService taskService;

    @Autowired
    public ManageController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task-list/{id}")
    public String showManagerTaskList(Model model, @PathVariable Integer id) {

        List<Task> tasks = taskService.findByManagerId(id);
        model.addAttribute("tasks", tasks);
        return "manager-task-list";
    }

    

}
