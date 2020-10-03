package com.codecool.fusy_qs.Group.DAO;

import com.codecool.fusy_qs.Group.Model.Group;

import java.util.ArrayList;

public interface GroupDao {
    Group getGroupById(String id);
    ArrayList<Group> getGroupsByMentorId(String mentor_id);

}
