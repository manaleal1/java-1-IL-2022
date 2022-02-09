package com.example.java1il2022.week4.day17.repository.impl;

import com.example.java1il2022.week4.day17.domain.entity.Student;
import com.example.java1il2022.week4.day17.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<String, Student> studentMap;

    public StudentRepositoryImpl() {
        this.studentMap = new ConcurrentHashMap<>();
        init();
    }

    private void init() {
        studentMap.put("1", new Student("1", "Tom"));
        studentMap.put("2", new Student("2", "Jerry"));
    }

    @Override
    public Student findStudentById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentMap.values().stream().collect(Collectors.toList());
    }
}
