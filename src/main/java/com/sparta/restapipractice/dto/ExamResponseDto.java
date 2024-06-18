package com.sparta.restapipractice.dto;

import com.sparta.restapipractice.entity.Exam;
import lombok.Getter;

@Getter
public class ExamResponseDto {

    private Long student_id;

    private Float score;

    private ExamRequestDto.Type type;

    public ExamResponseDto(Long student_id, Float score, ExamRequestDto.Type type) {
        this.student_id = student_id;
        this.score = score;
        this.type = type;
    }

    public ExamResponseDto(Exam exam) {
        this.student_id = exam.getStudent_id();
        this.type = exam.getType();
        this.score = exam.getScore();
    }
}
