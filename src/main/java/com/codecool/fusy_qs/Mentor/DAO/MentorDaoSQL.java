package com.codecool.fusy_qs.Mentor.DAO;


import com.codecool.fusy_qs.Group.DAO.GroupDao;
import com.codecool.fusy_qs.Group.DAO.GroupDaoSQL;

import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Group.Service.GroupService;
import com.codecool.fusy_qs.Group.Service.GroupServiceIMPL;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import com.codecool.fusy_qs.PSQLconnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Repository
public class MentorDaoSQL  implements MentorDao {
    PSQLconnection psqLconnection;

    public MentorDaoSQL(PSQLconnection psqLconnection) {
        this.psqLconnection = psqLconnection;
    }

    @Override
    public Mentor getMentorByID(String id) {

        String query = "SELECT * FROM user_data " +
                "RIGHT JOIN mentor ON" +
                " user_data.user_id=mentor.user_id" +
                " WHERE mentor.mentor_id= ?;";


        Mentor mentor = null;
        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer accountType = rs.getInt("account_type_id");
                String email = rs.getString("email");







                mentor = new Mentor(id, accountType, firstName, lastName, email);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MentorDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return mentor;
    }

//    select * from user_data FULL OUTER JOIN student ON user_data.user_id=student.user_id FULL OUTER JOIN groups ON student.group_id=groups.group_id


}
