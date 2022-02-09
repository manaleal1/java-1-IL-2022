package com.example.java1il2022.week4.day17.service;

import com.example.java1il2022.week4.day17.domain.dto.StudentResponseDTO;
import com.example.java1il2022.week4.day17.domain.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentResponseDTO findStudentById(String id);
    List<StudentResponseDTO> findAllStudents();
}
