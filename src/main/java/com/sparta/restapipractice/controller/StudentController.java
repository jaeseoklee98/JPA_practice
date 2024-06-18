package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.ExamRequestDto;
import com.sparta.restapipractice.dto.StudentRequestDto;
import com.sparta.restapipractice.dto.StudentResponseDto;
import com.sparta.restapipractice.entity.Exam;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.repository.StudentRepository;
import com.sparta.restapipractice.service.ExamService;
import com.sparta.restapipractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    // 학생 등록
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDto requestDto) {
        studentService.add(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("학생 등록이 완료되었습니다.");
    }

    // id로 학생 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "id") Long id) {
        Student student = studentService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }


    // 학생 전체 조회
    // (GET) /students
    // (GET) /students?number=
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();

        List<StudentResponseDto> responseDtoList = studentList.stream().map(StudentResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }
}
