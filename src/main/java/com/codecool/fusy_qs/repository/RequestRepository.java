package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {

    @Query(value = "SELECT request FROM Request request WHERE request.group.groupId = ?1")
    List<Request> getRequestsByGroupId(Long groupId);
}
