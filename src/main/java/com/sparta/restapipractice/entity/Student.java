package com.sparta.restapipractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Student {

    /**
     * ID(엔티티 고유번호)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long student_id;
    /**
     * 학번(e.g 20243223)
     */
    @Column
    private String studentNumber;
    /**
     * 이름
     */
    @Column
    private String name;
    /**
     * 이메일
     */
    @Column
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> exams;

    public Student(Long id, Long student_id, String studentNumber, String name, String email) {
        this.id = id;
        this.student_id = student_id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
    }
}
