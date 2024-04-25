package com.team_task.tracker.service.employee;

import com.team_task.tracker.dao.EmployeeRepository;
import com.team_task.tracker.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByUserName(username);
    }
}
