package com.team_task.tracker.service.employee;

import com.team_task.tracker.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findByUsername(String username);

    List<Employee> findAll();
}
