package com.example.java1il2022.week4.day17.service.impl;

import com.example.java1il2022.week4.day17.domain.dto.StudentResponseDTO;
import com.example.java1il2022.week4.day17.domain.entity.Student;
import com.example.java1il2022.week4.day17.repository.StudentRepository;
import com.example.java1il2022.week4.day17.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResponseDTO findStudentById(String id) {
        Student s = repository.findStudentById(id);
        return new StudentResponseDTO(s.getName());
    }

    @Override
    public List<StudentResponseDTO> findAllStudents() {
        return repository.findAllStudents()
                .stream()
                .map(s -> new StudentResponseDTO(s.getName()))
                .collect(Collectors.toList());
    }
}
