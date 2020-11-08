package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.entity.User;
import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupClass, Long> {

}
