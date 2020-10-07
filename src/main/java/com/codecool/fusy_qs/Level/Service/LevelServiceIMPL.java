package com.codecool.fusy_qs.Level.Service;

import com.codecool.fusy_qs.Level.DAO.LevelDao;
import com.codecool.fusy_qs.Level.Model.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceIMPL implements LevelService {
//    LevelDao levelDao;

    public LevelServiceIMPL(
//            LevelDao levelDao
    ) {
//        this.levelDao = levelDao;
    }

    @Override
    public Level getLevelByCcReq(Integer totalCoinsEarned) {
//        return levelDao.getLevelCcReq(totalCoinsEarned);
        return null;
    }

    @Override
    public List<Level> getAllLevels() {
//        return levelDao.getAllLevels();
        return null;
    }

    @Override
    public Level getLevelById(Integer idLevel) {
//        return levelDao.getLevelById(idLevel);
        return null;
    }

    @Override
    public void editLevel(Level level) {
//         levelDao.editLevel(level);
    }

    @Override
    public void deleteLevelById(Integer idLevel) {
//        levelDao.deleteLevelById(idLevel);
    }
}
