package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.Student;
import lombok.Getter;

@Getter
public class StudentResponseDto {
    private Long id;
    private String studentNumber;
    private String name;
    private String email;

    public StudentResponseDto(Long id, String studentNumber, String email, String name) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.email = email;
        this.name = name;
    }

    public StudentResponseDto(Student student) {
        this.id = student.getId();
        this.studentNumber = student.getStudentNumber();
        this.name = student.getName();
        this.email= student.getEmail();
    }
}
