package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public List<Level> getAllLevels() {
        return (List<Level>) levelRepository.findAll();
    }
}
