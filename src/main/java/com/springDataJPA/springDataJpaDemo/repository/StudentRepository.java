package com.springDataJPA.springDataJpaDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springDataJPA.springDataJpaDemo.entity.Student;
import org.springframework.transaction.annotation.Transactional;


/**
 * Spring data JPA documentation for query creation 
 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.named-queries.annotation-based-configuration
 * Query will be created base on attribute present in the table
 */


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {	
	public List<Student> findByName(String firstName);
	public List<Student> findByNameContaining(String firstName);
	public List<Student> findByLastname(String lastName);
	public List<Student> findByGuardinName(String guardianName);
	public List<Student> findByLastnameAndName(String lastName, String name);
	
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
	
	/**
	 * @Transactional Annotation is used for Transaction Management It starts the transaction before the annotated method begins executing and commits the transaction after the method completes successfully.
	 *  If an exception occurs during method execution, Spring rolls back the transaction to maintain data integrity.
	 * @Modifying: This annotation is typically used in Spring Data JPA repositories to indicate that a method modifies the database state. It works in conjunction with query methods such as
	 * @Query to specify JPQL (Java Persistence Query Language) or native SQL queries for update or delete operations. 
	 */
	@Transactional
	@Modifying
	@Query(value = " update tbl_student set name = ?1 where email_address = ?2", nativeQuery =true)
	int updateStudentFirstNameByEmailId(String name, String emailID);
	

}
