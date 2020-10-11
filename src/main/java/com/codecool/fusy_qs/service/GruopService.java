package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Group;

public interface GruopService  {

    void addGroup(Group group);
    Group findGroupById(Long Id);

}
