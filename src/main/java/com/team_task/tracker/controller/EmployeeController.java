package com.team_task.tracker.controller;

import com.team_task.tracker.entity.Task;
import com.team_task.tracker.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    TaskService taskService;

    @Autowired
    public EmployeeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/requestTaskCompletion")
    public String requestTaskCompletion(@RequestParam("taskId") Integer id, @RequestParam("newNote") String newNote) {

        Task theTask = taskService.findById(id);

        if (theTask == null)
            throw  new RuntimeException("Task not found of taskId : " + id);

        theTask.setStatus("COMPLETION_REQUESTED");
        theTask.setLatestNote(newNote);

        taskService.save(theTask);

        return "redirect:/";
    }

}
