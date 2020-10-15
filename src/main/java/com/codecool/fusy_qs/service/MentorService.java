package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Mentor;

public interface MentorService {

    Mentor findMentorById(Long id);
    Mentor findMentorByEmail(String email);

}
