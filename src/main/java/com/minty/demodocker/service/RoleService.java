package com.minty.demodocker.service;

import com.minty.demodocker.entities.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    Role getRole(Long id);
    Role getRoleByRoleName(String roleName);
    Role updateRole(Role role);
    void deleteRole(Long id);
    List<Role> getRoleList();

}
