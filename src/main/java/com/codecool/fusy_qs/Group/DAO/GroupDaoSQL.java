package com.codecool.fusy_qs.Group.DAO;

import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Order;
import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Student.DAO.StudentDaoSQL;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class GroupDaoSQL implements GroupDao {

    PSQLconnection psqLconnection;

    public GroupDaoSQL(PSQLconnection psqLconnection) {
        this.psqLconnection = psqLconnection;
    }

    @Override
    public Group getGroupById(String groupId) {

        String query = "SELECT * FROM groups " +
                "WHERE group_id = ?;";

        Group group = null;

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst1 = con.prepareStatement(query)) {

            pst1.setString(Order.FIRST_ATTRIBUTE.getValue(), groupId);
            ResultSet rs = pst1.executeQuery();

            while (rs.next()) {

                String classId = rs.getString("class_id");
                String groupName = rs.getString("group_name");
                String mentorId = rs.getString("mentor_id");

                group = new Group(groupId, classId, groupName, mentorId);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return group;
    }

}
