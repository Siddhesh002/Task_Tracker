package com.team_task.tracker.dao;

import com.team_task.tracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t JOIN t.assignee a WHERE a.manager.id = :managerId")
    List<Task> findTasksByManagerId(@Param("managerId") Integer managerId);

    List<Task> findTasksByAssigneeId(@Param("assigneeId") Integer assigneeId);
}
