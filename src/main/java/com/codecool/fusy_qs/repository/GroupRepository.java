package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.User;
import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupClass, Long> {
    public

    @Query(value = "SELECT * from user_data " +
            "INNER JOIN group_class_users ON user_data.user_id = group_class_users.users_user_id " +
            "INNER JOIN group_class ON group_class.group_id = group_class_users.group_class_group_id " +
            "WHERE group_id = 1;",
            nativeQuery = true)
    List<User> findAllUsersByGroupId(Long id);


}
