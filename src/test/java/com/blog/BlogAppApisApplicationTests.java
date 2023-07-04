package com.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void repoTest() {
		String className = userRepo.getClass().getName();
		String packageName = userRepo.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packageName);
	}

}
