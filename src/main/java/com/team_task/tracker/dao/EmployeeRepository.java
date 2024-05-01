package com.team_task.tracker.dao;

import com.team_task.tracker.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByUserName(String userName);

    @Query("SELECT e FROM Employee e WHERE e.manager.id = :managerId")
    List<Employee> findAllByManagerId(@Param("managerId") int managerId);

    @Query("SELECT e FROM Employee e JOIN e.role r WHERE r.role = :roleName")
    List<Employee> findAllByRoleName(String roleName);
}
