package com.codecool.fusy_qs.Level.Service;

import com.codecool.fusy_qs.Level.DAO.LevelDao;
import com.codecool.fusy_qs.Level.Model.Level;
import org.springframework.stereotype.Service;

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
}
