package com.springDataJPA.springDataJpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springDataJPA.springDataJpaDemo.entity.CourseMaterial;

@Repository	
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

}
