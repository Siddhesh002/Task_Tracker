package com.team_task.tracker.service.employee;

import com.team_task.tracker.entity.Employee;

public interface EmployeeService {

    Employee findByUsername(String username);
}
