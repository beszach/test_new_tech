package com.alex.test_new_tech.service;


import com.alex.test_new_tech.dao.RoleDao;
import com.alex.test_new_tech.model.Role;
import com.alex.test_new_tech.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceDataBase implements RoleService{

    private final RoleRepository roleRepository;

    private final RoleDao roleDao;

    public RoleServiceDataBase(RoleRepository roleRepository, RoleDao roleDao) {
        this.roleRepository = roleRepository;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void add(Role role) {
//        roleRepository.saveAndFlush(role);
        roleDao.add(role);
    }


    @Transactional
    @Override
    public List<Role> getAll() {
//        return roleRepository.findAll();
        return roleDao.getAll();
    }

}
