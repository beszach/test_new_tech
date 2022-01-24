package com.alex.test_new_tech.service;

import com.alex.test_new_tech.dao.UserDao;
import com.alex.test_new_tech.model.User;
import com.alex.test_new_tech.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Log4j2
public class UserServiceDataBase implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserDao userDao;

    @Autowired
    public UserServiceDataBase(PasswordEncoder passwordEncoder, UserRepository userRepository, UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.saveAndFlush(user);
        userDao.add(user);
        log.info("Add user: {}", user);
    }

    @Override
    public void update(User userUpdated) {
        userUpdated.setPassword(passwordEncoder.encode(userUpdated.getPassword()));
//        userRepository.saveAndFlush(userUpdated);
        userDao.update(userUpdated);
        log.info("Update user: {}",  userUpdated);
    }

    @Override
    public void delete(Long id) {
//        userRepository.deleteById(id);
        userDao.delete(id);
        log.info("Delete user with id: {}", id);
    }

    @Override
    public List<User> getAll() {
//        return userRepository.findAll();
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
//        return userRepository.findById(id).orElse(null);
        return userDao.getById(id);
    }

    @Override
    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
        return userDao.findByEmail(email);
    }

}
