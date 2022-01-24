package com.alex.test_new_tech.repository;


import com.alex.test_new_tech.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
