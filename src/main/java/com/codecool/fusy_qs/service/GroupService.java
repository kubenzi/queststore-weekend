package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.GroupClass;

public interface GroupService {

    void addGroup(GroupClass group);
    GroupClass findGroupById(Long Id);

}
