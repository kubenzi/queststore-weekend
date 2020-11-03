package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.service.LevelService;
import com.codecool.fusy_qs.service.StudentService;
import com.codecool.fusy_qs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping
public class AuthenticationController {

    UserService userService;
    StudentService studentService;
    LevelService levelService;

    public AuthenticationController(UserService userService,
                                    StudentService studentService,
                                    LevelService levelService) {
        this.userService = userService;
        this.studentService = studentService;
        this.levelService = levelService;
    }

    @GetMapping("/loginForm")
    public String getLoginForm(Model model) {
        model.addAttribute("maybeUser", new User());
        return "loginForm";
    }

    @PostMapping("/loginForm")
    public void processLoginAttempt(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @ModelAttribute("maybeUser") User user) throws IOException {
        Optional<User> maybeUser = userService.login(user);
        //co robi ten get()?
        if (maybeUser.isPresent()) {
            String accountType = maybeUser.get().getAccountType().getAccountType();
            HttpSession session = request.getSession(true);
            switch (accountType) {
                case "student":
                    Student student = studentService.findStudentByEmail(maybeUser.get().getEmail());
                    session.setAttribute("student", student);
                    session.setAttribute("level", levelService.getLevelByCcRequired(student.getTotalCoinsEarned()));
                    response.sendRedirect(request.getContextPath() + "/student/profile");
                    break;
                case "mentor":
                    User mentor = userService.findUserByEmail(maybeUser.get().getEmail());
                    session.setAttribute("mentor", mentor);
                    response.sendRedirect(request.getContextPath() + "/mentor/profile");
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/loginForm");
        }
    }

    @GetMapping("/logout")
    public void processLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect(request.getContextPath() + "/loginForm");
    }

}
