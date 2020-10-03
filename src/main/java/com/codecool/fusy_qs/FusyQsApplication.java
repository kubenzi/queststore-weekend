package com.codecool.fusy_qs;

import com.codecool.fusy_qs.Group.DAO.GroupDao;
import com.codecool.fusy_qs.Group.DAO.GroupDaoSQL;
import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Mentor.DAO.MentorDao;
import com.codecool.fusy_qs.Mentor.DAO.MentorDaoSQL;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import com.codecool.fusy_qs.Mentor.Service.MentorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class FusyQsApplication {


	public static void main(String[] args) {
		SpringApplication.run(FusyQsApplication.class, args);
		PSQLconnection psqLconnection = new PSQLconnection();
		System.out.println(psqLconnection.getUrl());
		GroupDao groupDao = new GroupDaoSQL(psqLconnection);
		MentorDao mentorDao = new MentorDaoSQL(psqLconnection);
		MentorService mentorService = new MentorService(mentorDao);
		Group groupxyz = groupDao.getGroupById("hLs3X-8.");
		System.out.println(groupxyz.getGroupName());
		ArrayList<Group> groups = groupDao.getGroupsByMentorId("bIx0U[5~");
		for (Group group: groups) {
			System.out.println(group.getGroupName());

		}




	}



}
