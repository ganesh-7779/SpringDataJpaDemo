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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor()
@Builder
@Table(name="course", uniqueConstraints = @UniqueConstraint(name= "courseId_Unique", columnNames = "course_id"))
public class Course {
 @SequenceGenerator(name = "course_sequence", sequenceName="course_sequence", allocationSize=1)
 @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="course_sequence" )	
 @Id
 @Column(name="course_id", nullable=false)
 private Long courseId;
 private String title;
 private Integer credit;
}
