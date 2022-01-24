package com.alex.test_new_tech.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.alex.test_new_tech.dao.Impl.UserDaoDataBase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DataJpaTest
@Log4j2
//@TestPropertySource("/application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(UserDaoDataBase.class)
@Transactional
@Rollback(value = false)
//@Sql(value = {"/data.sql"})
//@Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class UserDaoTest {

//    @Before
//    @Rollback(value = false)
//    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    public void initTest() throws SQLException {
//        log.info("Инициирую");
//    }


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDao userDao;

    @Test
//    @Sql("/add_users_in_test_db2.sql")
    public void should_find_all_users(){
//
//        log.info("Выполняю");
//        Role role = entityManager.find(Role.class, 1L);
//        entityManager.persist(role);
//
//        User user = User.builder()
//                .email("alex@mail.ru")
//                .firstName("alex")
//                .lastName("alex")
//                .age((byte) 5)
//                .password("alex@mail.ru")
//                .build();
//        user.addRole(role);
//
//        User user1 = User.builder()
//                .email("igor@mail.ru")
//                .firstName("igor")
//                .lastName("igor")
//                .age((byte) 51)
//                .password("igor@mail.ru")
//                .build();
//        user1.addRole(role);
//
//        userDao.add(user);
//        userDao.add(user1);
    }
}
