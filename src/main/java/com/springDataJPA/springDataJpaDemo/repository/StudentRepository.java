package com.springDataJPA.springDataJpaDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springDataJPA.springDataJpaDemo.entity.Student;


/**
 * Spring data JPA documentation for query creation 
 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.named-queries.annotation-based-configuration
 * Query will be created base on attribute present in the table
 */

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {	
	public List<Student> findByName(String firstName);
	public List<Student> findByNameContaining(String firstName);
	public List<Student> findByLasname(String lastName);
	public List<Student> findByGuardinName(String guardianName);
	public List<Student> findByLasnameAndName(String lastName, String name);
	
	/**
	 * @Queary Annotation is used to define native SQL queries or HQL (Hibernate Query Language) queries directly on the repository method. 
	 * By using this we can write native sql query. As Spring Data JPA's automatic query generation primarily supports JPQL (Java Persistence Query Language).
	 */
	//JPQL Java Persistence Query Language 
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	@Query("select s.name from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String emailId);
    
	/**
	 * @Queary Annotation is used to define native SQL queries or HQL (Hibernate Query Language) queries directly on the repository method. 
	 * By using this we can write native sql query to handle complex query. As Spring Data JPA's automatic query generation primarily supports JPQL (Java Persistence Query Language).
	 */
	
	@Query(value="select * from tbl_student where email_address= ?1", nativeQuery= true)
	Student getStudentByEmailAddressNative(String emailId);
	
	@Query(value="select * from tbl_student where email_address= :emailId", nativeQuery= true)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId")String emailId);
	


}
