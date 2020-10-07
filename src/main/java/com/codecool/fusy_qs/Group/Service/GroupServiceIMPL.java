package com.codecool.fusy_qs.Group.Service;

import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupServiceIMPL implements GroupService {

    private GroupRepository groupRepository;

    public GroupServiceIMPL(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group getGroupById(String id) {
//        return groupRepository.findById(Long.valueOf(id)).get();
        return null;
    }

    @Override
    public ArrayList<Group> getGroupsByMentorsID(String id) {
//        return groupDao.getGroupsByMentorId(id);
        return new ArrayList<>();
    }
}
