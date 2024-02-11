package com.springDataJPA.springDataJpaDemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springDataJPA.springDataJpaDemo.entity.Student;



@SpringBootTest
//@DataJpaTest // This will help we to test repository layer once the operation is done it will flush the data. Right now we are not using as we want keep data and perform operation 
public class StudentRepositoryTest {
	
	@Autowired(required=true)
	private StudentRepository studentRepository;
	
	@Test
	public void savStudent() {
		Student student =  Student.builder().emailId("shabbhir@gmail.com")
                .name("Ganesh")
                .lasname("Gavhad")
                .guardianName("Pankaj")
                .guardianEmail("pankaj@gmail.com")
                .guardianMobile("9999999999")
                .build();
		studentRepository.save(student);
	}
	
}
