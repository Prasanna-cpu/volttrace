package com.spring.volttrace.user_service;

import com.spring.volttrace.user_service.entity.User;
import com.spring.volttrace.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

	@Autowired
	private UserRepository userRepository;
	private static final Integer NO_OF_USERS = 50;


	@Test
	void contextLoads() {
	}

	@Test
	void addUsersToDB(){
		for(int i = 0; i < NO_OF_USERS; i++){
			User user = new User();
			user.setName("User " + i);
			user.setSurname("Surname " + i);
			user.setEmail("user" + i + "@example.com");
			user.setAddress("Address " + i);
			user.setAlerting(i % 2 == 0);
			user.setEnergyAlertingThreshold(1000.0 + i);
			userRepository.save(user);
		}
		log.info("Added " + NO_OF_USERS + " users to the database.");
	}

}
