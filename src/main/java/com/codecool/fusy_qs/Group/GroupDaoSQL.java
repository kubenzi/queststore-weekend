package com.codecool.fusy_qs.Group;

import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Student.DAO.StudentDaoSQL;
import com.codecool.fusy_qs.Student.Model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class GroupDaoSQL extends PSQLconnection implements GroupDao {
    @Override
    public Group getGroupById(String groupId) {

        String query = "SELECT * FROM groups" +
                "WHERE group_id= ?;";

        Group group = null;

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, groupId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String classId = rs.getString("class_id");
                String groupName = rs.getString("group_name");
                Integer groupWallet = rs.getInt("group_wallet");
                String mentorId = rs.getString("mentor_id");


                group = new Group(groupId, classId, groupName, groupWallet, mentorId);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return group;
    }

    @Override
    public ArrayList<Group> getGroupsByMentorId(String mentor_id) {
        ArrayList<Group> groupsByMentorId = new ArrayList<>();
        String query = "SELECT * FROM groups" +
                "WHERE mentor_id= ?;";

        Group group = null;

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, mentor_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String groupId = rs.getString("group_id");
                String classId = rs.getString("class_id");
                String groupName = rs.getString("group_name");
                Integer groupWallet = rs.getInt("group_wallet");
                String mentorId = rs.getString("mentor_id");


                group = new Group(groupId, classId, groupName, groupWallet, mentorId);
                groupsByMentorId.add(group);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return groupsByMentorId;

    }

}
