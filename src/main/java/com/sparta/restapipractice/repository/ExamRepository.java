package com.sparta.restapipractice.repository;

import com.sparta.restapipractice.dto.ExamRequestDto;
import com.sparta.restapipractice.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByStudentIdAndType(Long studentId, ExamRequestDto.Type type);
}
