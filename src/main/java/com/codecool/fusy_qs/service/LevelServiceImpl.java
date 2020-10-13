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
        return (List<Level>) levelRepository.findAll();
    }

    @Override
    public Level getLevelByCcRequired(Integer coolcoinsRequired) {
        return levelRepository.findLevelByCoolcoinsRequired(coolcoinsRequired);
    }


    @PostConstruct
    private void postConstruct() {
        Level leve1 = new Level("paper plane", 0, "icon-paper-plane-empty");
        Level leve2 = new Level("plane", 500, "icon-paper-plane");
        Level leve3 = new Level("jet", 1000, "icon-fighter-jet");
        Level leve4 = new Level("space shuttle", 2000, "icon-space-shuttle");
        Level leve5 = new Level("space shuttle", 3000, "icon-rocket");

        levelRepository.saveAll(Arrays.asList(leve1, leve2, leve3, leve4, leve5));

    }
}
