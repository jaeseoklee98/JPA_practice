package com.sparta.restapipractice.service;

import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void add(StudentRequestDto requestDto) {
        Long Id =requestDto.getId();
        Long studentId = requestDto.getStudent_id();
        String studentNumber = requestDto.getStudentNumber();
        String name = requestDto.getName();
        String email = requestDto.getEmail();

        Student student =new Student(Id,studentId, studentNumber, name, email);
        studentRepository.save(student);
    }

    public Student findById(Long id) {
        Student student = findByStudentId(id);

        return new Student(
                student.getId(),
                student.getStudent_id(),
                student.getStudentNumber(),
                student.getName(),
                student.getEmail()
        );
    }

    public Student findByStudentId(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("등록된 학생이 없습니다."));
    }
}
