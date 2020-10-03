package com.codecool.fusy_qs.Group.Service;

import com.codecool.fusy_qs.Group.DAO.GroupDao;
import com.codecool.fusy_qs.Group.Model.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupServiceIMPL implements GroupService {
    GroupDao groupDao;

    public GroupServiceIMPL(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public Group getGroupById(String id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public ArrayList<Group> getGroupsByMentorsID(String id) {
        return groupDao.getGroupsByMentorId(id);
    }
}
