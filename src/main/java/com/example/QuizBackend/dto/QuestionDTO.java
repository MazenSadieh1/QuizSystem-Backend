package com.example.QuizBackend.dto;

import com.example.QuizBackend.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Long id;
    private QuestionType type;
    private String text;
    private int points;

    private Set<AnswerDTO> answers = new HashSet<>();

}
