package com.sparta.restapipractice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExamRequestDto {

    private Long id;

    private Long student_id;

    private Float score;

    private LocalDateTime examDate;

    private Type type;

    public enum Type{
        JPA, DB;

        @JsonCreator
        public static Type fromString(String key) {
            return key == null ? null : Type.valueOf(key.toUpperCase());
        }

        @JsonValue
        public String toValue() {
            return this.name();
        }
    };



    public ExamRequestDto(Long id, Long student_id, Float score, Type type, LocalDateTime examDate) {
        this.id = id;
        this.student_id = student_id;
        this.type = type;
        this.score = score;
        this.examDate = examDate;
    }
}
