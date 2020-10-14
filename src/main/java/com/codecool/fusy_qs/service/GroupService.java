package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.User;

public interface GroupService {

    void addGroup(GroupClass group);
    GroupClass findGroupById(Long Id);
//    void addUser(GroupClass group, User user);

}
