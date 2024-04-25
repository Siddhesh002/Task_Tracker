package com.team_task.tracker.dao;

import com.team_task.tracker.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByUserName(String userName);

}
