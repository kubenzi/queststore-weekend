package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Class;
import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GroupServiceImpl implements GroupService {
    GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public void addGroup(GroupClass group) {
        groupRepository.save(group);
    }

    @Override
    public GroupClass findGroupById(Long Id) {
        return groupRepository.findById(Id).orElse(null);
    }

    @Override
    public void saveGroup(GroupClass group) {
        groupRepository.save(group);
    }


//    @Override
//    public void addUser(GroupClass group, User user) {
//        group.getUsers().add(user);
//    }

    //    Class class is embeddable so there is no his own repository,
//    soooo group his class initializes in constructor
//    @PostConstruct
//    private void postConstruct(){
//        Class krk = new Class("krk-weekend");
//        GroupClass java = new GroupClass("Java", krk);
//        GroupClass csharp = new GroupClass("Csharp", krk);
//        groupRepository.save(java);
//        groupRepository.save(csharp);
//    }
}
