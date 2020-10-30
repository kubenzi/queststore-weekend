package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Level;
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
public class LevelRepositoryTest {

    @Autowired
    private LevelRepository levelRepository;

    @Test
    public void shoud_find_minimal_level() {
        // given:
        int coolcoins = 0;

        // when:
        Level level  = levelRepository.findLevelByCoolcoinsRequired(coolcoins);

        // then:
        assertEquals(level.getLevelId(), 1L);
    }

    @Test
    public void shoud_find_maximal_level() {
        // given:
        int coolcoins = 10000;

        // when:
        Level level  = levelRepository.findLevelByCoolcoinsRequired(coolcoins);

        // then:
        assertEquals(level.getLevelId(), 5L);

    }


}