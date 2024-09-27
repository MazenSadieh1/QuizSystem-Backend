package com.example.QuizBackend.entities;

import com.example.QuizBackend.enums.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Question {

    @Id
    @SequenceGenerator(
            name = "quiz_system_seq",
            sequenceName = "quiz_system_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quiz_system_seq"
    )
    private Long id;
    private QuestionType type;
    private String text;


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "quizId", referencedColumnName = "id")
    private Quiz quiz;

    public int getTotalPoints() {
        return  answers.stream()
                .mapToInt(Answer::getPoints)
                .sum();
    }

}
