package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Class;
import com.codecool.fusy_qs.entity.Group;
import com.codecool.fusy_qs.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GroupServiceImpl implements GruopService {
    GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Group findGroupById(Long Id) {
        return groupRepository.findById(Id).orElse(null);
    }

    //    Class class is embeddable so there is no his own repository,
//    soooo group his class initializes in constructor
    @PostConstruct
    private void postConstruct(){
        Class krk = new Class("krk-weekend");
        Group java = new Group("Fusy", krk);
        Group csharp = new Group("Csharp", krk);
        groupRepository.save(java);
        groupRepository.save(csharp);
    }
}
