package com.team_task.tracker.service.employee;

import com.team_task.tracker.dao.EmployeeRepository;
import com.team_task.tracker.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean employeesExist(Integer id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public List<Employee> findEmployeesByManagerId(Integer managerId) {
        return employeeRepository.findAllByManagerId(managerId);
    }

    @Override
    public Employee findEmployeeById(Integer id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeesByRoleName(String roleName) {
        return employeeRepository.findAllByRoleName(roleName);
    }
}
