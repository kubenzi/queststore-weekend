package com.codecool.fusy_qs.Mentor.DAO;

import com.codecool.fusy_qs.Group.Group;
import com.codecool.fusy_qs.Group.GroupDao;
import com.codecool.fusy_qs.Group.GroupDaoSQL;
import com.codecool.fusy_qs.Group.GroupService;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Student.DAO.StudentDao;
import com.codecool.fusy_qs.Student.Model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class MentorDaoSQL extends PSQLconnection implements MentorDao {

    @Override
    public Mentor getMentorByID(String id) {

        String query = "SELECT * FROM user_data " +
                "RIGHT JOIN mentor ON" +
                " user_data.user_id=mentor.user_id" +
                " WHERE mentor.user_id= ?;";


        Mentor mentor = null;
        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer accountType = rs.getInt("account_type_id");
                String email = rs.getString("email");


                GroupDao groupDao = new GroupDaoSQL();
                ArrayList<Group> groupsByMentorId = groupDao.getGroupsByMentorId(id);
                GroupService groupService = new GroupService(groupDao);




                mentor = new Mentor(id, accountType, firstName, lastName, email, groupsByMentorId);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MentorDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return mentor;
    }

//    select * from user_data FULL OUTER JOIN student ON user_data.user_id=student.user_id FULL OUTER JOIN groups ON student.group_id=groups.group_id


}
