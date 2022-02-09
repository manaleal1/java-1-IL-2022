package com.example.java1il2022.week4.day17.repository;

import com.example.java1il2022.week4.day17.domain.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    Student findStudentById(String id);
    List<Student> findAllStudents();
}
