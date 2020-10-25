package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.repository.LevelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public List<Level> getAllLevels() {
        return (List<Level>) levelRepository.findAllOrderById();
    }

    @Override
    public Level getLevelByCcRequired(Integer coolcoinsRequired) {
        return levelRepository.findLevelByCoolcoinsRequired(coolcoinsRequired);
    }

    @Override
    public Level getLevelById(Long levelId) {
        return levelRepository.findById(levelId).orElse(null);
    }

    @Override
    public void saveLevel(Level level) {
        levelRepository.save(level);
    }

}
