package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Sql("user_test.sql")
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void get_all_users() {
        // given:
        int listSize = 5;

        // when:
        List<User> allUser = (List<User>) userRepository.findAll();

        // then:
        assertEquals(allUser.size(), listSize);
    }
}