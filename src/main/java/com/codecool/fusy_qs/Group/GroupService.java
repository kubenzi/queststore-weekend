package com.codecool.fusy_qs.Group;

import org.springframework.stereotype.Service;

@Service
public class GroupService {
    GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public Group getGroupById(String id){
        return groupDao.getGroupById(id);
    }
}
