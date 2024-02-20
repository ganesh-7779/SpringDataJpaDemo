package com.springDataJPA.springDataJpaDemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor()
@Table(name="course_material", uniqueConstraints = @UniqueConstraint(name= "courseMaterialId_Unique", columnNames = "course_material_id"))
public class CourseMaterial {
	@Id
	@SequenceGenerator(name="course_matertial_sequence", sequenceName="course_matertial_sequence", allocationSize =1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "course_matertial_sequence")
	@Column(name="course_material_id", nullable=false)
	private long courseMaterialId;
	private String url;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="course_id",referencedColumnName="course_id")
	private Course course;
}
