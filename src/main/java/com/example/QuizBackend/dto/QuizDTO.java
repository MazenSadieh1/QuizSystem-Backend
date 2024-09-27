package com.example.QuizBackend.dto;

import com.example.QuizBackend.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class QuizDTO {

    private Long id;
    private Subject subject;
    private String title;
    private String creator;
    private String password;
    private int points;

    private Set<QuestionDTO> questions = new HashSet<>();


}
