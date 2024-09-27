package com.example.QuizBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

@ToString
@Getter
@Setter
@Entity
@Table
public class Answer {

    @Id
    @SequenceGenerator(
            name = "answer_id_seq",
            sequenceName = "answer_id_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_id_seq"
    )
    private Long id;
    private String text;
    @Column(nullable = false)
    private boolean correct;
    @Column(nullable = false)
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "questionId", referencedColumnName = "id")
    private Question question;

}