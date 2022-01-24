package com.alex.test_new_tech.service;

import com.alex.test_new_tech.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role roleName);
    List<Role> getAll();
}
