package com.sparta.restapipractice.entity;

import com.sparta.restapipractice.dto.ExamRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long student_id;

    @Column
    private Float score;

    @Column
    @Enumerated(EnumType.STRING)
    private ExamRequestDto.Type type;

    @CreatedDate
    @Column
    private LocalDateTime examdate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    public Exam(Long id, Long student_id, Float score, ExamRequestDto.Type type) {
        this.id = id;
        this.student_id = student_id;
        this.score = score;
        this.type = type;
        examCreated();
    }

    public void examCreated() {this.examdate = LocalDateTime.now();}
}
