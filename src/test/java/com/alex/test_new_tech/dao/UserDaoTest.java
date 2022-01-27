package com.alex.test_new_tech.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.alex.test_new_tech.dao.Impl.UserDaoDataBase;
import com.alex.test_new_tech.model.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;
import java.util.List;

@RunWith(SpringRunner.class)

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Log4j2
@ActiveProfiles("test")
@Import(UserDaoDataBase.class)
@Rollback(value = false)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    @Sql(value = "/data1.sql")
    @Sql(value = "/clearTables.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void should_find_all_users(){
        List<User> userList = userDao.getAll();
        Assert.assertEquals(5, userList.size());;
    }


    @Sql(value = "/should_get_true_user.sql")
    @Sql(value = "/clearTables.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void should_get_true_user_by_email(){
        User user = userDao.findByEmail("email4@mail.ru");
        Assert.assertEquals("name4", user.getFirstName());
    }

    @Sql(value = "/should_get_true_user2.sql")
    @Sql(value = "/clearTables.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void should_get_true_user_by_id(){
        User user = userDao.getById(99L);
        Assert.assertEquals(user.getFirstName(), "name5");
    }

    @Test
    @Sql(value = "/clearTables.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_be_id_added_user_is_not_null(){
        User user = User.builder()
                .firstName("zero")
                .lastName("zero")
                .email("zero@mail.ru")
                .password("zero")
                .build();
        userDao.add(user);
        Assert.assertNotNull(user.getId());
    }




}
