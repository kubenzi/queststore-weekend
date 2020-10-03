package com.codecool.fusy_qs.Mentor.Service;

import com.codecool.fusy_qs.Mentor.DAO.MentorDao;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import org.springframework.stereotype.Service;

@Service
public class MentorService {
    MentorDao mentorDao;

    public MentorService(MentorDao mentorDao) {
        this.mentorDao = mentorDao;
    }

    public Mentor getMentorById(String id){
        return mentorDao.getMentorByID(id);
    }
}
