package com.springDataJPA.springDataJpaDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springDataJPA.springDataJpaDemo.entity.Student;


/**
 * Spring data JPA documentation for query creation 
 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.named-queries.annotation-based-configuration
 * Queary will be created base on attribute present in the table
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {	
	public List<Student> findByName(String firstName);
	public List<Student> findByNameContaining(String firstName);
	public List<Student> findByLasname(String lastName);
	public List<Student> findByGuardinName(String guardianName);
	public List<Student> findByLasnameAndName(String lastName, String name);



}
