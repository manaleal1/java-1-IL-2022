package com.example.java1il2022.week4.day17.domain.dto;

public class StudentResponseDTO {
    private String name;

    public StudentResponseDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
