package com.alex.test_new_tech.dao.Impl;

import com.alex.test_new_tech.dao.UserDao;
import com.alex.test_new_tech.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Log4j2
public class UserDaoDataBase implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("from User where email=:email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    @Override
    public void add(User user) {
        log.info("Add user: "+user);
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        log.info("Update user: "+user);
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}
