package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Level;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LevelRepository extends CrudRepository<Level, Long> {

    @Query(value = "SELECT * FROM level" +
            " WHERE coolcoins_required =(SELECT MAX (coolcoins_required)" +
            " FROM level WHERE coolcoins_required <= ?1)",
    nativeQuery = true)

    Level findLevelByCoolcoinsRequired(Integer coolCoinsRequired);


}
