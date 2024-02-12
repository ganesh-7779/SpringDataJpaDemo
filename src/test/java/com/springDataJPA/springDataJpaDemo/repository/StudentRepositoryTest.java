package com.springDataJPA.springDataJpaDemo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springDataJPA.springDataJpaDemo.entity.Guardian;
import com.springDataJPA.springDataJpaDemo.entity.Student;



/**
 * 
 */

@SpringBootTest
//@DataJpaTest // This will help we to test repository layer once the operation is done it will flush the data. Right now we are not using as we want keep data and perform operation 
public class StudentRepositoryTest {
	
	@Autowired(required=true)
	private StudentRepository studentRepository;
	
	/**
	 *  To save the data into table tbl_student in database 
	 */
	@Test
	public void savStudent() {
		Student student =  Student.builder().emailId("shabbheir@gmail.com")
                .name("Ganesh")
                .lasname("Gavhad")
                //.guardianName("Pankaj")
                //.guardianEmail("pankaj@gmail.com")
                //.guardianMobile("9999999999")
                .build();
		studentRepository.save(student);
	}
	
	/**
	 * Written test case to check embedded and embeddable in JPA and save the data
	 */
	Guardian guardian = Guardian.builder().email("ganeshb8@gmail.com").mobile("78474847").name("Pratik").build();
	
	@Test
	public void saveStudentWithGuardian() {
		Student student = Student.builder().name("Ganesh")
				.emailId("Ganesh4@gmail.com")
				.lasname("Gavhad")
				.guardin(guardian).build();
		studentRepository.save(student);

		}
	
	/** 
	 *
	 *  Test case to find all student present in tbl_student table
	 */
	@Test
	public void printAllStudent() {
		List<Student> student = studentRepository.findAll();
		System.out.println("StudentLisr: "+student);
		
	}
	
	
	
}
