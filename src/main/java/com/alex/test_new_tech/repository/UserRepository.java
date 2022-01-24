package com.alex.test_new_tech.repository;

import com.alex.test_new_tech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
