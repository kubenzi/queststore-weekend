package com.codecool.fusy_qs;

import com.codecool.fusy_qs.DAO.StudentDao;
import com.codecool.fusy_qs.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class UserController {
    private StudentDao studentDao;

    public UserController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @GetMapping("/student")
    String showUpdateForm(Model model) {
        Student student = studentDao.getStudentByID("x%[>j!X#");
        model.addAttribute(student);
        return "student";
    }

}
