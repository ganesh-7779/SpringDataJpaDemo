package com.springDataJPA.springDataJpaDemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springDataJPA.springDataJpaDemo.entity.Course;
import com.springDataJPA.springDataJpaDemo.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder().title("JPA Tutorial and Study Material").credit(100).build();
		
		CourseMaterial couseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		
		repository.save(couseMaterial);
	}

}
