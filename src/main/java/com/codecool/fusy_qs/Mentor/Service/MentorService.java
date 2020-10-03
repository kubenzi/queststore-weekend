package com.codecool.fusy_qs.Mentor.Service;

import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Group.Service.GroupService;
import com.codecool.fusy_qs.Mentor.DAO.MentorDao;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MentorService {
    MentorDao mentorDao;
    GroupService groupService;

    public MentorService(MentorDao mentorDao) {
        this.mentorDao = mentorDao;
    }

    public Mentor getMentorById(String id){
        return mentorDao.getMentorByID(id);
    }

    public ArrayList<Group> getMentorsGroupsById(String id){return groupService.getGroupsByMentorsID(id);}
}
