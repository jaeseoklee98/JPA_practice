package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.ExamRequestDto;
import com.sparta.restapipractice.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students/{id}/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }


    @PostMapping
    public ResponseEntity<?> addexam(@PathVariable(name = "id") Long student_id, @RequestBody ExamRequestDto requestDto) {
        examService.add(student_id,requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("과목 등록이 완료되었습니다.");
    }
}
