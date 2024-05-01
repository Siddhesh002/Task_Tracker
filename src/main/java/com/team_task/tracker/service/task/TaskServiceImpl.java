package com.team_task.tracker.service.task;

import com.team_task.tracker.dao.TaskRepository;
import com.team_task.tracker.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findByUserId(Integer userId) {
        return taskRepository.findTasksByAssigneeId(userId);
    }

    @Override
    public List<Task> findByManagerId(Integer managerId) {
        return taskRepository.findTasksByManagerId(managerId);
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Task task) {
        taskRepository .save(task);
    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

}
