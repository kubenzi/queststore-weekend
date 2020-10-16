package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Mentor;
import com.codecool.fusy_qs.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {
    MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Mentor findMentorById(Long id) {
        return mentorRepository.findById(id).orElse(null);
    }

    @Override
    public Mentor findMentorByEmail(String email) {
        return mentorRepository.findByEmail(email);
    }
}
