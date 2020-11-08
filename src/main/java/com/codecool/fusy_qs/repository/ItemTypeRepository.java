package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.ItemType;

import com.codecool.fusy_qs.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {



}
