package com.codecool.fusy_qs.Level.DAO;

import com.codecool.fusy_qs.Level.Model.Level;
import com.codecool.fusy_qs.Order;
import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Student.DAO.StudentDaoSQL;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class LevelDaoSQL implements LevelDao {

    PSQLconnection psqLconnection;

    public LevelDaoSQL(PSQLconnection psqLconnection) {
        this.psqLconnection = psqLconnection;
    }

    @Override
    public Level getLevelCcReq(Integer totalCoinsEarned) {
        String query = "SELECT * FROM level_of_experience " +
                "WHERE coolcoins_required =(" +
                "SELECT MAX (coolcoins_required) " +
                "FROM level_of_experience " +
                "WHERE coolcoins_required <= ?);";

        Level level = null;

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(Order.FIRST_ATTRIBUTE.getValue(), totalCoinsEarned);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Integer levelID = rs.getInt("level_id");
                String levelName = rs.getString("level_name");
                Integer coolcoinsRequired = rs.getInt("coolcoins_required");

                level = new Level(levelID, levelName, coolcoinsRequired);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }

        return level;
    }

    @Override
    public List<Level> getAllLevels() {
        String query = "SELECT * FROM level_of_experience;";

        List<Level> levelList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Integer levelID = rs.getInt("level_id");
                String levelName = rs.getString("level_name");
                Integer coolcoinsRequired = rs.getInt("coolcoins_required");

                Level level = new Level(levelID, levelName, coolcoinsRequired);
                levelList.add(level);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }

        return levelList;
    }

    @Override
    public Level getLevelById(Integer levelId) {
        String query = "SELECT * FROM level_of_experience WHERE level_id = ?;";

        Level level = null;

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(Order.FIRST_ATTRIBUTE.getValue(), levelId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

//                Integer levelID = rs.getInt("level_id");
                String levelName = rs.getString("level_name");
                Integer coolcoinsRequired = rs.getInt("coolcoins_required");

                level = new Level(levelId, levelName, coolcoinsRequired);

            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }

        return level;
    }
}
