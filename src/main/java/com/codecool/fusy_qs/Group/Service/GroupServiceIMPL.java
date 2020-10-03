package com.codecool.fusy_qs.Group.Service;

import com.codecool.fusy_qs.Group.DAO.GroupDao;
import com.codecool.fusy_qs.Group.Model.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceIMPL implements GroupService {
    GroupDao groupDao;

    public GroupServiceIMPL(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public Group getGroupById(String id) {
        return groupDao.getGroupById(id);
    }
}
