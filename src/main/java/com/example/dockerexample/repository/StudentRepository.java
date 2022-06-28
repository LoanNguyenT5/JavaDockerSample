package com.example.dockerexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dockerexample.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
