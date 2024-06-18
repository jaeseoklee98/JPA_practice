package com.sparta.restapipractice.controller;

import com.sparta.restapipractice.dto.ExamRequestDto;
import com.sparta.restapipractice.dto.ExamResponseDto;
import com.sparta.restapipractice.entity.Exam;
import com.sparta.restapipractice.repository.ExamRepository;
import com.sparta.restapipractice.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/students")
public class ExamController {

    private final ExamService examService;
    private final ExamRepository examRepository;

    public ExamController(ExamService examService, ExamRepository examRepository) {
        this.examService = examService;
        this.examRepository = examRepository;
    }


    @PostMapping("/{student_id}/exams")
    public ResponseEntity<?> addexam(@PathVariable(name = "student_id") Long student_id, @RequestBody ExamRequestDto requestDto) {
        examService.add(student_id,requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("과목 등록이 완료되었습니다.");
    }

    @GetMapping("/exams")
    public ResponseEntity<List<ExamResponseDto>> getAllexam() {
        List<Exam> examList = examRepository.findAll();
        List<ExamResponseDto> responseDtoList = examList.stream().map(ExamResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping("/{student_id}/exams")
    public ResponseEntity<List<ExamResponseDto>> getExam(@PathVariable(name = "student_id") Long studentId) {
        List<Exam> examList = examRepository.findByStudentId(studentId);
        List<ExamResponseDto> responseDtoList = examList.stream()
                .map(ExamResponseDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping("/{student_id}/exams/{type}")
    public ResponseEntity<List<ExamResponseDto>> getExamsByStudentIdAndType(@PathVariable(name = "student_id") Long studentId,
                                                                            @PathVariable(name = "type") ExamRequestDto.Type type) {
        List<Exam> examList = examService.findExamsByStudentIdAndType(studentId, type);
        List<ExamResponseDto> responseDtoList = examList.stream()
                .map(ExamResponseDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }
}
