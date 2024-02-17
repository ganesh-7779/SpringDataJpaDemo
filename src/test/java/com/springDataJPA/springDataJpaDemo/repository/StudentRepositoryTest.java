package com.springDataJPA.springDataJpaDemo.repository;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.springDataJPA.springDataJpaDemo.entity.Guardian;
import com.springDataJPA.springDataJpaDemo.entity.Student;


@SpringBootTest
//@DataJpaTest // This will help we to test repository layer once the operation is done it will flush the data. Right now we are not using as we want keep data and perform operation
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Order test methods based on @Order annotation
public class StudentRepositoryTest {
	
	@Autowired(required=true)
	private StudentRepository studentRepository;
	
	/**
	 *  To save the data into table tbl_student in database 
	 */
	@Test
	@Order(1)
	public void savStudent() {
		String emailId = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com"; // Change length as needed
		Student student =  Student.builder().emailId(emailId)
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
	Guardian guardian = Guardian.builder().email("ganseb8@gmail.com").mobile("78474847").name("Pratik").build();
	
	@Test
	@Order(2)
	public void saveStudentWithGuardian() {
		String emailId = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com"; // Change length as needed

		Student student = Student.builder().name("Pratik")
				.emailId(emailId)
				.lasname("pawar")
				.guardin(guardian).build();
		studentRepository.save(student);

		}
	
	/** 
	 *
	 *  Test case to find all student present in tbl_student table
	 */
	@Test
	@Order(3)
	public void printAllStudent() {
		List<Student> student = studentRepository.findAll();
		System.out.println("StudentLisr: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find all student by name present in tbl_student table
	 */
	@Test
	@Order(4)
	public void findByName() {
		List<Student> student = studentRepository.findByName("Pratik");
		System.out.println("StudentListByName: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find student by emailId in tbl_student table
	 */
	@Test
	@Order(5)
	public void findByNameContaining() {
		List<Student> student = studentRepository.findByNameContaining("Pr");
		System.out.println("StudentListByNameContaining: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find all student by Last Name present in tbl_student table
	 */
	@Test
	@Order(6)
	public void findByNameLastName() {
		List<Student> student = studentRepository.findByLasname("Gavhad");
		System.out.println("StudentListByLastName: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find all student by Guardian Name present in tbl_student table
	 */
	@Test
	@Order(7)
	public void findByNameGuardianName() {
		List<Student> student = studentRepository.findByGuardinName("Pankaj");
		System.out.println("StudentListByLastName: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find all student by Name and lastName present in tbl_student table
	 */
	@Test
	@Order(8)
	public void findByNameAndLastName() {
		List<Student> student = studentRepository.findByLasnameAndName("pawar","Pratik");
		System.out.println("StudentListByLastName: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find all student by Name and lastName present in tbl_student table
	 */
	@Test
	@Order(9)
	public void findByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("Ganeshs@gmail.com");
		System.out.println("StudentByEamilId: "+student);
		
	}
	
	/** 
	 *
	 *  Test case to find student Name by emailiD present in tbl_student table
	 */
	@Test
	@Order(10)
	public void findFirstNameByEmailAddress() {
		String student = studentRepository.getStudentFirstNameByEmailAddress("Ganeshs@gmail.com");
		System.out.println("StudentFirstNameByEamilId: "+student);
		
	}
	
	@Test
	@Order(11)
	public void findByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("Ganeshs@gmail.com");
		System.out.println("StudentByEamilIdNative: "+student);
		
	}
	@Test
	@Order(12)
	public void findByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("Ganeshs@gmail.com");
		System.out.println("StudentByEamilIdNativeNamedParam: "+student);
		
	}
}
