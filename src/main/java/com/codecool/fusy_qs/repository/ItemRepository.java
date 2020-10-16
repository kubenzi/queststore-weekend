package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value = "SELECT * FROM Item", nativeQuery = true)
    List<Item> getAllItems();

    @Query(value = "SELECT record FROM Item record WHERE record.itemType.itemTypeId = 2")
    List<Item> getAllIndividualItems();

    @Query(value = "SELECT record FROM Item record WHERE record.itemType.itemTypeId = 1")
    List<Item> getAllGroupItems();
}
