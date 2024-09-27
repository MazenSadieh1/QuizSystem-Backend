package com.example.QuizBackend.entities;

import com.example.QuizBackend.enums.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table
public class Quiz {

    @Id
    @SequenceGenerator(
            name = "quiz_id_seq",
            sequenceName = "quiz_id_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quiz_id_seq"
    )
    private Long id;
    private Subject subject;

    @Column(unique = true)
    private String title;
    private String creator;
    private String password;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private Set<Question> questions = new HashSet<>();

    public int getTotalPoints() {
        return  questions.stream()
                .mapToInt(Question::getTotalPoints)
                .sum();
    }
}
