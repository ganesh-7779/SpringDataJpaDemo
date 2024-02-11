package com.springDataJPA.springDataJpaDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//Whatever we are having in this class will create table in db with help of entity annotation
@Entity
@Data // all getter and setter, toString, hashcode will generated here;
@AllArgsConstructor  // To create parameterized constructor
@NoArgsConstructor   //
@Builder // generates a builder class for the Student class,
@Table(name="tbl_student", uniqueConstraints = @UniqueConstraint(name= "emailId_unique", columnNames = "email_address"))
public class Student {
	@Id   // Will define this field as primary key of this table 
	@SequenceGenerator(name = "student_sequence", sequenceName="student_sequence", allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_sequence" )
	private String name;
	private String lasname;
	private Long studentId;
	private String guardianName;
	@Column(name = "email_address", nullable=false)
	private String emailId;
	private String guardianEmail;
	private String guardianMobile;

}
