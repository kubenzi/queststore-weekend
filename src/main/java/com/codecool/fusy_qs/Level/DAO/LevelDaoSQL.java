package com.codecool.fusy_qs.Level.DAO;

import com.codecool.fusy_qs.Level.Model.Level;
import com.codecool.fusy_qs.Order;
import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Student.DAO.StudentDaoSQL;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Logger;

@Repository
public class LevelDaoSQL extends PSQLconnection implements LevelDao {

    @Override
    public Level getLevelCcReq(Integer totalCoinsEarned) {
        String query = "SELECT * FROM level_of_experience " +
                "WHERE coolcoins_required =(" +
                "SELECT MAX (coolcoins_required) " +
                "FROM level_of_experience " +
                "WHERE coolcoins_required <= ?);";

        Level level = null;

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
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

}
