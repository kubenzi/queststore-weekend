package com.codecool.fusy_qs;

import com.codecool.fusy_qs.Mentor.DAO.MentorDao;
import com.codecool.fusy_qs.Mentor.DAO.MentorDaoSQL;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import com.codecool.fusy_qs.Mentor.Service.MentorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FusyQsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FusyQsApplication.class, args);
		MentorDao mentorDao = new MentorDaoSQL();
		MentorService mentorService = new MentorService(mentorDao);
		Mentor mentor = mentorService.getMentorById("bIx0U[5~");
		System.out.println(mentor.toString());


	}


}
