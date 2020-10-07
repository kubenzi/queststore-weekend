package com.codecool.fusy_qs.Student.DAO;

import com.codecool.fusy_qs.Order;
import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Repository
public class StudentDaoSQL implements StudentDao {

    private PSQLconnection psqLconnection;
    @Autowired
    public StudentDaoSQL(PSQLconnection psqLconnection) {
        this.psqLconnection = psqLconnection;
    }

    @Override
    public Student getStudentByID(String id) {
        String query = "SELECT * FROM user_data " +
                "RIGHT JOIN student ON" +
                " user_data.user_id=student.user_id" +
                " WHERE student.user_id= ?;";

        Student student = null;

        try (Connection con = DriverManager.getConnection(psqLconnection.getUrl(), psqLconnection.getUsername(), psqLconnection.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(Order.FIRST_ATTRIBUTE.getValue(), id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer accountType = rs.getInt("account_type_id");
                String email = rs.getString("email");
                String groupId = rs.getString("group_id");
                Integer wallet = rs.getInt("wallet");
                Integer totalCoinsEarned = rs.getInt("total_coins_earned");


                student = new Student(id, accountType, firstName, lastName, email, groupId, wallet, totalCoinsEarned);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


        return student;
    }

}
