package com.example.java1il2022.week4.day17.controller;

import com.example.java1il2022.week4.day17.domain.dto.StudentResponseDTO;
import com.example.java1il2022.week4.day17.domain.entity.Student;
import com.example.java1il2022.week4.day17.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class StudentController {

    private final StudentService ss;

    @Autowired
    public StudentController(StudentService ss) {
        this.ss = ss;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(@RequestParam String name) {
        return new ResponseEntity<>(ss.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> getAllStudentById(@PathVariable String id) {
        return new ResponseEntity<>(ss.findStudentById(id), HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> xxException() {
        return null;
    }
}
