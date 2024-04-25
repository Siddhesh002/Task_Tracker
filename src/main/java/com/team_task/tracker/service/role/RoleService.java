package com.team_task.tracker.service.role;

import com.team_task.tracker.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(Integer id);
}
