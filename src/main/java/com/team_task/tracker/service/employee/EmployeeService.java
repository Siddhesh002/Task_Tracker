package com.team_task.tracker.service.employee;

import com.team_task.tracker.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findByUsername(String username);

    List<Employee> findAll();

    boolean employeesExist(Integer id);

    List<Employee> findEmployeesByManagerId(Integer managerId);

    Employee findEmployeeById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);

    List<Employee> findEmployeesByRoleName(String roleName);
}
