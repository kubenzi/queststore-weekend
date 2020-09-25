package com.codecool.fusy_qs.DAO;

import com.codecool.fusy_qs.Model.Student;
import com.codecool.fusy_qs.PSQLconnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StudentDaoSQL extends PSQLconnection implements StudentDao {

    @Override
    public Student getStudentByID(String id) {
        String query = "SELECT * FROM user_data WHERE  user_id = ? ;";

        Student student = null;

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Integer accountType = rs.getInt("account_type_id");
                String email = rs.getString("email");
                student = new Student(id, accountType, firstName, lastName, email);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(StudentDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return student;
    }
}
