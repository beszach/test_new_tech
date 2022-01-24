package com.alex.test_new_tech.dao;

import com.alex.test_new_tech.model.Role;

import java.util.List;

public interface RoleDao {
    void add(Role roleName);
    List<Role> getAll();
}
