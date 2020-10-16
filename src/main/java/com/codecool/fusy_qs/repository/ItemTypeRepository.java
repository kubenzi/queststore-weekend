package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.ItemType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {

}
