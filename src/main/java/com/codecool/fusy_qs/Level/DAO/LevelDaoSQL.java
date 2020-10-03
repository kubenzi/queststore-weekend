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
                String iconName = rs.getString("icon_name");


                level = new Level(levelID, levelName, coolcoinsRequired, iconName);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }

        return level;
    }

    @Override
    public List<Level> getAllLevels() {
        String query = "SELECT * FROM level_of_experience ORDER BY level_id;";

        List<Level> levelList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Integer levelID = rs.getInt("level_id");
                String levelName = rs.getString("level_name");
                Integer coolcoinsRequired = rs.getInt("coolcoins_required");
                String iconName = rs.getString("icon_name");

                Level level = new Level(levelID, levelName, coolcoinsRequired, iconName);
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

                String levelName = rs.getString("level_name");
                Integer coolcoinsRequired = rs.getInt("coolcoins_required");
                String iconName = rs.getString("icon_name");

                level = new Level(levelId, levelName, coolcoinsRequired, iconName);

            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }

        return level;
    }

    @Override
    public void editLevel(Level level) {
        String query = "UPDATE level_of_experience SET level_name = ?, coolcoins_required = ?, icon_name= ? " +
                "WHERE level_id = ?;";

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(Order.FIRST_ATTRIBUTE.getValue(), level.getLevelName());
            pst.setInt(Order.SECOND_ATTRIBUTE.getValue(), level.getCcolcoinsRequired());
//            pst.setInt(Order.THIRD_ATTRIBUTE.getValue(), level.getLevelId());
//            pst.setString(Order.FOURTH_ATTRIBUTE.getValue(), level.getIconName());
            pst.setString(Order.THIRD_ATTRIBUTE.getValue(), level.getIconName());
            pst.setInt(Order.FOURTH_ATTRIBUTE.getValue(), level.getLevelId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteLevelById(Integer idLevel) {
        String query = "DELETE FROM level_of_experience WHERE level_id = ?;";

        Level level = null;

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(Order.FIRST_ATTRIBUTE.getValue(), idLevel);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
