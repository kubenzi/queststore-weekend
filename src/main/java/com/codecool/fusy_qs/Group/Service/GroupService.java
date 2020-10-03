package com.codecool.fusy_qs.Group.Service;

import com.codecool.fusy_qs.Group.Model.Group;

import java.util.ArrayList;

public interface GroupService {
    public Group getGroupById(String id);
    public ArrayList<Group> getGroupsByMentorsID(String id);
}
