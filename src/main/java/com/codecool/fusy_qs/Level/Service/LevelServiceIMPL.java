package com.codecool.fusy_qs.Level.Service;

import com.codecool.fusy_qs.Level.DAO.LevelDao;
import com.codecool.fusy_qs.Level.Model.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceIMPL implements LevelService {
    LevelDao levelDao;

    public LevelServiceIMPL(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    @Override
    public Level getLevelByCcReq(Integer totalCoinsEarned) {
        return levelDao.getLevelCcReq(totalCoinsEarned);
    }

    @Override
    public List<Level> getAllLevels() {
        return levelDao.getAllLevels();
    }

    @Override
    public Level getLevelById(Integer idLevel) {
        return levelDao.getLevelById(idLevel);
    }

    @Override
    public Level editLevelById(Integer idLevel) {
        return null;
    }
}
