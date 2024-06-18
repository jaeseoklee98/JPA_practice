package com.sparta.restapipractice.service;

import com.sparta.restapipractice.dto.ExamRequestDto;
import com.sparta.restapipractice.entity.Exam;
import com.sparta.restapipractice.entity.Student;
import com.sparta.restapipractice.repository.ExamRepository;
import com.sparta.restapipractice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;

    public void add(Long student_id, ExamRequestDto requestDto) {
        Student student = studentRepository.findById(student_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        Exam exam = new Exam(
                requestDto.getId(),
                student.getId(),
                requestDto.getScore(),
                requestDto.getType()
        );
        examRepository.save(exam);
    }

    public List<Exam> findExamsByStudentIdAndType(Long studentId, ExamRequestDto.Type type) {
        return examRepository.findByStudentIdAndType(studentId, type);
    }
}
