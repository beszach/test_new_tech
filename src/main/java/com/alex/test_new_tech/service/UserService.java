package com.alex.test_new_tech.service;

import com.alex.test_new_tech.model.User;

import java.util.List;


public interface UserService {
    User findByEmail(String email);
    void add(User user);
    void update(User user);
    void delete(Long id);
    List<User> getAll();
    User getById(Long id);
}
