package com.codecool.fusy_qs.Mentor.Service;

import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Group.Service.GroupService;
import com.codecool.fusy_qs.Mentor.DAO.MentorDao;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MentorService {
//    MentorDao mentorDao;
    GroupService groupService;

    @Autowired
    public MentorService(
//            MentorDao mentorDao,
                         GroupService groupService) {
//        this.mentorDao = mentorDao;
        this.groupService = groupService;
    }

    public Mentor getMentorById(String id){
//        return mentorDao.getMentorByID(id);
        return null;
    }

    public ArrayList<Group> getMentorsGroupsById(String id){return groupService.getGroupsByMentorsID(id);}
}
