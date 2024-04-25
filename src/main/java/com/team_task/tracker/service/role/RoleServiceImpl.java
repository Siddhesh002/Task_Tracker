package com.team_task.tracker.service.role;

import com.team_task.tracker.dao.RoleRepository;
import com.team_task.tracker.entity.Role;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer roleId) {
        Optional<Role> result = roleRepository.findById(roleId);

        Role theRole = null;

        if (result.isPresent()) {
            theRole = result.get();
        }
        else {
            throw new RuntimeException("Role not found with id : " + roleId);
        }

        return theRole;
    }
}
