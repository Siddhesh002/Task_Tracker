package com.team_task.tracker.service.task;

import com.team_task.tracker.entity.Task;

import java.util.List;

public interface TaskService {

   List<Task> findByUserId(Integer userId);

   List<Task> findByManagerId(Integer managerId);

   Task findById(Integer id);

   void save(Task task);

   void deleteById(Integer id);
}
