package com.team_task.tracker.controller;

import com.team_task.tracker.entity.Employee;
import com.team_task.tracker.entity.Task;
import com.team_task.tracker.service.employee.EmployeeService;
import com.team_task.tracker.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    TaskService taskService;
    EmployeeService employeeService;

    @Autowired
    public ManageController(TaskService taskService, EmployeeService employeeService) {
        this.taskService = taskService;
        this.employeeService = employeeService;
    }

    @GetMapping("/task-list/{id}")
    public String showManagerTaskList(Model model, @PathVariable Integer id) {

        List<Task> tasks = taskService.findByManagerId(id);
        model.addAttribute("tasks", tasks);
        model.addAttribute("managerId", id);
        return "manager-task-list";
    }

    @PostMapping("/processTaskCompletionRequest")
    public String processTaskCompletionRequest(@RequestParam("taskId") Integer id, @RequestParam("newNote") String newNote,@RequestParam("managerId") int managerId, @RequestParam("action") String action) {

        Task theTask = taskService.findById(id);

        if (theTask == null)
            throw  new RuntimeException("Task not found of taskId : " + id);

        if(action.equals("accept"))
            theTask.setStatus("COMPLETED");
        else
            theTask.setStatus("IN_PROGRESS");

        theTask.setLatestNote(newNote);

        taskService.save(theTask);

        return "redirect:/manage/task-list/"+managerId;
    }

    @PostMapping("/showFormForTaskUpdate")
    public String showFormForUpdate(@RequestParam(value = "taskId",defaultValue = "-1") int theId, Model theModel, @RequestParam("managerId") int managerId) {

        Task theTask;

        if(theId == -1)
            theTask = new Task();
        else
            theTask = taskService.findById(theId);

        theModel.addAttribute("task", theTask);
        theModel.addAttribute("managerId", managerId);

        List<Employee> employees = employeeService.findEmployeesByManagerId(managerId);

        theModel.addAttribute("employees", employees);

        return "task-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("task") Task theTask, @RequestParam("managerId") int managerId) {

        // save the employee
        taskService.save(theTask);

        // use a redirect to prevent duplicate submissions
        return "redirect:/manage/task-list/"+managerId;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("taskId") int theId,@RequestParam("managerId") int managerId) {

        taskService.deleteById(theId);

        return "redirect:/manage/task-list/"+managerId;
    }


}
